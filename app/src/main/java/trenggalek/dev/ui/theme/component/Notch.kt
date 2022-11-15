package trenggalek.dev.ui.theme.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import trenggalek.dev.util.Constant

@Composable
fun Notch() {
    val notchWidth = Constant.getMinIslandWidth()
    val notchHeight = Constant.getMinIslandHeight()

    Card(
        modifier = Modifier
            .width(notchWidth)
            .height(notchHeight),
        backgroundColor = Constant.dynamicIslandBackgroundColor,
        shape = Constant.dynamicIslandBackgroundShape,
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            FakeCamera()
            NotificationLight()
            FakeCamera()
        }
    }
}
@Composable
fun NotificationLight() {
    val infiniteTransition = rememberInfiniteTransition()
    val infinitelyAnimatedFloat = infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(
        modifier = Modifier
            .height(6.dp)
            .width(6.dp)
    ) {
        drawCircle(
            color = Color.Green,
            radius = 10f,
            alpha = infinitelyAnimatedFloat.value
        )
    }
}
