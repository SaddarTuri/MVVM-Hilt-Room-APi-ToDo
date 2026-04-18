package saddar.todo.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import saddar.todo.backend.LocalRepository
import saddar.todo.models.generalModels.SellItemModel
import javax.inject.Inject

@HiltViewModel
class SellListViewModel @Inject constructor(
    private val localRepository: LocalRepository
) : BaseViewModel() {

    var getList: MutableLiveData<List<SellItemModel>> = MutableLiveData()
    var addList: MutableLiveData<Int> = MutableLiveData()

    fun getList() {
        viewModelScope.launch {
            localRepository.getData()
                .run {
                    getList.value = this
            }
        }
    }

    fun addList(item: List<SellItemModel>) {
        viewModelScope.launch {
            localRepository.insertData(item)
                .run {
                    addList.value = 1
                }
        }
    }
}