// 6.6.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.range(2, 3)  // range(start, **count**) not end
            .startWith(1)
            .subscribe(observer)
}

/*
New Subscription
Next 1
Next 2
Next 3
Next 4
All Completed
 */
/*
Combining Observables
Picture!!!
*/
