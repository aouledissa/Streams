package io.aouledissa.chat.viewmodel

import io.aouledissa.data.models.ChatHistory

sealed class ChatState {
    object Loading : ChatState()
    data class DataReady(val data: ChatHistory) : ChatState()
    data class DataError(
        val message: String,
        val throwable: Throwable? = null
    ) : ChatState()
}