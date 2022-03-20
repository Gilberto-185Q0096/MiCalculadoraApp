package edu.itsco.micalculadoraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var n1: Double = 0.0
    private var n2: Double = 0.0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_punto.setOnClickListener{
            pulsarNumero(".")
        }
        btn_cero.setOnClickListener{
            pulsarNumero("0")
        }
        btn_uno.setOnClickListener{
            pulsarNumero("1")
        }
        btn_dos.setOnClickListener{
            pulsarNumero("2")
        }
        btn_tres.setOnClickListener{
            pulsarNumero("3")
        }
        btn_cuatro.setOnClickListener{
            pulsarNumero("4")
        }
        btn_cinco.setOnClickListener{
            pulsarNumero("5")
        }
        btn_seis.setOnClickListener{
            pulsarNumero("6")
        }
        btn_siete.setOnClickListener{
            pulsarNumero("7")
        }
        btn_ocho.setOnClickListener{
            pulsarNumero("8")
        }
        btn_nueve.setOnClickListener{
            pulsarNumero("9")
        }

        btn_multiplicacion.setOnClickListener{
            pulsarOperacion(MULTIPLICACION)
        }
        btn_division.setOnClickListener{
            pulsarOperacion(DIVISION)
        }
        btn_resta.setOnClickListener{
            pulsarOperacion(RESTA)
        }
        btn_suma.setOnClickListener{
            pulsarOperacion(SUMA)
        }
        btn_borrar.setOnClickListener{
            limpiarTodo()
        }
        btn_calcular.setOnClickListener{
            var calcular =
                when(operacion){
                    MULTIPLICACION -> n1 * n2
                    DIVISION -> n1 / n2
                    RESTA -> n1 - n2
                    SUMA -> n1 + n2
                else
                    -> 0
                }
            n1 = calcular as Double
            lb_resultado.text = if("$calcular".endsWith(".0")){
                "$calcular".replace(".0","")
            }
            else{
                "%.2f".format(calcular)
            }
        }
    }

    private fun pulsarOperacion(operacion: Int){
        this.operacion = operacion

        lb_resultado.text = "0"
    }

    companion object{
        const val SIN_OPERACION = 0
        const val MULTIPLICACION = 1
        const val DIVISION = 2
        const val RESTA = 3
        const val SUMA = 4
    }

    private fun pulsarNumero(cifra:String){
        if (lb_resultado.text == "0" && cifra != "."){
            lb_resultado.text ="$cifra"
        }
        else {
            lb_resultado.text = "${lb_resultado.text}$cifra"
        }

        if (operacion == SIN_OPERACION){
            n1 = lb_resultado.text.toString().toDouble()
        }
        else{
            n2 = lb_resultado.text.toString().toDouble()
        }
    }

    private fun limpiarTodo(){
        n1 = 0.0
        n2 = 0.0
        lb_resultado.text = "0"
        operacion = SIN_OPERACION
    }
}