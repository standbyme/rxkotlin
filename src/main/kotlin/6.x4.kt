import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    Observable
            .range(1, 10)
            .reduce { previousAccumulation, newEmission -> previousAccumulation + newEmission }
            .subscribeBy { println("accumulation $it") }
}