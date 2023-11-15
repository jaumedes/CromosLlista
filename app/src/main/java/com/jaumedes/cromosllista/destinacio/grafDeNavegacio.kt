package com.jaumedes.cromosllista.destinacio

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jaumedes.cromosllista.ui.pantalles.theme.PantallaAlbumCromos
import com.jaumedes.cromosllista.ui.pantalles.theme.PantallaGuerrerCromos
import com.jaumedes.cromosllista.ui.pantalles.theme.PantallaLlibreCromos
import com.jaumedes.cromosllista.ui.pantalles.theme.PantallaLlistaDeAlbums
import com.jaumedes.cromosllista.ui.pantalles.theme.PantallaLlistaDeGuerrers
import com.jaumedes.cromosllista.ui.pantalles.theme.PantallaLlistaDeLlibres
import com.jaumedes.cromosllista.ui.pantalles.theme.PantallaPrincipal

@Composable
fun GrafDeNavegacio(){

    val controladorDeNavegacio = rememberNavController()

    NavHost(
        navController =controladorDeNavegacio,
        startDestination = Destinacio.Principal.rutaGenerica
    ){
        composable(
            route = Destinacio.Principal.rutaGenerica
        )
        {
            PantallaPrincipal(

                onLlistaDeGuerrersClick= {
                    controladorDeNavegacio.navigate(
                        Destinacio.LlistaDeGuerrers.rutaGenerica)
                },
                onLlistaDeLlibresClick= {
                    controladorDeNavegacio.navigate(
                        Destinacio.LlistaDeLlibres.rutaGenerica)
                },
                onLlistaDeAlbumsClick= {
                    controladorDeNavegacio.navigate(
                        Destinacio.LlistaDeAlbums.rutaGenerica)
                }
            )
        }

        //GUERRERS
        composable(
            route=Destinacio.LlistaDeGuerrers.rutaGenerica,
            arguments = Destinacio.LlistaDeGuerrers.navArgs
        ){
            val titol = it.arguments?.getString(ArgumentDeNavegacio.Titol.clau)
            requireNotNull(titol)

            PantallaLlistaDeGuerrers(titol,
                onGuerrerClick = {
                        guerrerId: String ->
                    controladorDeNavegacio.navigate(Destinacio.CromoGuerrer.creaRutaEspecifica(guerrerId))},
                onPopUpClick={controladorDeNavegacio.navigateUp()})
        }

        composable(
            route=Destinacio.CromoGuerrer.rutaGenerica,
            arguments = Destinacio.CromoGuerrer.navArgs){
            val id = it.arguments?.getString(ArgumentDeNavegacio.CromoGuerrer.clau)
            requireNotNull(id)

            PantallaGuerrerCromos(id = id, onPopUpClick = {controladorDeNavegacio.navigateUp()})
        }

        //LLIBRES
        composable(
            route=Destinacio.LlistaDeLlibres.rutaGenerica,
            arguments = Destinacio.LlistaDeLlibres.navArgs
        ){
            val llibre = it.arguments?.getString(ArgumentDeNavegacio.Llibre.clau)
            requireNotNull(llibre)

            PantallaLlistaDeLlibres(llibre,
                onLlibreClick = { llibreId: String  ->
                    controladorDeNavegacio.navigate(Destinacio.CromoLlibre.creaRutaEspecifica(llibreId)) },
                onPopUpClick={controladorDeNavegacio.navigateUp()})
        }

        composable(
            route=Destinacio.CromoLlibre.rutaGenerica,
            arguments = Destinacio.CromoLlibre.navArgs){
            val id = it.arguments?.getString(ArgumentDeNavegacio.CromoLlibre.clau)
            requireNotNull(id)

            PantallaLlibreCromos(id = id, onPopUpClick = {controladorDeNavegacio.navigateUp()})
        }

        //ALBUMS
        composable(
            route=Destinacio.LlistaDeAlbums.rutaGenerica,
            arguments = Destinacio.LlistaDeAlbums.navArgs
        ){
            val album = it.arguments?.getString(ArgumentDeNavegacio.Album.clau)
            requireNotNull(album)

            PantallaLlistaDeAlbums(album,
                onAlbumClick = { albumId: String  ->
                    controladorDeNavegacio.navigate(Destinacio.CromoAlbum.creaRutaEspecifica(albumId)) },
                onPopUpClick={controladorDeNavegacio.navigateUp()})
        }

        composable(
            route=Destinacio.CromoAlbum.rutaGenerica,
            arguments = Destinacio.CromoAlbum.navArgs){
            val id = it.arguments?.getString(ArgumentDeNavegacio.CromoAlbum.clau)
            requireNotNull(id)

            PantallaAlbumCromos(id = id, onPopUpClick = {controladorDeNavegacio.navigateUp()})
        }
    }
}