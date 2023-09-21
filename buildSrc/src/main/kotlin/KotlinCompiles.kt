import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Setup kotlin expirimental API
 */
fun Project.setupKotlinCompile() {
    this.tasks.withType(KotlinCompile::class.java) {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            @Suppress("SuspiciousCollectionReassignment")
            freeCompilerArgs += listOf(
                "-Xuse-experimental=" +
                    "kotlin.Experimental," +
                    "kotlin.time.ExperimentalTime",
                "-Xinline-classes",
                "-progressive"
            )
        }
    }
}
