import java.security.KeyStore.TrustedCertificateEntry
import java.util.*

class Game {
    val uuid = UUID.randomUUID()
    var addTime = Date()
    var rundenList: MutableList<GGeneric> = mutableListOf<GGeneric>()
    var gameUsers: MutableList<User> = mutableListOf<User>()
    var selectedGame: Int = 0

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
            'S' to "select game",
            'P' to "play game",
            'Q' to "quit",
            'R' to "Show Results",
            '.' to "quit",
        )
        var key: Char
        while (true) {
            var thisGameName: String =
                when (selectedGame) {
                    1 -> "Kniffel"
                    2 -> "Phase10"
                    3 -> "Jassen"
                    else -> "Generic"
                }
            var myPrompt: String = prompt + thisGameName + ":" + uuid
                .hashCode()
                .toString(16) + ":"
            print(myPrompt)
            key = System.`in`.read().toChar()
            readln()
            when (key.uppercaseChar()) {
                'H' -> showHelp(commands)
                'L' -> print(this.toString())
                'P' -> {
                    var i: Int = 0
                    println("los gehts...")
                    var myRunde = GGeneric()
                    while (true) {
                        i++
                        when (selectedGame) {
                            1 -> myRunde = GKniffel()
                            2 -> myRunde = GPhase10()
                            3 -> myRunde = GJassen()
                            0 -> myRunde = GGeneric()
                        }
                        myRunde.spielRunde(
                            gameUsers, myPrompt +
                                    "Runde " + i + ":"
                        )
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
                'S' -> {
                    var line: String = ""
                    var i: Int = 0
                    println(
                        returnSelect()
                    )
                    println(
                        "1. Kniffel\t2.Phase10\n3" +
                                ".Jassen\tdefault:Generic"
                    )
                    line = readln()
                    try {
                        i = line.toInt()
                    } catch (ex: Exception) {
                        print("\b")
                        i = 0
                    }
                    when (i) {
                        1 -> println("Kniffel Selected")
                        2 -> println("Phase10  Selected")
                        3 -> println("Jassen Selected")
                        0 -> println("Generil Selected")
                    }
                    selectedGame = i
                }
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


