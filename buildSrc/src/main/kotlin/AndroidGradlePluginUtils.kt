import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

@Suppress("UNCHECKED_CAST")
fun <T : BaseExtension> Project.getAndroidExtension(): T? {
    return extensions.findByName("android") as T?
}

fun Project.initKotlinSrcDirectories() {
    val androidExt = extensions.getByName("android") as BaseExtension
    androidExt.sourceSets.configureEach {
        logger.debug("Add `kotlin` directory to source set {}", name)
        java.setSrcDirs(java.srcDirs + file("src/$name/kotlin"))
    }
}

fun Project.excludeAndroidTestPackagingOptions() {
    val androidExt = extensions.getByName("android") as BaseExtension
    androidExt.sourceSets.configureEach {
        if (name == "androidTest") {
            logger.debug("Format packaging options for {}", name)
            androidExt.packagingOptions {
                exclude("META-INF/*.kotlin_module")
            }
        }
    }
}
