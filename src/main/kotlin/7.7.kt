// 7.6.kt
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    Flowable.range(1, 6)
            .map { Item(it) }
            .observeOn(Schedulers.newThread())
            .subscribe(subscriber_2)
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
Subscriber received Item(id=4)
Requesting two more
Subscriber received Item(id=5)
Subscriber received Item(id=6)
Done!
 */

/*
Then, inside onNext, on comment (3), we checked if the received item is the 5th one
(as we are using a range, the 5th item's value will be 5);
if the item is the 5th one, then we are again requesting for 2 more.
 */