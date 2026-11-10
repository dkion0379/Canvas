package tw.edu.pu.csim.s1141245.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import tw.edu.pu.csim.s1141245.canvas.ui.theme.CanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CanvasTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    TestCanvas(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CanvasTheme {
        Greeting("Android")
    }
}

@Composable
fun TestCanvas(modifier: Modifier = Modifier) {
    var canvasWidth by remember { mutableFloatStateOf(0f) }
    var canvasHeight by remember { mutableFloatStateOf(0f) }

    Canvas(
        modifier = modifier.fillMaxSize()
    ) {
        //繪製洋紅色的圓, 半徑 100, 圓心 (100,100)
        drawCircle(
            Color.Magenta,
            100f,
            Offset(100f, 100f)
        )

        //繪製藍色空心矩形, 左上角 (300,200), 寬度與高度 200
        drawRect(
            Color.Blue,
            Offset(300f, 200f),
            Size(200f, 200f),
            style = Stroke(width = 10f) // 使用 style 控制外框樣式
        )

        canvasWidth = size.width
        canvasHeight = size.height

        // 繪製紅色的線， 從 (200,800) 畫到右下角, 線條粗細 10
        // size.width：畫布的總寬度（Float）
        // size.height：畫布的總高度（Float)
        drawLine(
            Color.Red,
            Offset(200f, 800f),
            Offset(size.width, size.height),
            strokeWidth = 10f
        )

    }

    Text("畫布寬度： $canvasWidth, 長度： $canvasHeight")
}
