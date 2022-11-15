package trenggalek.dev.ui.theme.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.dp

@Composable
fun FakeCamera() {
    Card(
        modifier = Modifier
            .height(30.dp)
            .width(30.dp),
        backgroundColor = Gray.copy(alpha = 0.2f),
        shape = CircleShape
    ) {}
}
