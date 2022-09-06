class Test2 {
}

fun main() {
//    val str: String? = "Hello"
    val str: String? = null
//processNonNullString(str)       // compilation error: str can be null
    val length = str?.let {
        println("let() called on $it")
        it.length
    } ?: 2
    println(length)


    val numbers = mutableListOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }.let(::println)

//    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!$firstItem!"
    }.uppercase().let(::println)


    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }
    println(firstAndLast)


    val also = "fafdafs".also { it.length }.also { println(it) }
    println(also)

    "fasdfasfsadf".let { it.length }.let { it * 200 }.let {
        println(it)
        20
    }.let(::println)

    1 shl 2

    val oddNumbers = generateSequence(1) { it + 2 } // `it` is the previous element
    println(oddNumbers.take(444).toList())
}