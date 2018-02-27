// 6.6.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.just(2, 3)
            .startWith(1)
            .subscribe(observer)
}

/*
New Subscription
Next 1
Next 2
Next 3
All Completed
 */
/*
Combining Observables
Picture!!!
*/
