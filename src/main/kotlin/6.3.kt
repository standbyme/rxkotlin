// 6.3
import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable = Observable.just(1, 5, 9)  // number don't have specific meaning
    observable
            .flatMap { x -> Observable.just(x + 1, x + 2) }
            .subscribe(observer)
}

/*
New Subscription
Next 2
Next 3
Next 3
Next 4
Next 4
Next 5
All Completed
 */

/*
Transforming Observables
flatMap -- Monad
http://reactivex.io/documentation/operators/images/flatMap.c.png
 */