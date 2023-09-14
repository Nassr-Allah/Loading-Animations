package com.nassrallah.animations

import android.animation.TypeConverter
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun BouncingBallsAnimation(
    modifier: Modifier = Modifier,
    color: Color,
    size: Float,
    animDuration: Int = 250,
    easing: Easing = LinearEasing
) {

    var startBallOne by remember {
        mutableStateOf(false)
    }
    var startBallTwo by remember {
        mutableStateOf(false)
    }
    var startBallThree by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        delay(200)
        startBallOne = true
        delay(100)
        startBallTwo = true
        delay(100)
        startBallThree = true
    }

    Box(modifier = modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
        Row(modifier = Modifier
            .height((size / 2).dp)
            .width(size.dp)) {
            if (startBallOne) {
                BouncingBall(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color)
                        .weight(1f),
                    animDuration = animDuration,
                    easing = easing,
                    size = size,
                )
            }
            Spacer(modifier = Modifier.width(3.dp))
            if (startBallTwo) {
                BouncingBall(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color)
                        .weight(1f),
                    animDuration = animDuration,
                    easing = easing,
                    size = size,
                )
            }
            Spacer(modifier = Modifier.width(3.dp))
            if (startBallThree) {
                BouncingBall(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color)
                        .weight(1f),
                    animDuration = animDuration,
                    easing = easing,
                    size = size,
                )
            }
        }
    }
}

@Composable
fun BouncingBall(
    modifier: Modifier = Modifier,
    animDuration: Int,
    easing: Easing,
    size: Float,
) {
    val infiniteTransition = rememberInfiniteTransition()

    val ballPosition = infiniteTransition.animateValue(
            initialValue = 0.dp,
            targetValue = (size/5).dp,
            typeConverter = Dp.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = animDuration,
                    easing = easing
                ),
                repeatMode = RepeatMode.Reverse
            )
        ).value
    Box(
        modifier = Modifier
            .offset(y = ballPosition)
    ) {
        Box(modifier = modifier.size((size / 4).dp))
    }
}
