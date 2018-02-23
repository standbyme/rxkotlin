import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    Observable.interval(600, TimeUnit.MILLISECONDS).subscribe(observer)
    Thread.sleep(2000)
}

/*
New Subscription
Next 0
Next 1
Next 2
 */