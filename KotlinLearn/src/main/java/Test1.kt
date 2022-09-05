import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.pow

class Test1 {


}

infix fun Int.`**`(x: Int) = toDouble().pow(x).toInt()
infix fun Long.`**`(x: Int) = toDouble().pow(x).toLong()
infix fun Float.`**`(x: Int) = pow(x)
infix fun Double.`**`(x: Int) = pow(x)
suspend fun main() = coroutineScope {
    launch {
        delay(1000)
        println("Kotlin Coroutines World!")

        sumReduce()
    }
    println("Hello")
    var p = null
//    p = Person("f")
//    val person = p as? Person
//    val person2 = p as? Person
//    val b = person == person2
//    person === person2
//    person?.copy("ff")

//    println(person?.name)

    println(Person("f", 19) == Person("f", 19))
    println(Person("f", 19) .equals(Person("f", 19)))
    println(Person("f", 19) === Person("f", 19))
    var(name,age) = Person("f", 19)
    var a = -Person("f", 19)
    println(a.name1)
    println(a.age)


    println(200210.toString(2))
    println(2 `**` 3)
    println(4.inv())
    println(0b0000_0100.inv())
    println(Task("aaa", 2).priority)


    val numbers = intArrayOf(3, 1)
    println(sumReduce(*numbers))

}

fun sumReduce(vararg nums: Int) =    nums.reduce { acc, i -> acc + i }

operator fun Person.unaryMinus() =
    Person(name1 +"test", -age)


data class Person(var name1:String,var age:Int){

    var priority = 3
        set(value) {
            field = value.coerceIn(1..5)
        }
}


class Task(val name: String, _priority: Int = DEFAULT_PRIORITY) {
    companion object {
        const val MIN_PRIORITY = 1
        const val MAX_PRIORITY = 5
        const val DEFAULT_PRIORITY = 3
    }

    var priority = validPriority(_priority)
        set(value) {
            field = validPriority(value)
        }

    private fun validPriority(p: Int) =
        p.coerceIn(MIN_PRIORITY, MAX_PRIORITY)
}
