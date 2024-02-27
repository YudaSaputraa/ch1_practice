package practice

import app.model.ComputerSpec

class ScopeFunctionExample {
    private val creatorName : String? = null;
    private var computerData : ComputerSpec? = null

    fun run(){
        creatorName?.let {
            println("Created by $creatorName")
        }?: run {
            println("This program is Open Source")
        }
        println(computerData)
        computerData?.apply {
            this.processorName = "Intel Pentium"
        }?: run{ println("")}
        computerData = ComputerSpec(
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveIGPU = true,
            totalRamInGb = 32,
            EGPUName = "RTX 4080"
        )
        computerData?.apply {
            this.processorName = "Intel Celereon"
        }?: run{println("computer data is null")}
          println(computerData)

        // with

        //berfore
        println(computerData?.processorName)
        println(computerData?.totalRamInGb)

        //after

        with(computerData)
        {
            println(this?.processorName)
            println(this?.totalRamInGb)
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            ScopeFunctionExample().run()
        }
    }
}