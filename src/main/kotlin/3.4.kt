import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable: Observable<Int> = Observable.create<Int> {
        it.onComplete()
        it.onNext(2)
    }

    observable.subscribe(observer)
}

/*
New Subscription
Next 1
 */