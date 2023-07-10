import java.util.*

class GJassen() : GGeneric() {

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