package io.aouledissa.chat.di

import io.aouledissa.chat.viewmodel.ChatViewModel
import org.koin.dsl.module

val chatModule = module {
    single { ChatViewModel(get()) }
}