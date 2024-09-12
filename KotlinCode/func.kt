fun birthdayGreeting(name: String = "Rover", age: Int): String {
    return "Happy Birthday, $name! You are now $age years old!"
}

fun main() {
    //Named
    println(birthdayGreeting(name = "Rex", age = 2))
    //Default
    println(birthdayGreeting(age = 5))
    println(birthdayGreeting("Rex", 2))
}