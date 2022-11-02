package info.sanaebadi.akeliustask.feature.asset.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import info.sanaebadi.akeliustask.repository.AssetRepository
import javax.inject.Inject

@HiltViewModel
class AssetViewModel @Inject constructor(assetRepository: AssetRepository) : ViewModel() {
    val asset = assetRepository.getAsset().asLiveData()
}