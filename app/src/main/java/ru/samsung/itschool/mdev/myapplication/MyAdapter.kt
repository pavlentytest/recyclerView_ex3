package ru.samsung.itschool.mdev.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val list: List<Person>) : RecyclerView.Adapter<MyAdapter.MyView>() {

    class MyView(item: View) : RecyclerView.ViewHolder(item) {
        val tvName: TextView = item.findViewById(R.id.tvName)
        val tvNumber: TextView = item.findViewById(R.id.tvNumber)
        val imgSex: ImageView = item.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val myItem = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyView(myItem)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.tvName.text = list.get(position).name
        holder.tvNumber.text = list.get(position).phoneNumber
        holder.imgSex.setImageResource(
            when(list.get(position).sex) {
                'M' -> R.drawable.ic_baseline_man_24
                else -> R.drawable.ic_baseline_woman_24
            }
        )
    }

    override fun getItemCount() = list.size

}