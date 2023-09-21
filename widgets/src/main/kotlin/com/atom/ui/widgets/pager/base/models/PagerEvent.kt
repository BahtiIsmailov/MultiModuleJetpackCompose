package com.atom.ui.widgets.pager.base.models

sealed class PagerEvent {
    data class ScrollToPage(val page: Int) : PagerEvent()
    data class AnimateScrollToPage(val page: Int) : PagerEvent()

    data class AnimateScrollBy(val distance: Float) : PagerEvent()

    data class ScrollBy(val distance: Float) : PagerEvent()

    object StopScroll : PagerEvent()
}
