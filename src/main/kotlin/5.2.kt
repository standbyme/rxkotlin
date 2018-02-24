// 5.2.kt
import io.reactivex.subjects.AsyncSubject

fun main(args: Array<String>) {
    val subject = AsyncSubject.create<Int>()
    subject.onNext(1)
    subject.onNext(2)
    subject.subscribe(observer)
    subject.onNext(3)
    subject.subscribe(observer)
    subject.onComplete()
}

/*
New Subscription
New Subscription
Next 3
All Completed
Next 3
All Completed
 */

/*
As ConnectableObservable starts emitting on call of connect,
AsyncSubject emits its only value on call of onComplete only.
 */