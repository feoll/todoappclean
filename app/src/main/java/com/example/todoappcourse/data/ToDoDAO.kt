package com.example.todoappcourse.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todoappcourse.data.models.ToDoData

@Dao
interface ToDoDAO {
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData(): LiveData<List<ToDoData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(toDoData: ToDoData): Long

    @Update
    suspend fun updateData(toDoData: ToDoData): Int

    @Delete
    suspend fun deleteData(toDoData: ToDoData): Int

    @Query("DELETE FROM todo_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): LiveData<List<ToDoData>>
}