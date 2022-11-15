package trenggalek.dev.ui.theme.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import trenggalek.dev.helper.Notification
import trenggalek.dev.util.Constant
import trenggalek.dev.util.Constant.noRippleClickable
import kotlin.random.Random

private val notificationList = listOf(
    Notification.PhoneCall({ PhoneCallExpanded() }, { PhoneCallCollapsed() }),
    Notification.MediaPlayer({ MediaPlayerExpanded() }, { MediaPlayerCollapsed() })
)

fun getRandomNotification(): Notification {
    val randomValue = Random.nextInt(0, notificationList.size)
    return notificationList[randomValue]
}
@Composable
fun DynamicIsland(
    modifier: Modifier = Modifier,
    notificationId: Int,
    notification: Notification? = null,
) {
    var showExpandedContent by remember(notificationId) { mutableStateOf(true) }

    Box(
        modifier = modifier
            .padding(8.dp)
            .clip(Constant.dynamicIslandBackgroundShape)
            .background(Constant.dynamicIslandBackgroundColor)
            .defaultMinSize(Constant.getMinIslandWidth(), Constant.getMinIslandHeight())
            .animateContentSize()
            .wrapContentSize()
    ) {
        if (notification == null) {
            Notch()
        } else {
            Box(
                modifier = Modifier
                    .noRippleClickable { showExpandedContent = true }
                    .padding(16.dp)
            ) {
                if (showExpandedContent) {
                    notification.expandedContent()

                    LaunchedEffect(true) {
                        delay(3000)
                        showExpandedContent = false
                    }

                } else {
                    notification.collapsedContent()
                }
            }
        }
    }

}