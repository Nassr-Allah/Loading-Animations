package com.nassrallah.animations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nassrallah.animations.ui.theme.AnimationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                                VerticalBarsAnimation(modifier = Modifier.weight(1f), color = Color.White, size = 50f)
                                MovingBallAnimation(modifier = Modifier.weight(1f), color = Color.White, size = 50f)
                            }

                            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                                HorizontalBarsAnimation(modifier = Modifier.weight(1f), color = Color.White, size = 50f)
                                BouncingBallsAnimation(modifier = Modifier.weight(1f), color = Color.White, size = 50f)
                            }
                        }
                    }
                }
            }
        }
    }
}
