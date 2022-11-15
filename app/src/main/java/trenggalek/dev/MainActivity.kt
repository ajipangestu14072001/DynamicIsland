package trenggalek.dev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.launch
import trenggalek.dev.helper.Notification
import trenggalek.dev.ui.theme.DynamicIslandTheme
import trenggalek.dev.ui.theme.component.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicIslandTheme {
                val sheetState = rememberModalBottomSheetState(
                    initialValue = ModalBottomSheetValue.Hidden,
                    confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
                )
                val coroutineScope = rememberCoroutineScope()

                var notificationId by remember { mutableStateOf(1) }
                var randomNotification by remember { mutableStateOf<Notification?>(null) }

                BackHandler(sheetState.isVisible) {
                    coroutineScope.launch { sheetState.hide() }
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    DynamicIsland(
                        notificationId = notificationId,
                        notification = randomNotification,
                    )
                }

                ModalBottomSheetLayout(
                    sheetState = sheetState,
                    sheetShape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp),
                    sheetContent = {

                        Column(
                            modifier = Modifier.padding(20.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {

                            Image(
                                painter = rememberAsyncImagePainter("https://3.bp.blogspot.com/-VVp3WvJvl84/X0Vu6EjYqDI/AAAAAAAAPjU/ZOMKiUlgfg8ok8DY8Hc-ocOvGdB0z86AgCLcBGAsYHQ/s1600/jetpack%2Bcompose%2Bicon_RGB.png",),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(150.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Button(
                                onClick = {
                                    notificationId++
                                    randomNotification = null
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp)
                                    .padding(top = 20.dp),
                                shape = RoundedCornerShape(20.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Gray,
                                    contentColor = Color.White
                                ),
                                contentPadding = PaddingValues(vertical = 14.dp)
                            ) {
                                Text(text = "Remove notifications")
                            }
                            Button(
                                onClick = {
                                    notificationId++
                                    randomNotification = getRandomNotification()
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp)
                                    .padding(top = 20.dp),
                                border = BorderStroke(1.dp, Color.Gray),
                                shape = RoundedCornerShape(20.dp),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Gray),
                                contentPadding = PaddingValues(vertical = 14.dp)
                            ) {
                                Text(text = "Send Random Notification", color = Color.Gray)
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 24.dp)
                            .padding(horizontal = 24.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(32.dp))
                        Button(
                            onClick = {
                                coroutineScope.launch {
                                    if (sheetState.isVisible) sheetState.hide()
                                    else sheetState.show()
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .padding(top = 20.dp),
                            border = BorderStroke(1.dp, Color.Gray),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Gray),
                            contentPadding = PaddingValues(vertical = 14.dp)
                        ) {
                            Text(text = "Click to show bottom sheet", color = Color.Gray)
                        }
                    }
                }
            }
        }
    }
}
