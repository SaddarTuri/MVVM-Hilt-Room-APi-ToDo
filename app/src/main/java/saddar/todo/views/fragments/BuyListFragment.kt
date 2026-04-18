package saddar.todo.views.fragments

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import saddar.todo.R
import saddar.todo.databinding.FragmentBuyListBinding
import saddar.todo.extensions.viewGone
import saddar.todo.extensions.viewVisible
import saddar.todo.viewModels.BuyListViewModel
import saddar.todo.views.activities.navHostActivities.HomeHostActivity
import saddar.todo.views.adapters.BuyListAdapter

@AndroidEntryPoint
class BuyListFragment : BaseFragment() {

    private lateinit var binding: FragmentBuyListBinding
    private val viewModel: BuyListViewModel by viewModels()

    override fun getLayoutResId() = R.layout.fragment_buy_list

    private val buyListAdapter: BuyListAdapter by lazy {
        BuyListAdapter(requireContext())
    }

    override fun onCreateView(mRootView: ViewGroup, savedInstanceState: Bundle?) {
        attachViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBuyListBinding.bind(view)
        controlToolbar()

        viewModel.buyList()
    }


    private fun controlToolbar(){
       val mToolbar = (requireActivity() as HomeHostActivity).binding.toolbarId
        mToolbar.toolbar.viewVisible()
        mToolbar.tvName.text = getString(R.string.buy_list)
        mToolbar.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    private fun setAdapter() {
        binding.buyListRecycler.let {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.adapter = buyListAdapter
        }
    }

    private fun attachViewModel() {
        observe(viewModel.snackBarMessage) {
            val msg = it?.consume()
            if (!msg.isNullOrEmpty()) {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            }
        }

        observe(viewModel.buyList) {
            if (it.isNullOrEmpty()){
                binding.shimmerFrameLayout.viewVisible()
            }else {
                binding.shimmerFrameLayout.viewGone()
                binding.buyListRecycler.viewVisible()
                buyListAdapter.buyList = it
                setAdapter()
            }
        }
    }
}