import io.reactivex.Maybe
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    val maybeEmpty: Maybe<Int> = Maybe.empty()
    maybeEmpty.subscribeBy(
            onComplete = { println("Completed Empty") },
            onError = { println("Error $it") },
            onSuccess = { println("Completed with value $it") }
    )
}

/*
Completed Empty
 */