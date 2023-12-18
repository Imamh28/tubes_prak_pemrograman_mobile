package com.example.tubes_ppm

data class TugasData(
    val namaTugas: String? = null,
    val waktuDeadline: String? = null,
    // val uploadWaktuDeadline: LocalDataTime? = null, dengan menggunakan lib java.time.LocalDateTime dan Android API level 26 (Android 8.0 / Oreo) dan seterusnya.
    val mataKuliah: String? = null,
    val deskripsiSingkat: String? = null) {

}
