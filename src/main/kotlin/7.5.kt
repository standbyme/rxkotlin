// 7.5.kt
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    Flowable.range(1, 6)
            .map { Item(it) }
            .observeOn(Schedulers.newThread())
            .subscribe(subscriber_1)  // 1
    Thread.sleep(2000)
}

/*
New Subscription
Item Created 1
Item Created 2
Item Created 3
Item Created 4
Item Created 5
Item Created 6
Subscriber received Item(id=1)
Subscriber received Item(id=2)
Subscriber received Item(id=3)
Subscriber received Item(id=4)  // No onComplete method called
 */

/*
1
WeChat
 */

/*
although Flowable emitted all the items for the range, it was never passed to Subscriber after 7
 */