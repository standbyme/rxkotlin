// 7.4.kt
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    data class Item(val id: Int) {
        init {
            println("Item Created $id")
        }
    }

    Flowable.range(1, 260).map { Item(it) }  // Only this line changes, too
            .observeOn(Schedulers.newThread())
            .subscribe({
                Thread.sleep(100)  // time bu yi guo xiao
                println("Received $it")
            })
    Thread.sleep(27000)
}

/*
Item Created 1
Item Created 2
...
Item Created 127
Item Created 128
Received Item(id=1)
Received Item(id=2)
...
Received Item(id=95)
Received Item(id=96)  // 1 It does not clear whole buffer  128-96=32
Item Created 129
Item Created 130
...
Item Created 223
Item Created 224  // 224-96=128
Received Item(id=97)
Received Item(id=98)
...
Received Item(id=191)
Received Item(id=192)  // 224-192=32
Item Created 225
Item Created 226
...
Item Created 259
Item Created 260
Received Item(id=193)
Received Item(id=194)
...
Received Item(id=259)
Received Item(id=260)
 */

/*
Flowable, instead of emitting all the items
, emitted few items in a chunk, waited for the consumer to coup up then again continued
Flowable hosts the default buffer size of 128 elements for operators, so, when the consumer is taking time, the emitted items may wait in the buffer.
 */

/*
So, why use Subscriber instead of Observer?
Because Subscriber supports some extra operations and backpressure.
For instance, it can convey how many items it wishes to receive as a message to upstream.
 */

/*
using lambda with Subscriber is similar to Observe;
this implementation will automatically request an unbounded number of emissions from the upstream.
As with our last code, we didn't specify how many emissions we want,
but it internally requested unbounded number of emissions,
and that's why we received all the items emitted.
 */