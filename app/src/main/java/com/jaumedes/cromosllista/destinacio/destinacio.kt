package com.jaumedes.cromosllista.destinacio

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destinacio (

    val rutaBase: String,
    val argumentsDeNavegacio: List<ArgumentDeNavegacio> = emptyList()

){
    val rutaGenerica = run{
        val claus = argumentsDeNavegacio.map {"{${it.clau}}"}
        listOf(rutaBase)
            .plus(claus)
            //joinToString amb el Separator
            .joinToString("/")
    }
    val navArgs = argumentsDeNavegacio.map{it.toNavArgument()}
    //Principal
    object Principal: Destinacio("Principal")

    //Guerrers
    object LlistaDeGuerrers: Destinacio(
        rutaBase = "LlistadeGuerrers",
        argumentsDeNavegacio = listOf(ArgumentDeNavegacio.Titol)
    ){
        fun CreaRutaEspecifica(titol: String) = "$rutaBase/$titol"
    }

    object CromoGuerrer: Destinacio(
        rutaBase = "CromoGuerrer",
        argumentsDeNavegacio = listOf(ArgumentDeNavegacio.CromoGuerrer))
    {
        fun creaRutaEspecifica(id: String)= "$rutaBase/$id"
    }

    //LLibres
    object LlistaDeLlibres: Destinacio(
        rutaBase = "LlistadeLlibres",
        argumentsDeNavegacio = listOf(ArgumentDeNavegacio.Llibre)
    ){
        fun CreaRutaEspecifica(llibre: String) = "$rutaBase/$llibre"
    }

    object CromoLlibre: Destinacio(
        rutaBase = "CromoLlibre",
        argumentsDeNavegacio = listOf(ArgumentDeNavegacio.CromoLlibre))
    {
        fun creaRutaEspecifica(id: String)= "$rutaBase/$id"
    }

    //Albums
    object LlistaDeAlbums: Destinacio(
        rutaBase = "Llistadealbums",
        argumentsDeNavegacio = listOf(ArgumentDeNavegacio.Album)
    ){
        fun CreaRutaEspecifica(album: String) = "$rutaBase/$album"
    }

    object CromoAlbum: Destinacio(
        rutaBase = "CromoAlbum",
        argumentsDeNavegacio = listOf(ArgumentDeNavegacio.CromoAlbum))
    {
        fun creaRutaEspecifica(id: String)= "$rutaBase/$id"
    }
}

enum class ArgumentDeNavegacio(
    val clau:String,
    val tipus: NavType<*>
) {
    Titol("Títol", NavType.StringType),
    Llibre("Llibre", NavType.StringType),
    Album("Llibre", NavType.StringType),
    CromoGuerrer("CromoGuerrers", NavType.IntType),
    CromoLlibre("CromoLlibre", NavType.IntType),
    CromoAlbum("Cromoalbum", NavType.IntType);


    fun toNavArgument(): NamedNavArgument {
        return navArgument(clau){tipus}
    }
}