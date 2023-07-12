class Dice() {
    var numberOfDices: Int = 2
    val diceSymbols: List<Char> = listOf(
        '\u2680',
        '\u2681',
        '\u2682',
        '\u2683',
        '\u2684',
        '\u2685',
    )

    fun showDice() {
        diceSymbols.forEach {
            print(" " + it)
        }
    }

    fun setDiceNumber(numberOfDices: Int) {
        this.numberOfDices = numberOfDices
    }

    fun doDice() {
        var j: Int = 0
        var i: Int = 0
        for (i in 0..this.numberOfDices - 1) {
            var myRand = (1..6).random()
            print(diceSymbols[myRand - 1] + "   ")
            for (j in 1..myRand)
                print(myRand.toString())
            println("")
        }
    }
}