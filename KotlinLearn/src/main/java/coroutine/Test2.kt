package coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Test2 {

}

fun main(){
    runBlocking {
        launch {
            doWorld()
        }
        println("Hello")
    }
    println("!!!!")
}

private suspend fun doWorld() {
    delay(1000L)
    println("World!")
}