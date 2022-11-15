package trenggalek.dev.util

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Constant {

    val dynamicIslandBackgroundShape = RoundedCornerShape(64.dp)
    val dynamicIslandBackgroundColor = Color.Black

    @Composable
    fun getMinIslandWidth(): Dp {
        val configuration = LocalConfiguration.current
        return (configuration.screenWidthDp / 2.5f).dp
    }

    @Composable
    fun getMinIslandHeight(): Dp {
        val configuration = LocalConfiguration.current
        return (configuration.screenHeightDp / 18f).dp
    }

    @Composable
    fun getScreenWidthDp(): Dp {
        val configuration = LocalConfiguration.current
        return configuration.screenWidthDp.dp
    }

    @SuppressLint("ModifierFactoryUnreferencedReceiver")
    inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
        clickable(indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
            onClick()
        }
    }

}