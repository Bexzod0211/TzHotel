package uz.gita.tzhotel.data.models

import uz.gita.tzhotel.R

data class MoreAboutHotelData(
    val icon:Int,
    val title:String
)


val moreAboutHotelList = listOf(
    MoreAboutHotelData(icon = R.drawable.img_comfort,"Удобства"),
    MoreAboutHotelData(icon = R.drawable.img_permitted,"Что включено"),
    MoreAboutHotelData(icon = R.drawable.img_denied,"Что не включено")
)
