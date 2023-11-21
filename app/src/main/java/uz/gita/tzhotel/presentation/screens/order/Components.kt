package uz.gita.tzhotel.presentation.screens.order

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.tzhotel.ui.theme.Typography

data class OrderInfoData(
    val text1:String,
    val text2:String
)

@Composable
fun OrderInfoItem(
    data:OrderInfoData
) {
    Row(
        modifier = Modifier
            .padding(
                top = 12.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
        Text(
            text = data.text1,
            modifier = Modifier
                .weight(1f),
            style = Typography
                .displayMedium
        )
        Text(
            text = data.text2,
            modifier = Modifier
                .weight(1f),
            style = Typography
                .displayMedium
                .copy(
                    color = Color.Black
                )
        )
    }
}

@Preview
@Composable
fun OrderInfoItemPreview() {
    OrderInfoItem(OrderInfoData(text1 = "Вылет из", text2 = "Санкт-Петербург"))
}