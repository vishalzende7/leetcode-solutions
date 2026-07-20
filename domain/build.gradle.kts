plugins {
    kotlin("jvm")
    id("io.insert-koin.compiler.plugin") apply true
}

group = "org.example.domain"
version = "1.0"


//repositories {
//    mavenCentral()
//}

dependencies {
    testImplementation(kotlin("test"))

    //DI: Koin
    implementation(platform("io.insert-koin:koin-bom:4.2.0"))
    implementation("io.insert-koin:koin-core")
    implementation("io.insert-koin:koin-annotations")

    implementation(project(":cli-navigation"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}