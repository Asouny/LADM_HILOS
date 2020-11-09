package mx.tecnm.tepic.ladm_hilos

import kotlinx.android.synthetic.main.activity_main.*

class Hilo (p:MainActivity) : Thread(){
    private var iniciado = false
    private var  puntero = p
    private var pausa = false

    override fun run(){
        super.run()
        iniciado = true

        while(iniciado == true){
            sleep(200)
            if(pausa==false){
                puntero.runOnUiThread{
                    puntero.textView.setText(puntero.contador.toString())
                    puntero.contador++
                }
            }
        }
    }

    fun estaIniciado(): Boolean {
        return iniciado
    }

    fun pausar(){
        pausa = true
    }

    fun despausar(){
        pausa = false
    }

    fun detener(){
        iniciado = false
    }

    fun reiniciar(){
        puntero.textView.setText("0")
    }

}