package io.posadilla.applistacontactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import io.posadilla.applistacontactos.ui.theme.AppListaContactosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppListaContactosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeView(modifier = Modifier.padding((innerPadding)))
                }
            }
        }
    }
}

@Composable
fun HomeView(modifier: Modifier = Modifier) {
    val listaNombres = remember {
        mutableStateListOf(
            "Angel",
            "Carlos",
            "Pedro",
            "David",
            "Raul",
            "Oscar",
            "Mercedes"
        )
    }
    var inputText by remember { mutableStateOf("") }

    /*
    * Column(
    *   modifier=modifier
    * )
    * {
    *   Text("nombre")
    *   // FORMAS DE ITERAR UNA LISTA
    *   for(nombre in listaNombres){
    *       Text(text = nombre)
    *   }
    *   listaNombres.forEach{nombre ->
    *       Text(text = nombre)
    *   }
    * }
    * */
    LazyVerticalGrid(
        modifier = modifier.padding(20.dp),
        columns = GridCells.Adaptive(minSize = 100.dp)
    )
    {
        // vamos a pintar un elemento determinado
        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        )
        {
            TextField(
                value = inputText,
                onValueChange = { textoTeclado ->
                    inputText = textoTeclado
                },
                modifier = Modifier.padding(20.dp)
            )
        }
        item(
            span = {
                GridItemSpan(maxLineSpan)
            }
        )
        {
            Button(
                onClick = {
                    // añadir si
                    val texto = inputText
                    if(texto.isNotEmpty()){
                        listaNombres.add(inputText)
                        inputText = ""
                    }
                },
                modifier = Modifier.padding(20.dp)

            ) {
                Text("Añadir Nombre")
            }
        }
        items( items = listaNombres)
        { nombre ->
            Card(
                modifier = Modifier
                    .padding(20.dp)
                    //.wrapContentWidth(Alignment.CenterHorizontally)

                    // Novedad!! clickable y remove
                    .clickable{
                        listaNombres.remove(nombre)
                    }
            ){
                Text(text = nombre)
            }

        }

    }
}

/*
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
    AppListaContactosTheme {
        Greeting("Android")
    }
}
*/
