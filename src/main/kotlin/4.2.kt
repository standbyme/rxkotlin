import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable: Observable<Int> = Observable.range(1, 5)
    observable.subscribe(observer)
}