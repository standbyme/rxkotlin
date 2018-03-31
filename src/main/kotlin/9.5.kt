import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    listOf("1", "2", "3")
            .toObservable()
            .subscribeOn(Schedulers.computation())//(1)
            .map { item ->
                println("Mapping $item - ${Thread.currentThread().name}")
                item.toInt()
            }
            .observeOn(Schedulers.io())//(2)
            .subscribe { item ->
                println("Received $item -${Thread.currentThread().name}")
            }

    Thread.sleep(1000)
}

/*
Mapping 1 - RxComputationThreadPool-1
Mapping 2 - RxComputationThreadPool-1
Mapping 3 - RxComputationThreadPool-1
Received 1 -RxCachedThreadScheduler-1
Received 2 -RxCachedThreadScheduler-1
Received 3 -RxCachedThreadScheduler-1
 */

/*
The subscribeOn() operator will suggest to the source Observable upstream
which Scheduler to use and how to execute operations on one of its threads.
If that source is not already tied to a particular Scheduler,
it will use the Scheduler you specify.
 */

/*
In the following example,
it makes no difference whether you put this subscribeOn() right after Observable.just() or after one of the operators.
The subscribeOn() will communicate upstream to the Observable.just() which Scheduler to use no matter where you put it.
For clarity,
though, you should place it as close to the source as possible:
 */

/*
All three accomplish the same effect with subscribeOn()
Observable.just(1, 2, 3)
        .subscribeOn(Schedulers.computation()) //preferred
        .map {it+1}
        .filter {it < 3}
        .subscribe(observer)

Observable.just(1, 2, 3)
        .map {it+1}
        .subscribeOn(Schedulers.computation())
        .filter {it < 3}
        .subscribe(observer)

Observable.just(1, 2, 3)
        .map {it+1}
        .filter {it < 3}
        .subscribeOn(Schedulers.computation())
        .subscribe(observer)
 */