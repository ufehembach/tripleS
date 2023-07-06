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
    clearScreen()}

fun anyFunc() {// if it's impossible to add 'throws IOException' here
    try {
        var c = getJ.chr (); //reads a char into c
        println(" "+c)
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
    print ("bla blupp")
    print ("bla blupp")
    print ("bla blupp")
    print ("bla blupp")
    print ("bla blupp")
    print ("bla blupp")
    print ("bla blupp")
    print ("bla blupp")
    print("\u001b[H\u001b[2J")
    System.out.flush()
}
