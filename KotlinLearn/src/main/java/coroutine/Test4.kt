package coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Test4 {

}

fun main(){
    runBlocking {
        doWorld()
        println("end!!!!")
    }

}

private suspend fun doWorld() {
    coroutineScope {
        launch {
            delay(2000L)
            println("World!2")
        }
        launch {
            delay(1000L)
            println("World!1")
        }
        println("Hello")
    }
    println("doWorld !!!!")
}

//runBlocking  和  coroutineScope 区别是什么？