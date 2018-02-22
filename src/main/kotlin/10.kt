import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.just("A String").subscribe(observer)
    Observable.just(54).subscribe(observer)
    Observable.just(listOf("String 1", "String 2", "String 3",
            "String 4")).subscribe(observer)
    Observable.just(mapOf(Pair("Key 1", "Value 1"), Pair
    ("Key 2", "Value 2"), Pair("Key 3", "Value3"))).subscribe(observer)
    Observable.just(arrayListOf(1, 2, 3, 4, 5, 6)).subscribe(observer)
    Observable.just("String 1", "String 2", "String 3").subscribe(observer)//1
}