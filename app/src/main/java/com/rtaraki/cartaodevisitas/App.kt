package com.rtaraki.cartaodevisitas

import android.app.Application
import com.rtaraki.cartaodevisitas.data.AppDatabase
import com.rtaraki.cartaodevisitas.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}