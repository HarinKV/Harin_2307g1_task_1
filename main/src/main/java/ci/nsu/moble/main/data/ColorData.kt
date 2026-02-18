package ci.nsu.moble.main.data

import android.graphics.Color

object ColorData {
    val colors = mapOf(
        "red" to Color.RED,
        "blue" to Color.BLUE,
        "green" to Color.GREEN,
        "yellow" to Color.YELLOW,
        "cyan" to Color.CYAN,
        "magenta" to Color.MAGENTA,
        "black" to Color.BLACK,
        "white" to Color.WHITE,
        "gray" to Color.GRAY,

    ).mapKeys { it.key.lowercase() }
}