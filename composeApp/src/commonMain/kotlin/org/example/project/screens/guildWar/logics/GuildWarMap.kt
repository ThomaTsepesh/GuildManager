package org.example.project.screens.guildWar.logics

class GuildWarMap {
    private val locations = listOf(
        Location(0, "A1"),
        Location(1, "A2"),
        Location(2, "B1"),
        Location(3, "B2"),
        Location(4, "F1"),
        Location(5, "C1"),
        Location(6, "D1"),
        Location(7, "F2"),
        Location(8, "C2"),
        Location(9, "D2")
    )
    fun getLocationById(id: Int): Location {
        return locations.getOrNull(id) ?: throw IllegalStateException("Invalid location ID: $id")
    }
    fun getLocationByName(name: String): Location{
        locations.forEach { location -> if (location.name == name){return location} }
        return locations.get(0)
    }
    fun saveLocationByName(newLocation: Location){
        locations.forEach { location -> if (location.name == newLocation.name){} }

    }
    fun getAllLocations(): List<Location>{
        return locations
    }
    fun setRequiredSquadsForAllLocations(count: Int){
        locations.forEach { it.requiredSquads = count }
    }
}

data class Location(
    val id: Int,
    val name: String,
    var requiredSquads: Int = 0,
    var squadTags: MutableMap<String, Int> = mutableMapOf()
){
    fun addSquad(tag: String, count: Int){
        val currentTotal = squadTags.values.sum()
        if (currentTotal+count > requiredSquads){
            throw IllegalStateException("Cannot add more squads")
        }
        squadTags[tag] = (squadTags[tag] ?: 0) + count
    }
    fun addSquads(squads: Map<String, Int>){
        squadTags = squads.toMutableMap()
    }
    fun removeSquads(tag: String, count: Int){
        val currentCount = squadTags[tag] ?: throw IllegalStateException("Tag $tag not found")
        if (count > currentCount) {
            throw IllegalStateException("Cannot remove more squads than currently assigned")
        }
        if (count == currentCount){
            squadTags.remove(tag)
        } else{
          squadTags[tag] = currentCount - count
        }
    }

    fun getSquads(): Map<String, Int>{
        return squadTags.toMap()
    }

    fun isFullyAssigned(): Boolean{
        return squadTags.values.sum() == requiredSquads
    }
}