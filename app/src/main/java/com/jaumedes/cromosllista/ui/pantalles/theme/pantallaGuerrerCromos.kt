package com.jaumedes.cromosllista.ui.pantalles.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jaumedes.cromosllista.R
import com.jaumedes.cromosllista.dades.Guerrers
import com.jaumedes.cromosllista.dades.Llibres

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaGuerrerCromos(id: String, onPopUpClick: () -> Unit){
    val num = id.toInt()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                title = {
                    Text("Cromo - ${Guerrers.dadesGuerrer[num].nom}")
                },
                navigationIcon = {
                    IconButton(onClick = {onPopUpClick()})
                    {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Vista detallada"
                        )
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondary)
        ) {
            Image(
                painter = painterResource(id = R.drawable.cardtemplate),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val textStyle = MaterialTheme.typography.headlineSmall

                Text(Guerrers.dadesGuerrer[num].nom,
                    modifier = Modifier
                        .padding(top=90.dp),
                    style = textStyle)

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.loremflickr.com/300/300/warriors?lock=${Guerrers.dadesGuerrer[num].id}")
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp, start = 30.dp, end = 30.dp)
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.primary)
                        .weight(0.9F)
                )
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, bottom = 130.dp, start = 30.dp, end = 30.dp)
                        .weight(1F)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Atac: ${Guerrers.dadesGuerrer[num].atac}" +
                            "\nDefensa: ${Guerrers.dadesGuerrer[num].defensa}" +
                            "\nArma: ${Guerrers.dadesGuerrer[num].arma}" +
                            "\nObjecte: ${Guerrers.dadesGuerrer[num].objectes}",
                        fontSize = 25.sp,
                    )
                }
            }
        }
    }
}
