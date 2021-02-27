package io.aouledissa.common

import android.view.View

fun View?.show() {
    this?.let {
        visibility = View.VISIBLE
    }
}

fun View?.hide() {
    this?.let {
        visibility = View.GONE
    }
}