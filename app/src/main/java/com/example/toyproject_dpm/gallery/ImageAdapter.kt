package com.example.toyproject_dpm.gallery

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.toyproject_dpm.databinding.ItemGridBinding
import com.example.toyproject_dpm.model.ImageModel


class ImageAdapter() : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    lateinit var ImageData: ArrayList<ImageModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemGridBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ImageData[position])
    }

    override fun getItemCount(): Int {
        return ImageData.size
    }

    class ViewHolder(
        private val binding: ItemGridBinding
        ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: ImageModel) {
            Glide.with(itemView).load(image.download_url).into(binding.imageView)
        }
    }
}