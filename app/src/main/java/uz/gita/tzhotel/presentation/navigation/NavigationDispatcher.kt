package uz.gita.tzhotel.presentation.navigation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import uz.gita.tzhotel.utils.myLog
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationDispatcher @Inject constructor() : AppNavigator, NavigationHandler {
    override val navigationBuffer = MutableSharedFlow<NavigationArgs>()

    private suspend fun navigate(args:NavigationArgs){
        myLog("NavigationDispatcher navigate")
        navigationBuffer.emit(args)
    }

    override suspend fun back() {
        navigate {
            pop()
        }
    }

    override suspend fun backAll() {
        navigate {
            popAll()
        }
    }

    override suspend fun navigateTo(screen: AppScreen) {
        navigate {
            myLog("NavigationDispatcher onClick")
            push(screen)
        }
    }

    override suspend fun replace(screen: AppScreen) {
        navigate {
            replace(screen)
        }
    }

    override suspend fun replaceAll(screen: AppScreen) {
        navigate {
            replaceAll(screen)
        }
    }

    override suspend fun replaceAll(screens: List<AppScreen>) {
        navigate {
            replaceAll(screens)
        }
    }


}