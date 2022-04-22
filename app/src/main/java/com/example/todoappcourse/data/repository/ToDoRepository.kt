package com.example.todoappcourse.data.repository

import androidx.lifecycle.LiveData
import com.example.todoappcourse.data.ToDoDAO
import com.example.todoappcourse.data.models.ToDoData

class ToDoRepository(private val toDoDAO: ToDoDAO) {

    val getAllData: LiveData<List<ToDoData>> = toDoDAO.getAllData()
    val sortByHighPriority: LiveData<List<ToDoData>> = toDoDAO.sortByHighPriority()
    val sortByLowPriority: LiveData<List<ToDoData>> = toDoDAO.sortByLowPriority()

    suspend fun insertData(toDoData: ToDoData): Long {
        return toDoDAO.insertData(toDoData)
    }

    suspend fun updateData(toDoData: ToDoData): Int {
        return toDoDAO.updateData(toDoData)
    }

    suspend fun deleteData(toDoData: ToDoData): Int {
        return toDoDAO.deleteData(toDoData)
    }

    suspend fun deleteAll() {
        toDoDAO.deleteAll()
    }

    fun searchDatabase(searchQuery: String): LiveData<List<ToDoData>> {
        return toDoDAO.searchDatabase(searchQuery)
    }
}