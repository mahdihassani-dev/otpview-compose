plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("maven-publish")
}



android {
    namespace = "com.example.otpviewcompose"
    compileSdk = 34


    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }


}


publishing{
    publications{
        register<MavenPublication>("release"){
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}



//publishing {
//    publications {
//        create<MavenPublication>("gpr") {
//            run {
//                groupId = "com.github.mahdihassani-dev"
//                artifactId = "otpviewcompose"
//                version = "1.0"
//                artifact("$buildDir/outputs/aar/OtpViewCompose-release.aar")
//            }
//        }
//    }
//
//
//    repositories {
//        maven {
//            name = "GitHubPackages"
//            /** Configure path of your package repository on Github
//             *  Replace GITHUB_USERID with your/organisation Github userID and REPOSITORY with the repository name on GitHub
//             */
//            url = uri("https://maven.pkg.github.com/114219970/OtpViewCompose") // Github Package
//            credentials {
//                //Fetch these details from the properties file or from Environment variables
//                val githubProperties = Properties()
//                githubProperties.load(FileInputStream(rootProject.file("github.properties")))
//                username = githubProperties["gpr.usr"] as String? ?: System.getenv("GPR_USER")
//                password = githubProperties["gpr.key"] as String? ?: System.getenv("GPR_API_KEY")
//            }
//        }
//    }
//
//
//}




