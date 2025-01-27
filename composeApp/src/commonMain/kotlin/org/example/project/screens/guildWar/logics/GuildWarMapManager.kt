package org.example.project.screens.guildWar.logics

class GuildWarMapManager(
    private val map: GuildWarMap
) {
    // Получить объект Location по ID
    fun getLocationById(locationId: Int): Location {
        return map.getLocationById(locationId)
    }
    fun getLocationByName(locationName: String): Location {
        return map.getLocationByName(locationName)
    }

    // Установить требуемое количество отрядов для всех локаций
    fun setRequiredSquadsForAllLocations(count: Int) {
        map.setRequiredSquadsForAllLocations(count)
    }

    // Добавить отряды к указанной локации
    fun addSquadToLocation(location: Location, tag: String, count: Int) {
        location.addSquad(tag, count)
    }
    fun addSquadsToLocation(location: Location, squads: Map<String, Int>){
        location.addSquads(squads)
    }
    // Удалить отряды из указанной локации
    fun removeSquadsFromLocation(locationId: Int, tag: String, count: Int) {
        val location = map.getLocationById(locationId)
        location.removeSquads(tag, count)
    }

    // Получить список всех локаций
    fun getAllLocations(): List<Location> {
        return map.getAllLocations()
    }


}
