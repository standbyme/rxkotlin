// Lambda Function

fun main(args: Array<String>) {
    val sum = { x: Int, y: Int -> x + y }
    println("Sum ${sum(12, 14)}")
}