buildscript {
    repositories {
        google()
        jcenter()
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
        maven { setUrl("http://kotlin.bintray.com/kotlin-eap") }
        maven { setUrl("http://kotlin.bintray.com/kotlin-dev") }
        maven { setUrl("https://kotlin.bintray.com/kotlinx") }
        maven { setUrl("https://dl.bintray.com/jetbrains/kotlin-native-dependencies") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath("com.github.jengelman.gradle.plugins:shadow:2.0.2")
        classpath(kotlin("gradle-plugin", version = "1.4.20"))
    }
}

allprojects {
    repositories {
        maven { setUrl("http://kotlin.bintray.com/kotlin-eap") }
        maven { setUrl("http://kotlin.bintray.com/kotlin-dev") }
        maven { setUrl("https://kotlin.bintray.com/kotlinx") }
        maven { setUrl("https://dl.bintray.com/kotlin/ktor") }
        maven { setUrl("https://dl.bintray.com/sargunster/maven") }
        maven { setUrl("https://dl.bintray.com/kotlin/squash") }
        maven { setUrl("https://dl.bintray.com/badoo/maven") }
        maven { setUrl("https://dl.bintray.com/russhwolf/multiplatform-settings") }
        maven { setUrl("https://dl.bintray.com/korlibs/korlibs") } //For Common) Date
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }

        google()
        jcenter()
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
