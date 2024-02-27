package app

import app.model.ComputerSpec

class App (var creatorName : String ){ //constructor nullable
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
        ) ,
        ComputerSpec(
            processorName = "Intel Pentium",
            processorTotalCore = 2,
            isHaveIGPU = false,
            totalRamInGb = 2,
            EGPUName = "GTX 2080"
        )
    )

    private var selectedComputer : ComputerSpec? = null

    fun run(){
        printHeader()
        getSelectedComputer()
    }
   private fun printHeader(){
       println("=========================")
       println(computerData)
       println("=========================")
           println("Created by $creatorName")

       //sama dengen
//       if (creatorName != null){
//           println("Created by $creatorName")
//       }else{
//           println("This program is Open Source")
//       }

        println("=========================")
        println("Order PC App")
        println("=========================")
       computerData.forEachIndexed{index, data -> // lamda function
           println("${index + 1}.${data.processorName} : ${data.EGPUName}")
       }
        println("==========================")

    }
    private fun getSelectedComputer(){
        println("Masukkan Pilihan Anda : ")
        try {
            val selectedIndex = readln().toInt()
            if ( selectedIndex in 1 .. computerData.size){
                selectedComputer = computerData[selectedIndex - 1]
                println("Pilihan komputer anda : \n$selectedComputer")

            }else{
                println("Pilihan anda tidak ada")
               getSelectedComputer()
            }


            print("pilihan anda adalah $selectedIndex")
        }catch (e : NumberFormatException){
            println("Input anda bukan angka")
            getSelectedComputer() //recursive
        }
    }
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

            val app = App("Tony Stark") // Object of App

            app.run()
            //    App().run() // agar lebih singkat
        }
    }

}



