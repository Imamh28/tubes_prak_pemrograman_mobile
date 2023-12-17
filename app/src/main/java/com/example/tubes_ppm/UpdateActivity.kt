package com.example.tubes_ppm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tubes_ppm.databinding.ActivityUpdateBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding:ActivityUpdateBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.updateButton.setOnClickListener {
            val namaTugas = binding.updateNamaTugas.text.toString()
            val waktuDeadline = binding.updateWaktuDeadline.text.toString()
            val mataKuliah = binding.updateMataKuliah.text.toString()
            val deskripsiSingkat = binding.updateDeskripsiSingkat.text.toString()

            updateData(namaTugas, waktuDeadline, mataKuliah, deskripsiSingkat)
        }
    }

    private fun updateData(namaTugas: String, waktuDeadline:String, mataKuliah: String, deskripsiSingkat: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Informasi Tugas")
        val tugasData = mapOf<String, String>("namaTugas" to namaTugas, "waktuDeadline" to waktuDeadline, "matakuliah" to mataKuliah, "deskripsiSingkat" to deskripsiSingkat)
        databaseReference.child(namaTugas).updateChildren(tugasData).addOnSuccessListener {
            binding.updateNamaTugas.text.clear()
            binding.updateWaktuDeadline.text.clear()
            binding.updateMataKuliah.text.clear()
            binding.updateDeskripsiSingkat.text.clear()
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this, "Unable to updated", Toast.LENGTH_SHORT).show()
        }
    }
}
