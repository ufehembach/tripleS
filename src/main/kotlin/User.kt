import java.util.*

class User(var name: String){

    val uuid = UUID.randomUUID()
    val addTime = Date()
    init{
        println("Created User >"+this.name+"<")
    }

    //var eMail: String = ""
    var aktivated: Boolean = true
}