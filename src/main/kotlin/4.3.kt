import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

//Cold Observables
fun main(args: Array<String>) {
    val observable: Observable<Int> = listOf(1, 2, 3, 4).toObservable()

    observable.subscribe(observer)

    observable.subscribe(observer)
}

/*
For both the subscribe calls, you got the exact same emission from the first one to the last one.
All the Observable factory methods we have used up until this chapter return Cold Observables
Cold Observables are passive, they don't emit anything until subscribe is called.
 */

/*
New Subscription
Next 1
Next 2
Next 3
Next 4
All Completed
New Subscription
Next 1
Next 2
Next 3
Next 4
All Completed
 */