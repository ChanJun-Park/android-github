object Testing {
	private const val junitVersion = "4.13.2"
	private const val junitAndroidExtVersion = "1.1.3"
	private const val junit5Version = "5.7.2"
	private const val junit5Android = "1.2.2"
	private const val junit5AndroidPluginVersion = "1.7.1.1"
	private const val espressoVersion = "3.4.0"
	private const val truthVersion = "1.1.3"

	const val junit = "junit:junit:$junitVersion"
	const val junitAndroidExt = "androidx.test.ext:junit:$junitAndroidExtVersion"
	const val jupiter = "org.junit.jupiter:junit-jupiter:$junit5Version"
	const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:$junit5Version"
	const val vintage = "org.junit.vintage:junit-vintage-engine:$junit5Version" // junit4 지원
	const val junit5AndroidCore = "de.mannodermaus.junit5:android-test-core:$junit5Android"
	const val junit5AndroidRunner = "de.mannodermaus.junit5:android-test-runner:$junit5Android"
	const val junit5AndroidPlugin = "de.mannodermaus.gradle.plugins:android-junit5:$junit5AndroidPluginVersion"
	const val truth = "com.google.truth:truth:$truthVersion"
	const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
}