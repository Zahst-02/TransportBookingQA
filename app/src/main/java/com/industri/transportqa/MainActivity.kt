package com.industri.transportqa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val fareCalculator = FareCalculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNik = findViewById<EditText>(R.id.etNik)
        val btnSubmitBooking = findViewById<Button>(R.id.btnSubmitBooking)
        val tvBookingStatus = findViewById<TextView>(R.id.tvBookingStatus)

        btnSubmitBooking.setOnClickListener {
            val nik = etNik.text.toString().trim()

            if (nik.isBlank()) {
                tvBookingStatus.text = "NIK tidak boleh kosong"
            } else if (!fareCalculator.isValidNik(nik)) {
                tvBookingStatus.text = "NIK tidak valid (harus 16 digit angka)"
            } else {
                tvBookingStatus.text = "Pemesanan Tiket Berhasil Diverifikasi"
            }
        }
    }
}
