package com.hjdeveloper.smartbar.ClassUtilitary;

/**
 * Created by Developer on 04/04/2017.
 */

import android.text.Editable;
import android.text.TextWatcher;

public class TextWatcherSinCero implements TextWatcher {
    public TextWatcherSinCero() {
    }

    public void afterTextChanged(Editable editable) {
        if(editable.length() > 1 && editable.charAt(0) == 48) {
            editable.replace(0, 1, "");
        }

    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
}