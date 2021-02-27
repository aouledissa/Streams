package io.aouledissa.data

import io.aouledissa.data.models.ChatHistory
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ChatHistoryRepository {

    fun fetchChatHistory(): Single<ChatHistory> {
        return Single.just(ChatHistory("someID"))
            .delay(5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
    }
}