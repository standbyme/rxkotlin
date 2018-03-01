
inline fun doSomeStuff(a: Int) = a * a

fun main(args: Array<String>) {
    for (i in 1..5) {
        println("$i Output ${doSomeStuff(i)}")
    }
}

/*
1 Output 1
2 Output 4
3 Output 9
4 Output 16
5 Output 25
 */