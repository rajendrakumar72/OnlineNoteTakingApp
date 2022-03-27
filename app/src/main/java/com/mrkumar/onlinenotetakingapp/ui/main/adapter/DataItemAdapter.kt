package com.mrkumar.onlinenotetakingapp.ui.main.adapter

import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrkumar.onlinenotetakingapp.data.model.ApiResponseModel
import com.mrkumar.onlinenotetakingapp.data.model.ApiResponseModelItem
import com.mrkumar.onlinenotetakingapp.databinding.ItemDataLayoutBinding
import java.util.Collections.addAll

class DataItemAdapter(val dataItem:ArrayList<ApiResponseModelItem>) :RecyclerView.Adapter<DataItemAdapter.DataViewHolder>(){




    class DataViewHolder (val binding: ItemDataLayoutBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding=ItemDataLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binding.txtName.text=dataItem[position].name
        holder.binding.txtAge.text=dataItem[position].age.toString()


    }

    override fun getItemCount(): Int {
        return dataItem.size
    }
    fun addUsers(dataItem: List<ApiResponseModelItem>) {
        this.dataItem.apply {
            clear()
            addAll(dataItem)

        }
    }

}