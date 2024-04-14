package com.rahul.entertainmentnewz.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val default: Dp = 0.dp,
    val four_dp: Dp = 4.dp,
    val eight_dp: Dp = 8.dp,
    val ten_dp: Dp = 10.dp,
    val twelve_dp: Dp = 12.dp,
    val fourteen_dp: Dp = 14.dp,
    val twoFifty_dp: Dp = 250.dp,
    val threeFifty_dp: Dp = 350.dp
)

val LocalSpacing = compositionLocalOf { Spacing() }

val spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current