object Dependencies {

    const val material = "com.google.android.material:material:${LibVersions.material}"
    const val coilCompose = "io.coil-kt:coil-compose:${LibVersions.coil}"
    const val bouquet = "io.github.grizzi91:bouquet:${LibVersions.bouquet}"
    const val timber = "com.jakewharton.timber:timber:${LibVersions.timber}"

    object Classpath {
        const val android = "com.android.tools.build:gradle:${LibVersions.android}"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${LibVersions.kotlin}"
        const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:${LibVersions.desugarJdkLibs}"
    }

    object Kotlin {

        const val stdlibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${LibVersions.kotlin}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${LibVersions.kotlin}"

        object Coroutines {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibVersions.coroutines}"
        }
    }

    object AndroidX {

        const val coreKtx = "androidx.core:core-ktx:${LibVersions.coreKtx}"
        const val appcompat = "androidx.appcompat:appcompat:${LibVersions.appcompat}"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:${LibVersions.fragmentKtx}"
        const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${LibVersions.lifecycle}"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibVersions.lifecycle}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${LibVersions.lifecycle}"
        const val cardView = "androidx.cardview:cardview:${LibVersions.cardView}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${LibVersions.constraintLayout}"

        object Compose {

            const val ui = "androidx.compose.ui:ui:${LibVersions.compose}"
            const val foundation = "androidx.compose.foundation:${LibVersions.compose}"
            const val uiTooling = "androidx.compose.ui:ui-tooling-preview:${LibVersions.compose}"
            const val util ="androidx.compose.ui:ui-util:${LibVersions.compose}"
            const val activity = "androidx.activity:activity-compose:${LibVersions.composeActivity}"
            const val material = "androidx.compose.material:material:${LibVersions.compose}"
            const val constraintLayout =
                "androidx.constraintlayout:constraintlayout-compose:${LibVersions.constraintLayoutCompose}"

            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${LibVersions.lifecycle}"
        }

        object Navigation {

            const val compose = "androidx.navigation:navigation-compose:${LibVersions.navigation}"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:${LibVersions.navigation}"
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${LibVersions.navigation}"
        }
    }

    object Validation {

        const val ktlint = "com.pinterest:ktlint:${LibVersions.ktlint}"
    }
}
