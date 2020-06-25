package com.aomi.mybase.core.platform

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T>(
    private inline val onClick: (T) -> Unit,
    diffCallback: BaseDiffUtilCallback<T>
): ListAdapter<T, BaseViewHolder<T>>(diffCallback) {

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T>

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(getItem(position), onClick)
    }

}