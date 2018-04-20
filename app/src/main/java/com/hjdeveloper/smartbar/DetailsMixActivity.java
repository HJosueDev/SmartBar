package com.hjdeveloper.smartbar;


import com.hjdeveloper.smartbar.ClassUtilitary.Datos;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hjdeveloper.smartbar.ClassUtilitary.BluetoothUtils;
import com.hjdeveloper.smartbar.ClassUtilitary.Datos;

import at.abraxas.amarino.Amarino;

import static com.hjdeveloper.smartbar.ClassUtilitary.Datos.myMap;


public class DetailsMixActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private static final String DEVICE_ADDRESS="98:D3:31:FB:20:54";
    int red, green, blue;

    private ListView dispostivios;
    private BluetoothUtils bluetooth;


    String[] itemsMix;
    Datos datos =new Datos();

    private Button btnServir;
    private EditText editTextName;
    private EditText editTextCapacidad;


    private EditText[] editTextPorcentajes;

    TextView textView;
    String position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_mix);

        Amarino.connect(this,DEVICE_ADDRESS);

        //Creamos un objeto BluetoothUtils
        //para simplificar us uso
        bluetooth = new BluetoothUtils();

        //Obtenemos la lista de elementos
        dispostivios = (ListView) findViewById(R.id.dispositivos);

        //Obtenemos los nombres de los dispositivos
        //bluetooth vinculados
        String[] nombres = bluetooth.getNames();

        //Asignamos los nombres a la lista
        dispostivios.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres));

        //Leemos los "clicks" sobre los elementos de
        //la lista
        dispostivios.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });



        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextCapacidad=(EditText)findViewById(R.id.editTextCapacidad);


        position=getIntent().getExtras().getString("parametro");
        this.textView=(TextView)findViewById(R.id.textViewName);

        editTextPorcentajes=getEditText();
        imprimirDatos();

        btnServir=(Button)findViewById(R.id.btnServir);

        btnServir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cien por ciento de un baso se llena en
                int timeTotalGlass=20;

                if (!itemsMix[0].isEmpty() && Integer.parseInt(itemsMix[0])>0){

                    //tiempo de la valvula 1
                    int timeValvula1=(Integer.parseInt(itemsMix[0])/100)*timeTotalGlass;

                }

                if (!itemsMix[1].isEmpty() && Integer.parseInt(itemsMix[1])>0){

                    //tiempo de la valvula 2
                    int timeValvula2=(Integer.parseInt(itemsMix[1])/100)*timeTotalGlass;

                }

                if (!itemsMix[2].isEmpty() && Integer.parseInt(itemsMix[2])>0){

                    //tiempo de la valvula 3
                    int timeValvula2=(Integer.parseInt(itemsMix[2])/100)*timeTotalGlass;

                }

                if (!itemsMix[3].isEmpty() && Integer.parseInt(itemsMix[3])>0){

                    //tiempo de la valvula 3
                    int timeValvula2=(Integer.parseInt(itemsMix[3])/100)*timeTotalGlass;

                }
            }
        });
    }


    public EditText[] getEditText(){
        EditText[] editTextPorcentajes = new EditText[]{
                (EditText) this.findViewById(R.id.porcentageBebida1),
                (EditText) this.findViewById(R.id.porcentageBebida2),
                (EditText) this.findViewById(R.id.porcentageBebida3),
                (EditText) this.findViewById(R.id.porcentageBebida4)};
        return editTextPorcentajes;
    }

    public String[] splitValues(){
        int count=0;
        String data = myMap.get(position);
        itemsMix = data.split(",");
        for (String item : itemsMix)
        {
            itemsMix[count] = itemsMix[count].trim();
            count++;
        }
        return itemsMix;
    }

    public void imprimirDatos(){
        String [] arrayDatos=splitValues();
        for (int i=0;i<editTextPorcentajes.length;i++){
            editTextPorcentajes[i].setText(arrayDatos[i]);
        }

        editTextName.setText(position);


    }




    /**
     * Cuando cerramos la app desconectamos
     */
    protected void onPause() {
        super.onPause();
        bluetooth.disconnect();
    }



    /**
     * Método que se ejecutará cuando se pulse sobre un elemento de la
     * lista. Index indicará el número del elemento pulsado.
     */
    public void onItemClick(AdapterView<?> ag, View v, int index, long id) {
        //Conectamos con el elemento pulsado
        if (bluetooth.connect(index))
            Toast.makeText(this, R.string.conectado, Toast.LENGTH_SHORT).show();
    }




    /**
     * Método que se ejecutará cuando pulsemos sobre uno de los botones
     * de LED. El parámetro v indica que botón hemos pulsado
     */
    public void enviar(View v) {
        //Si no estamos conectados, terminamos
        if (bluetooth.isConnected() == false) {
            Toast.makeText(this, R.string.primero_conectar, Toast.LENGTH_SHORT).show();
            return;
        }

        switch (v.getId()) {
            case R.id.led_1:
                bluetooth.send(1);
                break;
            case R.id.led_2:
                bluetooth.send(2);
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStop();

    }
}