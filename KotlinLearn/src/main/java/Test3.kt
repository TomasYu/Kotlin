class Test3 {

}

fun main() {
    val items = listOf(1, 2, 3, 4, 5)

// Lambdas are code blocks enclosed in curly braces.
    items.fold(0, {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    })

// Parameter types in a lambda are optional if they can be inferred:
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i }).also { println(it) }

// Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times).also { println(it) }



    val repeatFun: String.(Int) -> String = { times -> this.repeat(times) }
    val twoParameters: (String, Int) -> String = repeatFun // OK

    fun runTransformation(f: (String, Int) -> String): String {
        return f("hello", 3)
    }
    val result = runTransformation(repeatFun) // OK
    println(result)
    println(twoParameters("aaa", 3))
    println(repeatFun("aaa", 3))
    println("aaa".repeatFun(3))


    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3)) // extension-like call


    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    val sum2 = { x: Int, y: Int -> x + y }

    listOf<Int>().filter {
        val shouldFilter = it > 0
        shouldFilter
    }

    listOf<Int>().filter {
        val shouldFilter = it > 0
        return@filter shouldFilter
    }

    listOf<String>().filter { it.length == 5 }.sortedBy { it }.map { it.uppercase() }

    mapOf<Int,Int>().forEach { (_, value) -> println("$value!") }

    fun(x: Int, y: Int): Int {
        return x + y
    }
    fun(x: Int, y: Int): Int = x + y
    listOf<Int>().filter(fun(item) = item > 0)


    var sum3 = 0
    listOf<Int>(2,3,4).filter { it > 0 }.forEach {
        sum3 += it
    }
    print(sum3)

    val sum333: Int.(Int) -> Int = { other -> plus(other) }



    class HTML {
        fun body() {  }
    }

    fun html(init: HTML.() -> Unit): HTML {
        val html = HTML()  // create the receiver object
        html.init()        // pass the receiver object to the lambda
        return html
    }

    html {       // lambda with receiver begins here
        body()   // calling a method on the receiver object
    }

}