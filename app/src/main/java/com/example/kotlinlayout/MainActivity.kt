package com.example.kotlinlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayout = findViewById(R.id.MainLinearLayout) as LinearLayout    // レイアウトファイルにあるレイアウトのidを指定して読み込みます
        linearLayout.gravity = Gravity.CENTER   // 画面中央寄せ

        /*** textView ***/
        val text = TextView(this)
        text.text = "textViewサンプル"
        text.gravity = Gravity.CENTER
        text.textSize = 35F

        linearLayout.addView(text)  // レイアウトファイルにテキストビューを追加します

        /*** RadioButton ***/
        val radioGroup = RadioGroup(this)
        radioGroup.gravity = Gravity.CENTER
        radioGroup.orientation = RadioGroup.VERTICAL

        val list: List<String> = listOf("サンプル1", "サンプル2", "サンプル3", "サンプル4", "サンプル5")

        list.forEach{
            val radioButton = RadioButton(this)
            radioButton.text = it
            radioButton.setPadding(0, 30, 0, 30)
            radioGroup.addView(radioButton) // radioGroupにradioButtonを追加する
            if(it.equals(list[0])){
                radioButton.isChecked = true
            }
        }

        linearLayout.addView(radioGroup)

        /*** Button ***/
        val button = Button(this)
        button.text = "Buttonサンプル"

        linearLayout.addView(button)

        button.setOnClickListener {     // Buttonがクリックされた時
            val id: Int = radioGroup.checkedRadioButtonId
            val radiotext: String = radioGroup.findViewById<RadioButton>(id).text.toString()

            val builder = AlertDialog.Builder(this@MainActivity)
            builder
                .setMessage(radiotext)
            builder.create().show()
        }
    }
}
