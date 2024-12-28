package com.example.spotify.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.spotify.SongsListActivity
import com.example.spotify.databinding.CategoryItemRecyclerRowBinding
import com.example.spotify.models.CategoryModel

class CategoryAdapter (private val categoryList: List<CategoryModel>):
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding: CategoryItemRecyclerRowBinding):
        RecyclerView.ViewHolder(binding.root){
            // bind the data with views
            fun bindData(category :CategoryModel){
                binding.nameTextView.text=category.name
                Glide.with(binding.coverImageView).load(category.coverUrl)
                    .apply(
                        RequestOptions().transform(RoundedCorners(32))
                    )

                    .into(binding.coverImageView)
                //start songsList Activity
                val context =binding.root.context
                binding.root.setOnClickListener{
                    SongsListActivity.category=category
                    context.startActivity(Intent(context,SongsListActivity::class.java))
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=CategoryItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(categoryList[position])
    }
}