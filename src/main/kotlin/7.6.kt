// 7.6.kt
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    Flowable.range(1, 4)  // Only this line change! compared with 7.5.kt
            .map { Item(it) }
            .observeOn(Schedulers.newThread())
            .subscribe(subscriber_1)
    Thread.sleep(2000)
}

/*
New Subscription
Item Created 1
Item Created 2
Item Created 3
Item Created 4
Subscriber received Item(id=1)
Subscriber received Item(id=2)
Subscriber received Item(id=3)
Subscriber received Item(id=4)
Done!  // onComplete method called
 */

/*
This example tend to tell when will onComplete method will be called.
Not about Flowable
 */