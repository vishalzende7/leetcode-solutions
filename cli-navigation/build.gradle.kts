plugins {
    kotlin("jvm")
}

group = "com.vishalzende.navigation"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}