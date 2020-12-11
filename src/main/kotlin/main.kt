fun main() {

    println("Введите количество секунд")
    val seconds = readLine()!!.toInt()
    println("Был(а) в сети ${agoToText(seconds)}")
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> minutes(seconds)
        in 60 * 60 + 1 .. 60 * 60 * 24 -> hours(seconds)
        in 60 * 60 * 24 + 1 .. 60 * 60 * 24 * 2 -> "вчера"
        in 60 * 60 * 24 * 2 .. 60 * 60 * 24 * 3 -> "позачера"
        else -> "давно"
    }
}

fun minutes(seconds: Int): String {
    val minutes = seconds / 60
    return when {
        minutes % 10 == 1 && minutes != 11 -> "$minutes минуту назад"
        minutes % 10 == 2 || minutes % 10 == 3 || minutes % 10 == 4 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hours(seconds: Int):String {
    return when (val hours = seconds / 60 / 60){
        1, 21 -> "$hours час назад"
        2, 3, 4, 22, 23, 24 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}