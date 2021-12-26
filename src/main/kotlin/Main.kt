const val MINUT = 60
const val HOUR = MINUT*60
const val DAY = HOUR*24
const val TWO_DAY = DAY*2
const val THRE_DAY =DAY*3

fun main(args: Array<String>) {
    val time = 60
    val textAgo= agoToText(time)
    println("был(а) online $textAgo")
}

fun agoToText(time:Int):String{
    return when(time){
        in 0 .. MINUT-> "только что"
        in MINUT..HOUR -> {
           val minutAgo = time/MINUT
           val minutToText = enddingTime(minutAgo,false)
           "$minutAgo $minutToText назад"
        }
        in HOUR .. DAY -> {
            val hourAgo = time/HOUR
            val hourToText = enddingTime(hourAgo,true)
            "$hourAgo $hourToText назад"
        }
        in DAY .. TWO_DAY -> "сегодня"
        in TWO_DAY..THRE_DAY ->"вчера"
        else -> "давно"
    }
}

fun enddingTime(time: Int,hourOrMinut:Boolean):String{
    val endNumber = time % 10
    if (!hourOrMinut){
        return when {
            endNumber == 1 && time!=11 -> "минуту"
            endNumber > 4 || time>9 && time<21 ->"минут"
            else -> "минуты"
        }
    }else{
        return when {
            endNumber == 1 && time!=11 -> "час"
            endNumber > 4 || time>9 && time<21 ->"часов"
            else -> "часа"
        }
    }
}