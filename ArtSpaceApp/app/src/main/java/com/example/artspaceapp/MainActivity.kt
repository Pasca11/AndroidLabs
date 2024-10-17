package com.example.artspaceapp

import android.app.Notification
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

enum class Action {
    Rewind, Next
}

@Composable
fun DisplayFooter(
    imageId: Int,
    onAction: (Action) -> Unit,
    modifier: Modifier = Modifier,
    verticalAlignment: Alignment = Alignment.Center,
    horizontal: Arrangement.HorizontalOrVertical = Arrangement.Center
) {
    Row(
        modifier = modifier,
        verticalAlignment  = Alignment.CenterVertically
    ) {
        androidx.compose.material3.Button(
            onClick = { onAction(Action.Rewind) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Rewind")
        }
        androidx.compose.material3.Button(
            onClick = { onAction(Action.Next) },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Next")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
    }
}