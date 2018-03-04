// 8.5.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    var retryCount = 0
    Observable.just(1, 2, "Errr", 3)
            .map { it.toIntOrError() }
            .retry { _, _ ->
                (++retryCount) < 3
            }
            .subscribe(observer)
}
/*
Same with 8.4
 */

/*
we used the retry operator with a retry limit.
we used the retry operator with a predicate.
The retry operator will keep retrying until the predicate returns true and
will pass the error to downstream whenever the predicate returns false.
 */
