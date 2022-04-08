package com.chetu.trainingapp.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.chetu.trainingapp.base.BaseViewModel

class LoginViewModel(application: Application) : BaseViewModel(application) {
    var onClick: MutableLiveData<Boolean> = MutableLiveData(false)
    var email: ObservableField<String> = ObservableField("")
    var password: ObservableField<String> = ObservableField("")
    var mContext = application

    fun loginValidation(){
        onClick.value = true
    }
}