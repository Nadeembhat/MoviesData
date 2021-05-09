package com.android.ernb.moviesData.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
/**
 * Created by Er Nadeem Bhat on 09/05/2021 ,10:48 AM
 * ernadeembhat@gmail.com
 * Copyright(R)
 */
class RecyclerViewDecoration(private val offset:Int=3) :RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(offset,offset,offset,offset)
    }
}