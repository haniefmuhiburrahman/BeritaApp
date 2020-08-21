package com.hanief.beritaapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hanief.beritaapp.R
import com.hanief.beritaapp.activity.DetailActivity
import com.hanief.beritaapp.model.Berita
import kotlinx.android.synthetic.main.item_berita.view.*

class BeritaAdapter(var data: ArrayList<Berita>?) : RecyclerView.Adapter<BeritaAdapter.BeritaHolder>() {
    class BeritaHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivPhoto = itemView.iv_photo
        val tvAuthor = itemView.tv_author
        val tvTitle = itemView.tv_title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent,false)

        val holder = BeritaHolder(view)

        return holder
    }

    override fun getItemCount(): Int {

        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: BeritaHolder, position: Int) {

        holder.tvAuthor.text = data?.get(position)?.author
        holder.tvTitle.text = data?.get(position)?.title

        Glide.with(holder.itemView.context).load(data?.get(position)?.urlToImage).into(holder.ivPhoto)

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("title", data?.get(position)?.title)
            intent.putExtra("author", data?.get(position)?.author)
            intent.putExtra("description", data?.get(position)?.description)
            intent.putExtra("photo", data?.get(position)?.urlToImage)

            holder.itemView.context.startActivity(intent)
        }
    }
}