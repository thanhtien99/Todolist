package com.example.managework.mvvmtodolist.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Insert
    suspend fun insert(taskEntry: TaskEntry)

    @Delete
    suspend fun delete(taskEntry: TaskEntry)

    @Update
    suspend fun update(taskEntry: TaskEntry)

    @Query("DELETE FROM task_table")
    suspend fun deletaAll()

    @Query("SELECT * FROM task_table ORDER BY timestamp DESC")
    fun getAllTasks(): LiveData<List<TaskEntry>>

    @Query("SELECT * FROM task_table ORDER BY priority ASC")
    fun getAllPriorityTasks(): LiveData<List<TaskEntry>>

    @Query("SELECT * FROM task_table WHERE title LIKE :searchQuery ORDER BY timestamp DESC")
    fun searchDatabase(searchQuery: String): LiveData<List<TaskEntry>>
}