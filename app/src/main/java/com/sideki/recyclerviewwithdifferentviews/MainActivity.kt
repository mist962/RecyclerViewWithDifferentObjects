package com.sideki.recyclerviewwithdifferentviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.sideki.recyclerviewwithdifferentviews.adapters.MainAdapter
import com.sideki.recyclerviewwithdifferentviews.api.FakeApi
import com.sideki.recyclerviewwithdifferentviews.models.repository.Repository
import com.sideki.recyclerviewwithdifferentviews.viewmodels.MainViewModel
import com.sideki.recyclerviewwithdifferentviews.viewmodels.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fakeApi = FakeApi()
    private val repository = Repository(fakeApi)
    private var mainViewModel = MainViewModel(repository)
    private val mainViewModelFactory = MainViewModelFactory(repository)
    val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        recyclerview.adapter = adapter

        progress_bar.visibility = View.VISIBLE

        mainViewModel.getRandItems()
        mainViewModel.itemsRandom.observe(this, {
            adapter.setData(it)
            progress_bar.visibility = View.INVISIBLE
        })
    }
}