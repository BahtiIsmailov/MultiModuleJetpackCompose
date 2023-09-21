import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Speedometer() {
    var speed by remember { mutableIntStateOf(90) }

    Box(
        modifier = Modifier
            .size(200.dp)
            .border(width = 10.dp, color = Color.Red, shape = CircleShape)
            .background(color = Color.Transparent, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = speed.toString(),
            fontSize = 100.sp,
            color = Color.White
        )
    }

    Spacer(modifier = Modifier.height(16.dp))

    SpeedInput(speed) { newSpeed ->
        speed = newSpeed
    }
}

@Composable
fun SpeedInput(initialSpeed: Int, onSpeedChange: (Int) -> Unit) {
    var text by remember { mutableStateOf(initialSpeed.toString()) }

    BasicTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                text.toIntOrNull()?.let { newSpeed ->
                    onSpeedChange(newSpeed)
                }
            }
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SpeedLimitComponent() {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Speedometer()
    }
}
