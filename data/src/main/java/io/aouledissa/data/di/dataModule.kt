package io.aouledissa.data.di

import io.aouledissa.data.ChatHistoryRepository
import org.koin.dsl.module

val dataModule = module {

    single { ChatHistoryRepository() }
}