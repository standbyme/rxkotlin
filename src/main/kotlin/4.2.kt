import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

// Dispose: 处理
fun main(args: Array<String>) {

    val observale: Observable<Long> = Observable.interval(100, TimeUnit.MILLISECONDS)

    val observer: Observer<Long> = object : Observer<Long> {
        lateinit var disposable: Disposable

        override fun onSubscribe(d: Disposable) {
            disposable = d
        }

        override fun onNext(item: Long) {
            if (item >= 5 && !disposable.isDisposed) {
                disposable.dispose()
                println("Disposed")
            }
            println("Received $item")//Disposed buhuijixuchuliqitazhi danshizheyilunyaozhixingwan suoyihuiyou Received 5
        }

        override fun onError(e: Throwable) {
            println("Error ${e.message}")
        }

        override fun onComplete() {
            println("Complete")
        }

    }

    observale.subscribe(observer)
    Thread.sleep(1000)
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