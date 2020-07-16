package com.miklesam.masterofdota.room.streetblocked

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.miklesam.masterofdota.datamodels.roommodels.HeroProgress
import com.miklesam.masterofdota.datamodels.roommodels.StreetViewBlocked
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


@Database(entities = [StreetViewBlocked::class], version = 1)

abstract class StreetBlockedDatabase : RoomDatabase() {

    abstract fun noteDao(): StreetBlockedDao

    companion object {
        val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

        @Volatile
        private var INSTANCE: StreetBlockedDatabase? = null

        fun getInstance(context: Context): StreetBlockedDatabase =
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
                StreetBlockedDatabase::class.java, "street_main.db"
            )
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        scope.launch {
                            getInstance(
                                context
                            )
                                .noteDao().insertStreetBlocked(StreetViewList.AllStreetView)
                        }
                    }
                })
                .build()


    }


}