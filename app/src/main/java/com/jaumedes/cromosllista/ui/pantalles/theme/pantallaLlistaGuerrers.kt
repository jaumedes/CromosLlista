package com.jaumedes.cromosllista.ui.pantalles.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jaumedes.cromosllista.R
import com.jaumedes.cromosllista.dades.Guerrer
import com.jaumedes.cromosllista.dades.Guerrers

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaLlistaDeGuerrers(titol: String, onGuerrerClick: (String) -> Unit, onPopUpClick: () -> Unit){

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                title = {
                    Text("LLISTA DE GUERRERS")
                },
                navigationIcon = {
                    IconButton(onClick = {onPopUpClick()})
                    {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Llista de guerrers"
                        )
                    }
                }
            )
        }
    ) {
        LazyColumn(modifier = Modifier
            .padding(it)
            .fillMaxSize())
        {

            items(Guerrers.dadesGuerrer){ guerrer ->
                ItemGuerrer(guerrer = guerrer) { onGuerrerClick(guerrer.id) }
            }
        }
    }
}

@Composable
fun ItemGuerrer(guerrer: Guerrer, onGuerrerClick: (String)-> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .clickable { onGuerrerClick(guerrer.id) }
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.onSecondary)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.loremflickr.com/300/300/warriors?lock=${guerrer.id}")
                .crossfade(true)
                .build(),
                placeholder= painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(15.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                val textStyle = MaterialTheme.typography.headlineSmall

                Text(guerrer.nom, style = textStyle)
                Text("Atac: ${guerrer.atac}  /  Defensa: ${guerrer.defensa}" +
                        "\nArma: ${guerrer.arma}" +
                        "\nObjecte: ${guerrer.objectes}")
            }
        }
    }
}