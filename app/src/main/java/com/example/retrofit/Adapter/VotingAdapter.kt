package com.example.retrofit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Model.Voting
import com.example.retrofit.R
import kotlinx.android.synthetic.main.voting_item.view.*

class VotingAdapter(var votingList:ArrayList<Voting>):RecyclerView.Adapter<VotingAdapter.VotingViewHolder>() {
    var mClickListener: ClickListener? = null
    fun setClickListener(clickListener: ClickListener) {
        this.mClickListener = clickListener
    }
    inner class VotingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        private lateinit var voting:Voting
        init {
            itemView.setOnClickListener(this)
        }
        fun bind (voting:Voting) {
            this.voting=voting
            itemView.txt_ClassName.text=voting.classRoom
                itemView.txt_name.text=voting.name
        }

        override fun onClick(view: View?) {
            mClickListener?.onClick(voting)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VotingViewHolder {
        return VotingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.voting_item,parent,false))
    }

    override fun getItemCount(): Int {
       return votingList.size
    }

    override fun onBindViewHolder(holder: VotingViewHolder, position: Int) {
        holder.bind(votingList[position])
    }
    interface ClickListener{
        fun onClick(voting:Voting)
    }

}