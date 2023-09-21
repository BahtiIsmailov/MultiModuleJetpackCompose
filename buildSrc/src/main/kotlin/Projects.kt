import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import java.io.File
import java.io.FileInputStream
import java.util.Properties

fun RepositoryHandler.setupRepositories() {
    google()
    mavenCentral()
    maven { setUrl("https://www.jitpack.io") }
}

object Projects {
    object Utills {
        const val utills = ":utils"
    }

    object Widgets {
        const val widgets = ":widgets"
    }

    object Resources {
        const val resources = ":resources"
    }

    object SpeedLimitComponent {
        const val speedLimitComponent = ":speed_limit_component"
    }
}

