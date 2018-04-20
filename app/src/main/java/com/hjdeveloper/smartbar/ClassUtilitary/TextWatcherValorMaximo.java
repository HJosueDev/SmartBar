package com.hjdeveloper.smartbar.ClassUtilitary;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Developer on 04/04/2017.
 */

public class TextWatcherValorMaximo implements TextWatcher {

    private int valorMaximo;

    public TextWatcherValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public TextWatcherValorMaximo(TextWatcherValorMaximo textWatcher) {
        this.valorMaximo = textWatcher.valorMaximo;
    }

    public void afterTextChanged(Editable editable) {
        try {
            int numero = Integer.parseInt(editable.toString());
            if(numero > this.valorMaximo) {
                editable.replace(0, editable.length(), String.valueOf(this.valorMaximo));
            }
        } catch (NumberFormatException var3) {
            ;
        }

    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public int hashCode() {
        boolean prime = true;
        byte result = 1;
        int result1 = 31 * result + this.valorMaximo;
        return result1;
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            TextWatcherValorMaximo other = (TextWatcherValorMaximo)obj;
            return this.valorMaximo == other.valorMaximo;
        }
    }
}
