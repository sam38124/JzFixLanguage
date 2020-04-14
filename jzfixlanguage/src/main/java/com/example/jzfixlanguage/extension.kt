package com.example.jzfixlanguage

import android.app.Dialog
import android.content.res.Resources
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.jzfixlanguage.function.Companion.getAllChildViews
import com.jzsql.lib.mmySql.Sql_Result

fun View.fixLanguage(){
    getAllChildViews(this)
    for(i in getAllChildViews(this)){
        Log.e("view","$i")
        if(i is TextView){
           i.text=i.text.toString().getFix()
        }else if(i is Button){
            i.text=i.text.toString().getFix()
        }else if(i is EditText){
            i.setText(i.text.toString().getFix())
            i.hint=i.hint.toString().getFix()
        }
    }
}

fun Resources.jzString(int:Int):String{
    val a=getString(int).getFix()
    return a
}

fun String.getFix():String{
        var b=this
        FixLanguage.newInstance.sqlHelper.query("select replto from fixlan where repl='${this.replace("'","")}'",
            Sql_Result {
                b=it.getString(0)
            })
        return b
}
