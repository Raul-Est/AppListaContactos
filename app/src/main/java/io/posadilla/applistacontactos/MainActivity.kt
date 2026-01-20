package io.posadilla.applistacontactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.fromColorLong
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import io.posadilla.applistacontactos.ui.theme.AppListaContactosTheme
import java.math.BigInteger
import kotlin.String

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
    val listaContactos = remember {mutableStateListOf(Contacto(nombre = "Mario", apellidos = "Rios", mail = "mario.rios@iepgroup.es", telefono = BigInteger(
        "123456789"
    ),
        imagenId = R.drawable.veni
    ))}
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
                        listaContactos.add(
                            Contacto (
                                nombre = inputText,
                                apellidos = "Rios",
                                mail = "mail@mail",
                                telefono = BigInteger("0000000"),
                                imagenId = R.drawable.veni
                            )
                        )
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
                    .padding(20.dp),
                onClick = { listaNombres.remove(nombre)}
                    //.wrapContentWidth(Alignment.CenterHorizontally)
                    // Novedad!! clickable y remove
                    // .clickable{ listaNombres.remove(nombre) },
                    //.hoverable(Propiedad Del Hover por definir),

            ){
                // Centramos el texto en el boton, ocupando
                // todo el espacio posible

                Text(
                    modifier= Modifier.fillMaxWidth(1f),
                    text = nombre, textAlign = TextAlign.Center)
            }
        }
//        item (
//            span = {GridItemSpan(maxLineSpan)}
//        ){
//            Image(
//                painter = painterResource(R.drawable.veni),
//                contentDescription = null,
//                modifier = Modifier.height(75.dp)
//                // nota: agregar tamaño a la imagen
//            )
//        }


        items( items = listaContactos)
        { contacto ->
            Card(
                modifier = Modifier
                    .padding(20.dp),
                onClick = { listaContactos.remove(contacto)}
            ){
                Image(
                    painter = painterResource(R.drawable.veni),
                    contentDescription = null,
                    modifier = Modifier.height(75.dp)
                    // nota: agregar tamaño a la imagen
                )
                Text( text = contacto.nombre +" "+
                    contacto.apellidos //+" "+
                    //contacto.mail + " "+ contacto.telefono
                )
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
/*
PS C:\Users\raul.esteban_alumnoj\AndroidStudioProjects\AppListaContactos> git add .
warning: in the working copy of '.idea/misc.xml', LF will be replaced by CRLF the next time Git touches it
PS C:\Users\raul.esteban_alumnoj\AndroidStudioProjects\AppListaContactos> git commit -m "Actualizacion Centrado"
[master b2241ad] Actualizacion Centrado
2 files changed, 2 insertions(+), 4 deletions(-)
PS C:\Users\raul.esteban_alumnoj\AndroidStudioProjects\AppListaContactos> git push

bajar con -> git pull
* */