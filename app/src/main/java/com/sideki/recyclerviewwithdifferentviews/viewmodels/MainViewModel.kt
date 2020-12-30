package com.sideki.recyclerviewwithdifferentviews.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sideki.recyclerviewwithdifferentviews.models.data.ItemOne
import com.sideki.recyclerviewwithdifferentviews.models.data.ItemTwo
import com.sideki.recyclerviewwithdifferentviews.models.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val itemsRandom: MutableLiveData<List<Any>> = MutableLiveData()

    fun getRandItems() {
        viewModelScope.launch {
            itemsRandom.value = repository.getAllItemsRandom()
        }
    }

}