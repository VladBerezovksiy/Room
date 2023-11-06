package com.example.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskListAdapter(var items: List<Task> = emptyList()) :
    RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val listItemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return TaskViewHolder(listItemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.desc.text = items[position].description
    }

    fun updateItems(itemsToUpdate: List<Task>){
        items = itemsToUpdate
        notifyDataSetChanged()
    }
}

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.name)
    val desc: TextView = itemView.findViewById(R.id.description)
}