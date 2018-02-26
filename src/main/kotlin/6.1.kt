// 6.1.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable = Observable.just(1, 2, 3)
    observable.map { x -> 10 * x }.subscribe(observer)  // 10*it
}

/*
New Subscription
Next 10
Next 20
Next 30
All Completed
 */
/*
Operator
Amount: 454
(2018.2.26)
http://reactivex.io/documentation/operators.html#alphabetical
http://rxmarbles.com/
 */
/*
Transforming Observables
map -- Functor
Marble
 */