// 7.2.kt
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    data class Item(val id: Int) {
        init {
            println("Item Created $id")
        }
    }

    Observable.just(1, 2, 3).map { Item(it) }
            .observeOn(Schedulers.newThread())  // Schedulers will be introduced in next chapter
            .subscribe({
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
https://upload-images.jianshu.io/upload_images/6773051-d68c51355a9d8e2d.gif
[Rxjava2入门教程五：Flowable背压支持](https://www.jianshu.com/p/ff8167c1d191)
 */
/*
you will notice that the Observable (producer) continued to emit items, though the Observer (consumer) was not at all in pace with it.
Until the time Observer (producer) finished emitting all the Items, the Observer (consumer) processed only the very first item (item 1).
this could lead to a lot of problems, including the OutOfMemory error.
 */
/*
The only problem with Observable is when an Observer cannot cope with the pace of an Observable.
An Observable, by default, chains work by pushing items synchronously to the Observer, one at a time.
However, if the observer has to perform some time-consuming computations
, this may take longer than the interval of each item emission of Observable.
 */

/*
// 1
we will discuss this method in detail in the later chapters
, but, for now, just keep in mind that this observeOn method helps us specify a thread to run the subscription
, and Scheduler.computation() provides us a with a thread to perform computations.
 */

/*
this could lead to a lot of problems, including the OutOfMemoryError exceptions.
 */

/*
A solution to this problem could be a feedback channel from consumer to producer
, through which the consumer can tell the producer to wait until it completes processing the previous emission.
This way, consumers or messaging middleware will not become saturated and unresponsive under high load;
 instead, they may request fewer messages, letting the producer decide how to slow down.
This feedback channel is called backpressure.
[背压 百度百科](https://baike.baidu.com/item/%E8%83%8C%E5%8E%8B)
 */

/*
Backpressure is not supported in Observables and Observers
, the solution could be using Flowables and Subscribers instead.
 */

/*
We may call Flowables a backpressured version of Observables.
Probably, the only difference between Flowables and Observables is that Flowable takes backpressure into consideration.
 */

/*
Flowables were added in ReactiveX 2.x (RxKotlin 2.X), and the previous versions don't include them.
let's replace Observable with Flowable
 */

