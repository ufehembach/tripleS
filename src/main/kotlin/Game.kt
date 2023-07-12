import java.security.KeyStore.TrustedCertificateEntry
import java.util.*
import java.time.*

class Game {
    val uuid = UUID.randomUUID()
    var addTime = LocalDateTime.now()
    var ergebnis: GGeneric = GGeneric()
    var users: MutableList<User> = mutableListOf<User>()
    var selectedGame: Int = 0
    var selectedUsers: Int = 0
    var started: Boolean = false
    var name: String = ""
    var runde: Int = 0

    init {
        println("Game created")
    }

    var hochGewinnt = true

    override fun toString(): String {
        var myReturn: String = returnUser()
        users.forEach {
            myReturn += it.toString() + "\n"
        }
        myReturn += returnRound()
        myReturn += ergebnis.toString()
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
            var myPrompt: String = prompt + thisGameName + ":"
            //+ uuid .hashCode() .toString(16)
            print(myPrompt+":")
            key = System.`in`.read().toChar()
            readln()
            when (key.uppercaseChar()) {
                'H' -> showHelp(commands)
                'L' -> print(ergebnis.toString(users,myPrompt))
                'P' -> {
                    if (users.size > 0) {
                        started = true
                        ergebnis.spielRunde(users, myPrompt)
                    } else
                        println("No Players, use <a> first")
                    println(ergebnis.toString(users, myPrompt))
                    if (ergebnis.isGameOver())
                        println("Game over")
                }

                'A' -> {
                    if (started) {
                        println("Game Started, no changes can be applied")
                        break
                    }
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
                            if (!users.contains(
                                    usersInGame
                                        .usersList[i]
                                )
                            ) {
                                users.add(usersInGame.usersList[i])
                                println(
                                    "\tadded " + i + " " + usersInGame
                                        .usersList[i]
                                )
                                ergebnis.addDataStructure()
                            }
                        }
                    } while (true)
                }

                'q' -> return
                '.' -> return
                'S' -> {
                    if (started) {
                        println("Game Started, no changes can be applied")
                        break
                    }
                    var line: String = ""
                    var i: Int = 0
                    println(
                        returnSelect()
                    )
                    println(
                        "1. Kniffel\t2. Phase10\n" +
                                "3. Jassen\t default:Generic"
                    )
                    line = readln()
                    try {
                        i = line.toInt()
                    } catch (ex: Exception) {
                        print("\b")
                        i = 0
                    }
                    when (i) {
                        1 -> {
                            println("Kniffel Selected")
                            ergebnis = GKniffel()
                        }

                        2 -> {
                            println("Phase10  Selected")
                            //  ergebnis = GPhase10()
                            println("Not Implemented yet! \nPlease try " +
                                    "again.")
                        }

                        3 -> {
                            println("Jassen Selected")
                            ergebnis = GJassen()
                        }

                        0 -> {
                            println("Generic Selected")
                            ergebnis = GGeneric()
                        }
                    }
                    selectedGame = i
                }
            }
        }
    }

    fun listUsers() {
        var ii: Int = 0
        var myReturn: String = ""
        users.forEach {
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


/* parking lot
                     var i: Int = -1
                    println("los gehts...")
                    var myRunde = GGeneric()
                    while (true) {
                        i++
                        when (selectedGame) {
                            0 -> myRunde = GKniffel()
                            1 -> myRunde = GPhase10()
                            2 -> myRunde = GJassen()
                            -1 -> myRunde = GGeneric()
                        }
                        myRunde.spielRunde(
                            gameUsers, myPrompt +
                                    "Runde " + i + ":"
                        )
                        rundenList.add(myRunde)
                    }
 */