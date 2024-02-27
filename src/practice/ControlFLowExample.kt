package practice

import app.model.ComputerSpec

class ControlFLowExample {
    private val computerData = listOf(
        ComputerSpec(
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveIGPU = true,
            totalRamInGb = 32,
            EGPUName = "RTX 4080"
        ),
        ComputerSpec(
            processorName = "Intel Celeron",
            processorTotalCore = 2,
            isHaveIGPU = false,
            totalRamInGb = 4,
            EGPUName = "GTX 300"
        )
    )


    val name: String? = "nawangsari"
    fun run() {
        //if else
//        println(checkNameUsingWhen(name))
//        exampleWhen()
//        checkName()
        printSomething()

    }

    fun printSomething() {
        //for - loop 1
        for (index in 1..10) {
            println("ini loop-$index")
        }
        //step loop
        for (index in 1..10 step 2) {
            println("ini loop-$index")
        }
        //downTo
        for (index in 10 downTo 1 step 2) {
            println("ini loop-$index")
        }
        //for loop manual
        for (index in computerData.indices) {
            println("$index ${computerData[index]}")
        }

        //equivalen


        //dowhile
        var index = 0
        do {
            println("do while index $index")
            index++

        } while (index < 5)

        index = 0
        while (index < 5) {
            println("while index $index")
            index++
        }

        //escape
        for (index in 1..10) {
            if (index == 5) continue
            println("ini with continue loop-$index")
        }
        //destroy the loop
        for (index in 1..10) {
            if (index == 5) break
            println("ini with break loop-$index")
        }

    }

    fun checkName(name: String?): String {
        return if (name == null) {
            "Your name still Empty"
        } else if (name.contains("Komang", ignoreCase = true)) {
            "Komang anak bali kan?"
        } else if (name.contains("bella", ignoreCase = true)) {
            "ohh bella anak batam>?"
        } else {
            "iih gatau dimana"
        }
    }

    private fun checkNameUsingWhen(name: String?): String { // buat nilai yang udah fix
        return when (name) {
            "yuda" -> "Apakah kamu lahir di februari?"
            "nawangsari" -> "apakah kamu lahir di nawangjagad?"
            else -> {
                "Data kamu tidak ada"
            }
        }


    }

    private fun exampleWhen() {
        val contentType = ContentType.PHOTO
        when (contentType) {
            ContentType.PHOTO -> {
                println("Ini Photo")
            }

            ContentType.VIDEO -> {
                println("ini Video")
            }

        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ControlFLowExample().run()
        }
    }
}

private var name: String? = "Tony stark"

private fun checkName() { //
    //escape condition
    if (name == null) return
    println("Nama anda adalah $name")
    println("Anda adalah anak pemilik BCA")

}

enum class ContentType {
    PHOTO, VIDEO
}