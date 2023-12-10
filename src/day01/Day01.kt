package day01

import readInput

fun main() {
    val testInput = readInput("Day01")
    part1(testInput)
}

fun part1(input: List<String>): Int {
    val sumOfAllCalibrationValues = input
            .map { findCalibrationValue(it) }
            .reduce(Int::plus)
    println("The sum of all calibration values is '$sumOfAllCalibrationValues'")
    return sumOfAllCalibrationValues
}

private fun findCalibrationValue(inputLine: String): Int {
    println("Finding calibration value for '$inputLine':")
    val firstDigit = inputLine.first(Char::isDigit)
    print("first digit: $firstDigit, ")

    val lastDigit = inputLine.last(Char::isDigit)
    print("last digit: $lastDigit" )

    val calibrationValue = "$firstDigit$lastDigit"
    println("==> calibration value: $calibrationValue\n")
    return calibrationValue.toInt()
}
