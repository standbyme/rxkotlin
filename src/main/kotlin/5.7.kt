// 5.7.kt
import io.reactivex.subjects.ReplaySubject

fun main(args: Array<String>) {
    val subject = ReplaySubject.create<Int>()
    subject.onNext(1)
    subject.onNext(2)
    subject.subscribe(observer)
    subject.onNext(3)
    subject.subscribe(observer)
    subject.onComplete()
}

/*
New Subscription
Next 1
Next 2
Next 3
New Subscription
Next 1
Next 2
Next 3
All Completed
All Completed
 */