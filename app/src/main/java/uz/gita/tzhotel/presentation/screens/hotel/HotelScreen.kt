package uz.gita.tzhotel.presentation.screens.hotel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.tzhotel.R
import uz.gita.tzhotel.data.models.moreAboutHotelList
import uz.gita.tzhotel.presentation.screens.numbers.BlueButton
import uz.gita.tzhotel.ui.theme.BlueJasmine
import uz.gita.tzhotel.ui.theme.ChromeYellow
import uz.gita.tzhotel.ui.theme.GramsHair
import uz.gita.tzhotel.ui.theme.HadFieldBlue
import uz.gita.tzhotel.ui.theme.PureLaughter
import uz.gita.tzhotel.ui.theme.Typography
import uz.gita.tzhotel.utils.myLog

class HotelScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: HotelContract.ViewModel = getViewModel<HotelViewModel>()


        ScreenContent(uiState = viewModel.uiState.collectAsState(), onEventDispatcher = viewModel::onEventDispatcher)

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ScreenContent(
    uiState: State<HotelContract.UiState>,
    onEventDispatcher: (HotelContract.Intent) -> Unit,
) {
    var pagerState = rememberPagerState(3)


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        Text(
            text = "Отель",
            style = Typography
                .bodyLarge,
            modifier = Modifier
                .padding(
                    top = 12.dp
                )
                .fillMaxWidth(),
            textAlign = TextAlign.Center

        )
        if (uiState.value.isLoading){
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
               ) {
                CircularProgressIndicator()
            }
        }
        else {
            Box(
                modifier = Modifier
                    .padding(
                        top = 16.dp
                    )
                    .fillMaxWidth()
                    .height(300.dp),

            ) {
                HorizontalPager(
                    pageCount = 3,
                    state = pagerState,
                    reverseLayout = true,
                    modifier = Modifier
                        .matchParentSize()
                ) {
                    PagerItem(imageUrl = uiState.value.hotelInfo?.image_urls?.get(it) ?: "")
                }

                DotsIndicator(
                    totalDots = 3,
                    selectedIndex = if (pagerState.currentPage == 2) 0 else if (pagerState.currentPage == 0) 2 else 1,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                )

            }

            Box(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp
                    )
                    .background(
                        color = PureLaughter,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = "star",
                        modifier = Modifier
                            .size(15.dp)
                    )

                    Text(
                        text = "${uiState.value.hotelInfo?.rating} ${uiState.value.hotelInfo?.rating_name}",
                        style = TextStyle(
                            color = ChromeYellow,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.sfprodisplaymedium)),
                            fontWeight = FontWeight.W500,
                            lineHeight = 19.2.sp
                        )
                    )
                }
            }

            Text(
                text = "${uiState.value.hotelInfo?.name}",
                style = Typography
                    .displayLarge,
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 8.dp
                    )
            )

            Text(
                text = "${uiState.value.hotelInfo?.adress}",
                style = TextStyle(
                    color = HadFieldBlue,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.sfprodisplaymedium)),
                    fontWeight = FontWeight.W500,
                    lineHeight = 16.8.sp
                ),
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp
                    )
            )

            Row(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 8.dp
                    ),
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "от ${uiState.value.hotelInfo?.minimal_price} ₽",
                    style = Typography
                        .displaySmall
                )
                Text(
                    text = "${uiState.value.hotelInfo?.price_for_it}",
                    style = Typography
                        .displayMedium,
                    modifier = Modifier
                        .padding(
                            bottom = 4.dp,
                            start = 4.dp
                        )
                )
            }

            Divider(
                thickness = 4.dp,
                color = GramsHair,
                modifier = Modifier
                    .padding(top = 12.dp)
            )

            Text(
                text = "Об отеле",
                style = Typography
                    .displayLarge,
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 12.dp
                    )
            )

            Row(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 12.dp,
                        end = 16.dp
                    )
            ) {
                Text(
                    text = "${uiState.value.hotelInfo?.about_the_hotel?.peculiarities?.get(1)}",
                    style = Typography
                        .displayMedium
                )

                Text(
                    text = "${uiState.value.hotelInfo?.about_the_hotel?.peculiarities?.get(0)}",
                    style = Typography
                        .displayMedium,
                    modifier = Modifier
                        .padding(
                            start = 16.dp
                        )
                )
            }



            Row(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 12.dp,
                        end = 16.dp
                    )
            ) {
                Text(
                    text = "${uiState.value.hotelInfo?.about_the_hotel?.peculiarities?.get(2)}",
                    style = Typography
                        .displayMedium
                )

                Text(
                    text = "${uiState.value.hotelInfo?.about_the_hotel?.peculiarities?.get(3)}",
                    style = Typography
                        .displayMedium,
                    modifier = Modifier
                        .padding(
                            start = 16.dp
                        )
                )
            }

            Text(
                text = "${uiState.value.hotelInfo?.about_the_hotel?.description}",
                style = Typography
                    .displayMedium
                    .copy(color = Color.Black),
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp
                    )
            )



            LazyColumn(
                /*modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                state = rememberLazyListState()*/
                modifier = Modifier
                    .height((78*3+30).dp)
            ) {

                items(moreAboutHotelList) {
                    MoreAboutHotelItem(item = it)
                }

            }

            BlueButton(
                text = "К выбору номера" ,
                modifier = Modifier
                    .padding(
                        top = 80.dp,
                        bottom = 20.dp
                    ),
                onClick = {
                    myLog("onClick HotelScreen")
                    onEventDispatcher.invoke(HotelContract.Intent.SelectNumberClicked(uiState.value.hotelInfo?.name?:""))
                }
            )
        }

    }
}

@Composable
@Preview(showSystemUi = true)
private fun ScreenPreview() {
    ScreenContent(uiState = remember {
        mutableStateOf(HotelContract.UiState())
    }, onEventDispatcher = {

    })
}