// 7.1.kt
import io.reactivex.Observable

fun main(args: Array<String>) {
    data class Item(val id: Int) {
        init {
            println("Item Created $id")
        }
    }

    Observable.just(1, 2, 3).map { Item(it) }
            .subscribe({
                println("Received $it")
                Thread.sleep(100)
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
