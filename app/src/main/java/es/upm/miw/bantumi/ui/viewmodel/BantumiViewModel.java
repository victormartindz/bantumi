package es.upm.miw.bantumi.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import es.upm.miw.bantumi.dominio.logica.JuegoBantumi;

public class BantumiViewModel extends ViewModel {

    private ArrayList<MutableLiveData<Integer>> tablero;

    private MutableLiveData<JuegoBantumi.Turno> turno;

    public BantumiViewModel() {
        turno = new MutableLiveData<>(JuegoBantumi.Turno.turnoJ1);
        tablero = new ArrayList<>(JuegoBantumi.NUM_POSICIONES);
        for (int i = 0; i < JuegoBantumi.NUM_POSICIONES; i++) {
            tablero.add(i, new MutableLiveData<>(0));
        }
    }

    /**
     * @return Devuelve el turno actual
     */
    public LiveData<JuegoBantumi.Turno> getTurno() {
        return turno;
    }

    /**
     * Establece el valor para turno
     * @param turno valor
     */
    public void setTurno(JuegoBantumi.Turno turno) {
        this.turno.setValue(turno);
    }

    /**
     * Recupera el valor de una determinada posición
     *
     * @param pos posición
     * @return contenido de la posición <i>pos</i>
     */
    @NonNull
    public LiveData<Integer> getNumSemillas(int pos) {
        if (pos < 0 || pos >= JuegoBantumi.NUM_POSICIONES) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return tablero.get(pos);
    }

    /**
     * Asigna el valor v a la posición pos del tablero
     *
     * @param pos índice
     * @param v valor
     */
    public void setNumSemillas(int pos, int v) {
        if (pos < 0 || pos >= JuegoBantumi.NUM_POSICIONES) {
            throw new ArrayIndexOutOfBoundsException();
        }
        tablero.get(pos).setValue(v);
    }
}