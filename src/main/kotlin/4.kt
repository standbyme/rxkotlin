// https://www.safaribooksonline.com/library/view/reactive-programming-in/9781788473026/f618b5d2-ec1d-40a9-bd41-99be0f0963ff.xhtml

inline fun doSomeStuff(a: Int) = a * a

fun main(args: Array<String>) {
    for (i in 1..5) {
        println("$i Output ${doSomeStuff(i)}")
    }
}