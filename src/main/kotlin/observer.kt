import io.reactivex.Observer
import io.reactivex.disposables.Disposable

// This observer is the same as the previous
// https://www.jianshu.com/p/157126615f77
val observer: Observer<Any> = object : Observer<Any> {
    override fun onComplete() {
        println("All Completed")
    }

    override fun onNext(item: Any) {
        println("Next $item")
    }

    override fun onError(e: Throwable) {
        println("Error Occured ${e.message}")
    }

    override fun onSubscribe(d: Disposable) {
        println("New Subscription ")
    }
}