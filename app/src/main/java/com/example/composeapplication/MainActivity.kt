package com.example.composeapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialColors
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.example.composeapplication.cells.drawCell

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    val temp = ArrayList<ProgramModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.fetchData()


        temp.add(ProgramModel("Washington", R.drawable.washington))
        temp.add(ProgramModel("Moscow", R.drawable.moscow))
        temp.add(ProgramModel("Kyiv", R.drawable.kyiv))
        temp.add(ProgramModel("London", R.drawable.london))
        temp.add(ProgramModel("Paris", R.drawable.paris))

        setContent {
            drawList()
        }


    }

    @Composable
    fun drawList() {
        MaterialTheme()
        {
            VerticalScroller()
            {
                Column(
                    crossAxisSize = LayoutSize.Expand,
                    crossAxisAlignment = CrossAxisAlignment.Stretch,
                    mainAxisAlignment = MainAxisAlignment.Start,
                    mainAxisSize = LayoutSize.Expand
                ) {
                    HeightSpacer(height = 10.dp)
//                    viewModel.getData().observe(this@MainActivity, Observer { data ->
//                        data.forEach { model ->
//                            drawCell(model)
//                            HeightSpacer(height = 5.dp)
//                        }
//                    })
                    temp.forEach { model ->
                        Padding(left = 16.dp, right = 16.dp , bottom = 8.dp)
                        {
                            drawCell(model)
                        }

                    }

                    Padding(padding = 16.dp) {
                        Button(onClick = {
                            Toast.makeText(applicationContext, "Waiting...", Toast.LENGTH_SHORT)
                                .show()
                        }) {
                            Text("Load more cities")
                        }
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun DefaultPreview() {
        MaterialTheme {
            drawList()
        }
    }
}


