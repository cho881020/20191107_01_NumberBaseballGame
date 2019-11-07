package com.tjoeun.a20191107_01_numberbaseballgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tjoeun.a20191107_01_numberbaseballgame.adapters.ChatAdapter
import com.tjoeun.a20191107_01_numberbaseballgame.datas.ChatData
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : BaseActivity() {

//    471 => 4,7,1

    var chatList = ArrayList<ChatData>()
    var chatAdapter:ChatAdapter? = null

    var questionNumArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
        createQuestion()
    }

    fun createQuestion() {
        while (true) {
            val number = Random.nextInt(1, 10)

            if (!questionNumArray.contains(number)) {
                questionNumArray.add(number)
            }

            if (questionNumArray.size == 3) {
                break
            }

        }

        for (num in questionNumArray) {
            Log.d("출제숫자", num.toString())
        }


    }

    override fun setupEvents() {

        inputBtn.setOnClickListener {
            var inputNum = inputEdt.text.toString()
            chatList.add(ChatData(inputNum, "ME"))

            chatAdapter?.notifyDataSetChanged()

            chatListView.smoothScrollToPosition(chatList.size - 1)
        }

    }

    override fun setValues() {
        chatAdapter = ChatAdapter(this, chatList)
        chatListView.adapter = chatAdapter
    }


}
