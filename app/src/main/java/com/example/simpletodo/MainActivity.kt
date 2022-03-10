package com.example.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val listOfTask = mutableListOf<String>()
    lateinit var adapter: TaskItemAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onLongClickListener = object : TaskItemAdapter.OnLongClickListener {
            override fun onItemLongClicked(position: Int) {
                //1. Remove the item from the list
                listOfTask.removeAt(position)

                //2. Notify the adapter that our data set has changed
                adapter.notifyDataSetChanged()
            }

        }



        listOfTask.add("Walk the puppies")
        listOfTask.add("Bath the puppies")

        // Lookup the recyclerview in activity layout
        val rvTasks = findViewById<View>(R.id.recyclerview_toDoList) as RecyclerView

        //Create adapter passing the fake list 
        adapter = TaskItemAdapter(listOfTask, onLongClickListener)

        //Attach the adapter to the recyclerview to populate items
        rvTasks.adapter = adapter


        //Set layout manager to position the items
        rvTasks.layoutManager = LinearLayoutManager(this)

        //Set up the button and input field, so that the user can enter a task and add it to the list

         val inputTextField = findViewById<EditText>(R.id.addTaskField)

         findViewById<Button>(R.id.addTaskButton).setOnClickListener {

            //1. Grab the text the user has inputted into @+id/addTaskField
              val userInputtedText = inputTextField.text.toString()

            //2. Add the string to the list of task: listOfTasks
            listOfTask.add(userInputtedText)

            //3. Notify the adapter that our data has been updated
             adapter.notifyItemInserted(listOfTask.size-1)

            //4. Reset the text field
             inputTextField.setText("")

         }

    }
}