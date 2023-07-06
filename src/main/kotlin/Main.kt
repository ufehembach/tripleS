fun main(args: Array<String>) {
    println("Hello World!")
    println("""
 _____     _       _      ____
|_   _| __(_)_ __ | | ___/ ___|
  | || '__| | '_ \| |/ _ \___ \
  | || |  | | |_) | |  __/___) |
  |_||_|  |_| .__/|_|\___|____/
            |_|
    """.trimIndent())

    println("Spiel Stand System")

//    var myDice:Dice=Dice()
//    myDice.showDice()
//    myDice.doDice()
    var theTriples:TheTripleS=readTheTripleS()
   theTriples.doIt()
}
