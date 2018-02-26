import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    // Single will be introduced next
    val count: Single<Long> = Observable.just(2, 30, 22, 5, 60, 1).count()
    count.subscribeBy { println(it) }
}

/*
6
 */

/*
Count
Mathematical and Aggregate Operators
!!!Picture
return a Single
 */

/*
Single
 */