package uz.gita.tzhotel.presentation.screens.hotel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import uz.gita.tzhotel.R
import uz.gita.tzhotel.data.models.MoreAboutHotelData
import uz.gita.tzhotel.ui.theme.ChaosBlack
import uz.gita.tzhotel.ui.theme.GramsHair
import uz.gita.tzhotel.ui.theme.SuitBlue
import uz.gita.tzhotel.ui.theme.Typography

@Composable
fun PagerItem(imageUrl: String) {
    val painter = rememberImagePainter(
        data = imageUrl
    )

    Image(
        painter = painter,
        contentDescription = "image",
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MoreAboutHotelItem(item: MoreAboutHotelData) {
    Column {
        Row(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 20.dp
                )
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.icon),
                contentDescription = item.title,
                modifier = Modifier
                    .size(35.dp)
            )

            Column(
                modifier = Modifier
                    .padding(
                        start = 12.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    )
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = item.title,
                    style = Typography
                        .displayMedium
                        .copy(color = SuitBlue)
                )

                Text(
                    text = "Самое необходимое",
                    style = Typography
                        .displayMedium
                        .copy(
                            fontSize = 14.sp,
                            lineHeight = 16.8.sp
                        )
                )
            }

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_forward),
                contentDescription = "forward",
                modifier = Modifier
                    .size(30.dp)
            )
        }
        Divider(
            thickness = 2.dp,
            color = GramsHair,
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 63.dp,
                    end = 16.dp
                )
        )
    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .padding(bottom = 12.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(
                horizontal = 8.dp,
                vertical = 4.dp
            )
    ) {
        LazyRow(
            modifier = modifier
                .wrapContentHeight()
                .wrapContentWidth()
        ) {
            items(totalDots) { index ->

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(color = if (index == selectedIndex) ChaosBlack else Color(0xFFC7C7C7))
                )

                if (index != totalDots - 1) {
                    Spacer(
                        modifier = Modifier
                            .size(8.dp)
                    )
                }
            }
        }
    }

}

@Composable
@Preview
fun MoreAboutHotelItemPreview() {
    MoreAboutHotelItem(item = MoreAboutHotelData(icon = R.drawable.img_comfort, title = "Удобства"))
}