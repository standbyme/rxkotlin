import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {

    Observable.interval(500, TimeUnit.MILLISECONDS)
            .subscribe { println(it) }

    Thread.sleep(2500)
}

/*
0
1
2
3
4
 */
/*
This Observable will actually fire on a thread other than the main one.
Effectively, the main thread will kick-off Observable.interval(),
but not wait for it to complete because it is operating on its own separate thread now.
This, in fact, makes it a concurrent application because it is leveraging two threads now.
If we do not call a sleep() method to pause the main thread,
it will charge to the end of the main() method and quit the application before the intervals have a chance to fire.
 */