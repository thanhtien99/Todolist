package com.example.managework.mvvmtodolist.repository

import androidx.lifecycle.LiveData
import com.example.managework.mvvmtodolist.database.TaskDao
import com.example.managework.mvvmtodolist.database.TaskEntry

class TaskRepository(val taskDao: TaskDao) {

    suspend fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)

    suspend fun updateData(taskEntry: TaskEntry) = taskDao.update(taskEntry)

    suspend fun deletaItem(taskEntry: TaskEntry) = taskDao.delete(taskEntry)

    suspend fun deleteAll() {
        taskDao.deletaAll()
    }

    fun getAllTasks(): LiveData<List<TaskEntry>> = taskDao.getAllTasks()

    fun getAllPriorityTasks(): LiveData<List<TaskEntry>> = taskDao.getAllPriorityTasks()

    fun searchDatabase(searchQuery: String): LiveData<List<TaskEntry>> {
        return taskDao.searchDatabase(searchQuery)
    }
}