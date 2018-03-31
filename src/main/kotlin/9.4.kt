import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    listOf("1", "2", "3")
            .toObservable()
            .map { item ->
                println("Mapping $item ${Thread.currentThread().name}")
                item.toInt()
            }
            .subscribe { item ->
                println("Received $item ${Thread.currentThread().name}")
            }
}
/*
Mapping 1 main
Received 1 main
Mapping 2 main
Received 2 main
Mapping 3 main
Received 3 main
 */
/*
How to use schedulers – subscribeOn and observeOn operators
Changing thread on subscription – subscribeOn operator
 */
/*
It's a simple RxKotlin code example;
we are creating Observable, mapping it, and then subscribing to it.
The only difference here is that I've printed the Thread name inside both the map and the subscribe lambdas.
 */
/*
From the output, we can determine that the main thread executes the entire subscription.
 */