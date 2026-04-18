package saddar.todo.backend

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import saddar.todo.backend.roomDB.ItemDao
import saddar.todo.backend.roomDB.SellRoomDB
import saddar.todo.models.generalModels.SellItemModel
import javax.inject.Inject

class LocalRepository @Inject constructor(@ApplicationContext private val context: Context){

    private val itemToSellDao: ItemDao = SellRoomDB.getDatabase(context).mItemDao()


    suspend fun insertData(list: List<SellItemModel>) {
        return itemToSellDao.insert(list)
    }

    suspend fun getData() : List<SellItemModel> {
        return itemToSellDao.getSellingItems(2)
    }

}