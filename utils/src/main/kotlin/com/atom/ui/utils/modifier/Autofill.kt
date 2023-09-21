@file:OptIn(ExperimentalComposeUiApi::class)

package com.atom.ui.utils.modifier

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.AutofillNode
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.composed
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalAutofill
import androidx.compose.ui.platform.LocalAutofillTree

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.autofill(
    autofillTypes: List<AutofillType>,
    onFill: (String) -> Unit,
): Modifier {
    return composed {
        val autofill = LocalAutofill.current
        val node = AutofillNode(onFill = onFill, autofillTypes = autofillTypes)
        LocalAutofillTree.current += node

        onGloballyPositioned {
            node.boundingBox = it.boundsInWindow()
        }.onFocusChanged { focusState ->
            autofill?.run {
                if (focusState.isFocused) {
                    requestAutofillForNode(node)
                } else {
                    cancelAutofillForNode(node)
                }
            }
        }
    }
}
