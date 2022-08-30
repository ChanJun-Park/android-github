plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("de.mannodermaus.android-junit5")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.applicationId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["runnerBuilder"] =
            "de.mannodermaus.junit5.AndroidJUnit5Builder"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(Modules.domain))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.constraintLayout)
    implementation(Material.material)

    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)

    testImplementation(Testing.jupiter)
    testRuntimeOnly(Testing.vintage)
    testImplementation(Testing.junit)
    testImplementation(Testing.truth)
    androidTestImplementation(Testing.junitAndroidExt)
    androidTestImplementation(Testing.espresso)
    androidTestImplementation(Testing.jupiterApi)
    androidTestImplementation(Testing.junit5AndroidCore)
    androidTestRuntimeOnly(Testing.junit5AndroidRunner)
}

kapt {
    correctErrorTypes = true
}