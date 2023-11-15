package com.jaumedes.cromosllista.dades

import androidx.compose.ui.graphics.Color
import kotlin.random.Random
import kotlin.random.nextInt

data class Album(
    val id: String,
    val titolAlbum: String,
    val foto: String,
    val color: Color,
    val banda: String,
    val genere: String,
    val discografica: String,
    val format: String,
    val exemplarsVenuts: Int,
)

class Albums{
    companion object {
        private fun generaAlbum(i: Int): Album {
            return Album(
                id = i.toString(),
                titolAlbum = nomAlbumRandom(),
                foto = "https://loremflickr.com/300/300/music?lock=$i",
                color = Color(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)),
                banda = nomBandaRandom(),
                genere = nomGenereRandom(),
                discografica = nomDiscograficaRandom(),
                format = nomFormatRandom(),
                exemplarsVenuts = Random.nextInt(1000..10000),
            )
        }
        val dadesAlbum = (0..100).toList().map { generaAlbum(it) };

    }
}

fun nomAlbumRandom():String {

    val noms = listOf(
        "Vulgar display of power",
        "Obzen",
        "10.000 days",
        "All hope is gone",
        "The end of a heartache",
        "One",
        "Hell awaits",
        "Peace sells, but who's buying",
        "Master of puppets",
        "Powerslave",
        "Master of reality",
        "Still hungry",
        "Images and words",
        "Ad majorem sathanas gloriam",
        "Hybrid Theory",
        "The black crown",
        "Iowa",
        "Rust in piece",
        "And justice for all...",
        "Immutable",
        "Altered State",
        "The mara effect",
        "Evil empire",
        "The atrocity exhibition",
        "The sound of perseverance",
        "KILL",
        "The ultimate Sin",
        "Demigod",
        "Grand declaration of war",
        "Aenima",
        "Lateralus",
        "Incarnate",
        "Meteora",
        "Christ illusion",
        "The subliminal verses: 3"
    )
    var nomAlbum = noms.random()
    return nomAlbum
}

fun nomBandaRandom():String {

    val noms = listOf(
        "Tool",
        "Opeth",
        "Metallica",
        "Pantera",
        "Megadeth",
        "Slayer",
        "Exodus",
        "Meshuggah",
        "Tesseract",
        "Rage Against The Machine",
        "Slipknot",
        "Twisted Sister",
        "Suicide Silence",
        "Killswitch Engage",
        "Dream Theater",
        "Iron Maiden",
        "Linkin Park",
        "Death",
        "Cannibal Corpse",
        "Gorgoroth",
        "Mayhem",
        "Spiritbox",
        "Behemoth",
        "Black Sabbath",
        "Ozzy Osbourne"
    )
    var nomBanda = noms.random()
    return nomBanda
}

fun nomGenereRandom():String {

    val noms = listOf(
        "Thrash Metal",
        "Doom Metal",
        "Black Metal",
        "Djent",
        "MetalCore",
        "DeathCore",
        "Death Metal",
        "Groove",
        "Nu-Metal",
        "Progressive Metal",
        "Power Metal",
        "Heavy Metal",
        "Classic",
        "Glam Metal",
        "Math Metal",
        "Rap Metal"
    )
    var nomGenere = noms.random()
    return nomGenere
}

fun nomDiscograficaRandom():String {

    val noms = listOf(
        "RoadRunner Rec.",
        "Nuclear Blast",
        "Napalm Rec.",
        "Metal Blade",
        "Avantgarde M.",
        "Enigma Rec.",
        "Xtreem Music",
        "Uprising Rec.",
        "Locomotive M.",
        "Eagle Rec.",
        "High And Loud",
        "Relapse Rec.",
        "Black Mark",
        "Drakkar",
        "Epic Rec.",
        "Indie Rec.",
        "Soundholic"

    )
    var nomDiscografica = noms.random()
    return nomDiscografica
}

fun nomFormatRandom():String {

    val noms = listOf(
        "Digital",
        "CD",
        "Vinil",
        "Cassette",
        "Streaming"
    )
    var nomFormat = noms.random()
    return nomFormat
}