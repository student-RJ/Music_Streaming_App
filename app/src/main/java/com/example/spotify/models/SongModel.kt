package com.example.spotify.models

import android.icu.text.CaseMap.Title

data class SongModel(
    val id:String,
    val title: String,
    val subtittle:String,
    val url : String,
    val coverUrl :String,
){
    constructor():this("","","","","",)
}
