package com.mrkumar.onlinenotetakingapp.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrkumar.onlinenotetakingapp.R
import com.mrkumar.onlinenotetakingapp.data.api.ApiHelper
import com.mrkumar.onlinenotetakingapp.data.api.RetrofitBuilder
import com.mrkumar.onlinenotetakingapp.data.model.ApiResponseModelItem
import com.mrkumar.onlinenotetakingapp.databinding.ActivityGetDataBinding
import com.mrkumar.onlinenotetakingapp.ui.base.ViewModelFactory
import com.mrkumar.onlinenotetakingapp.ui.main.adapter.DataItemAdapter
import com.mrkumar.onlinenotetakingapp.ui.main.viewmodel.MyViewModel
import com.mrkumar.onlinenotetakingapp.utlis.Status

class GetDataActivity : AppCompatActivity() {
    lateinit var binding: ActivityGetDataBinding
    private lateinit var viewModel: MyViewModel
    private lateinit var adapter: DataItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGetDataBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        setupViewModel()
        setupUI()
        setUpObservers()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MyViewModel::class.java)
    }

    private fun setupUI() {
        binding.rvTo.layoutManager = LinearLayoutManager(this)
        adapter = DataItemAdapter(arrayListOf())
        binding.rvTo.addItemDecoration(
            DividerItemDecoration(
                binding.rvTo.context,
                (binding.rvTo.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.rvTo.adapter = adapter
    }

    private fun setUpObservers(){
        viewModel.getData().observe(this, Observer{
            it?.let { resource ->
            when(resource.status){
                Status.SUCCESS->{
                    binding.rvTo.visibility = View.VISIBLE
                    binding.pbShow.visibility = View.GONE
                    resource.data?.let { dataItem -> retrieveList(dataItem) }
                }
                Status.ERROR -> {
                    binding.rvTo.visibility = View.VISIBLE
                    binding.pbShow.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
                Status.LOADING -> {
                    binding.pbShow.visibility = View.VISIBLE
                    binding.rvTo.visibility = View.GONE
                }
            }
            }
        })
    }
    private fun retrieveList(dataItem: List<ApiResponseModelItem>) {
        adapter.apply {
            addUsers(dataItem)
            notifyDataSetChanged()
        }
    }

}