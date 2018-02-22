// https://www.safaribooksonline.com/library/view/reactive-programming-in/9781788473026/ce6a69b9-ea5c-44a6-952f-d3a8ed0af8e8.xhtml

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {

    // This observer is the same as the previous
    val observer: Observer<String> = object : Observer<String> {
        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(item: String) {
            println("Next $item")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription ")
        }
    }

    val list = listOf("String 1", "String 2", "String 3", "String 4")
    val observableFromIterable: Observable<String> = Observable.fromIterable(list)//1
    observableFromIterable.subscribe(observer)

    val callable = { "From Callable" }
    val observableFromCallable: Observable<String> = Observable.fromCallable(callable)//2
    observableFromCallable.subscribe(observer)
}