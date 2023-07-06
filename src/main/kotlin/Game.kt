import java.security.KeyStore.TrustedCertificateEntry
import java.util.*

class Game {
    val uuid = UUID.randomUUID()
    var addTime = Date()
    var rundenList: MutableList<Runde> = mutableListOf<Runde>()
    var gameUsers: MutableList<User> = mutableListOf<User>()

    init {
        println("Game created")
    }

    var hochGewinnt = true

    override fun toString(): String {
        var myReturn: String = ""
//        rundenList.forEach {
//            if (it.name != "Void") {
//                myReturn += it.name + "\t"
//                if (it.aktivated)
//                    myReturn += " aktiv" + "\t"
//                else
//                    myReturn += " Not aktiv" + "\t"
//                myReturn += " " + it.uuid + "\n"
//            }
//        }
        return myReturn
    }

    fun commands(prompt: String, usersInGame: Users) {
        var commands = linkedMapOf(
            'L' to "list current game",
            'A' to "add user to game",
            'P' to "play game",
            'Q' to "quit",
            '.' to "quit",
        )
        var myPrompt: String = prompt + "U:"
        var key: Char
        while (true) {
            print(myPrompt + ":")
            key = System.`in`.read().toChar()
            readln()
            when (key.uppercaseChar()) {
                'H' -> showHelp(commands)
                'L' -> print(this.toString())
                'E' -> println("edit-not implemented")
                'A' -> {
                    println(" Which users play?, (x to finish)")
                    println(usersInGame.toString())
                    var line: String = ""
                    var i: Int = 0
                    do {
                        print("  >")
                        line = readln()
                        if (line == "x")
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
                        listUsers()
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



