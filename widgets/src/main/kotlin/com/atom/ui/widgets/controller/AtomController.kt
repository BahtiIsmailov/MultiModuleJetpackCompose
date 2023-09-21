package com.atom.ui.widgets.controller

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.atom.ui.resources.AtomTheme
import com.atom.ui.widgets.R


@Composable
fun AtomController(
    modifier: Modifier = Modifier,
    state: ControllerState,
    onIncreaseEvent: () -> Unit,
    onDecreaseEvent: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {
        val (title, value, controller) = createRefs()
        val valueText = if (state.form == ControllerForm.ROUND) stringResource(
            id = R.string.value_temperature,
            state.textValue
        ) else if (state.value > 0) stringResource(
            id = R.string.value,
            state.textValue
        ) else state.textValue
        Text(
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(
                    top = AtomTheme.dimens.xxs,
                    start = AtomTheme.dimens.xl
                ),
            text = state.title,
            style = AtomTheme.typography.h4,
            color = Color.White
        )

        Text(
            modifier = Modifier
                .constrainAs(value) {
                    top.linkTo(title.bottom)
                    end.linkTo(title.end)
                }
                .offset(
                    x = AtomTheme.dimens.xxs,
                    y = AtomTheme.dimens.xs
                ),
            text = valueText,
            style = AtomTheme.typography.h4,
            color = state.colorValue
        )
        Box(
            modifier = Modifier
                .constrainAs(controller) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .size(AtomTheme.dimens.boxSize)
                .border(
                    BorderStroke(
                        width = AtomTheme.dimens.xxs,
                        color = Color.White
                    ),
                    shape = RoundedCornerShape(AtomTheme.dimens.e)
                ),
        ) {
            IconButton(
                modifier = Modifier.align(state.firstIconState.second),
                onClick = {
                    if (state.form == ControllerForm.VERTICAL) onIncreaseEvent.invoke()
                    else onDecreaseEvent.invoke()
                }

            ) {
                Image(
                    imageVector = ImageVector.vectorResource(state.firstIconState.first),
                    contentDescription = null
                )
            }

            IconButton(
                modifier = Modifier
                    .align(state.secondIconState.second),
                onClick = {
                    if (state.form == ControllerForm.VERTICAL) onDecreaseEvent.invoke()
                    else onIncreaseEvent.invoke()
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(state.secondIconState.first),
                    contentDescription = null
                )
            }
        }
    }
}

