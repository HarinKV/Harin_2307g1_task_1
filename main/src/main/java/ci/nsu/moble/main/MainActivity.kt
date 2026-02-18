package ci.nsu.moble.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ci.nsu.moble.main.ui.main.ColorSearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ColorSearchFragment.newInstance())
                .commit()
        }
    }
}