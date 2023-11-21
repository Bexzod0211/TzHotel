package uz.gita.tzhotel.presentation.screens.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.tzhotel.R
import uz.gita.tzhotel.ui.theme.ChromeYellow
import uz.gita.tzhotel.ui.theme.FreezeUp
import uz.gita.tzhotel.ui.theme.GramsHair
import uz.gita.tzhotel.ui.theme.PureLaughter
import uz.gita.tzhotel.ui.theme.Sambucus
import uz.gita.tzhotel.ui.theme.Typography

class OrderScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: BookContract.ViewModel = getViewModel<BookViewModel>()

        ScreenContent(uiState = viewModel.uiState.collectAsState(), onEventDispatcher = viewModel::onEventDispatcher)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(
    uiState: State<BookContract.UiState>,
    onEventDispatcher: (BookContract.Intent) -> Unit,
) {
    val orderInfo = uiState.value.orderInfo
    val orderInfoList = listOf(
        OrderInfoData(text1 = "Вылет из", text2 = orderInfo?.departure ?: ""),
        OrderInfoData(text1 = "Страна, город", text2 = "${orderInfo?.arrival_country}"),
        OrderInfoData(text1 = "Даты", text2 = "${orderInfo?.tour_date_start}-${orderInfo?.tour_date_stop}"),
        OrderInfoData(text1 = "Кол-во ночей", text2 = "${orderInfo?.number_of_nights} ночей"),
        OrderInfoData(text1 = " Отель", text2 = "${orderInfo?.hotel_name}"),
        OrderInfoData(text1 = "Номер", text2 = "${orderInfo?.room}"),
        OrderInfoData(text1 = "Питание", text2 = "${orderInfo?.nutrition}"),
    )
    var phoneNumber = remember {
        mutableStateOf("")
    }

    var isFocused by remember {
        mutableStateOf(false)
    }

    var email = remember {
        mutableStateOf("")
    }
    var isFirstTouristOpened by remember {
        mutableStateOf(true)
    }


    var values = mutableListOf(
        mutableListOf(
            remember {
            mutableStateOf("")
        },
            remember {
                mutableStateOf("")
            },
            remember {
                mutableStateOf("")
            },
            remember {
                mutableStateOf("")
            },
            remember {
                mutableStateOf("")
            },
            remember {
                mutableStateOf("")
            })
    )


    val labels = listOf(
        "Имя",
        "Фамилия",
        "Дата рождения",
        "Гражданство",
        "Номер загранпаспорта",
        "Срок действия загранпаспорта",

        )

    val onValueChanges = mutableListOf<MutableList<onValueChange>>(
        mutableListOf(
            {
                values[0][0].value = it
            },
            {
                values[0][1].value = it
            },
            {
                values[0][2].value = it
            },
            {
                values[0][3].value = it
            },
            {
                values[0][4].value = it
            },
            {
                values[0][5].value = it
            }
        )
    )




    LazyColumn {
        item {
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
                            onEventDispatcher.invoke(BookContract.Intent.BackButtonClicked)
                        }
                )

                Text(
                    text = "Бронирование",
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

        item {
            Divider(
                thickness = 4.dp,
                color = GramsHair,
                modifier = Modifier
                    .padding(top = 12.dp)
            )

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
                        text = "${uiState.value.orderInfo?.horating} ${uiState.value.orderInfo?.rating_name}",
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
                text = "${uiState.value.orderInfo?.hotel_name}",
                style = Typography
                    .displayLarge,
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 8.dp
                    )
            )

            Text(
                text = "${uiState.value.orderInfo?.hotel_adress}",
                style = Typography
                    .bodyMedium,
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp
                    )
            )

            Divider(
                thickness = 4.dp,
                color = GramsHair,
                modifier = Modifier
                    .padding(top = 12.dp)
            )


        }


        items(orderInfoList) {
            OrderInfoItem(data = it)
        }

        item {
            Divider(
                thickness = 4.dp,
                color = GramsHair,
                modifier = Modifier
                    .padding(top = 12.dp)
            )
            Text(
                text = "Информация о покупателе",
                style = Typography
                    .displayLarge,
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 16.dp
                    )

            )


            CustomTextField(
                boxModifier = Modifier
                    .padding(
                        top = 16.dp
                    ),
                modifier = Modifier
                    .onFocusChanged {
                        isFocused = it.isFocused
                    }
                    .fillMaxWidth()
                    .height(60.dp),
                value = phoneNumber,
                onValueChange = {
                    if (it.length >= 10)
                        phoneNumber.value = it.substring(0, 10)
                    else phoneNumber.value = it
                    /*var arr = it.toCharArray()


                    var lastDigit = it.lastIndexOfAny(CharArray(10) {
                        "$it"[0]
                    })
//                      +7 (***) ***-**-**
                    var phone = "+7 (***) ***-**-**"
                    for (i in 4..lastDigit) {
                        if (arr[i].isDigit()) {
                            phone = phone.replaceFirst("*", "${arr[i]}")
                        }
                    }
//                        myLog("old:$phoneNumber - new:$it")
                    myLog("compareTo ${it.compareTo(phoneNumber.value)}")

                    if (it.length < phoneNumber.value.length){

                    }

                    var lastChar = Char(0)
                    myLog("${phoneNumber.value} : ${it}")



                        for (i in it.indices){
                            if (phoneNumber.value.length-1>=i) {
                                if ("${phoneNumber.value[i]}" != "${it[i]}") {
                                    myLog("${phoneNumber.value[i]} : ${it[i]}")
                                    lastChar = it[i]
                                    break
                                }
                            }
                        }
                        if (lastChar.isDigit()){
                            phoneNumber.value = phoneNumber.value.replaceFirst("*","$lastChar")
                        }*/

                },
                label = "Номер телефона",
                keyboardType = KeyboardType.Phone,
                visualTransformation = if (isFocused) {
                    {
                        mobileNumberFilter(it)
                    }
                } else {
                    {
                        TransformedText(it, OffsetMapping.Identity)
                    }
                },

                )

            CustomTextField(
                value = email,
                onValueChange = {
                    email.value = it
                },
                modifier = Modifier
                    .fillMaxWidth(),
                boxModifier = Modifier
                    .padding(
                        top = 4.dp
                    ),
                label = "Почта",
                keyboardType = KeyboardType.Email
            )

            Text(
                text = "Эти данные никому не передаются. После оплаты мы вышлем чек на указанный вами номер и почту",
                style = Typography
                    .displayMedium
                    .copy(
                        fontSize = 14.sp,
                        lineHeight = 16.8.sp,
                        fontWeight = FontWeight.W400
                    ),
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 4.dp
                    )
            )

            Divider(
                thickness = 4.dp,
                color = GramsHair,
                modifier = Modifier
                    .padding(top = 12.dp)
            )


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 4.dp
                    )
                    .height(60.dp)
                    .fillMaxWidth()
                    .clickable {
                        isFirstTouristOpened = !isFirstTouristOpened
                    }
            ) {
                Text(
                    text = "Первый турист",
                    style = Typography
                        .displayLarge
                )

                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            color = FreezeUp,
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = if (isFirstTouristOpened) R.drawable.ic_closed else R.drawable.ic_opened),
                        contentDescription = "button",
                        modifier = Modifier
                            .size(18.dp)
                    )
                }
            }
            if (isFirstTouristOpened) {
                for (i in 0 until 6){
                    TouristInfo(list = listOf(
                        TouristInfoData(value = values[0][i], onValueChange = onValueChanges[0][i], isError = uiState.value.errorList?.get(i) ?: remember {
                            mutableStateOf(false)
                        },
                            label = labels[i])

                    ))
                }
            }

            Divider(
                thickness = 4.dp,
                color = GramsHair,
                modifier = Modifier
                    .padding(top = 12.dp)
            )


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 4.dp
                    )
                    .height(60.dp)
                    .fillMaxWidth()
                    .clickable {
                        isFirstTouristOpened = !isFirstTouristOpened
                    }
            ) {
                Text(
                    text = "Первый турист",
                    style = Typography
                        .displayLarge
                )

                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .background(
                            color = FreezeUp,
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = if (isFirstTouristOpened) R.drawable.ic_closed else R.drawable.ic_opened),
                        contentDescription = "button",
                        modifier = Modifier
                            .size(18.dp)
                    )
                }
            }

        }


    }

}

typealias onValueChange = (String)->Unit

@Composable
private fun TouristInfo(
    list:List<TouristInfoData>
) {


    list.forEach {
        CustomTextField(
            value = it.value,
            onValueChange = it.onValueChange,
            modifier = Modifier,
            boxModifier = Modifier.padding(top = 4.dp),
            label = it.label,
            keyboardType = KeyboardType.Text
        )
    }
}


data class TouristInfoData(
    val value: State<String>,
    val onValueChange: (String) -> Unit,
    val isError: State<Boolean>,
    val label: String,
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomTextField(
    value: State<String>,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    boxModifier: Modifier,
    label: String,
    keyboardType: KeyboardType,
    visualTransformation: (AnnotatedString) -> TransformedText = {
        TransformedText(it, OffsetMapping.Identity)
    },
) {
    Box(
        modifier = boxModifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
            .background(
                color = GramsHair,
                shape = RoundedCornerShape(12.dp)
            )
            .fillMaxWidth()
            .height(68.dp)
//                    .clickable {
////                        myLog("tf clicked")
//
//                    }
        ,
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp),
            value = value.value,
            onValueChange = onValueChange,
            label = {
                Text(
//                            modifier = Modifier
//                                .align(Alignment.CenterStart),
                    text = label,
                    style = Typography
                        .bodySmall
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = GramsHair,
                unfocusedBorderColor = GramsHair
            ),
            textStyle = Typography
                .displayMedium
                .copy(
                    color = Sambucus,
                    lineHeight = 17.6.sp,
                    letterSpacing = 0.75.sp
                ),
            visualTransformation = visualTransformation
        )
    }
}

@Composable
@Preview(showSystemUi = true)
private fun ScreenPreview() {
    ScreenContent(
        uiState = remember {
            mutableStateOf(BookContract.UiState())
        },
        onEventDispatcher = {

        }
    )
}

const val mask = "+7 (***) ***-**-**"
fun mobileNumberFilter(text: AnnotatedString): TransformedText {
    // change the length
    val trimmed =
        if (text.text.length >= 10) text.text.substring(0..9) else text.text

    val annotatedString = AnnotatedString.Builder().run {
        for (i in trimmed.indices) {
            val trimmedPortion = trimmed[i]
            if (i == 0) {
                append("+7 ($trimmedPortion")
            } else {
                append(trimmedPortion)
            }
            if (i == 2) {
                append(") ")
            }
            if (i == 5 || i == 7) {
                append("-")
            }
        }
        pushStyle(SpanStyle(color = Color.Black))
        append(mask.takeLast(n = if (mask.length - length > 0) mask.length - length else 0))
        toAnnotatedString()
    }

    val phoneNumberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 2) return offset + 4
            if (offset <= 5) return offset + 6
            if (offset <= 7) return offset + 7
            if (offset <= 9) return offset + 8
            return 16
        }

        //+7 (***) ***-**-**
        override fun transformedToOriginal(offset: Int): Int {
            if (offset <= 3) return offset - 3
            if (offset <= 8) return offset - 5
            if (offset <= 12) return offset - 6
            if (offset <= 15) return offset - 7
            if (offset <= 18) return offset - 8
            return 10
        }
    }

    return TransformedText(annotatedString, phoneNumberOffsetTranslator)
}
