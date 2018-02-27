// 7.3.kt
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    data class Item(val id: Int) {
        init {
            println("Item Created $id")
        }
    }

    Flowable.just(1, 2, 3).map { Item(it) }  // Only this line changes
            .observeOn(Schedulers.newThread())
            .subscribe({
                // There is a Subscriber instead of Observer
                // , but with Lambda,it looks same.
                // we will talk about this later
                Thread.sleep(100)
                println("Received $it")
            })
    Thread.sleep(1000)
}

/*
Item Created 1
Item Created 2
Item Created 3
Received Item(id=1)
Received Item(id=2)
Received Item(id=3)
 */

/*
Nothing Different
 */