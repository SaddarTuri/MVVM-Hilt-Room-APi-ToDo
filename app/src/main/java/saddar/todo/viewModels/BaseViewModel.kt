package saddar.todo.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import saddar.todo.utils.Event

open class BaseViewModel : ViewModel() {

    val snackBarMessage = MutableLiveData<Event<String>>()
    protected fun showSnackBarMessage(message: String) {
        snackBarMessage.value = Event(message)
    }
}