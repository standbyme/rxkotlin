import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable = Observable.interval(10, TimeUnit.MILLISECONDS)
    val subject = PublishSubject.create<Long>() //we created Subject with PublishSubject.create()
    /*
    There are many types of Subject available.
    PublishSubject is one of them.
    PublishSubject emits to an observer only those items that are emitted by the Observable sources subsequent to the time of the subscription.
    We will discuss in detail about the various types of Subject in the next section in this chapter.
     */
    observable.subscribe(subject)
    subject.subscribe({ println("Received $it") })
    Thread.sleep(60)
}

// Subjects
/*
Received 0
Received 1
Received 2
Received 3
Received 4
Received 5
 */

/*
You are probably thinking, what is the benefit of that?
When I can directly subscribe and Observer to Observable
, why should I use PublishSubject in between?
 */
