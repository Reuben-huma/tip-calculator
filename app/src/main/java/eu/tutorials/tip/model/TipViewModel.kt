package eu.tutorials.tip.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class TipViewModel: ViewModel() {
    private var percentage: Double = 0.2
    private val _tip = MutableLiveData(0.0)
    val tip: LiveData<String> = Transformations.map(_tip) { NumberFormat.getCurrencyInstance().format(it) }

    fun setPercentage(_percentage: Double) {
        percentage = _percentage
    }

    fun setTip(_amount: String?) {
        _tip.value = _amount?.toDoubleOrNull()?.times(percentage) ?: 0.0
    }

    fun roundUpTip() {
        _tip.value?.let { kotlin.math.ceil(it) }
    }

}
