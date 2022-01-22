package me.debuggeandoideas.coroutines

import kotlin.system.measureTimeMillis

fun main() {

    val time = measureTimeMillis {
        val userClient = UserApiClient()
        val creditApiClient = CreditApiClient()
        val post = PostData()
        for(i in 1..5){
            val user = userClient.getClientById(i)
            val userWithDebts = creditApiClient.getUserWithDebts(user)
            println(user)
            println(userWithDebts)
            post.postBBVA(userWithDebts)
            post.postBlueBank(userWithDebts)
            post.postInternationalBank(userWithDebts)
        }
    }

    println("Total " + time / 1000 + " seconds")
}

