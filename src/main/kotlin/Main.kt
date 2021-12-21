
fun main(args: Array<String>) {
    val time = 10
    val textAgo= agoToText(time)
    println("был(а) online $textAgo")
}

fun agoToText(time:Int,minut:Int=60,hour:Int=minut*minut,day:Int=hour*24,twoDays:Int=day*2,threeDays:Int=day*3):String{
    return when{
        time<minut-> "только что"
        time<hour && time>=minut -> {
           val minutAgo = time/minut
           val minutToText = enddingTime(minutAgo,false)
           "$minutAgo $minutToText назад"
        }
        time<day && time>=hour -> {
            val hourAgo = time/hour
            val hourToText = enddingTime(hourAgo,true)
            "$hourAgo $hourToText назад"
        }
        time<twoDays && time>=day -> "сегодня"
        time<threeDays && time>=twoDays ->"вчера"
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