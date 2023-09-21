package com.atom.ui.widgets.pager.base.models

import com.atom.ui.widgets.R

data class AtomPagerState(
    override val currentPage: Int,
    val titleRes: Int,
    val measureRes: Int?,
    val iconRes: Int? = R.drawable.lamp,
    override val content: List<Int>
) : BaseAtomPagerState<Int>(currentPage, content)

abstract class BaseAtomPagerState<T>(
    open val currentPage: Int,
    open val content: List<T>
) {
    val pageContent: T get() = content[currentPage]
    val pageCount: Int get() = content.size


    fun getContentByPage(page: Int) = content[page]

    open fun getContentToText(page: Int): String = getContentByPage(page).toString()
}
