// https://www.safaribooksonline.com/library/view/reactive-programming-in/9781788473026/ce6a69b9-ea5c-44a6-952f-d3a8ed0af8e8.xhtml

import io.reactivex.Observable

fun main(args: Array<String>) {
    val list = listOf("String 1", "String 2", "String 3", "String 4")
    val observableFromIterable: Observable<String> = Observable.fromIterable(list)//1
    // You can also use `list.toObservable()` instead of `Observable.fromIterable(list)`
    observableFromIterable.subscribe(observer)
}