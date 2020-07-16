package com.miklesam.masterofdota.room.hero

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


@Database(entities = [HeroProgress::class], version = 1)

abstract class HeroProgressDatabase : RoomDatabase() {

    abstract fun noteDao(): HeroProgressDao

    companion object {
        val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

        @Volatile
        private var INSTANCE: HeroProgressDatabase? = null

        fun getInstance(context: Context): HeroProgressDatabase =
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
                HeroProgressDatabase::class.java, "heroes_main.db"
            )
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        scope.launch {
                            Log.w("In Market", "Insert Populate")
                            getInstance(
                                context
                            )
                                .noteDao().insertHeroProgress(HeroProgressList.AllHeroProgress)
                        }
                    }
                })
                .build()


    }


}