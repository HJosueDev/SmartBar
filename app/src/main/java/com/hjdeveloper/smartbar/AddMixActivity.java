package com.hjdeveloper.smartbar;


import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.hjdeveloper.smartbar.ClassUtilitary.TextWatcherValorMaximo;

public class AddMixActivity extends AppCompatActivity {

    private EditText editText_nombre;
    private EditText editText_capacidadRecipiente;

    private SeekBar[] seekBars_porcentajes;

    private EditText[] editTexts_porcentajes;
    private EditText[] editTexts_cantidades;
    private TextView textView_porcentajeTotal;
    private TextView textView_cantidadTotal;
    private TextWatcherValorMaximo textWatcher_cantidades;
    //public static final String EXTRA_MEZCLA_NUEVA = "dese.coctelera.MEZCLA_NUEVA";

    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mix);



        this.editText_nombre = (EditText)this.findViewById(R.id.editText_nombre);
        this.editText_capacidadRecipiente = (EditText)findViewById(R.id.editText_capacidadRecipiente);
        this.seekBars_porcentajes = this.obtenerSeekBarsPorcentajes();
        this.editTexts_porcentajes = this.obtenerEditTextsPorcentajes();
        this.editTexts_cantidades = this.obtenerEditTextsCantidades();
        this.textView_porcentajeTotal = (TextView)this.findViewById(R.id.textView_porcentajeTotal);
        this.textView_cantidadTotal = (TextView)this.findViewById(R.id.textView_cantidadTotal);


        btnSalvar=(Button) findViewById(R.id.button_aceptar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarDatos();
            }
        });

        actionSeekBars_porcentajes();
    }


    private void actionSeekBars_porcentajes(){
        seekBars_porcentajes[0].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                editTexts_porcentajes[0].setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                ActionSeekBar(0);
            }
        });


        seekBars_porcentajes[1].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                editTexts_porcentajes[1].setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                ActionSeekBar(1);
            }
        });


        seekBars_porcentajes[2].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                editTexts_porcentajes[2].setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                ActionSeekBar(2);
            }
        });


        seekBars_porcentajes[3].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                editTexts_porcentajes[3].setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
                ActionSeekBar(3);
            }
        });



    }


    private void ActionSeekBar(int indice){
        if (Integer.parseInt(editText_capacidadRecipiente.getText().toString())==0){
            showAletMessage("Alerta","Cantidad de Bebida Incorrecta,\n¿Desea cambiarla?");
            seekBars_porcentajes[indice].setProgress(0);
            editText_capacidadRecipiente.requestFocus();
        }
        else if(Integer.parseInt(textView_porcentajeTotal.getText().toString())>100){
            showAletMessage("Alerta","Esta sobrepasando el limite del vaso,\n¿Desea Reducirlo?");
            seekBars_porcentajes[indice].requestFocus();
            textView_porcentajeTotal.setTextColor(Color.RED);
            this.textView_porcentajeTotal.setText(String.valueOf(getTotalPorcentage()));
            this.editTexts_cantidades[indice].setText(
                    String.valueOf(getPorcentageMl(
                            Integer.parseInt(editText_capacidadRecipiente.getText().toString()),
                            Integer.parseInt(editTexts_porcentajes[indice].getText().toString()))
                    ));
        }
        else{
            this.textView_porcentajeTotal.setText(String.valueOf(getTotalPorcentage()));
            this.editTexts_cantidades[indice].setText(
                    String.valueOf(getPorcentageMl(
                            Integer.parseInt(editText_capacidadRecipiente.getText().toString()),
                            Integer.parseInt(editTexts_porcentajes[indice].getText().toString()))
            ));
            //this.editTexts_cantidades[indice].setText("25");
            textView_porcentajeTotal.setTextColor(Color.BLACK);
        }
    }




    private void guardarDatos(){

    }

    private SeekBar[] obtenerSeekBarsPorcentajes() {
        SeekBar[] seekBars_porcentajes = new SeekBar[]{
                (SeekBar)this.findViewById(R.id.seekBar_porcentajeL1),
                (SeekBar)this.findViewById(R.id.seekBar_porcentajeL2),
                (SeekBar)this.findViewById(R.id.seekBar_porcentajeL3),
                (SeekBar)this.findViewById(R.id.seekBar_porcentajeL4)};
        return seekBars_porcentajes;
    }


    private EditText[] obtenerEditTextsPorcentajes() {
        EditText[] editTexts_porcentajes = new EditText[]{
                (EditText)this.findViewById(R.id.editText_porcentajeL1),
                (EditText)this.findViewById(R.id.editText_porcentajeL2),
                (EditText)this.findViewById(R.id.editText_porcentajeL3),
                (EditText)this.findViewById(R.id.editText_porcentajeL4)};

        return editTexts_porcentajes;
    }


    private EditText[] obtenerEditTextsCantidades() {
        EditText[] editTexts_cantidades = new EditText[]{
                (EditText)this.findViewById(R.id.editText_cantidadL1),
                (EditText)this.findViewById(R.id.editText_cantidadL2),
                (EditText)this.findViewById(R.id.editText_cantidadL3),
                (EditText)this.findViewById(R.id.editText_cantidadL4)};

        return editTexts_cantidades;
    }


    private int getPorcentageMl(int base, int porcentageDrink){
        int porcentageMl=porcentageDrink/100*base;
        return porcentageMl;
    }

    private int getTotalPorcentage(){
        int sumaTotalPorcentajes=0;
        for (int i=0; i<editTexts_porcentajes.length; i++){
            sumaTotalPorcentajes=sumaTotalPorcentajes+Integer.parseInt(editTexts_porcentajes[i].getText().toString());
        }
        return sumaTotalPorcentajes;
    }

    /*
    private void registrarListenersEditTexts() {

        this.editText_capacidadRecipiente.setOnFocusChangeListener(this);
        this.editText_capacidadRecipiente.setOnFocusChangeListener(this);

        for(int i = 0; i < this.editTexts_porcentajes.length; ++i) {
            this.editTexts_porcentajes[i].setOnFocusChangeListener(this);
            this.editTexts_cantidades[i].setOnFocusChangeListener(this);
        }

    }

    private void registrarListenersSeekBars() {
        for(int i = 0; i < this.seekBars_porcentajes.length; ++i) {
            this.seekBars_porcentajes[i].setOnSeekBarChangeListener(this);
        }

    }
*/
    /*
    private void registrarTextWatchersValorMaximoEditTextsPorcentajes() {
        TextWatcherValorMaximo textWatcher_porcentajes = new TextWatcherValorMaximo(100);

        for(int i = 0; i < this.editTexts_porcentajes.length; ++i) {
            this.editTexts_porcentajes[i].addTextChangedListener(textWatcher_porcentajes);
        }

    }

    private void registrarTextWatchersValorMaximoEditTextsCantidades() {
        TextWatcherValorMaximo textWatcher_cantidadesAnterior = new TextWatcherValorMaximo(this.textWatcher_cantidades);
        this.textWatcher_cantidades = new TextWatcherValorMaximo(this.obtenerValor(this.editText_capacidadRecipiente));

        for(int i = 0; i < this.editTexts_cantidades.length; ++i) {
            this.editTexts_cantidades[i].removeTextChangedListener(textWatcher_cantidadesAnterior);
            this.editTexts_cantidades[i].addTextChangedListener(this.textWatcher_cantidades);
        }

    }

    private void registrarTextWatcherSinCerosEditTexts() {
        TextWatcherSinCero textWatcher_sinCeros = new TextWatcherSinCero();
        this.editText_capacidadRecipiente.addTextChangedListener(textWatcher_sinCeros);

        for(int i = 0; i < this.editTexts_porcentajes.length; ++i) {
            this.editTexts_porcentajes[i].addTextChangedListener(textWatcher_sinCeros);
            this.editTexts_cantidades[i].addTextChangedListener(textWatcher_sinCeros);
        }

    }

    private void actualizarTextView(TextView textView, int[] valores, int valorMaximo) {
        int sumatorio = 0;

        for(int i = 0; i < valores.length; ++i) {
            sumatorio += valores[i];
        }
        if(sumatorio <= valorMaximo) {
            textView.setTextColor(Color.RED);
        } else {
            textView.setTextColor(Color.BLACK);
        }

        textView.setText(String.valueOf(sumatorio));
    }



    private void actualizarTextViewsTotales() {
        this.actualizarTextView(this.textView_porcentajeTotal, this.obtenerPorcentajes(), 100);
        this.actualizarTextView(this.textView_cantidadTotal, this.obtenerCantidades(), this.obtenerValor(this.editText_capacidadRecipiente));
    }


    public void volverAtras(View view) {
        this.setResult(0);
        this.finish();
    }

    private boolean esNombreValido(String nombre) {
        return !nombre.equalsIgnoreCase("") && nombre != null;
    }



    private int[] obtenerPorcentajes() {
        int[] porcentajes = new int[this.seekBars_porcentajes.length];

        seekBars_porcentajes[1].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                editTexts_porcentajes[1].setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
        return porcentajes;
    }

    private int[] obtenerCantidades() {
        int[] cantidades = new int[this.editTexts_cantidades.length];

        for(int i = 0; i < this.editTexts_cantidades.length; ++i) {
            cantidades[i] = this.obtenerValor(this.editTexts_cantidades[i]);
        }

        return cantidades;
    }

    private int obtenerValor(EditText editText) {
        int valor;
        try {
            valor = Integer.parseInt(editText.getText().toString());
        } catch (NumberFormatException var4) {
            valor = 0;
        }

        return valor;
    }

    public void crearMezcla(View view) {
        String nombre = this.editText_nombre.getText().toString();
        int capacidadRecipiente = this.obtenerValor(this.editText_capacidadRecipiente);
        int[] porcentajes = this.obtenerPorcentajes();
        int[] cantidades = this.obtenerCantidades();
        if(this.esNombreValido(nombre)) {
            if(Mezcla.cabeEnRecipienteCantidades(cantidades, capacidadRecipiente)) {
                Intent datos = new Intent();
                Mezcla mezcla = new Mezcla(nombre, porcentajes, cantidades, capacidadRecipiente);
                datos.putExtra("dese.coctelera.MEZCLA_NUEVA", mezcla);
                this.setResult(-1, datos);
                this.finish();
            } else {
                this.mostrarDialogo("La mezcla no puede crearse", "La cantidad de los l�quidos excede la capacidad del recipiente");
            }
        } else {
            this.mostrarDialogo("La mezcla no puede crearse", "El campo de nombre est� vac�o");
        }

    }
*/
    private void mostrarDialogo(String titulo, String mensaje) {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Add the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });

        // Create the AlertDialog
        AlertDialog dialog = builder.create();*/

    }

    private void showAletMessage(String titulo, String mensaje) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle(titulo);
        dialogo.setMessage(mensaje);
        dialogo.setPositiveButton("Cambiar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialogo.create();
        dialogo.show();

    }
/*
    private int buscarVista(View vista_buscada, View[] vistas) {
        int identificadorVista = vista_buscada.getId();
        int encontrada = -1;

        for(int i = 0; i < vistas.length && encontrada == -1; ++i) {
            if(identificadorVista == vistas[i].getId()) {
                encontrada = i;
            }
        }

        return encontrada;
    }

    private void actualizarDesdeSeekBar(SeekBar seekBar) {
        int porcentaje = seekBar.getProgress();
        int capacidad = this.obtenerValor(this.editText_capacidadRecipiente);
        int cantidad = Mezcla.calcularCantidad(capacidad, porcentaje);
        int posicion_vista = this.buscarVista(seekBar, this.seekBars_porcentajes);
        if(posicion_vista > -1) {
            this.editTexts_porcentajes[posicion_vista].setText(String.valueOf(porcentaje));
            this.editTexts_cantidades[posicion_vista].setText(String.valueOf(cantidad));
        }

    }

    private void actualizarDesdeEditTextPorcentaje(EditText editText) {
        int porcentaje = this.obtenerValor(editText);
        int capacidad = this.obtenerValor(this.editText_capacidadRecipiente);
        int cantidad = Mezcla.calcularCantidad(capacidad, porcentaje);
        int posicion_vista = this.buscarVista(editText, this.editTexts_porcentajes);
        if(posicion_vista > -1) {
            this.seekBars_porcentajes[posicion_vista].setProgress(porcentaje);
            this.editTexts_cantidades[posicion_vista].setText(String.valueOf(cantidad));
        }

    }

    private void actualizarDesdeEditTextCantidad(EditText editText) {
        int cantidad = this.obtenerValor(editText);
        int capacidad = this.obtenerValor(this.editText_capacidadRecipiente);
        int porcentaje = Mezcla.calcularPorcentaje(capacidad, cantidad);
        int posicion_vista = this.buscarVista(editText, this.editTexts_cantidades);
        if(posicion_vista > -1) {
            this.seekBars_porcentajes[posicion_vista].setProgress(porcentaje);
            this.editTexts_porcentajes[posicion_vista].setText(String.valueOf(porcentaje));
        }

    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(fromUser) {
            this.actualizarDesdeSeekBar(seekBar);
            this.actualizarTextViewsTotales();
        }

    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.actualizarDesdeSeekBar(seekBar);
        this.actualizarTextViewsTotales();
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.actualizarDesdeSeekBar(seekBar);
        this.actualizarTextViewsTotales();
    }

    public void onFocusChange(View view, boolean hasFocus) {
        EditText editText = (EditText)view;
        int valor = this.obtenerValor(editText);
        if(!hasFocus) {
            if(valor == 0) {
                editText.setText(String.valueOf(valor));
            }

            if(this.buscarVista(editText, this.editTexts_porcentajes) > -1) {
                this.actualizarDesdeEditTextPorcentaje(editText);
            } else if(this.buscarVista(editText, this.editTexts_cantidades) > -1) {
                this.actualizarDesdeEditTextCantidad(editText);
            } else {
                this.registrarTextWatchersValorMaximoEditTextsCantidades();

                for(int i = 0; i < this.editTexts_porcentajes.length; ++i) {
                    this.actualizarDesdeEditTextPorcentaje(this.editTexts_porcentajes[i]);
                }
            }

            this.actualizarTextViewsTotales();
        }

    }
*/
}
