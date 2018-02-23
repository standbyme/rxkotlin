import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.empty<String>().subscribe(observer)
}

/*
New Subscription
All Completed
 */