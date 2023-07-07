import java.security.KeyStore.TrustedCertificateEntry
import java.util.*

class Game {
    val uuid = UUID.randomUUID()
    var addTime = Date()
    var rundenList: MutableList<GGeneric> = mutableListOf<GGeneric>()
    var gameUsers: MutableList<User> = mutableListOf<User>()

    init {
        println("Game created")
    }

    var hochGewinnt = true

    override fun toString(): String {
        var myReturn: String = returnUser()
        gameUsers.forEach {
            myReturn += it.toString() + "\n"
        }
        myReturn += returnRound()
        rundenList.forEach {
            myReturn += " " + it.toString() + "\n"
        }
        return myReturn
    }

    fun commands(prompt: String, usersInGame: Users) {
        var commands = linkedMapOf(
            'L' to "list current game",
            'A' to "add user to game",
            'P' to "play game",
            'Q' to "quit",
            'S' to "Sum",
            '.' to "quit",
        )
        var myPrompt: String = prompt + "G:" + uuid.hashCode().toString(16)
        var key: Char
        while (true) {
            print(myPrompt + ":")
            key = System.`in`.read().toChar()
            readln()
            when (key.uppercaseChar()) {
                'H' -> showHelp(commands)
                'L' -> print(this.toString())
                'P' -> {
                    var i: Int = 0
                    println("los gehts...")
                    while (true) {
                        i++
                        var myRunde: Runde = Runde()
                        myRunde.spielRunde(gameUsers, myPrompt +
                                "Runde "+ i + ":")
                        rundenList.add(myRunde)
                    }
                }

                'A' -> {
                    println(" Which users play?, (. or Q to finish)")
                    println(usersInGame.toString())
                    var line: String = ""
                    var i: Int = 0
                    do {
                        print("  >")
                        line = readln()
                        if (line == "." || line == "Q" || line == "q")
                            break
                        try {
                            i = line.toInt()
                        } catch (ex: Exception) {
                            print("\b")
                            continue
                        }
                        if (i < usersInGame.usersList.size) {
                            if (!gameUsers.contains(usersInGame.usersList[i])) {
                                gameUsers.add(usersInGame.usersList[i])
                                println(
                                    "\tadded " + i + " " + usersInGame
                                        .usersList[i]
                                )
                            }
                        }
                    } while (true)
                }
                'q' -> return
                '.' -> return
            }
        }
    }

    fun listUsers() {
        var ii: Int = 0
        var myReturn: String = ""
        gameUsers.forEach {
            myReturn += " " + ii++ + " "
            myReturn += it.name + "\t"
            if (it.aktivated)
                myReturn += " aktiv" + "\t"
            else
                myReturn += " Not aktiv" + "\t"
            myReturn += " " + it.uuid + "\n"
        }
    }

    fun listGameStand() {

    }
}



