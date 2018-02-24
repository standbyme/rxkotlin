// 5.2.kt
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable = Observable.interval(100, TimeUnit.MILLISECONDS)

    observable.subscribe({ println("Subscription 1 Received $it") })
    Thread.sleep(200)
    observable.subscribe({ println("Subscription 2 Received $it") })
    Thread.sleep(300)
}

/*
Subscription 1 Received 0
Subscription 1 Received 1
Subscription 1 Received 2
Subscription 2 Received 0
Subscription 1 Received 3
Subscription 2 Received 1
Subscription 1 Received 4
Subscription 2 Received 2
 */