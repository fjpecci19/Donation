package com.example.donacin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

class MainViewModel: ViewModel() {

    private var _cardList = MutableLiveData<MutableList<Card>>()
    val cardList: LiveData<MutableList<Card>>
        get() = _cardList

    init {
        viewModelScope.launch {
            _cardList.value = fetchCards()
        }
    }

    private suspend fun fetchCards(): MutableList<Card> {
        return withContext(Dispatchers.IO) {
            val cardListString = service.getCharacter()
            parseCardResult(cardListString)
            Log.d("Manzana", cardListString)
            mutableListOf()
        }
    }

    private fun parseCardResult(cardListString: String) {
        val CardJsonObject = JSONObject(cardListString)
        val resultsJsonArray = CardJsonObject.getJSONArray("results")

        for (i in 0 until resultsJsonArray.length()){
            val resultsJsonObject: JSONObject = resultsJsonArray[i] as JSONObject
            val id: String = resultsJsonObject.getString("id")
        }
    }
}
