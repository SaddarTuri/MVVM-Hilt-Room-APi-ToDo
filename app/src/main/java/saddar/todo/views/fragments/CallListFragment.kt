package saddar.todo.views.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import saddar.todo.R
import saddar.todo.databinding.FragmentCallListBinding
import saddar.todo.extensions.viewGone
import saddar.todo.extensions.viewVisible
import saddar.todo.viewModels.CallListViewModel
import saddar.todo.views.activities.navHostActivities.HomeHostActivity
import saddar.todo.views.adapters.CallListAdapter


@AndroidEntryPoint
class CallListFragment : BaseFragment() {

    private lateinit var binding: FragmentCallListBinding
    private val viewModel: CallListViewModel by viewModels()

    override fun getLayoutResId() = R.layout.fragment_call_list

    private val callListAdapter: CallListAdapter by lazy {
        CallListAdapter(requireContext())
    }

    override fun onCreateView(mRootView: ViewGroup, savedInstanceState: Bundle?) {
        attachViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCallListBinding.bind(view)
        controlToolbar()

        viewModel.callList()
    }

    private fun controlToolbar(){
        val mToolbar = (requireActivity() as HomeHostActivity).binding.toolbarId
        mToolbar.toolbar.viewVisible()
        mToolbar.tvName.text = getString(R.string.call_list)
        mToolbar.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    private fun setAdapter() {
        binding.callListRecycler.let {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.adapter = callListAdapter
        }
    }

    private fun attachViewModel() {
        observe(viewModel.snackBarMessage) {
            val msg = it?.consume()
            if (!msg.isNullOrEmpty()) {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
            }
        }

        observe(viewModel.callList) {
            if (it.isNullOrEmpty()){
                binding.shimmerFrameLayout.viewVisible()
            }else {
                binding.shimmerFrameLayout.viewGone()
                binding.callListRecycler.viewVisible()
                callListAdapter.callList = it
                setAdapter()
            }
        }
    }

}