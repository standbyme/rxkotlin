import io.reactivex.rxkotlin.toObservable

//Hot Observables
fun main(args: Array<String>) {
    val connectableObservable = listOf(1, 2, 3).toObservable().publish()//we used the publish operator to convert Cold Observable into ConnectableObservable.
    connectableObservable.subscribe({ println("Subscription 1: $it") })
    connectableObservable.subscribe({ println("Subscription 2: $it") })
    connectableObservable.connect()
    connectableObservable.subscribe({ println("Subscription 3: $it") })//Will not receive emissions
}
/*
Subscription 1: 1
Subscription 2: 1
Subscription 1: 2
Subscription 2: 2
Subscription 1: 3
Subscription 2: 3
 */

/*
Hot Observables are contrary to Cold Observables; it doesn't need subscriptions to start emission.
While you can compare Cold Observables to CD/DVD recordings,
Hot Observables are like TV channels—they continue broadcasting (emitting) their content
 , irrespective of whether anyone is watching (Observing) it or not.
 */

/*
A great example of Hot Observables is ConnectableObservable.
It is one of the most helpful forms of Hot Observables as well.
It can turn any Observable, even a Cold Observable, into a Hot Observable.
It doesn't start emitting on the subscribe call; instead, it gets activated after you call the connect method.
You have to make the subscribe calls before calling connect;
any subscribe calls after calling connect will miss the emissions fired previously.
 */

/*
Each emission goes to each Observer simultaneously, and they are processing data in an interleaved fashion.
 */

/*
Also note that the subscribe call on comment 6, after connect, has not received any emissions,
as ConnectableObservable is hot, and any new subscriptions occurred after connect will miss out the emissions fired previously (between the call of the connect method and the new subscription,
remember that, within a few milliseconds, computers can do a lot of tasks);
in this case, it missed all the emissions.

 */