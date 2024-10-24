package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DieViewModel : ViewModel() {
    private var dieRoll = MutableLiveData<Int>()

    fun getDieRoll(): LiveData<Int> { // return die roll in read only form, mutable live data is live data
        return dieRoll
    }
    fun setDieRoll(newRoll: Int){
        dieRoll.value = newRoll
    }
}