plugins {
	id("org.jetbrains.kotlin.jvm")
	id("kotlin-kapt")
}

java {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
	implementation(project(Modules.domain))

	implementation(DaggerHilt.hiltCore)
	"kapt"(DaggerHilt.hiltCompiler)

	implementation(Retrofit.retrofit)
	implementation(Retrofit.moshiConverter)
	implementation(Retrofit.okHttp)
	implementation(Retrofit.okHttpLoggingInterceptor)
}