package quock.kotlinfirstapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.adapter_layout.view.*

/**
 * Created by altaf.h.shaikh on 6/6/2017.
 */
class DataAdapter(var mItems : MutableList<Data>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private val mOnclickListener: View.OnClickListener;

    init {
        mOnclickListener = View.OnClickListener { v ->
            val item = v .tag as Data;
            Log.d("data",item.toString());
        }
    }


    fun Context.toast(message : CharSequence) =
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var name = mItems[position].name;
        var detail = mItems[position].description;
        holder.textView1.text = name;
        holder.textView2.text =  detail;

        with(holder.container){
            tag = mItems[position]
            setOnClickListener(mOnclickListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val layoutInflator = LayoutInflater.from(parent.context);
        return ViewHolder(layoutInflator.inflate(R.layout.adapter_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return mItems.size;
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView1 = view.textView1;
        val textView2 = view.textView2;
        val container = view.container;
    }

}

