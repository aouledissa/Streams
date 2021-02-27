package io.aouledissa.chat.viewmodel

import io.aouledissa.common.StatefulViewModel
import io.aouledissa.data.ChatHistoryRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import timber.log.Timber

class ChatViewModel(private val chatRepository: ChatHistoryRepository) :
    StatefulViewModel<ChatState>() {

    fun loadChatHistory() {
        chatRepository.fetchChatHistory()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                switchState(ChatState.Loading)
            }
            .subscribe(
                { switchState(ChatState.DataReady(data = it)) },
                {
                    switchState(ChatState.DataError(message = "an error occurred while retrieving the data"))
                    Timber.d("an error occurred while retrieving the data: $it")
                }
            ).addTo(disposables)
    }
}