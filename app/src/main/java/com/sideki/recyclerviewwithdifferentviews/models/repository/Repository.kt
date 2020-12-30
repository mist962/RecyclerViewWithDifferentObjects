package com.sideki.recyclerviewwithdifferentviews.models.repository

import com.sideki.recyclerviewwithdifferentviews.R
import com.sideki.recyclerviewwithdifferentviews.api.FakeApi
import com.sideki.recyclerviewwithdifferentviews.models.data.ItemOne
import com.sideki.recyclerviewwithdifferentviews.models.data.ItemTwo

class Repository(private val fakeApi: FakeApi) {

    suspend fun getAllItemsRandom(): List<Any>{
        return fakeApi.getAllItemsRandom()
    }
}