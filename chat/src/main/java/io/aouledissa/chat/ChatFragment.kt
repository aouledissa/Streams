package io.aouledissa.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import io.aouledissa.chat.viewmodel.ChatState
import io.aouledissa.chat.viewmodel.ChatViewModel
import io.aouledissa.common.hide
import io.aouledissa.common.show
import io.aouledissa.data.models.ChatHistory
import kotlinx.android.synthetic.main.fragment_chat.chatHistoryFragment
import kotlinx.android.synthetic.main.fragment_chat.loadingIndicator
import org.koin.android.ext.android.inject

class ChatFragment : Fragment() {

    private val viewModel: ChatViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is ChatState.Loading -> loadingIndicator.show()
                is ChatState.DataReady -> renderData(state.data)
                is ChatState.DataError -> displayErrorDialog(state.message)
            }
        })
        viewModel.loadChatHistory()
    }

    private fun renderData(data: ChatHistory) {
        Snackbar.make(chatHistoryFragment, "Data was loaded", Snackbar.LENGTH_SHORT).show()
        loadingIndicator.hide()
    }

    private fun displayErrorDialog(message: String) {
        Snackbar.make(chatHistoryFragment, message, Snackbar.LENGTH_SHORT).show()
    }
}