package org.example

import com.vishalzende.navigation.NavHost
import org.example.domain.`kotlin-collection`.PartitionAndTransformNav
import org.example.features.FirstOccurrenceStringCli
import org.example.navigation.NavMenu
import org.koin.core.annotation.KoinApplication
import org.koin.java.KoinJavaComponent

@KoinApplication(modules = [DiModule::class])
class App {
    fun run() {
        NavHost(startDestination = "main") {
            composable("main", NavMenu())
            composable("FirstOccurrenceStringCli", FirstOccurrenceStringCli())
            composable("PartitionAndTransformNav", PartitionAndTransformNav())
        }
    }
}

inline fun <reified T> inject(): Lazy<T> {
    return lazy {
        KoinJavaComponent.getKoin().get()
    }
}

