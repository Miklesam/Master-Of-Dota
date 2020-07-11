package com.miklesam.masterofdota.room.ability

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.miklesam.masterofdota.datamodels.roommodels.AbilityProgress
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


@Database(entities = [AbilityProgress::class], version = 1)

abstract class AbilityProgressDatabase : RoomDatabase() {

    abstract fun noteDao(): AbilityProgressDao

    companion object {
        val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

        @Volatile
        private var INSTANCE: AbilityProgressDatabase? = null

        fun getInstance(context: Context): AbilityProgressDatabase =
            INSTANCE
                ?: synchronized(this) {
                    INSTANCE
                        ?: buildDatabase(
                            context
                        )
                            .also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AbilityProgressDatabase::class.java, "ability_main.db"
            )
                // prepopulate the database after onCreate was called
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // insert the data on the IO Thread
                        scope.launch {
                            getInstance(
                                context
                            )
                                .noteDao()
                                .insertAbilityProgress(AbilityProgressList.AllAbilityProgress)
                        }
                    }
                })
                .build()


    }


}