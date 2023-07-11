import java.time.LocalDateTime
import java.util.*

open class GGeneric() {
    val uuid = UUID.randomUUID()
    var addTime = LocalDateTime.now()
    var listOfResults: MutableList<Int> = mutableListOf<Int>()
    var rundenZaehler: Int = 0

    init {
        println("Generic Game created")
    }

    open fun toString(
        spielers: MutableList<User>,
        prompt: String
    ): String {
        return super.toString()
    }

    open fun listRunde(spielers: MutableList<User>, prompt: String):
            String {
        var myReturn: String = ""
        myReturn += rundenZaehler.toString()

        spielers.forEach {
            myReturn += " ." + it.name
        }
        return (myReturn)
    }

    open fun listGame(spielers: MutableList<User>, prompt: String) {

    }

    open fun spielRunde(
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
            } while (!isGameOver())
        }
        rundenZaehler++
    }

    open fun isGameOver(): Boolean {
        return 1 == (1..10).random()
    }
}


/*  aus ChatGPT
fun main() {
    // Erstelle ein 2D-Array
    val array: Array<Array<Int>> = Array(3) { Array(4) { 0 } }

    // Ändere die Anzahl der Elemente in der y-Achse der zweiten Reihe
    array[1] = Array(6) { 0 }

    // Zugriff auf die Elemente im 2D-Array
    array[0][0] = 1
    array[1][2] = 3

    // Ausgabe der Elemente im 2D-Array
    for (row in array) {
        for (element in row) {
            print("$element ")
        }
        println()
    }
}
In diesem Beispiel wird zunächst ein 2D-Array array erstellt, das 3 Reihen
und 4 Spalten hat. Dann wird die Anzahl der Elemente in der y-Achse der
zweiten Reihe von 4 auf 6 geändert, indem ein neues Array der zweiten Reihe zugewiesen wird.

Die Zeile array[1] = Array(6) { 0 } weist der zweiten Reihe des 2D-Arrays
ein neues Array mit einer Länge von 6 zu. Dadurch wird die Anzahl der Elemente
 in der y-Achse der zweiten Reihe von 4 auf 6 geändert.

Anschließend kannst du wie gewohnt auf die Elemente im 2D-Array zugreifen
 und sie ändern. Beachte jedoch, dass sich die Anzahl der Elemente in der
 y-Achse der zweiten Reihe geändert hat, während die Anzahl der Elemente
 in den anderen Reihen unverändert bleibt.

Die Schleifen am Ende des Beispiels können verwendet werden, um alle
Elemente im aktualisierten 2D-Array zu durchlaufen und auszugeben.
 */