import java.time.*
import java.util.*
import kotlin.system.exitProcess

class TheTripleS {
    val uuid = UUID.randomUUID()
    var addTime = LocalDateTime.now()
    open var games: MutableList<Game> = mutableListOf<Game>()
    var users: Users = Users()
    var dice: Dice=Dice()
    init{
        println("Created TripleS..")
    }
    fun doIt() {
        var commands = linkedMapOf(
            'L' to "list",
            'H' to "help",
            'G' to "Games",
            'U' to "User",
            'Q' to "quit",
            '.' to "quit",
            'D' to "Dice",
            'N' to "set # of Dice",
            'G' to "Play Game",
        )
        var prompt: String = "3S:"
        var key: Char
        while (true) {
            print(prompt + ":")
            key = System.`in`.read().toChar()
            readln()
            when (key.uppercaseChar()) {
                'Q' -> {
                    exitProcess(99)
                }
                'H' -> showHelp(commands)
                'L' -> {
                    println("\t " + users.usersList.size + " Users in " +
                            "Database")
                    println("\t " + games.size + " Games in " +
                            "Database")
                }
                'D' -> dice.doDice()
                'G' -> {
                    var myGame:Game=Game()
                    games.add(myGame)
                    myGame.commands(prompt,users)
                }
                'U' -> users.commands(prompt)
                'N' -> {
                    try{
                        print("Number of Dices?")
                        var noOfDices:String = readln()
                        dice.numberOfDices = noOfDices.toInt()
                    }
                    catch(ex: Exception){
                        println("Sorry, invalid input("+ ex.localizedMessage
                                + "), nothing set!")
                    }
                }
            }
        }

    }


}