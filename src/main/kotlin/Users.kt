import java.util.*
import kotlin.system.exitProcess

class Users {
    val uuid = UUID.randomUUID()
    var addTime = Date()
    var usersList: MutableList<User> = mutableListOf<User>()

    init {
        println("List for User created..")
    }

    override fun toString(): String {
        var myReturn: String = ""
        //  var ii: Int = 0
//        usersList.forEach {
//             myReturn += " " + ii++ + " "
//            myReturn += it.name + "\t"
//            if (it.aktivated)
//                myReturn += " aktiv" + "\t"
//            else
//                myReturn += " Not aktiv" + "\t"
//            myReturn += " " + it.uuid + "\n"
//        }
        var i: Int = 0
        for (i in
        0..(usersList.size - 1)) {
            myReturn += " " + i + " "
            myReturn += usersList[i].toString() + "\n"
        }
        return myReturn
    }

    fun commands(prompt: String) {
        var commands = linkedMapOf(
            'L' to "list",
            'E' to "edit",
            'A' to "add",
            'D' to "disable",
            'F' to "dedisable",
            'Q' to "quit",
            '.' to "quit",
        )
        var myPrompt: String = prompt + "User Managment:"
        var key: Char
        while (true) {
            //  println(usersList)
            var line : String =""
            print(myPrompt + ":")
            key = System.`in`.read().toChar()
            line = readln()
            when (key.uppercaseChar()) {
                'H' -> {
                    println("Help")
                    showHelp(commands)
                }

                'L' -> {
                    println("List")
                    print(this.toString())
                }

                'E' -> {
                    println("Edit")
                    println("edit-not implemented")
                }

                'A' -> {
                    println("Add")
                    if (line.length>1)
                        usersList.add(User(line.trim()))
                    else
                    {
                        print("Username: ")
                        usersList.add(User(readln()))
                    }
                }

                'D' -> {
                    println("disable")
                    println("disable-not implemented")
                }

                'F' -> {
                    println("enable")
                    println("dedisable-not implemented")
                }

                ('.') -> {
                    println("quit")
                    return
                }

                ('Q') -> {
                    println("quit")
                    return
                }
                ('C') -> {
                    clearScreen()
                    return
                }
            }
        }
    }
}