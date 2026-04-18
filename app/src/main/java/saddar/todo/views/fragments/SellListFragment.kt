package saddar.todo.views.fragments

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import saddar.todo.R
import saddar.todo.databinding.FragmentSellListBinding
import saddar.todo.extensions.viewVisible
import saddar.todo.models.generalModels.SellItemModel
import saddar.todo.viewModels.SellListViewModel
import saddar.todo.views.activities.navHostActivities.HomeHostActivity
import saddar.todo.views.adapters.SellListAdapter

@AndroidEntryPoint
class SellListFragment : BaseFragment() {

    private lateinit var binding: FragmentSellListBinding
    private val viewModel: SellListViewModel by viewModels()

    var sellList: ArrayList<SellItemModel>? = null


    override fun getLayoutResId() = R.layout.fragment_sell_list

    private val sellListAdapter: SellListAdapter by lazy {
        SellListAdapter(requireContext())
    }

    override fun onCreateView(mRootView: ViewGroup, savedInstanceState: Bundle?) {
        attachViewModel()
        viewModel.getList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSellListBinding.bind(view)
        controlToolbar()
    }

    private fun controlToolbar(){
        val mToolbar = (requireActivity() as HomeHostActivity).binding.toolbarId
        mToolbar.toolbar.viewVisible()
        mToolbar.tvName.text = getString(R.string.sell_list)
        mToolbar.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setAdapter() {
        binding.sellListRecycler.let {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.adapter = sellListAdapter
        }
    }

    private fun attachViewModel() {

        observe(viewModel.getList) {
            sellList?.clear()
            sellList?.addAll(it)
            sellListAdapter.sellList = it as ArrayList<SellItemModel>?
            setAdapter()

            if (it.isNullOrEmpty()){
                viewModel.addList(sellListData())
                viewModel.getList()
            }

        }
    }

    fun sellListData():List<SellItemModel> {
        return listOf(SellItemModel(0,"Table","1200","1","2"), SellItemModel(0,"TV","3800","2","2"),
            SellItemModel(0,"iPhone X","15000","1","2"))
    }

}