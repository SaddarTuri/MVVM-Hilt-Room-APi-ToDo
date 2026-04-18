package saddar.todo.models.generalModels

class CallListModel : ArrayList<CallModelItem>()

data class CallModelItem(
    val id: Int,
    val name: String,
    val number: String
)
