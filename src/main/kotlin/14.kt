import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {

    val observale: Observable<Long> = Observable.interval(100, TimeUnit.MILLISECONDS)

    val observer: Observer<Long> = object : Observer<Long> {
        lateinit var disposable: Disposable//2

        override fun onSubscribe(d: Disposable) {
            disposable = d//3
        }

        override fun onNext(item: Long) {
            println("Received $item")
            if (item >= 5 && !disposable.isDisposed) {//4
                disposable.dispose()//5
                println("Stop")
            }
            println("Received $item")
        }

        override fun onError(e: Throwable) {
            println("Error ${e.message}")
        }

        override fun onComplete() {
            println("Complete")
        }

    }

    observale.subscribe(observer)
    Thread.sleep(1500)
}

/*
Received 0
Received 0
Received 1
Received 1
Received 2
Received 2
Received 3
Received 3
Received 4
Received 4
Received 5
Stop
Received 5
 */