import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.range(1, 3).subscribe(observer)
}

/*
New Subscription
Next 1
Next 2
Next 3
All Completed
 */