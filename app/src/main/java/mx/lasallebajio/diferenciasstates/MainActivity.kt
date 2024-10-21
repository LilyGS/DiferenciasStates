package mx.lasallebajio.diferenciasstates

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.lasallebajio.diferenciasstates.ui.theme.DiferenciasStatesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiferenciasStatesTheme {
                    MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        CounterFlow1()
        CounterFlow2()

        Spacer(modifier = Modifier.height(50.dp))
        SimpleCounter()
    }

}

@Composable
fun CounterFlow1() {
    val viewModel: CounterViewModel = viewModel()
    val count = viewModel.count.collectAsState()

    Button(onClick = { viewModel.increment() }) {
            Text("Count StateFlow 1: ${count.value}")
        }
}

@Composable
fun CounterFlow2() {
    val viewModel: CounterViewModel = viewModel()
    val count = viewModel.count.collectAsState()

    Button(onClick = { viewModel.increment() }) {
        Text("Count StateFlow 2: ${count.value}")
    }
}


@Composable
fun SimpleCounter() {
    val count = remember { mutableStateOf(0) }

        Button(onClick = { count.value++ }) {
            Text("Count MutableStateOf: ${count.value}")
        }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DiferenciasStatesTheme {
        MainScreen()
    }
}