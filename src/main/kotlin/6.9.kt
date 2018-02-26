import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.just("1", "2", "3", "4", "5")
            .scan { x, y -> x + " " + y }
            .subscribe(observer)
}

/*
New Subscription
Next 1
Next 1 2
Next 1 2 3
Next 1 2 3 4
Next 1 2 3 4 5
All Completed
 */