package com.example.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert
    fun add(task: Task)

    @Delete
    fun remove(task: Task)

    @Query("SELECT * FROM task")
    fun getAll(): LiveData<List<Task>>
    
}