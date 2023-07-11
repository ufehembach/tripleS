import java.time.LocalDateTime
import java.util.*

class User(var name: String){

    val uuid = UUID.randomUUID()
    val addTime = LocalDateTime.now()
    init{
        println("Created User >"+this.name+"<")
    }

    //var eMail: String = ""
    var aktivated: Boolean = true
    override fun toString(): String {
        var myReturn:String = ""
        myReturn += name + "\t"
        if (aktivated)
            myReturn += " aktiv" + "\t"
        else
            myReturn += " Not aktiv" + "\t"
        myReturn += " " + uuid + "\t"
        myReturn += " " + addTime
        return myReturn
    }
}