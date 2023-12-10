package day01

import readInputForDay

fun main() {
    val input = readInputForDay(1)
    part1(input)
    part2(input)
}

fun part1(input: List<String>): Int {
    val sumOfAllCalibrationValues = input
            .map(::calibrationValue1)
            .reduce(Int::plus)
    println("The sum of all calibration values is '$sumOfAllCalibrationValues'")
    return sumOfAllCalibrationValues
}

private fun calibrationValue1(inputLine: String): Int {
    println("Finding calibration value for '$inputLine':")
    val firstDigit = inputLine.first(Char::isDigit)
    print("first digit: $firstDigit, ")

    val lastDigit = inputLine.last(Char::isDigit)
    print("last digit: $lastDigit")

    val calibrationValue = "$firstDigit$lastDigit"
    println("==> calibration value: $calibrationValue\n")
    return calibrationValue.toInt()
}

fun part2(input: List<String>): Int {
    val sumOfCalibrationValues = input.sumOf(::calibrationValue2)
    println("The sum of all actual calibration values is '$sumOfCalibrationValues'")
    return sumOfCalibrationValues
}

fun calibrationValue2(input: String): Int {
    println("Finding calibration value for '$input':")
    val firstDigit = firstDigit(input)
    print("first digit: $firstDigit, ")
    val lastDigit = lastDigit(input)
    print("last digit: $lastDigit ")
    val calibrationValue = "$firstDigit$lastDigit"
    println("==> calibration value: $calibrationValue\n")
    return calibrationValue.toInt()
}

fun firstDigit(input: String): String {
    if (input.isBlank()) {
        return ""
    }
    val firstChar = input.first()
    if (firstChar.isDigit()) {
        return firstChar.toString()
    }
    return when {
        input.startsWith("one") -> "1"
        input.startsWith("two") -> "2"
        input.startsWith("three") -> "3"
        input.startsWith("four") -> "4"
        input.startsWith("five") -> "5"
        input.startsWith("six") -> "6"
        input.startsWith("seven") -> "7"
        input.startsWith("eight") -> "8"
        input.startsWith("nine") -> "9"
        else -> firstDigit(input.substring(1))
    }
}

fun lastDigit(input: String): String {
    if (input.isBlank()) {
        return ""
    }
    val lastChar = input.last()
    if (lastChar.isDigit()) {
        return lastChar.toString()
    }
    return when {
        input.endsWith("one") -> return "1"
        input.endsWith("two") -> return "2"
        input.endsWith("three") -> return "3"
        input.endsWith("four") -> return "4"
        input.endsWith("five") -> return "5"
        input.endsWith("six") -> return "6"
        input.endsWith("seven") -> return "7"
        input.endsWith("eight") -> return "8"
        input.endsWith("nine") -> return "9"
        else -> lastDigit(input.substring(0..<input.length - 1))
    }

}