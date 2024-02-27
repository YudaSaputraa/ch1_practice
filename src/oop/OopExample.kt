package oop

// encapsulation
private class AClass() {
    private fun run() {
        println("This is fron Class A")
    }

    fun runPublic() {
        println("This is from class A in public")
    }
}

class BClass() {
    fun run() {
        AClass().runPublic()
        println("This is fron Class B")
    }
}

// Abstraction
interface Balloon { // kakek
    fun blow()
    fun pop()
}

abstract class HotAirBallon() : Balloon { //  bapak
    override fun blow() {
        println("Blow the Ballon using hot air")
    }

    override fun pop() {
        println("Danger !!!")
    }
    fun moveLeft(){
        println("Move the ballon to the left")
    }
    // wajib diimplement di class turunan
    abstract fun carryPassengers()

}

class RedHotAirBallon() : HotAirBallon() { // extends //anak
    override fun carryPassengers() {
        println("Carrying 5 Passengers")
    }

    override fun blow() { // mengganti sifat dari parent
        println("blowing the ballon using Doa")
    }

    // overloading
     fun blow(name : String) { // mengganti sifat dari parent
        println("blowing the ballon using Doa")
    }

}
class BlueHotAirBallon() : HotAirBallon() { // extends //anak
    override fun carryPassengers() {
        println("Carrying 5 Passengers")
    }

    override fun blow() { // mengganti sifat dari parent
        println("blowing the ballon using Blue energy")
    }

    // overloading
    fun blow(name : String) { // mengganti sifat dari parent
        println("blowing the ballon using Doa")
    }

}

class RedBalloon() : Balloon { // implements
    override fun blow() {
        println("Meniup Balon merah")
    }

    override fun pop() {
        println("Balon merah meledak...")
    }

}

class BlueBalloon() : Balloon {
    override fun blow() {
        println("Meniup Balon biru")
    }

    override fun pop() {
        println("Balon biru meledak...")
    }

}
// Inheritance using open class
open class Processor(val name: String){
    fun initProcessor(){
        println("Initialize ... $name")
    }
}

class AMDProcessor():Processor("Ryzen 9")
class IntelProcessor():Processor("Intel core i9")


fun main(args: Array<String>) {
//    RedHotAirBallon().let {
//        //sifat kakek
//        it.blow()
//        it.pop()
//        //sifat bapak
//        it.moveLeft()
//    }
    AMDProcessor().initProcessor()
    IntelProcessor().initProcessor()


}