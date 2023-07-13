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
    //var standX: MutableList<Array<Int>> = mutableListOf()
    var stand: MutableList<MutableList<Int>> = mutableListOf()
    var kniffel = linkedMapOf(
        "1" to "nur einser",
        "2" to "nur zweier",
        "3" to "nur dreier",
        "4" to "nur vierer",
        "5" to "nur fünfer",
        "6" to "nur secher",
        "D" to "dreierpasch alle augen",
        "V" to "viererpasch alle augen",
        "F" to "full -house 35 punkte (2 + 3)",
        "S" to "kleine strasse 30 Punkte (4 in der reihe)",
        "G" to "grosse strasse 40 punkte (5 in der reihe)",
        "K" to "kniffel 50 Punkte (5er pasch)",
        "C" to "chance alle augen zählen",
    )
    var listI: Int = 0
    var ergebnis: MutableList<Int> = mutableListOf()

    init {
        println("Kniffel created")
    }

    fun showKniffel() {
        kniffel.forEach { key, text ->
            println(normalizeStringLeght(key, 12) + " -> " + text)
        }
    }

    fun readAUser(spielerI: Int) {
        showKniffel()
        while (true) {
            var input: String
            var key: Char
            print("         ->: ")
            key = System.`in`.read().toChar()
            print("     Points: ")
            input = readln()
            var number: Int = 0
            number = readANumber(input)
            println(number)
            when (key.uppercaseChar()) {
                '1' -> {
                    if (stand[spielerI][0] == -1)
                    {
                        stand[spielerI][0] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                '2' -> {
                    if (stand[spielerI][1] == -1)
                    {
                        stand[spielerI][1] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                '3' -> {
                    if (stand[spielerI][2] == -1)
                    {
                        stand[spielerI][2] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                '4' -> {
                    if (stand[spielerI][3] == -1)
                    {
                        stand[spielerI][3] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                '5' -> {
                    if (stand[spielerI][4] == -1)
                    {
                        stand[spielerI][4] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                '6' -> {
                    if (stand[spielerI][5] == -1)
                    {
                        stand[spielerI][5] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                'D' -> {
                    if (stand[spielerI][6] == -1)
                    {
                        stand[spielerI][6] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                'V' -> {
                    if (stand[spielerI][7] == -1)
                    {
                        stand[spielerI][7] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                'F' -> {
                    if (stand[spielerI][8] == -1)
                    {
                        stand[spielerI][8] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                'S' -> {
                    if (stand[spielerI][9] == -1)
                    {
                        stand[spielerI][9] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                'G' -> {
                    if (stand[spielerI][10] == -1)
                    {
                        stand[spielerI][10] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                'K' -> {
                    if (stand[spielerI][11] == -1)
                    {
                        stand[spielerI][11] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                'C' -> {
                    if (stand[spielerI][12] == -1)
                    {
                        stand[spielerI][12] = number
                        break
                    }
                    else
                    {
                        println("  already set! -> try again")
                        continue
                    }
                }

                else -> {
                    println("     Invalid! -> try again")
                    continue
                }
            }
        }
    }

    fun readANumber(line: String = ""): Int {
        var myInt: Int = 0
        try {
            myInt = line.toInt()
        } catch (ex: Exception) {
            // println("--> invalid: " + ex.localizedMessage)
            while (true)
                try {
                    myInt = readln().toInt()
                    break
                } catch (ex: Exception) {
                    println("--> invalid: " + ex.localizedMessage)
                    continue
                }
        }
        return myInt
    }

    override fun listRunde(
        spielers: MutableList<User>, prompt: String
    ): String {
        // return (toString(spielers, prompt))
        return ""
    }


    fun hauEineZeileRaus(
        text: String,
        spielers: MutableList<User>,
        stand: MutableList<MutableList<Int>>,
        row: Int,
        results: MutableList<Int>
    ): String {
        var myReturn: String = ""
        var myI: Int = 0
        var spieler: User
        myReturn += normalizeStringLeght(text, 14)
        spielers.forEach {
            myReturn += normalizeStringLeght(
                if (stand[myI][row] == -1)
                    "."
                else {
                    stand[myI][row]
                        .toString()
                }
            )
            if (stand[myI][row] != -1)
                results[myI] += stand[myI][row]
            myI++
        }
        return myReturn + "\n"
    }

    override fun toString(
        spielers: MutableList<User>,
        prompt: String
    ): String {
        var myReturn: String = " Total\n"
        myReturn += normalizeStringLeght("Spieler", 14)
        var results: MutableList<Int> = mutableListOf()
        spielers.forEach()
        {
            myReturn += normalizeStringLeght(it.name)
            results.add(0)
        }
        myReturn += "\n"
        var i: Int = 0
//nur einser
        myReturn += hauEineZeileRaus(
            "nur einser",
            spielers,
            stand,
            i++,
            results
        )
//nur zweier
        myReturn += hauEineZeileRaus(
            "nur zweier",
            spielers,
            stand,
            i++,
            results
        )
//nur dreier
        myReturn += hauEineZeileRaus(
            "nur dreier",
            spielers,
            stand,
            i++,
            results
        )
//nur vierer
        myReturn += hauEineZeileRaus(
            "nur vierer",
            spielers,
            stand,
            i++,
            results
        )
//nur fünfer
        myReturn += hauEineZeileRaus(
            "nur fünfer",
            spielers,
            stand,
            i++,
            results
        )
//nur secher
        myReturn += hauEineZeileRaus(
            "nur secher",
            spielers,
            stand,
            i++,
            results
        )
//gesamt
        myReturn += (normalizeStringLeght("-------------------------", 14))
        spielers.forEachIndexed { index, user ->
            myReturn += (normalizeStringLeght
                ("---------------------"))
        }
        myReturn += "\n"
//bonus bei 63 oder mehr -> plus 35
        myReturn += (normalizeStringLeght("bonus bei > 63", 14))
        spielers.forEachIndexed { index, user ->
            if (results[index] > 63) {
                results[index] += 35
                myReturn += (normalizeStringLeght("35"))
            } else
                myReturn += (normalizeStringLeght("00"))
        }
        myReturn += "\n"
//gesamter oberer teil
        myReturn += (normalizeStringLeght("gesamt oberer teil", 14))
        spielers.forEachIndexed { index, user ->
            myReturn += (normalizeStringLeght(results[index].toString()))
        }
        myReturn += "\n"
        myReturn += (normalizeStringLeght("-------------------------", 14))
        spielers.forEachIndexed { index, user ->
            myReturn += (normalizeStringLeght
                ("---------------------"))
        }
        myReturn += "\n"
//dreierpasch alle augen

        myReturn += hauEineZeileRaus(
            "dreier pasch",
            spielers,
            stand,
            i++,
            results
        )
//viererpasch alle augen
        myReturn += hauEineZeileRaus(
            "viererpasch",
            spielers,
            stand,
            i++,
            results
        )
//full-house 35 punkte (2+3)
        myReturn += hauEineZeileRaus(
            "full house",
            spielers,
            stand,
            i++,
            results
        )
//kleine strasse 30 Punkte (4 in der reihe)
        myReturn += hauEineZeileRaus(
            "kleine strasse",
            spielers,
            stand,
            i++,
            results
        )
//grosse strasse 40 punkte (5 in der reihe)
        myReturn += hauEineZeileRaus(
            "grosse strasse",
            spielers,
            stand,
            i++,
            results
        )
//kniffel 50 Punkte (5er pasch)
        myReturn += hauEineZeileRaus(
            "kniffel",
            spielers,
            stand,
            i++,
            results
        )
//chance alle augen zählen
        myReturn += hauEineZeileRaus(
            "chance",
            spielers,
            stand,
            i++,
            results
        )
//gesamt unterer teil
//gesamt oberer teil
//endsumme
        myReturn += (normalizeStringLeght("-------------------------", 14))
        spielers.forEachIndexed { index, user ->
            myReturn += (normalizeStringLeght
                ("---------------------"))
        }
        myReturn += "\n"
        myReturn += (normalizeStringLeght("endsumme", 14))
        spielers.forEachIndexed { index, user ->
            myReturn += (normalizeStringLeght(results[index].toString()))
        }
        myReturn += "\n"
        return (myReturn)
    }

    override fun addDataStructure() {
        var myList: MutableList<Int> = mutableListOf()
        kniffel.forEach { key ->
            myList.add(-1)
        }
        stand.add(myList)
    }

    override fun spielRunde(
        spielers: MutableList<User>,
        prompt: String
    ) {
        var mySpielerCount: Int = 0
        spielers.forEach {
            // punkte einlesen
            var myPrompt: String = ""
            myPrompt =
                prompt + ":" + "Runde " + rundenZaehler + 1 + ": " +
                        " für " + it.name + ":"
            println(myPrompt + ":")
            readAUser(mySpielerCount++)
        }
        // spiellogik wer hat gewonnen
        println(listRunde(spielers, prompt))
        // gesamtergebnis berechnen
        rundenZaehler++
    }

    override fun isGameOver(): Boolean {
        return -1 != stand[stand.size - 1].min()
    }
}