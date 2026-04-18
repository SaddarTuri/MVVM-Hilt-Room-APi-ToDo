package saddar.todo.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import saddar.todo.backend.ServerRepository
import saddar.todo.models.generalModels.BuyListModel
import saddar.todo.models.generalModels.CallListModel
import javax.inject.Inject

@HiltViewModel
class BuyListViewModel@Inject constructor(
    private val repository: ServerRepository
) : BaseViewModel() {

    var buyList: MutableLiveData<BuyListModel> = MutableLiveData()

    fun buyList() {
        viewModelScope.launch {
            repository.buyList().run {
                onSuccess {
                    buyList.value = it
                }

                onFailure {
                    it.message?.let { it1 -> showSnackBarMessage(it1) }
                }
            }
        }
    }
}