import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.just(54).subscribe(observer)
    Observable.just(listOf(1, 2, 3)).subscribe(observer)
    // Same Effect
    Observable.just(1, 2, 3).subscribe(observer)
    Observable.fromIterable(listOf(1, 2, 3)).subscribe(observer)
}

/*
New Subscription
Next 54
All Completed
New Subscription
Next [1, 2, 3]
All Completed
New Subscription
Next 1
Next 2
Next 3
All Completed
New Subscription
Next 1
Next 2
Next 3
All Completed
 */