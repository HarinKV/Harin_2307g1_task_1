package ci.nsu.moble.main.ui.main

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import ci.nsu.moble.main.R
import ci.nsu.moble.main.data.ColorData
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ColorSearchFragment : Fragment() {

    private lateinit var etColorName: TextInputEditText
    private lateinit var btnSearch: Button
    private lateinit var paletteContainer: LinearLayout

    companion object {
        private const val TAG = "ColorSearchFragment"

        fun newInstance(): ColorSearchFragment {
            return ColorSearchFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_color_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setupListeners()
        displayColorPalette()
    }

    private fun initViews(view: View) {
        etColorName = view.findViewById(R.id.etColorName)
        btnSearch = view.findViewById(R.id.btnSearch)
        paletteContainer = view.findViewById(R.id.paletteContainer)
    }

    private fun setupListeners() {
        btnSearch.setOnClickListener {
            val colorName = etColorName.text.toString().trim().lowercase()
            searchColor(colorName)
        }
    }

    private fun searchColor(colorName: String) {
        if (colorName.isEmpty()) {
            Log.d(TAG, "Пустой запрос")
            return
        }

        val color = ColorData.colors[colorName]

        if (color != null) {
            btnSearch.setBackgroundColor(color)
            Log.d(TAG, "Цвет '$colorName' найден и применен к кнопке")
        } else {
            btnSearch.setBackgroundColor(
                androidx.core.content.ContextCompat.getColor(requireContext(), R.color.purple_500)
            )
            Log.w(TAG, "Пользовательский цвет '$colorName' не найден")
        }
    }

    private fun displayColorPalette() {
        paletteContainer.removeAllViews()

        val titleView = TextView(requireContext()).apply {
            text = "Доступные цвета (${ColorData.colors.size}):"
            textSize = 16f
            setPadding(0, 16, 0, 8)
        }
        paletteContainer.addView(titleView)

        ColorData.colors.forEach { (name, colorValue) ->
            val button = MaterialButton(requireContext(), null, com.google.android.material.R.attr.materialButtonOutlinedStyle).apply {
                text = name
                setTextColor(Color.WHITE)
                setBackgroundColor(colorValue)
                setPadding(16, 8, 16, 8)
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 4, 0, 4)
                }

                setOnClickListener {
                    etColorName.setText(name)
                    searchColor(name)
                }
            }
            paletteContainer.addView(button)
        }
    }
}