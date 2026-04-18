package saddar.todo.backend.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import saddar.todo.models.generalModels.SellItemModel

@Database(entities = [SellItemModel::class], version = 1, exportSchema = false)
abstract class SellRoomDB : RoomDatabase() {

    abstract fun mItemDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: SellRoomDB? = null
        fun getDatabase(context: Context): SellRoomDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SellRoomDB::class.java,
                    "mSellingRoomDB"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}