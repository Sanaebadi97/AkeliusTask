package info.sanaebadi.akeliustask.feature.asset.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import info.sanaebadi.akeliustask.base.BaseFragment
import info.sanaebadi.akeliustask.databinding.FragmentAssetBinding
import info.sanaebadi.akeliustask.feature.asset.ui.adapter.AssetAdapter
import info.sanaebadi.akeliustask.feature.asset.ui.viewmodel.AssetViewModel
import info.sanaebadi.akeliustask.util.Resource

@AndroidEntryPoint
class AssetFragment : BaseFragment<FragmentAssetBinding>(FragmentAssetBinding::inflate) {
    private val viewModel: AssetViewModel by viewModels()
    val assetAdapter = AssetAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclervieweAsset.apply {
                adapter = assetAdapter
                layoutManager = LinearLayoutManager(context)
            }

            viewModel.asset.observe(viewLifecycleOwner) { result ->
                assetAdapter.submitList(result.data?.fileResponses)
                progressBar.isVisible =
                    result is Resource.Loading<*> && result.data?.fileResponses.isNullOrEmpty()
                textviewError.isVisible =
                    result is Resource.Error<*> && result.data?.fileResponses.isNullOrEmpty()
                textviewError.text = result.error?.localizedMessage

            }
        }
    }

}