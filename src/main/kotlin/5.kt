
import io.reactivex.Maybe
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    val maybeValue: Maybe<Int> = Maybe.just(14)
    maybeValue.subscribeBy(
            onComplete = { println("Completed Empty") },
            onError = { println("Error $it") },
            onSuccess = { println("Completed with value $it") }
    )
}

/*
Completed with value 14
 */