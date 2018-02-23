import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable: Observable<Int> = Observable.create<Int> {
        it.onNext(1)
    }

    observable.subscribe(observer)
}