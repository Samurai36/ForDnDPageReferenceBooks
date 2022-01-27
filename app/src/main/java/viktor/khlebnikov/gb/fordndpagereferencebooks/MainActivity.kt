package viktor.khlebnikov.gb.fordndpagereferencebooks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    private val paddingValue = 8.dp
    private val shapeValue = 8.dp
    private val elevationValue = 8.dp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }

    @Preview
    @Composable
    fun MainContent() {
        Scaffold(topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.reference_books)) },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }) {
            Column() {
                RowGrid()
            }
        }
    }

    @Composable
    fun RowGrid() {
        Row(
            Modifier
                .padding(paddingValue)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .padding(paddingValue)
            ) {
                RowItem(stringResource(R.string.spells), R.drawable.img_spells)
                Spacer(modifier = Modifier.padding(vertical = paddingValue))
                RowItem(stringResource(R.string.magic_items), R.drawable.img_magic_items)
                Spacer(modifier = Modifier.padding(vertical = paddingValue))
                RowItem("unknown_1", R.drawable.img_equipment)
            }
            Column(
                Modifier
                    .weight(1f)
                    .padding(paddingValue)
            ) {
                RowItem(stringResource(R.string.equipments), R.drawable.img_equipment)
                Spacer(modifier = Modifier.padding(vertical = paddingValue))
                RowItem(stringResource(R.string.monsters), R.drawable.img_monsters)
                Spacer(modifier = Modifier.padding(vertical = paddingValue))
                RowItem("unknown_2", R.drawable.img_spells)
            }
        }
    }

    @Composable
    fun RowItem(name: String, image: Int) {
        Card(elevation = elevationValue, shape = RoundedCornerShape(shapeValue))
        {
            Box(
                modifier = Modifier
                    .height(208.dp)
                    .border(
                        1.dp, MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(shapeValue),
                    )
                    .fillMaxWidth()

            )
            {
                Image(
                    painterResource(image),
                    contentDescription = stringResource(R.string.spells),
                    Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(shapeValue))
                        .align(Alignment.Center),
                    contentScale = ContentScale.FillWidth,
                )
                Column(
                    modifier = Modifier.align(Alignment.Center)
                ) {

                    TextButton(
                        onClick = {

                        }, modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row {
                            Image(
                                painterResource(R.drawable.icon_download),
                                contentDescription = stringResource(R.string.download),
                                Modifier.size(24.dp, 16.dp),
                                Alignment.BottomStart
                            )
                            Subtitle1(
                                text = stringResource(R.string.download),
                                modifier = Modifier.padding(start = paddingValue)
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(
                            Color
                                (0x99000000)
                        )
                        .align(Alignment.BottomCenter)
                ) {
                    Subtitle1(
                        text = name,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }


    @Composable
    fun Subtitle1(text: String, modifier: Modifier) = Text(
        text = text, modifier = modifier, style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
            color = Color.White,
        )
    )
}