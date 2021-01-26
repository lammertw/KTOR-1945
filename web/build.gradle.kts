plugins {
    id("org.jetbrains.kotlin.js")
}

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

dependencies {
    val kotlinVersion = "1.4.20"
    val muirwikComponentVersion = "0.6.3"
    val kotlinJsVersion = "pre.129-kotlin-$kotlinVersion"

    implementation(kotlin("stdlib-js"))

    //React, React DOM + Wrappers (chapter 3)
    implementation("org.jetbrains", "kotlin-react", "17.0.0-$kotlinJsVersion")
    implementation("org.jetbrains", "kotlin-react-dom", "17.0.0-$kotlinJsVersion")
    implementation(npm("react", "17.0.0"))
    implementation(npm("react-dom", "17.0.0"))

    //Kotlin Styled (chapter 3)
    implementation("org.jetbrains", "kotlin-styled", "1.0.0-$kotlinJsVersion")
    implementation(npm("styled-components", "~5.1.1"))
    implementation(npm("inline-style-prefixer", "~6.0.0"))

    //Video Player (chapter 7)
    implementation(npm("react-player", "~2.6.0"))

    //Share Buttons (chapter 7)
    implementation(npm("react-share", "~4.2.1"))

    //Coroutines (chapter 8)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")

    implementation("org.jetbrains", "kotlin-styled", "5.2.0-$kotlinJsVersion")
    
    implementation("io.ktor:ktor-client-js:1.4.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2") {
        version {
            strictly("1.4.2")
        }
    }
}

kotlin {
    js {
        browser {
            webpackTask {
                cssSupport.enabled = true
            }

            runTask {
                cssSupport.enabled = true
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}
