package com.example.smsapplication

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSmsIndox()
    }

    private fun getSmsIndox() {
        val  uriSms: Uri = Uri.parse("content://sms/inbox")
        val dataCursor : Cursor ?= contentResolver.query(uriSms, null, null, null, null)

        var from = arrayOf("body")
        var to = intArrayOf(android.R.id.text1)
        var adapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_1,
             dataCursor,
               from,to)
         var dataListView : ListView = findViewById(R.id.cpListv)
        dataListView.adapter = adapter
    }
}