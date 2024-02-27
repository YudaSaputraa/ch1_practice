package solid

import oop.*

// single Responsibility
class CalculatorWrong() {

    //global variable
    private val something: String = "Hello"
    fun plus(a: Int, b: Int) {
        val result = a + b
        println("Result is : $result")
    }

}

class CalculatorRight() {

    //global variable
    private val something: String = "Hello"
    fun plus(a: Int, b: Int): Int {
        return a + b
    }

}

fun prinResult(result: Number) {
    println("The result is $result")
}


class RockPapperScissor() {
    private var playerOne: Int = -1
    private var playerTwo: Int = -1

    private fun printOption() {
        println(
            """
            ===================
            GUNTING BATU KERTAS
            ===================
            OPTION :
            1. Gunting
            2. Batu
            3. Kertas

        """.trimIndent()
        )
    }

    private fun showResult(playerOne: Int, playerTwo: Int): String {
        return if (((playerOne + 1) % 3) == playerTwo) {
            "Player 2 menang"
        } else if (playerOne == playerTwo) {
            "Seri"
        } else {
            "Player 1 menang"
        }
    }

    private fun inputPlayerOne() {
        println("Masukkan pilihan 1 (0/2/3): ")
        playerOne = readln().toInt()
    }

    private fun inputPlayerTwo() {
        println("Masukkan pilihan 2 (0/1/2) : ")
        playerTwo = readln().toInt()
    }

    fun run() {
        printOption()
        inputPlayerOne()
        inputPlayerTwo()
        println(showResult(playerOne, playerTwo))
    }
}


// Open - Close
open class IronManSuit() {
    open fun blast() {
        println("Blast using laser powered by Arc Reactor")
    }

    fun activateAI() {
        println("Jarvis is active")
    }
}

class WarMachineSuit() : IronManSuit() {
    override fun blast() {
        println("Blast from war machine suit")
    }

}

// liskov subtitution
// using hot air balloon
class Capadocia() {
    private lateinit var balloon: HotAirBallon
    fun run() {
        balloon = BlueHotAirBallon()
        balloon.apply {
            carryPassengers()
            blow()
            pop()
        }
    }
}

// Interface Segregation
interface Animal {
    fun eat()
    fun hunt()
    fun walking()


    fun sleep()
    fun jump()
    fun breath()
    fun sound()
    fun reproduction()

}

interface Aves : Animal {
    fun fly()
    fun twit()
}

interface Fish : Animal {
    fun swim()

}

class Bird() : Aves {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        TODO("Not yet implemented")
    }

    override fun twit() {
        TODO("Not yet implemented")
    }


    override fun sleep() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }

    override fun reproduction() {
        TODO("Not yet implemented")
    }

}

class CatFish() : Fish {
    override fun swim() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }

    override fun reproduction() {
        TODO("Not yet implemented")
    }

}

// Dependency Inversion

class FirebaseAnalytics() {
    fun log(event: String) {
        println("Logging to firebase : Event Name : $event")
        Thread.sleep(2000)
        println("Logging success !")
    }
}

class NewRelicAnalytics() {
    fun log(event: String) {
        println("Logging to NewRelicAnalytics : Event Name : $event")
        Thread.sleep(2000)
        println("Logging success !")
    }
}

class MoEnggageAnalytics() {
    fun log(event: String) {
        println("Logging to MoEnggageAnalytics : Event Name : $event")
        Thread.sleep(2000)
        println("Logging success !")
    }
}

interface Analytics {
    fun logEvent(event: String)
}

// agnostic class
class AppAnalytics() : Analytics {
    private var firebaseAnalytics = FirebaseAnalytics()
    private var moEnggageAnalytics = MoEnggageAnalytics()
    private var newRelicAnalytics = NewRelicAnalytics()
    override fun logEvent(event: String) {
        firebaseAnalytics.log(event)
        moEnggageAnalytics.log(event)
        newRelicAnalytics.log(event)
    }

}

class SplashScreen(private val analytics: Analytics) {
    fun openPage() {
        println("Open page SplashScreen....")
        analytics.logEvent("SplashScreen")
    }
}

class HomaPage(private val analytics: Analytics) {


    fun openPage() {
        println("Open page login....")
        analytics.logEvent("Login")
    }

    class LoginPage(private val analytics: Analytics) {
        fun openPage() {
            println("Open page home....")
            analytics.logEvent("Home")
        }
    }

}

class App() {
    private val analytics = AppAnalytics()
    fun run() {
        SplashScreen(analytics).openPage()
        HomaPage(analytics).openPage()
        HomaPage.LoginPage(analytics).openPage()

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}

fun main(args: Array<String>) {
//    RockPapperScissor().run()
//    WarMachineSuit().blast()
    Capadocia().run()
}

