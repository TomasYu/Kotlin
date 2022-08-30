class Test {
}

//fun main() {
//    out@ for (i in 1..3) {
//        for (j in 1..100) {
//            if (i == 2) {
//                continue@out
//            }
//            println("$i $j")
//
//        }
//    }
//}
fun main() {
    println(foo(intArrayOf(10, 20, 20, 0, 30)))
}

/**
10
20
20
 */
fun foo(ints: IntArray){
    ints.forEach {
        if (it == 0) return // 默认从foo(){}返回
        println(it)
    }
}

/**
 * 10
20
20
30
 *
 *
 *相当于continue
 */
fun foo2(ints: IntArray) {
    ints.forEach lin@{
        if (it == 0) return@lin
        println(it)
    }
}

/**
 * 10
20
20
30
相当于continue
 */
fun foo3(ints: IntArray) {
    ints.forEach {
        if (it == 0) return@forEach
        println(it)
    }
}

/**
 * 10
20
20
30

相当于continue
 */
fun foo4(ints: IntArray) {
    ints.forEach(fun(value: Int) {
        if (value == 0) return
        println(value)
    })
}
