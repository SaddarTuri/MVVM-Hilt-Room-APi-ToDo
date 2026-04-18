package saddar.todo.extensions

import android.view.View


fun View.viewVisible() : View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

fun View.viewGone() : View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}
