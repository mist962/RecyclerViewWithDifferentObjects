package com.sideki.recyclerviewwithdifferentviews.models.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemTwo(
    val imageTwo: Int,
    val textTwo: String
) : Parcelable