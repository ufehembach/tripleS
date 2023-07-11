import java.text.DecimalFormat
import java.util.*

/*
36 karten
VI
VII
VIII
IX
X      -- ab hier 10 punkte
Unter -- 2
Ober -- 3
König -- 4
Ass -- 11

Farbe:
Herz
Laub
Schell
Eichel

wenn schell trumpf --> schell bauer --20
IX -> Weli/Nell -> 14
alle anderen bleiben gleich

man muss immer bedienen
karten werden verteilt

uwe hat 39 punkte
kata hat 0
kata ist im sack

kreuz

\  /
  X
/  \
oooo

user              u1    u2
r1  +punkt        1      0
    -punkt(sack)  0      0
r2                0      1
                  0      0
r3                0      1
                  1      0
ergebnis      =summe(gewinne) - summe säcke > 5
 */
class GJassen() : GGeneric() {
    //var standX: MutableList<Array<Int>> = mutableListOf()
    // var standO: MutableList<Array<Int>> = mutableListOf()
    var standX: MutableList<MutableList<Int>> = mutableListOf()
    var standO: MutableList<MutableList<Int>> = mutableListOf()
    var listI: Int = 0
    var ergebnis: MutableList<Int> = mutableListOf()

    init {
        println("Jassen created")
    }


    override fun listRunde(
        spielers: MutableList<User>, prompt: String
    ): String {
        var myReturn: String = "Runde "
        myReturn += rundenZaehler.toString()

        listI = 0
        myReturn += "\n Spieler\t"
        spielers.forEach()
        {
            myReturn += " \t" + normalizeStringLeght(it.name)
        }
        listI = 0
        myReturn += "\n Punkte \t"
        spielers.forEach()
        {
            myReturn += " \t" + normalizeStringLeght(
                standX[rundenZaehler][listI++].toString()
            )
        }
        listI = 0
        myReturn += "\n Säcke  \t"
        spielers.forEach()
        {
            myReturn += " \t" + normalizeStringLeght(standO[rundenZaehler][listI++].toString())
        }
        return (myReturn)
    }

    override fun toString(spielers: MutableList<User>, prompt: String)
            : String {
        var myReturn: String = "Total"
        var i: Int
        myReturn += "\n Spieler\t "
        spielers.forEach()
        {
            myReturn += " \t" + normalizeStringLeght(it.name)
        }
        listI = 0
        myReturn += "\n Punkte \t "
        spielers.forEach()
        {
            myReturn += " \t" + normalizeStringLeght(
                ergebnis[listI++]
                    .toString()
            )
        }
        return (myReturn)
    }

    override fun spielRunde(
        spielers: MutableList<User>,
        prompt: String
    ) {
        val listX = mutableListOf<Int>()
        val listO = mutableListOf<Int>()
        spielers.forEach {
            // punkte einlesen 
            do {
                var myPrompt: String = ""
                myPrompt =
                    prompt + ":" + "Rund " + rundenZaehler + 1 + ": Punkte" +
                            " für " + it.name + ":"
                print(myPrompt + ":")
                var input: String
                input = readln()
                try {
                    var i: Int = input.toInt()
                    listX.add(i)
                    break
                } catch (ex: Exception) {
                    println("--> invalid: " + ex.localizedMessage)
                    continue
                }
            } while (true)
        }
        // spiellogik wer hat gewonnen und wer ist im Sack
        val max = listX.maxOrNull()
        for (listI in 0..listX.size - 1) {
            if (listX[listI] < 20) //SACK
            {
                listX[listI] = 0
                listO.add(1)
            } else
                listO.add(0)
            if (listX[listI] == max)
                listX[listI] = 1
            else
                listX[listI] = 0
        }
        standX.add(listX)
        standO.add(listO)
        println(listRunde(spielers, prompt))
        // gesamtergebnis berechnen
        for (listI in 0..listX.size - 1) {
            if (rundenZaehler == 0) {
                ergebnis.add(0)
            }
            ergebnis[listI] += listX[listI] - listO[listI]
        }
        rundenZaehler++
    }

    override fun isGameOver(): Boolean {
        return ergebnis.max() == 5
    }
}


