package uz.gita.tzhotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.tzhotel.presentation.navigation.NavigationHandler
import uz.gita.tzhotel.presentation.screens.hotel.HotelScreen
import uz.gita.tzhotel.ui.theme.TzHotelTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationHandler: NavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TzHotelTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Navigator(screen = HotelScreen()) {
                        LaunchedEffect(key1 = it){
                            navigationHandler.navigationBuffer
                                .onEach {navArgs->
                                    navArgs.invoke(it)
                                }
                                .launchIn(lifecycleScope)
                        }
                        CurrentScreen()
                    }
                }
            }
        }
    }
}

