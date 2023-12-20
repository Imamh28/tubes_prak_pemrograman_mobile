package com.example.tubes_ppm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tubes_ppm.databinding.ActivityDeleteBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeleteBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_delete)

        binding.deleteButton.setOnClickListener{
            val namaTugas = binding.deleteNamaTugas.text.toString()
            if (namaTugas.isNotEmpty()){
                deleteData(namaTugas)
            } else {
                Toast.makeText(this, "Tolong masukkan nama tugas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteData(namaTugas: String){
        databaseReference = FirebaseDatabase.getInstance().getReference("Informasi Tugas")
        databaseReference.child(namaTugas).removeValue().addOnSuccessListener {
            binding.deleteNamaTugas.text.clear()
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Unable to Delete", Toast.LENGTH_SHORT).show()
        }
    }
}