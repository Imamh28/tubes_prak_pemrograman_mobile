package com.example.tubes_ppm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tubes_ppm.databinding.ActivityMainBinding
import com.example.tubes_ppm.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UploadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadBinding
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val namaTugas = binding.uploadNamaTugas.text.toString()
            val waktuDeadline = binding.uploadWaktuDeadline.text.toString()
            val mataKuliah = binding.uploadMataKuliah.text.toString()
            val deskripsiSingkat = binding.uploadDeskripsiSingkat.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("Informasi Tugas")
            val tugasData = TugasData(namaTugas, waktuDeadline, mataKuliah, deskripsiSingkat)
            databaseReference.child(namaTugas).setValue(tugasData).addOnSuccessListener {
                binding.uploadNamaTugas.text.clear()
                binding.uploadWaktuDeadline.text.clear()
                binding.uploadMataKuliah.text.clear()
                binding.uploadDeskripsiSingkat.text.clear()

                Toast.makeText(this, "Tersimpan", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@UploadActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, "Gagal!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}