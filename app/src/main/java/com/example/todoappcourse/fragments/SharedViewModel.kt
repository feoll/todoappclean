package com.example.todoappcourse.fragments

import android.app.Application
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.todoappcourse.R
import com.example.todoappcourse.data.models.Priority
import com.example.todoappcourse.data.models.ToDoData

class SharedViewModel(application: Application): AndroidViewModel(application) {

    val emptyDatabase: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkIfDatabaseEmpty(toDoData: List<ToDoData>) {
        emptyDatabase.value = toDoData.isEmpty()
    }

    private val context: Application = application

    val listener: AdapterView.OnItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(position) {
                0 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.red))}
                1 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.yellow))}
                2 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.green))}
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }

     fun verifyDataFromUser(title: String, description: String): Boolean =
        if(TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            false
        } else !(title.isEmpty() || description.isEmpty())

     fun parsePriority(priority: String): Priority {
        val priorities = context.resources.getStringArray(R.array.priorities)
        return when(priority) {
            priorities[0] -> {
                Priority.HIGH}
            priorities[1] -> {
                Priority.MEDIUM}
            priorities[2] -> {
                Priority.LOW}
            else -> Priority.LOW
        }
    }
}