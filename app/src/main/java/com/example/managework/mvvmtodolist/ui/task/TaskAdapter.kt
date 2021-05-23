package com.example.managework.mvvmtodolist.ui.task

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.managework.databinding.RowLayoutBinding
import com.example.managework.mvvmtodolist.database.TaskEntry

class TaskAdapter(val clickListener: TaskClickListener) : ListAdapter<TaskEntry, TaskAdapter.ViewHolder>(TaskDiffCallback) {

    companion object TaskDiffCallback : DiffUtil.ItemCallback<TaskEntry>() {
        override fun areItemsTheSame(oldItem: TaskEntry, newItem: TaskEntry) = oldItem.id == newItem.id
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: TaskEntry, newItem: TaskEntry) = oldItem == newItem
    }

    class ViewHolder(val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(taskEntry: TaskEntry, clickListener: TaskClickListener){
            binding.taskEntry = taskEntry
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current, clickListener)
    }

}

class TaskClickListener(val clickListener: (taskEntry: TaskEntry) -> Unit){
    fun onClick(taskEntry: TaskEntry) = clickListener(taskEntry)
}