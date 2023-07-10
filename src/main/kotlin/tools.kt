import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

internal object getJ {
    @Throws(IOException::class)
    fun chr(): Char {
        val bufferReader = BufferedReader(InputStreamReader(System.`in`))
        return bufferReader.readLine()[0]
    }
}

fun main(args: Array<String>) {
    clearScreen()
}

fun anyFunc() {// if it's impossible to add 'throws IOException' here
    try {
        var c = getJ.chr(); //reads a char into c
        println(" " + c)
    } catch (ex: Exception) {
        System.out.println("IOException has been caught");
    }
}


fun showHelp(commands: LinkedHashMap<Char, String>) {
    commands.forEach { (i, j) ->
        println(i + " " + j)
    }
}


fun clearScreen() {
    print("bla blupp")
    print("bla blupp")
    print("bla blupp")
    print("bla blupp")
    print("bla blupp")
    print("bla blupp")
    print("bla blupp")
    print("bla blupp")
    print("\u001b[H\u001b[2J")
    System.out.flush()
}

fun returnUser(): String {
    return ("""
 ____  _
|  _ \| | __ _ _   _  ___ _ __
| |_) | |/ _` | | | |/ _ \ '__|
|  __/| | (_| | |_| |  __/ |
|_|   |_|\__,_|\__, |\___|_|
               |___/
   """.trimIndent() + "\n")
}

fun returnGame(): String {
    return ("""
  ____
/ ___ | __ _ _ __ ___ ___
| |  _ / _` | '_ ` _ \ / _ \
| |_| | (_| | | | | | |  __/
\____|\__, _|_| |_| |_|\___|
    """.trimIndent() + "\n")
}

fun returnRound(): String {
    return ("""
 ____                       _
|  _ \ ___  _   _ _ __   __| |
| |_) / _ \| | | | '_ \ / _` |
|  _ < (_) | |_| | | | | (_| |
|_| \_\___/ \__,_|_| |_|\__,_|        
   """.trimIndent() + "\n")
}

fun returnSelect():String
{
 return """
____       _           _   _
/ ___|  ___| | ___  ___| |_| |
\___ \ / _ \ |/ _ \/ __| __| |
___) |  __/ |  __/ (__| |_|_|
|____/ \___|_|\___|\___|\__(_)
 """.trimIndent()
}
