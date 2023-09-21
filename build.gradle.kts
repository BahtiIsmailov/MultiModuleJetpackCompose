import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.tasks.factory.dependsOn

buildscript {
    repositories.setupRepositories()

    dependencies {
        classpath(Dependencies.Classpath.android)
        classpath(Dependencies.Classpath.kotlinGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    }
}

apply(plugin = "java")

allprojects {
    repositories.setupRepositories()

    val setupAndroidProjectAction: Action<in Plugin<*>> = Action { setupAndroidProject(this@allprojects) }
    project.plugins.withId(ANDROID_APP_PLUGIN, setupAndroidProjectAction)
    project.plugins.withId(ANDROID_LIBRARY_PLUGIN, setupAndroidProjectAction)

    project.plugins.withId(KOTLIN_ANDROID_PLUGIN) {
        setupKotlin(this@allprojects)
        initKotlinSrcDirectories()
        excludeAndroidTestPackagingOptions()
    }

    project.plugins.withId(KOTLIN_PLUGIN) {
        setupKotlin(this@allprojects)
    }
}

fun setupKotlin(project: Project) {
    project.dependencies {
        "implementation"(Dependencies.Kotlin.stdlibJdk8)
    }

    project.setupKotlinCompile()
}

fun setupAndroidProject(project: Project) {
    val androidExtension = project.getAndroidExtension<BaseExtension>() ?: return


    project.project.plugins.apply { apply(KOTLIN_ANDROID_PLUGIN) }

    androidExtension.compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    project.dependencies {
        "coreLibraryDesugaring"(Dependencies.Classpath.desugarJdkLibs)
    }

    androidExtension.defaultConfig {
        vectorDrawables.useSupportLibrary = true
    }
}

val ktlint by configurations.creating

dependencies {
    ktlint(Dependencies.Validation.ktlint)
}

val ktlintCheck by tasks.creating(JavaExec::class) {
    description = "Check Kotlin code style."
    classpath = ktlint
    args = listOf(
        "--android",
        "--editorconfig=" + file(".editorconfig").path,
        "--disabled_rules=import-ordering,indent"
    ) + allprojects.map { it.file("src").path + "/**/*.kt" }
}

tasks.named("check").dependsOn("ktlintCheck")
