package kg.tutorial.freshmarch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(val context: Context, val items: ArrayList<UserModelClass>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_user_layout,
                parent,
                false
            )
        )
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)

        holder.tvFirstName.text = item.first_name
        holder.tvPhoto.text = item.photo
        holder.tvSecondName.text = item.second_name
        holder.tvEducation.text = item.education.toString()
        holder.tvName.text = item.name
        holder.tvPosition.text = item.position
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val tvFirstName: TextView = itemView.findViewById<View>(R.id.tv_firstname) as TextView
        val tvPhoto: TextView = itemView.findViewById<View>(R.id.tv_photo) as TextView
        val tvSecondName: TextView = itemView.findViewById<View>(R.id.tv_second_name) as TextView
        val tvEducation: TextView = itemView.findViewById<View>(R.id.tv_education) as TextView
        val tvName: TextView = itemView.findViewById<View>(R.id.tv_name_one) as TextView
        val tvPosition: TextView = itemView.findViewById<View>(R.id.tv_position_one) as TextView


    }
}




