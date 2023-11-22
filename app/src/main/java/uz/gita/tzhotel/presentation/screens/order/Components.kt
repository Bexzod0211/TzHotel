package uz.gita.tzhotel.presentation.screens.order

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.tzhotel.R
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

@Composable
fun PaymentInfoItem(
    paymentType:String,
    price:String,
    priceColor: Color,
    priceFontWeight: FontWeight
){
    Row(
        modifier = Modifier
            .padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = paymentType,
            style = Typography
                .displayMedium
        )

        Text(
            text = price,
            style = Typography
                .displayMedium
                .copy(
                    color = priceColor,
                    fontWeight = priceFontWeight
                )
        )
    }

}

@Composable
fun AppBar(title:String,onBackButtonClick:()->Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "back",
            modifier = Modifier
                .padding(start = 16.dp)
                .size(20.dp)
                .clickable {
                    onBackButtonClick.invoke()
                }
        )

        Text(
            text = title,
            modifier = Modifier
                .weight(1f),
            style = Typography
                .bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .size(52.dp)
        )
    }
}