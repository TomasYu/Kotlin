package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Test1 {

}

fun main(){
    runBlocking {
        launch {
            delay(1000L)
            println("World!")
        }
        println("Hello")
    }
}