// 7.1.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    data class Item(val id: Int) {
        init {
            println("Item Created $id")
        }
    }

    val observable = Observable.just(1, 2, 3).map { Item(it) }
    observable
            .subscribe({
                println("Received $it")
                Thread.sleep(500)
            })
    Thread.sleep(1000)
}

/*
Item Created 1
Received Item(id=1)
Item Created 2
Received Item(id=2)
Item Created 3
Received Item(id=3)
 */
