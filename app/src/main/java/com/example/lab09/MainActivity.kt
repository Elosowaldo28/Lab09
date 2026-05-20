package com.example.lab09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.lab09.ui.theme.Lab09Theme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val urlBase = "https://json-placeholder.mock.beeceptor.com/"
val retrofit = Retrofit.Builder().baseUrl(urlBase)
    .addConverterFactory(GsonConverterFactory.create()).build()
val servicio = retrofit.create(PostApiService::class.java)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab09Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProgPrincipal9()
                }
            }
        }
    }
}

@Composable
fun ProgPrincipal9() {
    val navController = rememberNavController()

    Scaffold(
        topBar =    { BarraSuperior() },
        bottomBar = { BarraInferior(navController) },
        content =   { paddingValues -> Contenido(paddingValues, navController, servicio) }
    )
}