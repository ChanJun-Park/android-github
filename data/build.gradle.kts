plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
	id("kotlin-kapt")
}

android {
	compileSdk = ProjectConfig.compileSdk

	defaultConfig {
		minSdk = ProjectConfig.minSdk
		targetSdk = ProjectConfig.targetSdk

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {
	implementation(project(Modules.domain))

	implementation(DaggerHilt.hiltCore)
	kapt(DaggerHilt.hiltCompiler)

	implementation(Retrofit.retrofit)
	implementation(Retrofit.moshiConverter)
	implementation(Retrofit.okHttp)
	implementation(Retrofit.okHttpLoggingInterceptor)

	implementation(Room.roomRuntime)
	implementation(Room.roomKtx)
	kapt(Room.roomCompiler)

	implementation(Coroutines.coroutines)

	testImplementation(Retrofit.mockWebServer)
	testImplementation(Coroutines.coroutinesTest)
	testImplementation(Testing.jupiter)
	testRuntimeOnly(Testing.vintage)
	testImplementation(Testing.junit)
	testImplementation(Testing.truth)
}