package com.arekalov.pumpking

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Modifier.conditional(
    condition: Boolean,
    ifTrue: @Composable Modifier.() -> Modifier,
): Modifier {
    return if (condition) {
        then( ifTrue() )
    } else {
        this
    }
}
