package com.sideki.recyclerviewwithdifferentviews.api

import com.sideki.recyclerviewwithdifferentviews.R
import com.sideki.recyclerviewwithdifferentviews.models.data.ItemOne
import com.sideki.recyclerviewwithdifferentviews.models.data.ItemTwo
import kotlinx.coroutines.*

class FakeApi {

    suspend fun getAllItemsRandom(): List<Any> {
        val listRandomItems = mutableListOf<Any>()
        var i = 0
        CoroutineScope(Dispatchers.IO).async {
            while (i < 20) {
                val randNum = (1..2).random()
                if (randNum == 1) {
                    listRandomItems.add(ItemOne(R.drawable.ic_launcher_foreground, "Первый объект"))
                } else {
                    listRandomItems.add(ItemTwo(R.drawable.ic_launcher_background, "Второй объект"))
                }
                i++

            }
            delay(3000)
        }.await()
        return listRandomItems
    }


}