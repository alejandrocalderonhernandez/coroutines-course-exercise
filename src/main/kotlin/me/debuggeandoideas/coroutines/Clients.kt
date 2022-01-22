package me.debuggeandoideas.coroutines

class UserApiClient {
    fun getClientById(id: Int): User {
        ClientUtil.randomThreatSleep()
         Data.users.forEach{ u ->
            if (u.id == id) {
                return u
            }
        }
        throw IllegalArgumentException("Invalid id")
    }
}

class CreditApiClient {
    fun getUserWithDebts(user: User): UserDebts {
        ClientUtil.randomThreatSleep()
        val id = user.id
        if(Data.debts.containsKey(id)) {
            return UserDebts(id, Data.debts[id])
        }
        throw IllegalArgumentException("Invalid id")
    }
}

class PostData {

    fun postInternationalBank(user: UserDebts) {
        ClientUtil.randomThreatSleep()
        ClientUtil.postUser(user, "International Bank")
    }

    fun postBBVA(user: UserDebts) {
        ClientUtil.randomThreatSleep()
        ClientUtil.postUser(user, "BBVA")
    }

    fun postBlueBank(user: UserDebts) {
        ClientUtil.randomThreatSleep()
        ClientUtil.postUser(user, "blue bank")
    }
}

class ClientUtil {

    companion object {
        fun randomThreatSleep() {
            val sleep = (1..3).random().toLong()
            try {
                Thread.sleep(sleep * 1000)
            } catch (e: Exception) {
                println("Error to sleep thread")
            }
        }

        fun postUser(user: UserDebts, bank: String) {
            println("Posting in $bank with id: ${user.id}")
        }
    }

}