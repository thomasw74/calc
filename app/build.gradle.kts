plugins {
    application
    id("org.beryx.jlink") version "3.0.0"
    id("org.openjfx.javafxplugin") version("0.1.0")
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

javafx {
    version = "21"
    modules("javafx.controls")
}

dependencies {
    implementation(project(":parser"))
}

application {
    mainModule = "calc"
    mainClass = "calc.App"
}

jlink {
    options = listOf("--strip-debug", "--no-header-files", "--no-man-pages")
}
