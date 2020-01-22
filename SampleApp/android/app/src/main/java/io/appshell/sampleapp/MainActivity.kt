package io.appshell.sampleapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import io.appshell.shell.web.WebActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = ItemsAdapter(this, listOf(
            Item(R.drawable.icon_h5, "WebView") {
                startActivity(Intent(this, WebActivity::class.java))
            },
            Item(R.drawable.icon_react, "React Native") {

            }
        ))
        rv_main.adapter?.notifyDataSetChanged()
    }

    private data class Item(val icon: Int, val title: String, val onClick: () -> Unit)

    private class ItemsAdapter(
        private val context: Activity,
        private val itemList: List<Item>
    ) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ItemViewHolder {
            val rootView: View = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
            return ItemViewHolder(rootView)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = itemList[position]
            holder.rootView.setOnClickListener {
                item.onClick()
            }
            holder.iv_icon.setImageResource(item.icon)
            holder.tv_title.text = item.title
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        internal class ItemViewHolder(val rootView: View) : RecyclerView.ViewHolder(rootView) {

            val iv_icon: ImageView = itemView.findViewById(R.id.iv_icon)
            val tv_title: TextView = itemView.findViewById(R.id.tv_title)

        }
    }
}
