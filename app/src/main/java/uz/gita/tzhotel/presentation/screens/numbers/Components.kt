package uz.gita.tzhotel.presentation.screens.numbers

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.tzhotel.R
import uz.gita.tzhotel.data.network.response.Room
import uz.gita.tzhotel.presentation.screens.hotel.PagerItem
import uz.gita.tzhotel.ui.theme.BrilliantWhite
import uz.gita.tzhotel.ui.theme.GramsHair
import uz.gita.tzhotel.ui.theme.HadFieldBlue
import uz.gita.tzhotel.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NumberItem(
    item:Room,
    onBlueButtonClick:()->Unit
){
    Column {
        HorizontalPager(pageCount = 3) {
            PagerItem(imageUrl = item.image_urls[it])
        }

        Text(
            text = item.name,
            style = Typography
                .displayLarge,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp
                )
        )

        Row(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 16.dp
                )
        ) {
            Text(
                text = item.peculiarities[0],
                style = Typography
                    .displayMedium,
            )

            Text(
                text = item.peculiarities[1],
                style = Typography
                    .displayMedium,
                modifier = Modifier
                    .padding(
                        start = 16.dp
                    )
            )
        }

        Box(
            modifier = Modifier
                .padding(
                    top = 12.dp,
                    start = 16.dp
                )
                .background(
                    color= BrilliantWhite,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Подробнее о номере",
                    style = Typography
                        .displayMedium
                        .copy(
                            color = HadFieldBlue
                        )
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_go),
                    contentDescription = "go",
                    modifier = Modifier
                        .padding(
                            start = 4.dp
                        )
                        .size(20.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 8.dp
                ),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "${item.price} ₽",
                style = Typography
                    .displaySmall
            )
            Text(
                text = item.price_per,
                style = Typography
                    .displayMedium,
                modifier = Modifier
                    .padding(
                        bottom = 4.dp,
                        start = 4.dp
                    )
            )
        }
        
        BlueButton(
            text = "Выбрать номер",
            modifier = Modifier
            .padding(
                top = 16.dp
            ),
            onClick = {
                onBlueButtonClick.invoke()
            }
        )

        Divider(
            thickness = 4.dp,
            color = GramsHair,
            modifier = Modifier
                .padding(top = 12.dp)
        )
    }
}

@Composable
fun BlueButton(
    text:String,
    modifier: Modifier,
    onClick:()->Unit
){
    Box(
        modifier = modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
            .height(60.dp)
            .background(
                color = HadFieldBlue,
                shape = RoundedCornerShape(16.dp)
            )
            .fillMaxWidth()
            .clickable {
                       onClick.invoke()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = Typography
                .displayMedium
                .copy(
                    color = Color.White,
                    lineHeight = 17.6.sp,
                    letterSpacing = 0.1.sp
                )
        )
    }
}
