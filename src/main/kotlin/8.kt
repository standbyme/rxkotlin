// https://www.safaribooksonline.com/library/view/reactive-programming-in/9781788473026/b9534ab3-f4c0-452e-a17e-fe5a178532f7.xhtml

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {
    val observable: Observable<String> = Observable.create<String> {
        // it: ObservableEmitter<String!>
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onComplete()
    }

    observable.subscribe(observer)

    val observable2: Observable<String> = Observable.create<String> {
        // it: ObservableEmitter<String!>
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onError(Exception("My Custom Exception"))
    }

    observable2.subscribe(observer)
}

/*
New Subscription
Next Emit 1
Next Emit 2
Next Emit 3
Next Emit 4
All Completed
New Subscription
Next Emit 1
Next Emit 2
Next Emit 3
Next Emit 4
Error Occured My Custom Exception
 */