package info.sanaebadi.akeliustask.util

import java.util.*

object DateUtil {
    const val PATTERN_UTC_ZONED = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    fun isSameDates(startDate: Date, endDate: Date): Boolean {
        var different: Long = endDate.time - startDate.time
        println("startDate : $startDate")
        println("endDate : $endDate")
        println("different : $different")
        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24
        val elapsedDays = different / daysInMilli
        different %= daysInMilli
        val elapsedHours = different / hoursInMilli
        different %= hoursInMilli
        val elapsedMinutes = different / minutesInMilli
        different %= minutesInMilli
        val elapsedSeconds = different / secondsInMilli
        System.out.printf(
            "%d days, %d hours, %d minutes, %d seconds%n",
            elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds
        )
        return elapsedDays != 0L || elapsedHours != 0L || elapsedMinutes != 0L || elapsedSeconds != 0L
    }
}