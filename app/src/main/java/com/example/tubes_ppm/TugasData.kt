package com.example.tubes_ppm

data class TugasData(
    val uploadNamaTugas: String? = null,
    val uploadWaktuDeadline: String? = null,
    // val uploadWaktuDeadline: LocalDataTime? = null, dengan menggunakan lib java.time.LocalDateTime dan Android API level 26 (Android 8.0 / Oreo) dan seterusnya.
    val uploadMataKuliah: String? = null,
    val uploadDeskripsiSingkat: String? = null){

}
