import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.just(1, 2, 3, 4, 5)
            .scan { x, y -> x + y }
            .subscribe(observer)
}
/*
New Subscription
Next 1
Next 3
Next 6
Next 10
Next 15
All Completed
 */
/*
Transforming
!!! Picture
Scan
https://www.safaribooksonline.com/library/view/reactive-programming-in/9781788473026/assets/5bce443b-389b-4fe1-8dd2-9537b09bebf4.png
It takes a lambda with two arguments.
The first parameter is the result of a rolling aggregation of all previous emissions;
the second one is the current emission.
 */