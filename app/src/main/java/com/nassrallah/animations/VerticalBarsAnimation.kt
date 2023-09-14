package com.nassrallah.animations

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
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
fun VerticalBarsAnimation(
    modifier: Modifier = Modifier,
    color: Color,
    size: Float,
    animDuration: Int = 500,
    easing: Easing = FastOutLinearInEasing
) {

    Box(modifier = modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
        Row(
            modifier = Modifier
                .height(size.dp)
                .width(size.dp),
            verticalAlignment = Alignment.Bottom
        ) {

            VerticalBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(color)
                    .weight(1f),
                size = size,
                animDuration = animDuration,
                easing = easing
            )

            Spacer(modifier = Modifier.width(5.dp))

            VerticalBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(color)
                    .weight(1f),
                size = size,
                animDuration = animDuration + 100,
                easing = easing
            )

            Spacer(modifier = Modifier.width(5.dp))

            VerticalBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .background(color)
                    .weight(1f),
                size = size,
                animDuration = animDuration + 200,
                easing = easing
            )
        }
    }
}

@Composable
fun VerticalBar(modifier: Modifier = Modifier, size: Float, animDuration: Int, easing: Easing) {
    val infiniteTransition = rememberInfiniteTransition()

    val barHeight = infiniteTransition.animateFloat(
        initialValue = size/4,
        targetValue = size,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animDuration, easing = easing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = modifier.height(barHeight.value.dp)
    )
}
