package info.sanaebadi.akeliustask.feature.asset.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.akeliustask.databinding.AssetItemBinding
import info.sanaebadi.akeliustask.db.entity.AssetsResponse
import info.sanaebadi.akeliustask.db.entity.FileResponse
import info.sanaebadi.akeliustask.util.LoadImage

class AssetAdapter : ListAdapter<FileResponse, AssetAdapter.AssetViewHolder>(AssetComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder {
        val binding = AssetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AssetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class AssetViewHolder(private val binding: AssetItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(fileResponse: FileResponse) {
            binding.apply {
                LoadImage.loadImage(
                    imageAsset,
                    fileResponse.path,
                    LoadImage.getProgressDrawable(itemView.context)
                )
                textviewBirthtime.text = fileResponse.statsResponse?.birthtime

            }
        }
    }

    class AssetComparator : DiffUtil.ItemCallback<FileResponse>() {
        override fun areItemsTheSame(oldItem: FileResponse, newItem: FileResponse) =
            oldItem.path == newItem.path

        override fun areContentsTheSame(oldItem: FileResponse, newItem: FileResponse) =
            oldItem == newItem
    }


}
