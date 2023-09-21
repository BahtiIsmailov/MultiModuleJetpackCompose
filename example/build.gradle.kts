plugins {
    id(ANDROID_APP_PLUGIN)
    id(KOTLIN_ANDROID_PLUGIN)
    id(KOTLIN_PARCELIZE_PLUGIN)
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.atom.ui.example"
    compileSdk = AndroidVersions.compileSdk

    defaultConfig {
        applicationId = "com.atom.ui.example"
        minSdk = AndroidVersions.minSdk
        targetSdk = AndroidVersions.targetSdk
        versionCode = AndroidVersions.versionCode
        versionName = AndroidVersions.versionName
        testInstrumentationRunner = ANDROID_TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs = freeCompilerArgs.plus("-Xjvm-default=all")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = LibVersions.composeCompiler
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    dependencies {
        implementation(Dependencies.coilCompose)
        implementation(Dependencies.bouquet)

        implementation(Dependencies.AndroidX.coreKtx)
        implementation(Dependencies.AndroidX.appcompat)
        implementation(Dependencies.AndroidX.fragmentKtx)
        implementation(Dependencies.AndroidX.cardView)
        implementation(Dependencies.AndroidX.constraintLayout)
        implementation(Dependencies.AndroidX.livedataKtx)
        implementation(Dependencies.AndroidX.lifecycleRuntime)
        implementation(Dependencies.AndroidX.viewModelKtx)

        implementation(Dependencies.AndroidX.Navigation.compose)
        implementation(Dependencies.AndroidX.Navigation.uiKtx)
        implementation(Dependencies.AndroidX.Navigation.fragmentKtx)

        implementation(Dependencies.AndroidX.Compose.ui)
        implementation(Dependencies.AndroidX.Compose.uiTooling)
        implementation(Dependencies.AndroidX.Compose.activity)
        implementation(Dependencies.AndroidX.Compose.material)
        implementation(Dependencies.AndroidX.Compose.viewModel)
        implementation(Dependencies.AndroidX.Compose.constraintLayout)
        implementation(project(Projects.Resources.resources))
        implementation(project(Projects.Widgets.widgets))
        implementation(project(Projects.Utills.utills))
        implementation(project(Projects.SpeedLimitComponent.speedLimitComponent))
    }

}
