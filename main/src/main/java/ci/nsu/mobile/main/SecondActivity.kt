package ci.nsu.mobile.main

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Получение переданных данных
        val receivedData = intent.getStringExtra("USER_DATA") ?: "Нет данных"

        val textViewData = findViewById<TextView>(R.id.textViewData)
        textViewData.text = "Получено: $receivedData"

        // Настройка TopBar с кнопкой назад для возврата в MainActivity
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Показываем кнопку назад
        toolbar.setNavigationOnClickListener {
            // Возврат в MainActivity
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Очищаем стек
            startActivity(intent)
            finish() // Закрываем текущую Activity
        }
    }
}