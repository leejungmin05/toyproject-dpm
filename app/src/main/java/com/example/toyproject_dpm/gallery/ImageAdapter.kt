package com.example.toyproject_dpm.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.toyproject_dpm.R
import com.example.toyproject_dpm.model.ImageModel


class ImageAdapter(
    var ImageData: MutableList<ImageModel> = mutableListOf()
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        val view = ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_grid,
                parent,
                false
            )
        )
        return ImageAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        holder.bind(ImageData[position])
    }

    override fun getItemCount(): Int {
        return ImageData.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(image: ImageModel) {
            Glide.with(itemView).load(image.download_url).into()
        }
    }
}