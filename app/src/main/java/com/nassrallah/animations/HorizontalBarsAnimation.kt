package com.nassrallah.animations

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nassrallah.animations.ui.theme.AnimationsTheme

@Composable
fun HorizontalBarsAnimation(
    modifier: Modifier = Modifier,
    color: Color,
    size: Float,
    animDuration: Int = 500,
    easing: Easing = LinearEasing
) {
    Box(modifier = modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
        Row(modifier = Modifier
            .height((size / 4).dp)
            .wrapContentWidth()) {
            HorizontalBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(color),
                animDuration = animDuration,
                size = size,
                easing = easing
            )
            Spacer(modifier = Modifier.width(5.dp))
            HorizontalBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(color),
                animDuration = animDuration + 100,
                size = size,
                easing = easing
            )
            Spacer(modifier = Modifier.width(5.dp))
            HorizontalBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(color),
                animDuration = animDuration + 200,
                size = size,
                easing = easing
            )
        }
    }
}

@Composable
fun HorizontalBar(
    modifier: Modifier = Modifier,
    animDuration: Int,
    size: Float,
    easing: Easing
) {

    val infiniteTransition = rememberInfiniteTransition()

    val barWidth = infiniteTransition.animateFloat(
        initialValue = size / 2,
        targetValue = size / 4,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animDuration,
                easing = easing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(modifier = modifier
        .height(size.dp)
        .width(barWidth.value.dp))
}
