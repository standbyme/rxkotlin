// 5.6.kt
import io.reactivex.subjects.BehaviorSubject

fun main(args: Array<String>) {
    val subject = BehaviorSubject.create<Int>()
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
Next 2  // S1
Next 3  // S1
New Subscription
Next 3  // S2
Next 4  // S1
Next 4  // S2
All Completed
All Completed
 */