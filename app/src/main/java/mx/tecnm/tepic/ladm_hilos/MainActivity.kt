package mx.tecnm.tepic.ladm_hilos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var contador = 1
    var hilo : Hilo?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hilo = Hilo(this)

        button.setOnClickListener{
            if(hilo!!.estaIniciado()){
                Mensaje("Error, el hilo ya esta iniciado")
                return@setOnClickListener
            }
            hilo?.start()
        }

        button2.setOnClickListener{
            hilo?.pausar()
        }

        button3.setOnClickListener{
            hilo?.despausar()
        }

        button4.setOnClickListener{
            hilo?.reiniciar()
            contador=0
        }

        button5.setOnClickListener{
            hilo?.detener()
        }


    }

    private fun Mensaje (s: String){
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("ATENCION")
            .setPositiveButton("OK"){d,i->}
            .show()
    }

}