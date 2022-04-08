package com.chetu.trainingapp.base

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chetu.trainingapp.R

abstract class BaseActivity/*<T: ViewDataBinding, V : BaseViewModel>*/ : AppCompatActivity() {
    /* private var mViewDataBinding: T? = null
     private var mViewModel: V? = null

     abstract fun getBindingVariable(): Int

     abstract fun getLayoutId(): Int

     abstract fun getViewModel(): V

     fun getViewDataBinding(): T {
         return mViewDataBinding!!
     }

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         performDataBinding()

         setObserversOnBaseActivity()
     }

 //      Set observers

     private fun setObserversOnBaseActivity() {

     }

 //      Method to perform data binding on layout for activity

     private fun performDataBinding() {
         mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
         mViewModel = when (this.mViewModel) {
             null -> getViewModel()
             else -> mViewModel
         }
         mViewDataBinding!!.setVariable(getBindingVariable(), mViewModel)
         mViewDataBinding!!.executePendingBindings()
         mViewDataBinding!!.lifecycleOwner = this
     }*/

    fun Toast.showCustomToast(message: String, activity: Activity) {
        val layout = activity.layoutInflater.inflate(R.layout.custom_toast, activity.findViewById(R.id.toast_container))

        // set the text of the TextView of the message
        val textView = layout.findViewById<TextView>(R.id.toast_text)
        textView.text = message

        // use the application extension function
        this.apply {
            setGravity(Gravity.BOTTOM, 0, 0)
            duration = Toast.LENGTH_SHORT
            view = layout
            show()
        }
    }
}