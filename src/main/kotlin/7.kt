
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable: Observable<Any> = Observable.just(1,2,3) //6

    observable.subscribe(observer)//7
}

/*
New Subscription
Next 1
Next 2
Next 3
All Completed
 */