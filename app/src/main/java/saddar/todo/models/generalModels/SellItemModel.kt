package saddar.todo.models.generalModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemToSell")

data class SellItemModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "price")
    val price: String = "",

    @ColumnInfo(name = "quantity")
    val quantity: String = "",

    @ColumnInfo(name = "type")
    val type: String = ""
)