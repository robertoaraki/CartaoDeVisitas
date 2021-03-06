package com.rtaraki.cartaodevisitas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository(
    private val dao: BusinessCardDao
) {
    fun insert(businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(businessCard)
        }
    }

    fun getAll() = dao.getAll()

    fun update(businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.update(businessCard)
        }
    }
}