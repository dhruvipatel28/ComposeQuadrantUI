package dhruvi.patel.composequadrantui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dhruvi.patel.composequadrantui.ui.theme.ComposeQuadrantUITheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ComposeMainUI()
                }
            }
        }
    }
}

@Composable
fun ComposeMainUI(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            ComposeCellUI(
                0xFFEADDFF,
                R.string.text_composable,
                R.string.text_composable_desc,
                modifier = Modifier.weight(1f)
            )

            ComposeCellUI(
                0xFFD0BCFF,
                R.string.image_composable,
                R.string.image_composable_desc,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposeCellUI(
                0xFFB69DF8,
                R.string.row_composable,
                R.string.row_composable_desc,
                modifier = Modifier.weight(1f)
            )

            ComposeCellUI(
                0xFFF6EDFF,
                R.string.column_composable,
                R.string.column_composable_desc,
                modifier = Modifier.weight(1f)
            )
        }

    }
}


@Composable
fun ComposeCellUI(
    color: Long,
    title: Int,
    description: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(color.toInt()))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(title),
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(description),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeQuadrantUITheme {
        ComposeMainUI()
    }
}