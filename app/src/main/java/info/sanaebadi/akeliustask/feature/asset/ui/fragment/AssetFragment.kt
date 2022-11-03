package info.sanaebadi.akeliustask.feature.asset.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import info.sanaebadi.akeliustask.base.BaseFragment
import info.sanaebadi.akeliustask.databinding.FragmentAssetBinding
import info.sanaebadi.akeliustask.db.entity.FileEntity
import info.sanaebadi.akeliustask.feature.asset.ui.adapter.AssetAdapter
import info.sanaebadi.akeliustask.feature.asset.ui.viewmodel.AssetViewModel
import info.sanaebadi.akeliustask.util.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

@AndroidEntryPoint
class AssetFragment : BaseFragment<FragmentAssetBinding>(FragmentAssetBinding::inflate) {
    private val viewModel: AssetViewModel by viewModels()
    private val assetAdapter = AssetAdapter()
    var listofVechileName:List<FileEntity>?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclervieweAsset.apply {
                adapter = assetAdapter
                layoutManager = LinearLayoutManager(context)
            }

            viewModel.asset.observe(viewLifecycleOwner) { result ->
                listofVechileName=result.data
                assetAdapter.submitList(result.data)
                progressBar.isVisible =
                    result is Resource.Loading<*> && result.data.isNullOrEmpty()
                textviewError.isVisible =
                    result is Resource.Error<*> && result.data.isNullOrEmpty()
                textviewError.text = result.error?.localizedMessage

            }

            swipeToRefresh.setOnRefreshListener {
                swipeToRefresh.isRefreshing=false
                GlobalScope.async {
                    viewModel.sync()
                    Log.i(TAG, "onViewCreatedPull: " + listofVechileName )
                }
            }
        }
    }

    companion object {
        private const val TAG = "AssetFragment"
    }

}