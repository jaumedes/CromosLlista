package com.jaumedes.cromosllista.dades

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

data class Guerrer(
    val id: String,
    val nom: String,
    val foto: String,
    val color: Color,
    val edat: Int,
    val forsa: Int,
    val resistencia: Int,
    val atac: Int,
    val defensa: Int,
    val arma: String,
    val objectes: String,
)

class Guerrers{
    companion object {
        private fun generaGuerrer(i: Int): Guerrer {
            return Guerrer(
                id = i.toString(),
                nom = nomGuerrerRandom(),
                foto = "https://loremflickr.com/300/300/warriors?lock=$i",
                color = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)),
                edat = Random.nextInt(100),
                forsa = Random.nextInt(1000),
                resistencia = Random.nextInt(500),
                atac = Random.nextInt(1000),
                defensa = Random.nextInt(500),
                objectes = nomObjecteRandom(),
                arma = nomArmaRandom()
            )
        }

        val dadesGuerrer = (0..100).toList().map { generaGuerrer(it) };

    }
}

fun nomGuerrerRandom():String {

    val noms = listOf(
        "Guts",
        "Puck",
        "Griffith",
        "Casca",
        "Judeau",
        "Pippin",
        "Corkus",
        "Gaston",
        "Rickert",
        "Schierke",
        "Farnesse",
        "Serpico",
        "Ishidoro",
        "Skull Knight",
        "Zodd",
        "Grunbeld",
        "Locus",
        "Irvine",
        "Rakshas",
        "Femto",
        "Void",
        "Slan",
        "Ubik",
        "Conrad"
    )
    var nomGuerrer = noms.random()
    return nomGuerrer
}

fun nomObjecteRandom():String {

    val noms = listOf(
        "Poció",
        "Ultrapoció",
        "Eter",
        "Elixir",
        "Omnielixir",
        "PH+"
    )
    var nomObjecte = noms.random()
    return  nomObjecte
}

fun nomArmaRandom(): String {

    val noms = listOf(
        "Espasa",
        "Llança",
        "Arc",
        "Escut",
        "AK-47",
        "Falç",
        "Martell",
        "Destral",
        "Vareta màgica",
        "Bomba",
        "Daga",
        "Ganivet",
        "Ballesta",
        "Alabarda",
        "Katana",
        "Maça",

        )
    var nomArma = noms.random()
    return nomArma
}