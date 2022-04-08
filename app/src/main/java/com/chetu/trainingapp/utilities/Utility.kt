package com.chetu.trainingapp.utilities

import android.content.Context
import android.widget.Toast

class Utility {
    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}