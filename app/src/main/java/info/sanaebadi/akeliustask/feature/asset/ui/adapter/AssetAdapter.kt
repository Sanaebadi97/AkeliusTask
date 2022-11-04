package info.sanaebadi.akeliustask.feature.asset.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.akeliustask.databinding.AssetItemBinding
import info.sanaebadi.akeliustask.db.entity.FileEntity
import info.sanaebadi.akeliustask.util.LoadImage

class AssetAdapter : ListAdapter<FileEntity, AssetAdapter.AssetViewHolder>(AssetComparator()) {

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
        fun bind(fileResponse: FileEntity) {
            binding.apply {
                LoadImage.loadImage(
                    imageAsset,
                    fileResponse.path,
                    LoadImage.getProgressDrawable(itemView.context)
                )
                textviewModificationTime.text = "Modification Time = ${fileResponse.stats.mtime}"
                textviewSize.text = "Size = ${fileResponse.stats.size}"

            }
        }
    }

    class AssetComparator : DiffUtil.ItemCallback<FileEntity>() {
        override fun areItemsTheSame(oldItem: FileEntity, newItem: FileEntity) =
            oldItem.path == newItem.path

        override fun areContentsTheSame(oldItem: FileEntity, newItem: FileEntity) =
            oldItem == newItem
    }


}
