/*
2 drillinge
1 drilling und 1 viererfolge
1 vierling und 1 viererfolge
1 siebenerfolge
1 achterfolge
1 neunerfolge
2 vierlinge
7 karten einer farbe
1 fünfling und 1 zwilling
1 fünfling und 1 drilling

    Karten von 1-9 zählen je 5 Punkte
    Karten von 10-12 zählen je 10 Punkte
    Aussetzen-Karten zählen je 15 Punkte
    Joker zählen je 20 Punkte

 */
class GPhase10() : GGeneric() {
    init {
        println("Jassen created")
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