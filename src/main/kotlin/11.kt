import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    Observable.range(1, 4).subscribe(observer)
    Observable.empty<String>().subscribe(observer)

    Observable.interval(600, TimeUnit.MILLISECONDS).subscribe(observer)
    Thread.sleep(2000)

    Observable.timer(20, TimeUnit.MILLISECONDS).subscribe(observer)
    Thread.sleep(50)
}

/*
New Subscription
Next 1
Next 2
Next 3
Next 4
All Completed
New Subscription
All Completed
New Subscription
Next 0
Next 1
Next 2
New Subscription
Next 0
All Completed
 */