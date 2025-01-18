package com.example.rickandmorty.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.rickandmorty.R
import com.example.rickandmorty.common.Resource
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.domain.model.InfoRick
import com.example.rickandmorty.presentation.adapters.RecyclerViewAdapter
import com.example.rickandmorty.presentation.app.App
import com.example.rickandmorty.presentation.factory.ViewModelFactory
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy { RecyclerViewAdapter() }

    private val component by lazy{
        (application as App).component
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel.loadInfoListRick()
        listInfoObserver()
    }

    private fun listInfoObserver(){
        viewModel.infoListRick.onEach { result ->
            when (result) {
                is Resource.Error -> {
                    Log.d("GetInfoRick", "Error")
                    binding.progressBar.visibility = View.GONE
                    binding.title.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                is Resource.Loading -> {
                    Log.d("GetInfoRick", "Loading")
                    binding.progressBar.visibility = View.VISIBLE
                    binding.title.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                }
                is Resource.Success -> {
                    Log.d("GetInfoRick", "Success")
                    initAdapter(result)
                    binding.progressBar.visibility = View.GONE
                    binding.title.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.VISIBLE
                    adapter.onRickClickListener = { item ->
                        Toast.makeText(this, item.name, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun initAdapter(
        it: Resource.Success<List<InfoRick>>
    ) {
        binding.recyclerView.adapter = adapter
        adapter.submitList(it.data)
    }
}