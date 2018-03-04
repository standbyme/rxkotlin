import io.reactivex.Observable

inline fun Any.toIntOrError(): Int = toString().toInt()

fun main(args: Array<String>) {
    Observable.just(1, 2, "Errr", 3)
            .map { it.toIntOrError() }
            .subscribe(observer)
}

/*
New Subscription
Next 1
Next 2
Error Occured For input string: "Errr"
 */

/*
However, the problem with the onError event is that the error is emitted to the downstream consumer chain
, and the subscription is terminated instantly.
The program throws an exception in the map operator when the string Errr is emitted from the Observable.
The exception was caught by the onError handler
, but the Subscription doesn't get any further emissions.
 */

/*
let's take a look at how we can handle errors in a reactive way.
RxKotlin provides us with a few operators for error handling
 */