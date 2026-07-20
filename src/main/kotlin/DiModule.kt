package org.example

import org.example.domain.di.DiModule
import org.koin.core.annotation.Module


@Module(includes = [DiModule::class])
object DiModule