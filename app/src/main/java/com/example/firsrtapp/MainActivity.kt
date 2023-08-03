package com.example.firsrtapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firsrtapp.ui.theme.FirsrtAppTheme
import com.example.firsrtapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirsrtAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    CountryCompose(viewModel)
                }
            }
        }
    }
}

@Composable
fun CountryCompose(viewModel: MainViewModel) {

    val countryLiveDataList by viewModel.countryLiveData.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        viewModel.getCountryList()
    }
    Column {
        if (countryLiveDataList.isEmpty()) {
            Text(text = "Loading......")
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),

                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = "Country", textAlign = TextAlign.Left)

                Text(text = "Capital", textAlign = TextAlign.Left)
            }
            LazyColumn {

                items(countryLiveDataList) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(text = it.name, textAlign = TextAlign.Left)

                        Text(text = it.capital, textAlign = TextAlign.Left)
                    }
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
    FirsrtAppTheme {
        Greeting("Android")
    }
}