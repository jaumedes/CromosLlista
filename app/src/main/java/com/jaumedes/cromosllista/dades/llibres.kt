package com.jaumedes.cromosllista.dades

import androidx.compose.ui.graphics.Color
import kotlin.random.Random
import kotlin.random.nextInt

data class Llibre(
    val id: String,
    val titolLlibre: String,
    val foto: String,
    val color: Color,
    val autor: String,
    val editorial: String,
    val isbn: Int,
    val edicio: Int,
    val pais: String,
    val exemplarsVenuts: Int,
)

class Llibres{
    companion object {
        private fun generaLlibre(i: Int): Llibre {
            return Llibre(
                id = i.toString(),
                titolLlibre = nomLlibreRandom(),
                foto = "https://loremflickr.com/300/300/book?lock=$i",
                color = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)),
                autor = nomAutorRandom(),
                editorial = nomEditorialRandom(),
                isbn = Random.nextInt(1000..1000),
                edicio = Random.nextInt(10),
                pais = nomPaisRandom(),
                exemplarsVenuts = Random.nextInt(100..1000),
            )
        }
        val dadesLlibre = (0..100).toList().map { generaLlibre(it) };

    }
}

fun nomLlibreRandom(): String {

    val noms = listOf(
        "El senyor dels anells",
        "1894",
        "En las montañas de la locura",
        "La crida de Cthulhu",
        "Joc Brut",
        "La plaça del diamant",
        "Pulp",
        "Frankenstein",
        "Soldados de Salamina",
        "El policía de las ratas",
        "Ecce homo",
        "El arte de la guerra",
        "Ilíada",
        "Gran enciclopèdia del Barça",
        "Rigor Mortis"
    )
    var titolLlibre = noms.random()
    return  titolLlibre
}

fun nomAutorRandom(): String {

    val noms = listOf(
        "J.R.R Tolkien",
        "HP Lovecraft",
        "Roberto Bolaño",
        "Friedrich Nietzsche",
        "Mercè Rodoreda",
        "Mary Shelley",
        "Charles Bukowsky",
        "Manuel de Pedrolo",
        "George Orwell",
        "Javier Cercas",
        "Sun Tzu",
        "Homer",
        "La Sotana",
        "Tura Soler"
    )
    var nomAutor = noms.random()
    return nomAutor
}

fun nomEditorialRandom(): String {

    val noms = listOf(
        "Debolsillo",
        "Anagrama",
        "Minotauro",
        "Mestas",
        "EDUC@ULA",
        "Anaya",
        "Random House",
        "Alianza",
        "Lúmen",
        "Bambú",
        "Candaya",
        "Espasa",
        "Dojo",
        "La campana"
    )
    var nomEditorial = noms.random()
    return nomEditorial
}

fun nomPaisRandom(): String {

    val noms = listOf(
        "Espanya",
        "Catalunya",
        "Xina",
        "Estats Units",
        "Regne Unit",
        "Alemanya",
        "Bèlgica",
        "Iran",
        "França",
        "Colombia",
        "Argentina",
        "Senegal",
        "Marroc",
        "Australia",
        "Laos"
    )
    var nomPais = noms.random()
    return nomPais
}