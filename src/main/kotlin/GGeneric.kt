import java.util.*

class GGeneric {
    val uuid = UUID.randomUUID()
    var addTime = Date()
    var listOfRults: MutableList<Int> = mutableListOf<Int>()

    init {
        println("Jassen created")
    }

    override fun toString(): String {
        return super.toString()
    }

    fun spielRunde(spielers: MutableList<User>, prompt: String) {
        spielers.forEach {
            do {
                var myPrompt: String = ""
                myPrompt = prompt + " Punkte für " + it.name + ":"
                print(myPrompt)
                var input: String
                input = readln()
                try {
                    listOfRults.add(input.toInt())
                    break
                } catch (ex: Exception) {
                    println("--> invalid: " + ex.localizedMessage)
                    continue
                }
            } while (true)
        }
    }
}
