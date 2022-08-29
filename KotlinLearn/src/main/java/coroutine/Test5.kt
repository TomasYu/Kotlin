package coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Test5 {

}

fun main(){
    runBlocking {
        doWorld()
        println("end!!!!")
    }

}

private suspend fun doWorld() {
    coroutineScope {
        val job = launch {
            delay(2000L)
            println("World!2")
        }
        launch {
            delay(1000L)
            println("World!1")
        }
        job.join()
        println("Hello")
    }
    println("doWorld !!!!")
}

//runBlocking  和  coroutineScope 区别是什么？