package uz.gita.tzhotel.presentation.screens.paid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.tzhotel.R
import uz.gita.tzhotel.presentation.screens.numbers.BlueButton
import uz.gita.tzhotel.presentation.screens.order.AppBar
import uz.gita.tzhotel.ui.theme.GramsHair
import uz.gita.tzhotel.ui.theme.Typography

class PaidScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel:PaidContract.ViewModel = getViewModel<PaidViewModel>()
        ScreenContent(viewModel::onEventDispatcher)
    }
}

@Composable
private fun ScreenContent(
    onEventDispatcher:(PaidContract.Intent)->Unit
) {
    Column {
        AppBar(title = "Заказ оплачен") {
            onEventDispatcher.invoke(PaidContract.Intent.Back)
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        color = GramsHair,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_party),
                    contentDescription = "party",
                    modifier = Modifier
                        .padding(20.dp)
                )
            }


            Text(
                text = "Выш заказ принят в работу",
                style = Typography
                    .displayLarge,
                modifier = Modifier
                    .padding(
                        top = 60.dp
                    )
            )

            Text(
                text = "Подтверждение заказа №104893 может\nзанять некоторое время (от 1 часа до суток).\nКак только мы получим ответ от\nтуроператора, вам на почту придет\nуведомление.",
                style = Typography
                    .displayMedium,
                modifier = Modifier
                    .padding(
                        top = 36.dp
                    )
            )
        }

        BlueButton(
            text = "Супер",
            modifier = Modifier.padding(bottom = 16.dp),
            onClick = {
                onEventDispatcher.invoke(PaidContract.Intent.Back)
            }
        )
    }
}

@Composable
@Preview(showSystemUi = true)
private fun ScreenPreview() {
    ScreenContent {

    }
}