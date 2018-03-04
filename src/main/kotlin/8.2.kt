// 8.2.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.just(1, 2, "Errr", 3)
            .map { it.toIntOrError() }
            .onErrorReturn { -1 }
            .subscribe(observer)
}

/*
New Subscription
Next 1
Next 2
Next -1
All Completed  // onComplete
 */

/*
As we can see in the output, the onErrorReturn operator returns the specified default value.
The downstream didn't receive any item further as the upstream stopped emitting items
as soon as the error occurred.
 */