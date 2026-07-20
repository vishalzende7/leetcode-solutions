plugins {
    kotlin("jvm") version "2.3.20"
    id("io.insert-koin.compiler.plugin") apply true
}

group = "org.example"
version = "1.0-SNAPSHOT"

//repositories {
//    mavenCentral()
//    gradlePluginPortal()
//}

dependencies {
    implementation(project(":domain"))
    implementation(project("cli-navigation"))

    testImplementation(kotlin("test"))

    //DI: Koin
    implementation(platform("io.insert-koin:koin-bom:4.2.0"))
    implementation("io.insert-koin:koin-core")
    implementation("io.insert-koin:koin-annotations")

    //Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}