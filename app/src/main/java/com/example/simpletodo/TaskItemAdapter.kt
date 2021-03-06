package com.example.simpletodo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Tells the recyclerview how to display the data we give it
 */

class TaskItemAdapter(val listOfItems: List<String>) : RecyclerView.Adapter<TaskItemAdapter.ViewHolder>() {



    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context;
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val listView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        // Return a new holder instance
        return ViewHolder(listView)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return listOfItems.size
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Get the data model base on the position
        val item = listOfItems[position]
        holder.textView.text = item
    }



    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Store references to elements in our layout view
        val textView: TextView = itemView.findViewById(android.R.id.text1)


        init {
            itemView.setOnLongClickListener {

                Log.i("Dharel", "On LOng CLICK: $absoluteAdapterPosition")

                true
            }
        }

    }

}