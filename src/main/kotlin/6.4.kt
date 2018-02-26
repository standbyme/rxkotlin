// 6.4.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.range(0, 10)//(1)
            .filter { it > 15 }//(2)
            .subscribe(observer)
}

/*
New Subscription
All Completed
 */
/*
Conditional and Boolean Operators

 */