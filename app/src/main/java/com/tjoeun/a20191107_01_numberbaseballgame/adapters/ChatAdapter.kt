package com.tjoeun.a20191107_01_numberbaseballgame.adapters

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.tjoeun.a20191107_01_numberbaseballgame.R
import com.tjoeun.a20191107_01_numberbaseballgame.datas.ChatData

class ChatAdapter(context:Context, res:Int, list:ArrayList<ChatData>)
    : ArrayAdapter<ChatData>(context, res, list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    constructor(context:Context, list:ArrayList<ChatData>) : this(context, R.layout.chat_list_item, list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.chat_list_item, null)
        }
//        tempRow가 null인 경우를 대비했으니, row에 tempRow는 절대 null 아니라고 하면서 대입.
        var row = tempRow!!

        var data = mList.get(position)

        var contentTxt = row.findViewById<TextView>(R.id.contentTxt)

        if (data.speaker == "CPU") {
            contentTxt.gravity = Gravity.LEFT
        }
        else {
            contentTxt.gravity = Gravity.RIGHT
        }

        contentTxt.text = data.message

        return row
    }

}