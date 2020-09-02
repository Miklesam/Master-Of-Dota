package com.miklesam.mastersofdota.room.hairblocked

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.miklesam.mastersofdota.datamodels.roommodels.HairViewBlocked
import com.miklesam.mastersofdota.datamodels.roommodels.StreetViewBlocked
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


@Database(entities = [HairViewBlocked::class], version = 1)

abstract class HairBlockedDatabase : RoomDatabase() {

    abstract fun noteDao(): HairBlockedDao

    companion object {
        val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

        @Volatile
        private var INSTANCE: HairBlockedDatabase? = null

        fun getInstance(context: Context): HairBlockedDatabase =
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
                HairBlockedDatabase::class.java, "hair_main.db"
            )
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        scope.launch {
                            getInstance(
                                context
                            )
                                .noteDao().insertHairBlocked(HairViewList.AllHairView)
                        }
                    }
                })
                .build()


    }


}