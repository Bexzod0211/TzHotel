package uz.gita.tzhotel.presentation.screens.numbers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.tzhotel.R
import uz.gita.tzhotel.presentation.screens.order.AppBar
import uz.gita.tzhotel.ui.theme.GramsHair
import uz.gita.tzhotel.ui.theme.Typography

class NumbersScreen(val name: String) : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: NumbersContract.ViewModel = getViewModel<NumbersViewModel>()

        ScreenContent(
            uiState = viewModel.uiState.collectAsState(),
            onEventDispatcher = viewModel::onEventDispatcher,
            hotelName = name
        )
    }
}

@Composable
private fun ScreenContent(
    uiState: State<NumbersContract.UiState>,
    onEventDispatcher: (NumbersContract.Intent) -> Unit,
    hotelName: String,
) {
    LazyColumn {
        item {
            AppBar(title = hotelName) {
                onEventDispatcher.invoke(NumbersContract.Intent.BackButtonClicked)
            }
        }

        if (uiState.value.isLoading) {
            item {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        } else {

            item {
                Divider(
                    thickness = 4.dp,
                    color = GramsHair,
                    modifier = Modifier
                        .padding(top = 12.dp)
                )
            }

            items(uiState.value.response?.rooms ?: mutableListOf()) {
                NumberItem(
                    item = it,
                    onBlueButtonClick = {
                        onEventDispatcher.invoke(NumbersContract.Intent.OrderNumberClicked)
                    }
                )
            }
        }

    }
}


@Composable
@Preview
private fun ScreenPreview() {
    ScreenContent(
        uiState = remember {
            mutableStateOf(NumbersContract.UiState())
        },
        onEventDispatcher = {

        },
        hotelName = ""
    )
}