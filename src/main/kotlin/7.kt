// https://www.safaribooksonline.com/library/view/reactive-programming-in/9781788473026/a8ac3a5b-cf69-44d6-b036-de2aa7e1a18a.xhtml

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {

    val observer: Observer<Any> = object : Observer<Any> {
        //1
        override fun onComplete() {//2
            println("All Completed")
        }

        override fun onNext(item: Any) {//3
            println("Next $item")
        }

        override fun onError(e: Throwable) {//4
            println("Error Occured $e")
        }

        override fun onSubscribe(d: Disposable) {//5
            println("Subscribed to $d")
        }
    }

    val observable: Observable<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f).toObservable() //6

    observable.subscribe(observer)//7

    val observableOnList: Observable<List<Any>> =
            Observable.just(listOf("One", 2, "Three", "Four",
                    4.5, "Five", 6.0f),
                    listOf("List with Single Item"),
                    listOf(1, 2, 3, 4, 5, 6))//8
    observableOnList.subscribe(observer)//9
}

/*
Subscribed to io.reactivex.internal.operators.observable.ObservableFromIterable$FromIterableDisposable@xxxxxxxx
Next One
Next 2
Next Three
Next Four
Next 4.5
Next Five
Next 6.0
All Completed
Subscribed to io.reactivex.internal.operators.observable.ObservableFromArray$FromArrayDisposable@xxxxxxxx
Next [One, 2, Three, Four, 4.5, Five, 6.0]
Next [List with Single Item]
Next [1, 2, 3, 4, 5, 6]
All Completed
 */