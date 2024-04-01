package com.rahul.entertainmentnewz.data.mapper

import com.rahul.entertainmentnewz.data.dto.ChannelsDTOItem
import com.rahul.entertainmentnewz.domain.model.ChannelListItem


/** Mappers are used to convert entire data object to required data object
 */
fun ChannelsDTOItem.toChanelList() = ChannelListItem(
    discription = this.discription,
    icon = this.icon,
    pic = this.pic,
    title = this.title
)