package ru.edu.masu.calculator

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zer.setOnClickListener {setTextFields("0")}
        one.setOnClickListener {setTextFields("1")}
        two.setOnClickListener {setTextFields("2")}
        thr.setOnClickListener {setTextFields("3")}
        fou.setOnClickListener {setTextFields("4")}
        fiv.setOnClickListener {setTextFields("5")}
        six.setOnClickListener {setTextFields("6")}
        sev.setOnClickListener {setTextFields("7")}
        eig.setOnClickListener {setTextFields("8")}
        nin.setOnClickListener {setTextFields("9")}

        div.setOnClickListener {setTextFields("/")}
        mul.setOnClickListener {setTextFields("*")}
        plu.setOnClickListener {setTextFields("+")}
        min.setOnClickListener {setTextFields("-")}
        lef.setOnClickListener {setTextFields("(")}
        rig.setOnClickListener {setTextFields(")")}

        cle.setOnClickListener {
            action.text=""
            result.text=""
        }

        und.setOnClickListener {
            val str = action.text.toString()
            if(str.isNotEmpty())
                action.text = str.substring(0, str.length-1)
            result.text=""
        }

        equ.setOnClickListener {
            try {
                val ex = ExpressionBuilder(action.text.toString()).build()
                val whatwehave = ex.evaluate()

                val longRes = whatwehave.toLong()
                if(whatwehave==longRes.toDouble())
                    result.text=longRes.toString()
                else
                    result.text=whatwehave.toString()
            } catch(e:Exception) {
                Log.d("Ошибка", "${e.message}")
            }
        }

        abs.setOnClickListener {
            setTextFields("abs(")
        }
        pow.setOnClickListener {
            setTextFields("^")
        }
        sinn.setOnClickListener {
            setTextFields("sin(")
        }
        coss.setOnClickListener {
            setTextFields("cos(")
        }
        tan.setOnClickListener {
            setTextFields("tan(")
        }
        to8.setOnClickListener {
            var number = action.text
            if (number.isNotEmpty()) {
                var intt = number.toString()
                setTextFields((intt.toIntOrNull())?.toString(8) ?: "")
            }

        }
        to7.setOnClickListener {
            var number = action.text
            if (number.isNotEmpty()) {
                var intt = number.toString()
                setTextFields((intt.toIntOrNull())?.toString(7) ?: "")
            }
        }
        to6.setOnClickListener {
            var number = action.text
            if (number.isNotEmpty()) {
                var intt = number.toString()
                setTextFields((intt.toIntOrNull())?.toString(6) ?: "")
            }
        }
        to5.setOnClickListener {
            var number = action.text
            if (number.isNotEmpty()) {
                var intt = number.toString()
                setTextFields((intt.toIntOrNull())?.toString(5) ?: "")
            }
        }
        to4.setOnClickListener {
            var number = action.text
            if (number.isNotEmpty()) {
                var intt = number.toString()
                setTextFields((intt.toIntOrNull())?.toString(4) ?: "")
            }
        }
        to3.setOnClickListener {
            var number = action.text
            if (number.isNotEmpty()) {
                var intt = number.toString()
                setTextFields((intt.toIntOrNull())?.toString(3) ?: "")
            }
        }
        to2.setOnClickListener {
            var number = action.text
            if (number.isNotEmpty()) {
                var intt = number.toString()
                setTextFields((intt.toIntOrNull())?.toString(2) ?: "")
            }
        }
        mode.setOnClickListener {
            if (mode.text=="Science") {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                mode.text = "Simple"
            }
            else {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                mode.text="Science"
            }
        }
        info.setOnClickListener{
            OpenSetts()
        }




    }

    fun setTextFields(str: String) {
        if(result.text != ""){
            action.text=result.text
            result.text=""
        }
        action.append(str)

    }

    private fun OpenSetts() {
        val intent = Intent(this, Setts::class.java)
        startActivity(intent)
    }
}