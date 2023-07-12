import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
fun showHelp(commands: LinkedHashMap<Char, String>) {
    commands.forEach { (i, j) ->
        println(i + " " + j)
    }
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

fun returnSelect(): String {
    return """
 ____       _           _   _
/ ___|  ___| | ___  ___| |_| |
\___ \ / _ \ |/ _ \/ __| __| |
___) |  __/ |  __/ (__| |_|_|
|____/ \___|_|\___|\___|\__(_)
 """.trimIndent()
}

// Kindly provided by Gordon
fun normalizeStringLeght(str: String, len: Int = 10): String {
    return if (str.length < len)
        str.padStart(len, ' ')
    else if (str.length > len)
        str.substring(0, len)
    else
        str

}