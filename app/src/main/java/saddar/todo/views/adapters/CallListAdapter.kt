package saddar.todo.views.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import saddar.todo.R
import saddar.todo.databinding.CallRecyclerItemViewBinding
import saddar.todo.models.generalModels.CallModelItem

class CallListAdapter(private var context: Context?) :
    RecyclerView.Adapter<CallListAdapter.CallListViewHolder>() {

    var callList: ArrayList<CallModelItem>? = null

    inner class CallListViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding = CallRecyclerItemViewBinding.bind(itemView)
        var name = binding.tvName
        var phoneNo = binding.tvPhoneNo

    }

    private val mInflater: LayoutInflater by lazy {
        LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallListViewHolder {
        val view = mInflater.inflate(R.layout.call_recycler_item_view, parent, false)
        return CallListViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onBindViewHolder(holder: CallListViewHolder, position: Int) {
        val items = callList?.get(position)
        holder.name.text = "Name : ${items?.name}"
        holder.phoneNo.text = "Phone No : ${items?.number}"
    }


    override fun getItemCount(): Int {
        return callList!!.size
    }
}