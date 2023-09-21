package com.atom.ui.widgets.pager.items

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.constraintlayout.compose.ConstraintLayout
import com.atom.ui.resources.AtomTheme
import com.atom.ui.resources.WhiteColor
import com.atom.ui.widgets.pager.speedMeasure
import com.atom.ui.widgets.pager.speedTitle

@SuppressLint("ResourceType")
@Composable
fun DefaultAtomPagerItem(
    modifier: Modifier = Modifier,
    isCurrentPage: Boolean,
    titleItem: String = stringResource(id = speedTitle),
    measureItem: String = stringResource(id = speedMeasure),
    contentItem: String,
    @StringRes imageRes: Int? = null
) {


    ConstraintLayout(
        modifier = modifier
            .graphicsLayer {
                alpha = lerp(
                    start = 0.5f,
                    stop = 0.9f,
                    fraction = 0.15f
                )
            },
    ) {
        val (content, icon, title, mean) = createRefs()

        val styleContent = if (isCurrentPage) AtomTheme.typography.h1 else AtomTheme.typography.h2
        Text(
            modifier = Modifier.constrainAs(content) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            text = contentItem,
            style = styleContent,
            color = WhiteColor
        )

        if (isCurrentPage) {
            if (imageRes != null) {
                Image(
                    modifier = Modifier
                        .constrainAs(icon) {
                            top.linkTo(parent.top)
                            start.linkTo(content.end, 4.dp)
                            end.linkTo(parent.end)

                        }
                        .size(50.dp),
                    imageVector = ImageVector.vectorResource(imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            } else {
                Text(
                    modifier = Modifier.constrainAs(mean) {
                        top.linkTo(parent.top)
                        start.linkTo(content.end)
                        end.linkTo(parent.end)

                    },
                    text = measureItem,
                    style = AtomTheme.typography.h5,
                    color = Color.White
                )
            }
            Text(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(content.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                },
                text = titleItem,
                style = AtomTheme.typography.body1,
                color = Color.White
            )

        }

    }
}


