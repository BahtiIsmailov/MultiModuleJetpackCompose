package com.atom.ui.widgets.pager.base.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.stopScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.atom.ui.widgets.pager.base.models.AtomTypePager
import com.atom.ui.widgets.pager.base.models.BaseAtomPagerState
import com.atom.ui.widgets.pager.base.models.PagerEvent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> AtomPager(
    modifier: Modifier = Modifier,
    state: BaseAtomPagerState<T>,
    event: PagerEvent? = null,
    type: AtomTypePager,
    onPageChanged: (Int) -> Unit,
    item: @Composable (BaseAtomPagerState<T>, Int) -> Unit
) {
    val pagerState = rememberPagerState(
        pageCount = { state.pageCount },
        initialPage = state.currentPage
    )

    LaunchedEffect(pagerState, event) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            onPageChanged(page)
        }
        when (event) {
            is PagerEvent.AnimateScrollBy -> pagerState.animateScrollBy(event.distance)
            is PagerEvent.AnimateScrollToPage -> pagerState.animateScrollToPage(event.page)
            is PagerEvent.ScrollBy -> pagerState.scrollBy(event.distance)
            is PagerEvent.ScrollToPage -> pagerState.scrollToPage(event.page)
            PagerEvent.StopScroll -> pagerState.stopScroll()
            null -> {}
        }
    }

    when (type) {
        AtomTypePager.HORIZONTAL -> HorizontalAtomPager(pagerState, modifier) { page ->
            item.invoke(state, page)

        }

        AtomTypePager.VERTICAL -> VerticalAtomPager(pagerState, modifier) { page ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                item.invoke(state, page)
            }

        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalAtomPager(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    item: @Composable (Int) -> Unit
) {

    VerticalPager(
        modifier = modifier.fillMaxHeight(),
        state = pagerState,
        contentPadding = PaddingValues(vertical = 220.dp)
    ) {

        item.Draw(it = it)

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalAtomPager(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    item: @Composable (Int) -> Unit
) {

    HorizontalPager(
        state = pagerState,
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 90.dp)
    ) {
        item.Draw(it = it)
    }
}


@Composable
fun <T> (@Composable (T) -> Unit).Draw(it: T) {
    this.invoke(it)
}
