package com.example.composeapplication.cells

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.Padding
import androidx.ui.material.surface.Card
import androidx.ui.res.imageResource
import com.example.composeapplication.ProgramModel
import com.example.composeapplication.R

@Composable
fun drawCell(model: ProgramModel) {

    Card(elevation = 8.dp) {
        Padding(padding = 16.dp) {
            Column()
            {
                if (model.image != 0) {
                    val image = +imageResource(model.image)
                    Container(expanded = true, height = 180.dp) {
                        DrawImage(image = image)
                    }
                }

                Padding(top = 16.dp, bottom = 16.dp) {
                    Text(model.title)
                }
            }
        }
    }
}