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
import saddar.todo.databinding.BuyListRecyclerItemBinding
import saddar.todo.databinding.CallRecyclerItemViewBinding
import saddar.todo.models.generalModels.BuyListModel
import saddar.todo.models.generalModels.BuyListModelItem
import saddar.todo.models.generalModels.CallModelItem
import saddar.todo.models.generalModels.SellItemModel

class SellListAdapter(private var context: Context?) :
    RecyclerView.Adapter<SellListAdapter.SellListViewHolder>() {

    var sellList: ArrayList<SellItemModel>? = null

    inner class SellListViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding = BuyListRecyclerItemBinding.bind(itemView)
        var name = binding.tvName
        var price = binding.price
        var quatity = binding.quantity

    }

    private val mInflater: LayoutInflater by lazy {
        LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SellListViewHolder {
        val view = mInflater.inflate(R.layout.buy_list_recycler_item, parent, false)
        return SellListViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onBindViewHolder(holder: SellListViewHolder, position: Int) {
        val items = sellList?.get(position)
        holder.name.text = "Name : ${items?.name}"
        holder.price.text = "Price : ${items?.price.toString()}"
        holder.quatity.text = "Quantity : ${items?.quantity.toString()}"
    }

    override fun getItemCount(): Int {
        return sellList!!.size
    }
}