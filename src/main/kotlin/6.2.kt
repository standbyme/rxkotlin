// 6.2.kt

import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable = listOf(2, 30, 22, 5, 60, 1).toObservable()
    observable.filter { x -> x > 10 }.subscribe(observer)  // it > 10
}

/*
New Subscription
Next 30
Next 22
Next 60
All Completed
 */

/*
Filtering Observables
flatMap -- Monad
 */