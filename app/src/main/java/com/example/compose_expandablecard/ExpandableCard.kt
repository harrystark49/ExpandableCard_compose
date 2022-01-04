package com.example.compose_expandablecard

import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_expandablecard.ui.theme.Shapes
import kotlin.math.exp

@ExperimentalMaterialApi
@Composable
fun expandableCard(){
    var expandstate by remember {
        mutableStateOf(false)
    }
    val rotationstate by animateFloatAsState(
        targetValue =if(expandstate) 180f else 0f
    )

    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(400, easing = FastOutLinearInEasing )
        ),shape = Shapes.large,
        onClick = {
            expandstate=!expandstate
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                ) {
                Text(text = "title",
                    fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h6.fontSize,
                modifier = Modifier
                    .weight(6f))

                IconButton(onClick = {
                    expandstate=!expandstate
                },modifier = Modifier
                    .rotate(rotationstate)

                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "image",
                        modifier = Modifier
                            .weight(1f),

                    )
                }
            }
            if(expandstate){
                Text("baka".repeat(50),maxLines = 5)
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun expandablepreview(){
    expandableCard()
}