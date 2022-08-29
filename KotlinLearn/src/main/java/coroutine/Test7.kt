package coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Test7 {

}

fun main(){
    runBlocking {
        repeat(100_000){
            launch {
                delay(5000L)
                println(".")
            }
        }
    }

}

