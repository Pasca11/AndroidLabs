fun main() {
    val Steps = 4000
    val caloriesBurned = PedometerStepsTcalories(Steps);
    println("Walking $Steps steps burns $caloriesBurned calories")
}

fun PedometerStepsTcalories(NumberOFStepS: Int): Double {
    val CaloriesBurnedForEachStep = 0.04
    val TotalCaloriesBurned = NumberOfSteps * CaloriesBurnedForEachStep
    return TotalCaloriesBurned
}