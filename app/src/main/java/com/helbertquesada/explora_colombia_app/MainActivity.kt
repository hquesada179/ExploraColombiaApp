package com.helbertquesada.explora_colombia_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.helbertquesada.explora_colombia_app.ui.theme.Explora_Colombia_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Explora_Colombia_AppTheme {
                NavigationApp()
            }
        }
    }
}
