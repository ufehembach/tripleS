import java.lang.Exception

fun readTheTripleS(): TheTripleS {
    var myTheTripleS: TheTripleS = TheTripleS()

    println("try to read data from file")
    try {
        var myDiv = 1 / 0
    } catch (ex: Exception) {
        println("data not found\nnew data set created")
        myTheTripleS = TheTripleS()
    }
    Runtime.getRuntime().addShutdownHook(Thread {
        // Code, der ausgeführt werden soll, wenn der Prozess beendet wird
        println(
            """
 _                  _                _
| |__  _   _  ___  | |__  _   _  ___| |
| '_ \| | | |/ _ \ | '_ \| | | |/ _ \ |
| |_) | |_| |  __/ | |_) | |_| |  __/_|
|_.__/ \__, |\___| |_.__/ \__, |\___(_)
       |___/              |___/
        """.trimIndent())
        println ("save data to file...")
        // Weitere Aktionen, die du ausführen möchtest
    })
    return (myTheTripleS)
}