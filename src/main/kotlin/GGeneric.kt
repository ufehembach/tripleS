import java.util.*

open class GGeneric() {
    val uuid = UUID.randomUUID()
    var addTime = Date()
    var listOfResults: MutableList<Int> = mutableListOf<Int>()
    var rundenZaehler: Int = 0

    init {
        println("Generic Game created")
    }

    override fun toString(): String {
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