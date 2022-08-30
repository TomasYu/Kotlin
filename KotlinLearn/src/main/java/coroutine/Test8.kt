package coroutine

import kotlinx.coroutines.*

class Test6 {

}

//fun main(){
//    runBlocking {
//        val job = launch {
//            repeat(1_000) {i->
//                launch {
//                    println("job: I'm sleeping $i")
//                    delay(500L)
//                }
//            }
//        }
//        delay(1300L)
//        println("main: I'm tired of waiting!")
//        job.cancel()
//        job.join()
//        println("end")
//
//    }
//
//}


//fun main() = runBlocking {
////sampleStart
//    val startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        var nextPrintTime = startTime
//        var i = 0
//        while (i < 10) { // 一个执行计算的循环，只是为了占用 CPU
//            // 每秒打印消息两次
//            if (System.currentTimeMillis() >= nextPrintTime) {
//                println("job: I'm sleeping ${i++} ...")
//                nextPrintTime += 500L
//            }
//        }
//    }
//    delay(1300L) // 等待一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消一个作业并且等待它结束
//    println("main: Now I can quit.")
////sampleEnd
//}


//fun main() = runBlocking {
////sampleStart
//    val startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        var nextPrintTime = startTime
//        var i = 0
//        while (isActive) { // 可以被取消的计算循环
//            // 每秒打印消息两次
//            if (System.currentTimeMillis() >= nextPrintTime) {
//                println("job: I'm sleeping ${i++} ...")
//                nextPrintTime += 500L
//            }
//        }
//    }
//    delay(1300L) // 等待一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消该作业并等待它结束
//    println("main: Now I can quit.")
////sampleEnd
//}
//

//只是因为我catch了  导致所有的都要打印一下？
fun main() = runBlocking {
//sampleStart
    val job = launch(Dispatchers.Default) {
        repeat(100000) { i ->
            try {
                if (!isActive) {
                    return@launch
                }
                // print a message twice a second
                println("job: I'm sleeping $i ...")
                delay(500)
            } catch (e: Exception) {
                // log the exception
                println(e)
            }finally {
                println("job: I'm running finally")
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
//sampleEnd
}


//
//fun main() = runBlocking {
////sampleStart
//    val job = launch (Dispatchers.Default) {
//        try {
//            repeat(10000) { i ->
//                println("job: I'm sleeping $i ...")
//                delay(500L)
//            }
//        } finally {
//            withContext(NonCancellable) {
//                println("job: I'm running finally")
//                delay(1000L)
//                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
//            }
//        }
//    }
//    delay(1300L) // 延迟一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消该作业并等待它结束
//    println("main: Now I can quit.")
////sampleEnd
//}

//fun main() = runBlocking {
////sampleStart
//    val job = launch(Dispatchers.Default) {
//        repeat(10000) { i ->
//            try {
//
//                println("job: I'm sleeping $i ...")
//                delay(500L)
//            } finally {
////                withContext(NonCancellable) {
//                    println("job: I'm running finally")
//                    delay(1000L)
//                    println("job: And I've just delayed for 1 sec because I'm non-cancellable")
////                }
//            }
//        }
//
//    }
//    delay(1300L) // 延迟一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消该作业并等待它结束
//    println("main: Now I can quit.")
////sampleEnd
//}


//fun main() = runBlocking {
////sampleStart
//    withTimeout(1300L) {
//        repeat(1000) { i ->
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//    }
////sampleEnd
//}

//fun main() = runBlocking {
////sampleStart
//    val result = withTimeoutOrNull(1300L) {
//        repeat(1000) { i ->
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//        "Done" // 在它运行得到结果之前取消它
//    }
//    println("Result is $result")
////sampleEnd
//}


//sampleStart
var acquired = 0

class Resource {
    init {
        acquired++
    } // Acquire the resource

    fun close() {
        acquired--
    } // Release the resource
}

//fun main() {
//    runBlocking {
//        repeat(100_000) { // Launch 100K coroutines
//            launch {
//                val resource = withTimeout(60) { // Timeout of 60 ms
//                    delay(50) // Delay for 50 ms
//                    Resource() // Acquire a resource and return it from withTimeout block
//                }
//                resource.close() // Release the resource
//            }
//        }
//    }
//    // Outside of runBlocking all coroutines have completed
//    println(acquired) // Print the number of resources still acquired
//}
//sampleEnd


//fun main() {
////sampleStart
//    runBlocking {
//        repeat(100_000) { // Launch 100K coroutines
//            launch {
//                var resource: Resource? = null // Not acquired yet
//                try {
//                    withTimeout(60) { // Timeout of 60 ms
//                        delay(50) // Delay for 50 ms
//                        resource = Resource() // Store a resource to the variable if acquired
//                    }
//                    // We can do something else with the resource here
//                } finally {
//                    resource?.close() // Release the resource if it was acquired
//                }
//            }
//        }
//    }
//    // Outside of runBlocking all coroutines have completed
//    println(acquired) // Print the number of resources still acquired
////sampleEnd
//}

