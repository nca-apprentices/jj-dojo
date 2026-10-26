plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.kotlin.test)
    testRuntimeOnly(libs.junit.launcher)
}

kotlin {
    jvmToolchain(25)
}

application {
    mainClass = "dojo.MainKt"
}

tasks.test {
    useJUnitPlatform()
}
