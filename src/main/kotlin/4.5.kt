import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val connectableObservable = Observable.interval(10, TimeUnit.MILLISECONDS).publish()
    connectableObservable.subscribe({ println("Subscription 1: $it") })
    connectableObservable.subscribe({ println("Subscription 2: $it") })
    connectableObservable.connect()
    println("Sleep 1 starts")
    Thread.sleep(20)
    println("Sleep 1 ends")
    connectableObservable.subscribe({ println("Subscription 3: $it") })
    println("Sleep 2 starts")
    Thread.sleep(30)
    println("Sleep 2 ends")
}

/*
Sleep 1 starts
Subscription 1: 0
Subscription 2: 0
Subscription 1: 1
Subscription 2: 1
Sleep 1 ends
Sleep 2 starts
Subscription 1: 2
Subscription 2: 2
Subscription 3: 2
Subscription 1: 3
Subscription 2: 3
Subscription 3: 3
Subscription 1: 4
Subscription 2: 4
Subscription 3: 4
Sleep 2 ends
 */