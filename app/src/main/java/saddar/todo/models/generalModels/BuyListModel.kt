package saddar.todo.models.generalModels

class BuyListModel : ArrayList<BuyListModelItem>()

data class BuyListModelItem(
    val id: Int,
    val name: String,
    val price: Int,
    val quantity: Int,
    val type: Int
)
