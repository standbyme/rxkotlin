import io.reactivex.*
import io.reactivex.rxkotlin.*

fun main(args: Array<String>) {
    val list: List<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f) // 1
    val observable: Observable<Any> = list.toObservable();

    observable.subscribeBy( // named arguments for lambda Subscribers
            onNext = { println(it) },
            onError = { it.printStackTrace() },
            onComplete = { println("Done!") }
    )
}

/*
One
2
Three
Four
4.5
Five
6.0
Done!
*/
