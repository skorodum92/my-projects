package com.example.dmitriy.calculation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {


    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        tv.setText("0");

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    static boolean isempty=true;
    public void num_Clicked(View sender ) {
        Button bt = (Button) sender;
        if (tv.getText().length() > 7) return;
        if (isempty) {
            tv.setText(bt.getText());
            isempty = false;
        } else {
            tv.append(bt.getText());
        }
    }
        static int accumulator=0;
    static short operationToDo=0;
       public void op_Clicked(View sender){
           Button bt = (Button) sender;
           switch(operationToDo){
               case 0:
                   accumulator+=Integer.parseInt( tv.getText().toString() );
                break;

               case 1:
                   accumulator-=Integer.parseInt( tv.getText().toString() );
                   break;

               case 2:
                   accumulator+=Integer.parseInt( tv.getText().toString() );
                   break;

               case 3:
                   accumulator+=Integer.parseInt( tv.getText().toString() );
                   break;
           }
    tv.setText(Integer.toString(accumulator));
           if(bt.getText().toString().equals("+")) operationToDo=0;
           if(bt.getText().toString().equals("-")) operationToDo=1;
           if(bt.getText().toString().equals("/")) operationToDo=2;
           if(bt.getText().toString().equals("*")) operationToDo=3;
           isempty=true;
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
}
