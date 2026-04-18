package saddar.todo.views.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import saddar.todo.R
import saddar.todo.databinding.FragmentHomeBinding
import saddar.todo.extensions.viewGone
import saddar.todo.views.activities.navHostActivities.HomeHostActivity

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun getLayoutResId() = R.layout.fragment_home

    override fun onCreateView(mRootView: ViewGroup, savedInstanceState: Bundle?) {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        (requireActivity() as HomeHostActivity).binding.toolbarId.toolbar.viewGone()

        listener()
    }


    private fun listener(){
        binding.tvCall.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToCallListFragment()
            )
        }

        binding.tvBuy.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToBuyListFragment()
            )
        }

        binding.tvSell.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToSellListFragment()
            )
        }
    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as HomeHostActivity).binding.toolbarId.toolbar.viewGone()
    }


}