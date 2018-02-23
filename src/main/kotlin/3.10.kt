import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    Observable.timer(20, TimeUnit.MILLISECONDS).subscribe(observer)
    Thread.sleep(50)
}

/*
New Subscription
Next 0
All Completed
 */