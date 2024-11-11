import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_newsapp.R
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

//Step 1 - JB adapter class banayi tb usko data aur context denge then Recyclerview.Adapter se extend krenge
// ab ye Recycle view jis se extend kra hai na w0 ek view holder mangega jo ki isi class me bna lemge isi function ke hm alag se bhi bna skte hai iski class
class MyAdapter(var newsArrayList : ArrayList<News> ,val listner : setOnItemClickListner, var context : Activity) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    interface setOnItemClickListner{
        fun onItemClicked(ArrayList: News , position: Int)
    }
    // it holds the view so views are created every time , so memory can be saved

    // Step 2 - ViewHolder class bnayenge jo ki recycler view ke viewholder ko extend krega
    // iske andr ek view pass krenge
    // aur ye view holder hme power dega ki hm wo data set kre jo dikhana chahte hai
    // jb view holder ki class bna lenge to kaam ho jayega but Recycler view ka adapter class ko ni iske object ko call krega
    // jo ki hm onCreateViewHolder ke andr bnayenege

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hTittle = itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        // To create new view instance when layout manager fails top find a suitable view for a listitem

        // Step 3 - jo bhi hmne eachitem ka layout file bnaya hai usko inflate krenge
        // Infaltor xml ko java object me convert krta hai jo ki us layout ko yaha se accessible bnata hai
        // Parent ye function leke aya tha khud to usi ka context de denge
        // fir jb MyViewHolder ko ye irem deke return kr denge
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachitem,parent,false)
        val viewholder =  MyViewHolder(itemView)
           itemView.setOnClickListener{
               listner.onItemClicked(newsArrayList[viewholder.adapterPosition],viewholder.adapterPosition)
           }
        return viewholder
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        // Populate item with data
        // Step 4-bindVIewHolder data pass krega main list me yaaha se
        var currItem = newsArrayList[position]
        holder.hTittle.setText(currItem.newsHeading)
        holder.hImage.setImageResource(currItem.newsImage)


    }

    override fun getItemCount(): Int {
        // how many list items are present in array
        return newsArrayList.size
    }

}