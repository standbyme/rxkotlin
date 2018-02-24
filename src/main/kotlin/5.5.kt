// 5.5.kt
import io.reactivex.subjects.AsyncSubject

fun main(args: Array<String>) {
    val subject = AsyncSubject.create<Int>()
    subject.onNext(1)
    subject.onNext(2)
    subject.subscribe(observer)
    subject.onNext(3)
    subject.subscribe(observer)
    subject.onNext(4)
    subject.onComplete()
}

/*
New Subscription
New Subscription
Next 4  // S1
All Completed
Next 4  // S2
All Completed
 */

/*
As ConnectableObservable starts emitting on call of connect,
AsyncSubject emits its only value on call of onComplete only.
 */