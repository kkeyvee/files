package ru.edu.masu.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class Setts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setts)

        var buttonL: Button = findViewById(R.id.Light)
        var buttonD: Button = findViewById(R.id.Dark)
        var buttonC: Button = findViewById(R.id.Child)
        var lang: Switch = findViewById(R.id.Lang)

        buttonL.setOnClickListener{

        }
        buttonD.setOnClickListener{

        }
        buttonC.setOnClickListener{

        }
        lang.setOnClickListener{

        }
    }
}