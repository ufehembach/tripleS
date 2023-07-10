/*
nur einser
nur zweier
nur dreier
nur vierer
nur fünfer
nur secher
gesamt
bonus bei 63 oder mehr -> plus 35
gesamter oberer teil

dreierpasch alle augen
viererpasch alle augen
full-house 35 punkte (2+3)
kleine strasse 30 Punkte (4 in der reihe)
grosse strasse 40 punkte (5 in der reihe)
kniffel 50 Punkte (5er pasch)
chance alle augen zählen
gesamt unterer teil
gesamt oberer teil
endsumme

 */
class GKniffel() : GGeneric() {
    init {
        println("Kniffel created")
    }

    override fun toString(): String {
        return super.toString()
    }

    override fun listRunde(
        spielers: MutableList<User>,
        prompt: String
    ): String {
        var myReturn: String = ""
        myReturn += rundenZaehler.toString()

//        spielers.forEach()
//        {
//            myReturn += " ." + it.Name
//        }
        return (myReturn)
    }

    override fun listGame(spielers: MutableList<User>, prompt: String) {

    }

    override fun spielRunde(
        spielers: MutableList<User>,
        prompt: String
    ) {
        spielers.forEach {
            do {
                var myPrompt: String = ""
                myPrompt = prompt + " Punkte für " + it.name + ":"
                print(myPrompt)
                var input: String
                input = readln()
                try {
                    listOfResults.add(input.toInt())
                    break
                } catch (ex: Exception) {
                    println("--> invalid: " + ex.localizedMessage)
                    continue
                }
            } while (true)
        }
        rundenZaehler++
    }

    override fun isGameOver(): Boolean {
        return 1 == (1..10).random()
    }
}