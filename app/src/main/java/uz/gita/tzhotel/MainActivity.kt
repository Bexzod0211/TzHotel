package uz.gita.tzhotel

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.tzhotel.presentation.navigation.NavigationHandler
import uz.gita.tzhotel.presentation.screens.hotel.HotelScreen
import uz.gita.tzhotel.ui.theme.TzHotelTheme
import uz.gita.tzhotel.utils.myLog
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationHandler: NavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myLog(navigationHandler.javaClass.name)
        var context:Context? = null
        try {
            setContent {
                context = LocalContext.current
                TzHotelTheme {
                    // A surface container using the 'background' color from the theme
                    Navigator(screen = HotelScreen()) { navigator ->
                        LaunchedEffect(key1 = navigator) {
                            navigationHandler.navigationBuffer
                                .onEach { navArgs ->
                                    myLog("MainActivity navArgs onEach")
                                    navArgs.invoke(navigator)
                                }
                                .launchIn(lifecycleScope)
                        }
                        CurrentScreen()
                    }
                }
            }
        }
        catch (e:Exception){
            Toast.makeText(context, "${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}


