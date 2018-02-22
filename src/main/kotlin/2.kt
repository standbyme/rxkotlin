import io.reactivex.subjects.*

fun isEven(n: Int): Boolean = ((n % 2) == 0)

fun main(args: Array<String>) {
    val subject: Subject<Int> = PublishSubject.create()

    subject.map({ isEven(it) }).subscribe({
        println("The number is ${(if (it) "Even" else "Odd")}")
    })

    subject.onNext(4)
    subject.onNext(9)
}

/*
The number is Even
The number is Odd
*/