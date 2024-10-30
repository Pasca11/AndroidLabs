val shortEvents = events.filter { it.durationInMinutes < 60 }
println("You have ${shortEvents.size} short events.")
