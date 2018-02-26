// 6.2.kt

import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable = Observable.just(2, 30, 22, 5, 60, 1)
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
 */