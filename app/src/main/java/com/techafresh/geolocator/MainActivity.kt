package com.techafresh.geolocator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.location.aravind.getlocation.GeoLocator
import com.techafresh.geolocator.ui.theme.GeolocatorTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeolocatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val ctx = LocalContext.current
                    val geoLocator = GeoLocator(ctx, this@MainActivity)
                    geoLocator.GetLocation()
                    Greeting(geoLocator = geoLocator)
//                    Log.d("TAG", "onCreate: Lat = ${geoLocator.lattitude}")
//                    Log.d("TAG", "onCreate: Long = ${geoLocator.longitude}")
//                    Log.d("TAG", "onCreate: Adress = ${geoLocator.address}")
//                    Log.d("TAG", "onCreate: City = ${geoLocator.city}")
//                    Log.d("TAG", "onCreate: Country = ${geoLocator.country}")
//                    Log.d("TAG", "onCreate: State = ${geoLocator.state}")
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, geoLocator: GeoLocator) {
    Column(
        modifier = modifier.padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Latitude = ${geoLocator.lattitude}")
        Text(text = "Longitude = ${geoLocator.longitude}")
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Text(text = "Address: \n ${geoLocator.address}" , textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(bottom = 5.dp))
        Text(text = "City = ${geoLocator.city}")
        Text(text = "Country = ${geoLocator.country}")
        Text(text = "State = ${geoLocator.state}")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GeolocatorTheme {
//        Greeting("Android")
    }
}