package com.sideki.recyclerviewwithdifferentviews.models.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemOne(
    val imageOne: Int,
    val textOne: String
) : Parcelable