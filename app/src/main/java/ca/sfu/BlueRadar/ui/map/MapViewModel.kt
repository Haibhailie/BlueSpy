package ca.sfu.BlueRadar.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MapViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Shanks is handsome"
    }
    val text: LiveData<String> = _text
}