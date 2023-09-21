package com.atom.ui.example

import SpeedLimitComponent
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.atom.ui.resources.ErrorRedColor
import com.atom.ui.widgets.controller.AtomController
import com.atom.ui.widgets.controller.ControllerForm
import com.atom.ui.widgets.controller.ControllerState
import com.atom.ui.widgets.pager.base.components.AtomPager
import com.atom.ui.widgets.pager.base.models.AtomPagerState
import com.atom.ui.widgets.pager.base.models.AtomTypePager
import com.atom.ui.widgets.pager.items.DefaultAtomPagerItem
import com.atom.ui.widgets.pager.lamp
import com.atom.ui.widgets.pager.speedMeasure
import com.atom.ui.widgets.pager.speedTitle

class MainActivity : ComponentActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpeedLimitComponent()
            //ControllerExample()
        }
    }


    @Composable
    fun ControllerExample() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
        ) {
            var state by remember {
                mutableStateOf(
                    ControllerState(
                        colorValue = ErrorRedColor,
                        title = "Высота кресла",
                        value = 12,
                        form = ControllerForm.HORIZONTAL,
                        range = -22..180
                    )
                )
            }

            AtomController(state = state, onIncreaseEvent = {
                if (state.inRange(state.value + 1)) {
                    state = state.copy(value = state.value + 1)
                }
            }) {
                if (state.inRange(state.value - 1)) {
                    state = state.copy(value = state.value - 1)
                }
            }

        }
    }

    @Composable
    fun PagerExample() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
        ) {
            var state by remember {
                mutableStateOf(
                    AtomPagerState(
                        currentPage = 0,
                        iconRes = lamp,
                        titleRes = speedTitle,
                        measureRes = speedMeasure,
                        content = listOf(75, 76, 77, 78, 79)
                    )
                )
            }


            AtomPager(
                modifier = Modifier.align(Alignment.TopCenter),
                state = state,
                type = AtomTypePager.VERTICAL,
                onPageChanged = { state = state.copy(currentPage = it) }) { it, page ->

                DefaultAtomPagerItem(
                    isCurrentPage = (it.currentPage == page),
                    contentItem = it.getContentToText(page),
                    measureItem = "",
                    titleItem = stringResource(id = state.titleRes),
                    imageRes = lamp
                )
            }
        }
    }
}


