plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
    alias(libs.plugins.dokka.documentation)
}

val kvColorPaletteGroupId: String by project
val kvColorPaletteArtifactId: String by project
val kvColorPaletteVersion: String by project

android {
    namespace = "com.kavi.droid.color.palette"
    compileSdk = libs.versions.compilerSdkVersion.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdkVersion.get().toInt()

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
        val javaVersion = JavaVersion.toVersion(libs.versions.jvmVersion.get().toInt())
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmVersion.get()
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.material3)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

tasks.dokkaHtml {
    outputDirectory.set(layout.buildDirectory.asFile)
    dokkaSourceSets {
        named("main") {
            noAndroidSdkLink.set(false)
            reportUndocumented.set(true) // Optional, to include undocumented declarations
            skipDeprecated.set(false) // Optional, to skip deprecated members
            skipEmptyPackages.set(true) // Optional, to skip packages with no documentable members
            includeNonPublic.set(false) // Optional, to include non-public members
        }
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = kvColorPaletteGroupId
            artifactId = kvColorPaletteArtifactId
            version = kvColorPaletteVersion

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}