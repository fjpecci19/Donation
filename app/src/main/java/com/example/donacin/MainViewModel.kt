package com.example.donacin

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

            val cardlist = parseCardResult(cardListString)

            cardlist
        }
    }

    private fun parseCardResult(cardListString: String): MutableList<Card> {
        val cardJsonObject = JSONObject(cardListString)
        val resultsJsonArray = cardJsonObject.getJSONArray("results")

        val cardlist = mutableListOf<Card>()

        for (i in 0 until resultsJsonArray.length()){
            val resultsJsonObject: JSONObject = resultsJsonArray[i] as JSONObject
            val image: String = resultsJsonObject.getString("image")
            val name: String = resultsJsonObject.getString("name")
            val status: String = resultsJsonObject.getString("status")

            val card = Card(image, name, status)
            cardlist.add(card)
        }
        return cardlist
    }
}
