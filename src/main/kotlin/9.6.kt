import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers

fun main(args: Array<String>) {
    val observable = listOf("1", "2", "3")
            .toObservable()
            .subscribeOn(Schedulers.computation())
            .map {
                println("Mapping $item - ${Thread.currentThread().name}")
                it.toInt()
            }

    observable.subscribe { println("${Thread.currentThread().name}") }
    observable.subscribe { println("${Thread.currentThread().name}") }

    Thread.sleep(1000)
}

/*
Having multiple Observers to the same Observable with subscribeOn() will result in each one getting its own thread
(or have them waiting for an available thread if none are available).

if you have multiple subscribeOn() calls on a given Observable chain, the top-most one, or the one closest to the source
, will win and cause any subsequent ones to have no practical effect
 */