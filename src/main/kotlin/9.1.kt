import io.reactivex.Observable

fun main(args: Array<String>) {
    val startTime = System.currentTimeMillis()
    Observable.range(1, 3)
            .subscribe {
                Thread.sleep(200)
                println("1. $it")
            }

    Observable.range(10, 3)
            .subscribe {
                Thread.sleep(100)
                println("2. $it")
            }
    val endTime = System.currentTimeMillis()
    println("${endTime - startTime} ms")
}

/*
1. 1
1. 2
1. 3
2. 10
2. 11
2. 12
1088 ms
 */
/*
RxKotlin works on a single thread by default,
although it provides us with loads of operators to implement multi-threading
as per our business logic and requirements with ease.
 */
/*So, whenever you subscribe to an Observable and/or Flowable,
the current thread is blocked until all the items are emitted and received by the Observer chain
(except for the cases with interval and timer factory methods).
 By default, Observables execute work on the immediate thread,
 which is the thread that declared the Observer and subscribed it. 
 In many of our earlier examples,
 this was the main thread that kicked off our main() method.*/
/*
by default,
the Observable and the chain of operators applied to it will do the work on the same thread where subscribe is called,
and the thread will be blocked until Observer receives the onComplete or onError notification.
We can use schedulers to change this behavior.
 */

/*
A scheduler can be thought of as a thread poolthe scheduler API provides you with some pre-composed scheduler.
It also allows you to create a new user-defined scheduler.
 */

/*
Schedulers.io()
Schedulers.computation()
Schedulers.newThread()
Schedulers.single()
Schedulers.trampoline()
Schedulers.from()
 */