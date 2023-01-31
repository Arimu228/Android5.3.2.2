package com.example.android5322

import android.media.audiofx.DynamicsProcessing.Limiter
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_LONG
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.make

class ViewModel : ViewModel() {
    private var variable = 0
    val _count: MutableLiveData<Int> = MutableLiveData()
    val _Snack: MutableLiveData<Snackbar> = MutableLiveData()


    fun increase(view: View) {
        val ten = 10
        variable++
        _count.value = variable
        if (variable == 10) {
            _Snack.value = make(view, "вы достигли предела", LENGTH_LONG)

        } else if (variable >= 10) {
           variable = ten
            _count.value = variable

        }
    }

    fun disincrease(view: View) {
        variable--
        _count.value = variable
        val zero = 0
        if (variable == 0) {
            _Snack.value = make(view, "вы достигли предела", LENGTH_LONG)
        } else if(variable <= 0) {

            variable = zero
            _count.value = variable
        }
    }

//Если значение каунт равно 10 или нуля{ меняешь значение сенкбара }
//else { меняешь variable
//меняешь значение count }

}