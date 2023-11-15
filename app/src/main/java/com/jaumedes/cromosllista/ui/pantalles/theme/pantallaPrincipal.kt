package com.jaumedes.cromosllista.ui.pantalles.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal (
    onLlistaDeGuerrersClick: () ->Unit,
    onLlistaDeLlibresClick: () ->Unit,
    onLlistaDeAlbumsClick: () ->Unit
){
    Column( modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1F)) {
            Button(
                modifier = Modifier.align(Alignment.Center),
                onClick = {onLlistaDeGuerrersClick()})
            {
                Text(text = "Llista de Guerrers", fontSize = 40.sp)
            }
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1F)) {
            Button(
                modifier = Modifier.align(Alignment.Center),
                onClick = {onLlistaDeLlibresClick()})
            {
                Text(text = "Llista de Llibres", fontSize = 40.sp)
            }
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .weight(1F)) {
            Button(
                modifier = Modifier.align(Alignment.Center),
                onClick = {onLlistaDeAlbumsClick()})
            {
                Text(text = "Llista d'albums", fontSize = 40.sp)
            }
        }
    }
}