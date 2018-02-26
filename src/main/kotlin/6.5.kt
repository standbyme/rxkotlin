// 6.5.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.range(0, 10)
            .filter { it > 15 }
            .defaultIfEmpty(15)
            .subscribe(observer)
}

/*
New Subscription
Next 15
All Completed
 */

/*
Conditional and Boolean Operators
DefaultIfEmpty
http://reactivex.io/documentation/operators/images/defaultIfEmpty.c.png
 */