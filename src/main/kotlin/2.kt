import io.reactivex.subjects.*

fun isEvenOrOdd(n: Int): String = if ((n % 2) == 0) "Even" else "Odd"

fun main(args: Array<String>) {
    val subject: Subject<Int> = PublishSubject.create()

    subject.map({ isEvenOrOdd(it) }).subscribe({
        println("The number is $it")
    })

    subject.onNext(4)
    subject.onNext(9)
}

/*
The number is Even
The number is Odd
*/