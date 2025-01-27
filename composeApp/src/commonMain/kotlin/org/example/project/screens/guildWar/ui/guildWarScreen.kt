import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import guildmanager.composeapp.generated.resources.A1
import guildmanager.composeapp.generated.resources.A2
import guildmanager.composeapp.generated.resources.B1
import guildmanager.composeapp.generated.resources.B2
import guildmanager.composeapp.generated.resources.C1
import guildmanager.composeapp.generated.resources.C2
import guildmanager.composeapp.generated.resources.D1
import guildmanager.composeapp.generated.resources.D2
import guildmanager.composeapp.generated.resources.F1
import guildmanager.composeapp.generated.resources.F2
import guildmanager.composeapp.generated.resources.Res
import guildmanager.composeapp.generated.resources.planetTaris
import org.example.project.ui.components.AppScreen
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import guildmanager.composeapp.generated.resources.spice1
import guildmanager.composeapp.generated.resources.spiceModile
import org.example.project.screens.guildWar.logics.GuildWarMap
import org.example.project.screens.guildWar.logics.GuildWarMapManager


@Composable
@Preview
fun guildWarScreen(navController: NavHostController) {
    AppScreen(navController) {
        warMap()
    }
}

@Composable
private fun warMap() {
    val map = GuildWarMap()
    val guildWarManager = GuildWarMapManager(map)
    var selectedLocationName by remember { mutableStateOf<String?>(null) }

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center
    ) {
        val screenWidth = maxWidth
        val screenHeight = maxHeight

        val isLandscape = screenWidth > screenHeight
        val planetWidth = if (isLandscape) screenWidth * 0.5f else screenWidth * 0.6f
        val planetHeight = planetWidth

        screenMap(
            screenWidth = screenWidth,
            screenHeight = screenHeight,
            planetWidth = planetWidth,
            planetHeight = planetHeight,
            onLocationClick = { locationName ->
                selectedLocationName = locationName
            }
        )
        if (selectedLocationName != null) {
            val location = guildWarManager.getLocationByName(selectedLocationName!!)
            locationDetails(
                locationName = location.name,
                currentSquads = location.getSquads(),
                requiredSquads = location.requiredSquads,
                onSave = { updatedSquads ->
                    guildWarManager.addSquadsToLocation(location, updatedSquads)
                },
                onDismiss = { selectedLocationName = null }
            )
        }
    }
}


@Composable
private fun locationDetails(
    locationName: String,
    currentSquads: Map<String, Int>,
    requiredSquads: Int = 0,
    onSave: (Map<String, Int>) -> Unit,
    onDismiss: () -> Unit
) {
    val squads by remember { mutableStateOf(currentSquads.toMutableMap()) }
    var newTag by remember { mutableStateOf("") } // Для ввода нового тега
    var newCount by remember { mutableStateOf("") } // Для ввода количества отрядов

    AlertDialog(
        modifier = Modifier.size(500.dp),
        onDismissRequest = onDismiss,
        title = { Text("Details for $locationName", fontSize = 25.sp) },
        text = {
            Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Column {
                    Text("Required squads: $requiredSquads")
                    Spacer(Modifier.size(20.dp))
                    squads.forEach { (tag, count) ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("$tag:", modifier = Modifier.weight(1f)) // Название тега
                            Spacer(Modifier.width(8.dp))
                            Text("$count", modifier = Modifier.weight(1f)) // Отображение количества
                        }
                    }
                } //отображение отрядов

                Spacer(Modifier.height(16.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        TextField(
                            value = newTag,
                            onValueChange = { newTag = it },
                            placeholder = { Text("Enter tag") },
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(Modifier.size(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        TextField(
                            value = newCount,
                            onValueChange = { newCount = it },
                            placeholder = { Text("Count") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.width(80.dp)
                        )
                        Spacer(Modifier.size(8.dp))
                        Button(onClick = {
                            val count = newCount.toIntOrNull() ?: 0
                            if (newTag.isNotBlank() && count > 0) {
                                squads[newTag] = count
                                newTag = ""
                                newCount = ""
                            }
                        }) {
                            Text("Add Squad")
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(onClick = {
                onSave(squads)
                onDismiss()
            }) {
                Text("Save")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text(text = "Close")
            }
        }
    )
}

@Composable
private fun screenMap(
    screenWidth: Dp,
    screenHeight: Dp,
    planetWidth: Dp,
    planetHeight: Dp,
    onLocationClick: (String) -> Unit
) {
    BoxWithConstraints (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(if (maxWidth>maxHeight)Res.drawable.spice1 else Res.drawable.spiceModile),
            contentDescription = "background image",
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .size(planetWidth, planetHeight)
                .graphicsLayer {
                    translationX = (screenWidth - planetWidth).toPx() / 2f
                    translationY =
                        if (screenWidth > screenHeight) (screenHeight - planetHeight).toPx() / 3f else (screenHeight - planetHeight).toPx() / 2f
                }
        ) {
            Image(
                painter = painterResource(Res.drawable.planetTaris),
                contentDescription = "planet",
                modifier = Modifier.fillMaxSize()
            )
            mapElements(planetWidth, planetHeight, onLocationClick)
        }
    }
}
@Composable
private fun location(
    path: DrawableResource,
    offsetX: Dp,
    offsetY: Dp,
    locationWidth: Dp,
    locationHeight: Dp,
    onLocationClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .offset(offsetX, offsetY)
            .size(locationWidth, locationHeight)
            .clickable { onLocationClick() }
    ) {
        Image(
            painter = painterResource(path),
            contentDescription = "location image",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun mapElements(planetWidth: Dp, planetHeight: Dp, onLocationSelected: (String) -> Unit) {
    location(
        path = Res.drawable.A1,
        offsetX = planetWidth * 0.65f,
        offsetY = planetHeight * 0.16f,
        locationWidth = planetWidth * 0.24f,
        locationHeight = planetHeight * 0.23f,
        onLocationClick = { onLocationSelected("A1") }
    )
    location(
        path = Res.drawable.B1,
        offsetX = planetWidth * 0.499f,
        offsetY = planetHeight * 0.126f,
        locationWidth = planetWidth * 0.168f,
        locationHeight = planetHeight * 0.27f,
        onLocationClick = { onLocationSelected("B1") }
    )
    location(
        path = Res.drawable.F1,
        offsetX = planetWidth * 0.32f,
        offsetY = planetHeight * 0.13f,
        locationWidth = planetWidth * 0.17f,
        locationHeight = planetHeight * 0.170f,
        onLocationClick = { onLocationSelected("F1") }
    )
    location(
        path = Res.drawable.F2,
        offsetX = planetWidth * 0.12f,
        offsetY = planetHeight * 0.17f,
        locationWidth = planetWidth * 0.211f,
        locationHeight = planetHeight * 0.164f,
        onLocationClick = { onLocationSelected("F2") }
    )
    location(
        path = Res.drawable.A2,
        offsetX = planetWidth * 0.688f,
        offsetY = planetHeight * 0.385f,
        locationWidth = planetWidth * 0.208f,
        locationHeight = planetHeight * 0.377f,
        onLocationClick = { onLocationSelected("A2") }
    )
    location(
        path = Res.drawable.B2,
        offsetX = planetWidth * 0.48f,
        offsetY = planetHeight * 0.385f,
        locationWidth = planetWidth * 0.228f,
        locationHeight = planetHeight * 0.439f,
        onLocationClick = { onLocationSelected("B2") }
    )
    location(
        path = Res.drawable.C1,
        offsetX = planetWidth * 0.3f,
        offsetY = planetHeight * 0.285f,
        locationWidth = planetWidth * 0.242f,
        locationHeight = planetHeight * 0.205f,
        onLocationClick = { onLocationSelected("C1") }
    )
    location(
        path = Res.drawable.C2,
        offsetX = planetWidth * 0.29f,
        offsetY = planetHeight * 0.49f,
        locationWidth = planetWidth * 0.192f,
        locationHeight = planetHeight * 0.335f,
        onLocationClick = { onLocationSelected("C2") }
    )
    location(
        path = Res.drawable.D1,
        offsetX = planetWidth * 0.079f,
        offsetY = planetHeight * 0.3f,
        locationWidth = planetWidth * 0.235f,
        locationHeight = planetHeight * 0.192f,
        onLocationClick = { onLocationSelected("D1") }
    )
    location(
        path = Res.drawable.D2,
        offsetX = planetWidth * 0.079f,
        offsetY = planetHeight * 0.48f,
        locationWidth = planetWidth * 0.217f,
        locationHeight = planetHeight * 0.295f,
        onLocationClick = { onLocationSelected("D2") }
    )
}