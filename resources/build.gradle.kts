plugins {
    id(ANDROID_LIBRARY_PLUGIN)
    id(KOTLIN_ANDROID_PLUGIN)
}

android {
    namespace = "com.atom.ui.resources"
    compileSdk = AndroidVersions.compileSdk

    defaultConfig {
        minSdk = AndroidVersions.minSdk
        testInstrumentationRunner = ANDROID_TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    composeOptions {
        kotlinCompilerExtensionVersion = LibVersions.composeCompiler
    }
    buildToolsVersion = "34.0.0"
}

dependencies {
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.fragmentKtx)
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
}
repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}
