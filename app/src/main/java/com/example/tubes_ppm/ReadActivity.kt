package com.example.tubes_ppm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tubes_ppm.databinding.ActivityMainBinding
import com.example.tubes_ppm.databinding.ActivityReadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReadBinding
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val searchNamaTugas: String = binding.searchNamaTugas.text.toString()
            if (searchNamaTugas.isNotEmpty()){
                readData(searchNamaTugas)
            }else {
                Toast.makeText(this, "Masukkan Nama Tugas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(namaTugas: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Informasi Tugas")
        databaseReference.child(namaTugas).get().addOnSuccessListener {
            if (it.exists()){
                val namaTugas = it.child("namaTugas").value
                val waktuDeadline = it.child("waktuDeadline").value
                val mataKuliah = it.child("mataKuliah").value
                val deskripsiSingkat = it.child("deskripsiSingkat").value

                Toast.makeText(this, "Hasil Ditemukan", Toast.LENGTH_SHORT).show()
                binding.searchNamaTugas.text.clear()
                binding.readNamaTugas.text = namaTugas.toString()
                binding.readWaktuDeadline.text = waktuDeadline.toString()
                binding.readMataKuliah.text = mataKuliah.toString()
                binding.readDeskripsiSingkat.text = deskripsiSingkat.toString()
            } else {
                Toast.makeText(this, "Nama Tugas Tidak Ditemukan", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        }
    }
}