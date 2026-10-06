package io.github.davibrasil05.playai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import io.github.davibrasil05.playai.ui.PlayAiApp
import io.github.davibrasil05.playai.ui.theme.PlayAiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlayAiTheme {
                PlayAiApp()
            }
        }
    }
}
