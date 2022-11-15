package trenggalek.dev.ui.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import trenggalek.dev.R
import trenggalek.dev.util.Constant

@Composable
fun PhoneCallExpanded(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.width(Constant.getScreenWidthDp() - 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val imageSize = 64.dp
        val generalImageModifier = Modifier
            .clip(CircleShape)
            .size(imageSize)

        Image(
            painter = rememberAsyncImagePainter("https://assets.promediateknologi.com/crop/0x0:720x684/x/photo/2022/03/18/2402235054.jpg"),
            contentDescription = null,
            modifier = generalImageModifier,
            contentScale = ContentScale.Fit
        )

        Text(text = "Anya Geraldine", color = Color.White, fontSize = 16.sp)


        Icon(
            Icons.Default.Call, "Reject Call",
            modifier = generalImageModifier
                .background(Color.Red)
                .padding(12.dp)
                .rotate(130f),
            tint = Color.White
        )

        Icon(
            Icons.Default.Call, "Answer Call",
            modifier = generalImageModifier
                .background(Color.Green)
                .padding(12.dp),
            tint = Color.White
        )


    }
}