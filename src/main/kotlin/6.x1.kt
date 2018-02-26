// 6.7.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable
            .just(2, 3, 1)
            .sorted()
            .subscribe(observer)
}

/*
New Subscription
Next 1
Next 2
Next 3
All Completed
 */
/*
Caution: As we already mentioned
, the sorted operator collects all emissions and then sorts them before reemitting them in a sorted order;
thus, using this operator can cause significant performance implications.
Moreover, while using with large producers, it can cause OutOfMemory Error as well.
So, use the sorted operator cautiously, or try to avoid it unless extensively required.
 */