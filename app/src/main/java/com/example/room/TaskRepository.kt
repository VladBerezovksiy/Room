package com.example.room

import java.util.concurrent.Executors

class TaskRepository(private val database: TaskDatabase) {

    private val executor = Executors.newSingleThreadExecutor()

    fun getAll() = database.taskDao().getAll()

    fun add(task: Task) {
        executor.execute {
            database.taskDao().add(task)
        }
    }

    fun remove(task: Task) {
        executor.execute {
            database.taskDao().remove(task)
        }
    }

}