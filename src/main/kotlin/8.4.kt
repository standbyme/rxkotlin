// 8.4.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.just(1, 2, "Errr", 3)
            .map { it.toIntOrError() }
            .retry(2)
            .subscribe(observer)
}

/*
New Subscription
Next 1
Next 2
Next 1
Next 2
Next 1
Next 2
Error Occured For input string: "Errr"
 */

