fun main() {
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem[2])
    println(solarSystem.get(3))
    println(solarSystem.indexOf("Earth"))
    for (planet in solarSystem) {
        println(planet)
    }
    
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")
    solarSystem[3] = "Future Moon"
    solarSystem.removeAt(9)
    solarSystem.remove("Future Moon")
    println(solarSystem.contains("Pluto"))
}


