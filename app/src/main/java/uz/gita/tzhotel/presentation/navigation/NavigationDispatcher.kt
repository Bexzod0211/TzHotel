package uz.gita.tzhotel.presentation.navigation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

class NavigationDispatcher @Inject constructor() : AppNavigator, NavigationHandler {
    override val navigationBuffer = MutableSharedFlow<NavigationArgs>()

    private suspend fun navigate(args:NavigationArgs){
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


}