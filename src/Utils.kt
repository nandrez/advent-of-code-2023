import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines

fun readInputForDay(day: Int): List<String> {
    val value = day.padZero()
    return Path("src/day$value/Day$value.txt").readLines()
}

fun readInputForDay(day: Int, part: Int): List<String> {
    val zeroPadded = day.padZero()
    return Path("src/day$zeroPadded/Day" + zeroPadded + "_part" + part +  ".txt").readLines()
}

fun readExampleInputForDay(day: Int, part: Int): List<String> {
    val zeroPadded = day.padZero()
    return Path("src/day$zeroPadded/Day" + zeroPadded + "_part" + part +  "-example.txt").readLines()
}

private fun Int.padZero() = toString().padStart(2, '0')

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)
