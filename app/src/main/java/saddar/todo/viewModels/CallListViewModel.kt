package saddar.todo.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import saddar.todo.backend.ServerRepository
import saddar.todo.models.generalModels.CallListModel
import javax.inject.Inject

@HiltViewModel
class CallListViewModel@Inject constructor(
    private val repository: ServerRepository
) : BaseViewModel() {

    var callList: MutableLiveData<CallListModel> = MutableLiveData()

    fun callList() {
        viewModelScope.launch {
            repository.callList().run {
                onSuccess {
                        callList.value = it
                }

                onFailure {
                    it.message?.let { it1 -> showSnackBarMessage(it1) }
                }
            }
        }
    }
}