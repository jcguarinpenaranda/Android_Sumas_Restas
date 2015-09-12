package com.otherwisestudios.clase1compumovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_primervalor, et_segundovalor;
    private TextView tv_resultado;
    private RadioButton rb_sumar, rb_restar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_primervalor = (EditText) findViewById(R.id.et_primervalor);
        et_segundovalor = (EditText) findViewById(R.id.et_segundovalor);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);

        rb_sumar = (RadioButton) findViewById(R.id.rb_sumar);
        rb_restar = (RadioButton) findViewById(R.id.rb_restar);

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

        int num1 = Integer.parseInt(v1);
        int num2 = Integer.parseInt(v2);

        int res = 0;

        if(rb_sumar.isChecked()) {
            res = num1+num2;
        }else if(rb_restar.isChecked()) {
            res = num1-num2;
        }

        tv_resultado.setText(String.valueOf(res));
    }

}
