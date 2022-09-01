package flow

import com.sun.activation.registries.LogSupport.log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.cancellable
import kotlin.system.measureTimeMillis

class Test1 {

}

fun main() = runBlocking<Unit> {
//    log("ffasdf")
//    println(measureTimeMillis {
//        val async = async {
//            delay(1000L)
//        }
//        async.await()
//    })
//
//    (1..5).asFlow().cancellable().collect { value ->
////        if (value == 3) cancel()
//        println(value)
//    }
//
//    launch(Dispatchers.Unconfined) {  }
//    launch(newFixedThreadPoolContext(2,"aaa")) {
//        println("${Thread.currentThread().name}")
//    }
//


    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                println(("Started in ctx1 ${Thread.currentThread().name}"))
                withContext(ctx2) {
                    println("Working in ctx2 ${Thread.currentThread().name}")
                }
                println(("Back to ctx1 ${Thread.currentThread().name}"))
            }
        }
    }

    launch (Job()){  }
    MainScope()
    Dispatchers.Main
    yield()
}