package com.chuckerteam.chucker.internal.ui.storage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.chuckerteam.chucker.databinding.ChuckerFragmentStorageListBinding
import com.chuckerteam.chucker.internal.ui.MainViewModel

internal class StorageListFragment : Fragment() {

    private lateinit var storageListBinding: ChuckerFragmentStorageListBinding
    private lateinit var storageAdapter: StorageAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        storageListBinding = ChuckerFragmentStorageListBinding.inflate(inflater,container,false)
        storageAdapter = StorageAdapter()
        with(storageListBinding){
            storageRecyclerView.apply {
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                adapter = storageAdapter
            }
        }
        return storageListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.storages.observe(viewLifecycleOwner, Observer<List<String>> { preferences->
            storageAdapter.setData(preferences)
        })
    }

    companion object {
        fun newInstance() = StorageListFragment()
    }
}