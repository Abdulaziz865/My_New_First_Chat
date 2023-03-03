package com.example.my_new_first_chat.ui.fragments.basis.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my_new_first_chat.data.models.MessageModel

class ChatViewModel : ViewModel() {

    private val _noteLiveData = MutableLiveData<MutableList<MessageModel>>()
    val noteLiveData: LiveData<MutableList<MessageModel>> = _noteLiveData

    private var noteList = mutableListOf<MessageModel>()

    fun setModels(message: String, time: String) {
        noteList.add(MessageModel(message = message, time = time))
        _noteLiveData.value = noteList.toMutableList()
    }
}