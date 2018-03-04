// 8.3.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.just(1, 2, "Errr", 3)
            .map { it.toIntOrError() }
            .onErrorResumeNext(Observable.range(10, 2))
            .subscribe(observer)
}

/*
New Subscription
Next 1
Next 2
Next 10
Next 11
All Completed    // onComplete
 */

/*
The onErrorResumeNext operator helps you subscribe to a different producer
in case any error occurs.
 */