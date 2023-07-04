

fun main(args: Array<String>) {
    println("Hello World!")
    dicemain()
    var myDice:Dice=Dice()

    myDice.showDice()
    myDice.doDice()


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    Runtime.getRuntime().addShutdownHook(Thread {
        // Code, der ausgeführt werden soll, wenn der Prozess beendet wird
        println("Prozess wird beendet...")
        // Weitere Aktionen, die du ausführen möchtest
    })
}


fun dicemain() {
    val diceChar = '\u2680'
    println(diceChar)
}