import io.reactivex.Observable


fun main(args: Array<String>) {
    val observable: Observable<Int> = Observable.create<Int> {
        // it: ObservableEmitter<String!>
        it.onNext(1)
        it.onNext(2)
        it.onNext(3)
        it.onError(Exception("My Custom Exception"))
    }

    observable.subscribe(observer)
}

/*
New Subscription
Next 1
Next 2
Next 3
Error Occured My Custom Exception
 */