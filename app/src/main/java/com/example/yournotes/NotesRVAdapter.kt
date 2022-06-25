package com.example.yournotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener: NoteClickDeleteInterface,private val secondListener: NoteClickInterface) :
    RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    //passing data to adapter
    val allNote = ArrayList<Note>()


    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTV = itemView.findViewById<TextView>(R.id.idTVNote)
        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
        //NOtE: add the timesStamp
        val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)
    }

    //creates the items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder =
            NoteViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_note, parent, false))

        viewHolder.deleteIV.setOnClickListener { it: View ->
            listener.onDeleteIconClick(allNote[viewHolder.adapterPosition])

            viewHolder.itemView.setOnClickListener {
                secondListener.onNoteClick(allNote[viewHolder.adapterPosition])
            }
        }
        return viewHolder
    }

    //binds the data with the item
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       /*val currentNote = allNote[position]
        holder.noteTV.text = currentNote.noteTitle*/
        /*val secondNote = allNote[position]
        holder.textView.text = secondNote.text*/
        holder.noteTV.setText(allNote.get(position).noteTitle)
        holder.dateTV.setText("Last Updated : " + allNote.get(position).timesStamp)
    }

    //total number of items in the list
    override fun getItemCount(): Int {
        return allNote.size
    }
    fun updateList(newList: List<Note>){
        allNote.clear()
        allNote.addAll(newList)
        //updates the recyclerview
        notifyDataSetChanged()
}
}
//to handle clicks we need to create an interface
interface NoteClickDeleteInterface {
    fun onDeleteIconClick(note: Note)
}
interface NoteClickInterface{
    fun onNoteClick(note: Note)
}