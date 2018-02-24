import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable: Observable<Int> = Observable.range(1, 3)
    observable.subscribe({
        //onNext method
        println("Next $it")
    }, {
        //onError Method
        println("Error ${it.message}")
    }, {
        //onComplete Method
        println("Done")
    })
}

/*
Next 1
Next 2
Next 3
Done
 */