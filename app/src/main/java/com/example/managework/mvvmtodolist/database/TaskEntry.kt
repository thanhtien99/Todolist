package com.example.managework.mvvmtodolist.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@kotlinx.android.parcel.Parcelize
@Entity(tableName = "task_table")
class TaskEntry (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: Int,
    var timestamp: Long,

):Parcelable
