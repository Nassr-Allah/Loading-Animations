package com.nassrallah.animations

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.nassrallah.animations.ui.theme.AnimationsTheme

@Composable
fun MovingBallAnimation(
    modifier: Modifier = Modifier,
    color: Color,
    size: Float,
    animDuration: Int = 500,
    easing: Easing = FastOutLinearInEasing
) {
    Box(modifier = modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
        Row(modifier = Modifier.width(size.dp)) {
            MovingBall(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color),
                animDuration = animDuration,
                size = size,
                easing = easing
            )
        }
    }
}

@Composable
fun MovingBall(modifier: Modifier = Modifier, animDuration: Int, size: Float, easing: Easing) {
    val infiniteTransition = rememberInfiniteTransition()

    val ballPosition = infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = size.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = animDuration,
                easing = easing
            ),
            repeatMode = RepeatMode.Reverse
        )
    ).value

    Box(modifier = Modifier.width(size.dp).offset(x = ballPosition)) {
        Box(modifier = modifier.size((size / 4).dp))
    }
}
