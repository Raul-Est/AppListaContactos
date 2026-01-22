package io.posadilla.applistacontactos.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.posadilla.applistacontactos.Contacto
import io.posadilla.applistacontactos.R
import java.math.BigInteger



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
            // quitamos la imagen para poner la de internet
            //

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
                AsyncImage(
                    model = ("https://chatgpt.com/s/m_69726fc61f488191b570a1b7681085d9"),
                    contentDescription = null
                )
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

            /*
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
            }*/

            // copio la anterior y modifico para hacer las fotos cuadradas
            items( items = listaContactos)
            { contacto ->
                /*Card(
                    modifier = Modifier
                        .padding(20.dp),
                    onClick = { listaContactos.remove(contacto)}
                ){
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        if(contacto.imagenId != null) {
                            Image(
                                modifier = Modifier.size(size = 100.dp).clip(CircleShape),
                                painter = painterResource (R.drawable.veni),
                                contentDescription = null,
                                // contentScale Mantiene la escala de la imagen al reducir
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text(
                            text = contacto.nombre + " " +
                                    contacto.apellidos //+" "+
                            //contacto.mail + " "+ contacto.telefono
                        )
                    }
                */
                Card(
                    modifier = Modifier
                        .padding(20.dp),
                    onClick = { listaContactos.remove(contacto)}
                ){
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                        )
                    {
                        if(contacto.imagenId != null) {
                            Image(
                                modifier = Modifier.size(size = 100.dp).clip(CircleShape),
                                painter = painterResource (R.drawable.veni),
                                contentDescription = null,
                                // contentScale Mantiene la escala de la imagen al reducir
                                contentScale = ContentScale.Crop
                            )
                        }
                        Text(
                            text = contacto.nombre + " " +
                                    contacto.apellidos //+" "+
                            //contacto.mail + " "+ contacto.telefono
                        )
                    }



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