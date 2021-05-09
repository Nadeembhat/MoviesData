package com.android.ernb.moviesData.persistence

import androidx.room.TypeConverter
import com.android.ernb.moviesData.util.Category

/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,11:38 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
class Converter {

    @TypeConverter
    fun catToInt(cat: Category?): Int? {
        return cat?.ordinal
    }

    @TypeConverter
    fun intToCat(int: Int?): Category? {
        return int?.let {
            when (it) {
                0 -> Category.POPULAR
                1 -> Category.UPCOMING
                2 -> Category.TOPRATED
                else -> Category.POPULAR
            }
        }
    }

}