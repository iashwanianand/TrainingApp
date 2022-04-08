package com.chetu.trainingapp.logger

import android.content.Context
import android.os.Build
import android.os.Environment
import android.util.Log
import androidx.annotation.RequiresApi
import java.io.File
import java.text.SimpleDateFormat
import java.util.*


class Logger_New {
    companion object {
        private var deviceDetails =
            (Build.MANUFACTURER + "\t" + Build.MODEL + "\t" + Build.VERSION.RELEASE + "\t "
                    + Build.VERSION_CODES::class.java.fields[Build.VERSION.SDK_INT].name)
//        private var appVersionName = BuildConfig.VERSION_NAME

//        @Suppress("DEPRECATION")
        private val logFilePath =
            Environment.getExternalStorageDirectory().absolutePath + "/Android/data/com.chetu.trainingapp/files/Download"
        private const val LOG_FILE_NAME = "LogFile.txt"
        private const val DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss"
        private var userId: String = "Default User"

        fun logD(context: Context, className: String, methodName: String, message: String) {
            Log.d("$className -> $methodName", message)
            //writeToLogFile(context, className, methodName, message, "", "")
        }

        fun logE(
            context: Context,
            className: String,
            methodName: String,
            message: String,
            request: String,
            response: String
        ) {
            Log.e("$className -> $methodName", message)
            //writeToLogFile(context, className, methodName, message, request, response)
        }


//
//        fun logI(className: String, methodName: String, message: String) {
//            Log.i("$className -> $methodName", message)
//            writeToLogFile(className, methodName, message)
//        }
//
//        fun logV(className: String, methodName: String, message: String) {
//            Log.v("$className -> $methodName", message)
//            writeToLogFile(className, methodName, message)
//        }

//        @RequiresApi(Build.VERSION_CODES.O)
        fun writeToLogFile(
            context: Context,
            className: String,
            methodName: String,
            message: String
        ) {
            val dir = File(
                Objects.requireNonNull(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS))?.absolutePath + "/" + "logFiles"
            )
            if (!dir.exists()) {
                dir.mkdir()

            }
            val myFilepath: File? = File(dir, LOG_FILE_NAME)
            myFilepath.toString()
            val data = "${getCurrentDateTime()} \n " +
                    "$deviceDetails \n " +
//                    "$appVersionName \n " +
                    "$userId \n " +
                    "$className \n"+
                    "$methodName \n"+
                    "$message \n \n"

            if (!myFilepath!!.exists()) // create the new file.
                myFilepath.createNewFile()

            myFilepath.appendText("$data\n \n \n")

        }


        /*
        * Used to write message in the logfile
        * */
        @RequiresApi(Build.VERSION_CODES.O)
        fun writeMessageFile(context: Context, purpose: Int, message: String) {
            Log.e("writeMessageFile", message)
            val dir = File(
                Objects.requireNonNull(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS))?.absolutePath + "/" + "logFiles"
            )
            if (!dir.exists()) {
                dir.mkdir()
            }
            val myFilepath: File? = File(dir, LOG_FILE_NAME)
            myFilepath.toString()
            var data = message


            data = "${getCurrentDateTime()} \n OTHER Data :\n $message"

            if (!myFilepath!!.exists()) // create the new file.

                myFilepath.createNewFile()

            myFilepath.appendText(data + "\n\n")

        }


        fun deleteLogFile() {
            File(logFilePath, LOG_FILE_NAME).delete()
        }


        private fun getCurrentDateTime(): String {
            return SimpleDateFormat("yyyy-MMM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        }

    }
}