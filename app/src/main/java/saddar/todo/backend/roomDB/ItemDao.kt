package saddar.todo.backend.roomDB


import androidx.room.Dao
import androidx.room.Query
import saddar.todo.models.generalModels.SellItemModel

@Dao
interface ItemDao : RoomBaseDAO<SellItemModel>{

    @Query("SELECT * from itemToSell where type = :type")
    suspend fun getSellingItems(type:Int): List<SellItemModel>

}