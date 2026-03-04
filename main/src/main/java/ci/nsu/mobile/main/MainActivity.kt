package ci.nsu.mobile.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var editTextData: EditText
    private lateinit var buttonNavigate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация views
        editTextData = findViewById(R.id.editTextData)
        buttonNavigate = findViewById(R.id.buttonNavigate)

        // Настройка TopBar (для возврата из SecondActivity)
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false) // Не показываем кнопку назад в главной

        // Обработка кнопки перехода
        buttonNavigate.setOnClickListener {
            val dataToSend = editTextData.text.toString()

            // Создание Intent для перехода во SecondActivity
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("USER_DATA", dataToSend) // Передача строки
            }
            startActivity(intent)
        }
    }
}