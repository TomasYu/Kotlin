package coroutine

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Test8 {

}

/**
{@link com.sun.jmx.snmp.SnmpScopedPduRequest SnmpScopedPduRequest}
 */
//{@link }
fun main(){
    runBlocking {
        val job = launch {
            repeat(1_000) {i->
                println("job: I'm sleeping $i")
                delay(500L)
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting!")
        job.cancel()
        job.join()
        println("end")

    }

}

