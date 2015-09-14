package com.otherwisestudios.clase1compumovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_primervalor, et_segundovalor;
    private TextView tv_resultado;
    private CheckBox cb_sumar, cb_restar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_primervalor = (EditText) findViewById(R.id.et_primervalor);
        et_segundovalor = (EditText) findViewById(R.id.et_segundovalor);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);

        cb_sumar = (CheckBox) findViewById(R.id.cb_sumar);
        cb_restar = (CheckBox) findViewById(R.id.cb_restar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void operar(View view) {

        String v1= et_primervalor.getText().toString();
        String v2 = et_segundovalor.getText().toString();

        float num1=0, num2=0;
        try{
           num1 = Float.parseFloat(v1);
        }catch(Exception e){
            et_primervalor.setError("Esto parece no ser un número válido");
            return;
        }

        try{
            num2 = Float.parseFloat(v2);
        }catch(Exception e){
            et_segundovalor.setError("Esto parece no ser un número válido");
            return;
        }

        float ressuma = 0;
        float resresta = 0;

        String t = "";

        if(cb_sumar.isChecked()) {
            ressuma = num1+num2;
            t= String.valueOf(num1)+"+" + String.valueOf(num2)+ "= " +String.valueOf(ressuma);
        }

        if(cb_restar.isChecked()) {
            resresta = num1-num2;

            if(cb_sumar.isChecked()) {
                t+= " y "+String.valueOf(num1)+"-" + String.valueOf(num2)+ "= " +resresta;
            }else{
                t= String.valueOf(num1)+"-" + String.valueOf(num2)+ "= " +resresta;
            }

        }

        if(!cb_sumar.isChecked() && !cb_restar.isChecked()){
            t = "Resultado..";
        }

        tv_resultado.setText(t);
    }

}
