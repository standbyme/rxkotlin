// https://www.safaribooksonline.com/library/view/reactive-programming-in/9781788473026/5b7df6b1-81c2-40da-a0f5-851f6a73ee8c.xhtml

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