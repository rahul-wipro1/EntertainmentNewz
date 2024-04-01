package com.rahul.entertainmentnewz.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/** This is the required data class
 */
@Parcelize
data class ChannelListItem(
    val date: String? = "",
    val discription: String? = "",
    val icon: String? = "",
    val pic: String? = "",
    val title: String? = "",
): Parcelable
