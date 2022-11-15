package trenggalek.dev.helper

import androidx.compose.runtime.Composable

sealed class Notification {
    abstract val expandedContent: @Composable () -> Unit
    abstract val collapsedContent: @Composable () -> Unit

    data class PhoneCall(
        override val expandedContent: @Composable () -> Unit,
        override val collapsedContent: @Composable () -> Unit
    ) : Notification()

    data class MediaPlayer(
        override val expandedContent: @Composable () -> Unit,
        override val collapsedContent: @Composable () -> Unit
    ) : Notification()
}