package com.example.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;



public class MainActivity extends Activity {

    EditText origBill;
    EditText origTipPerc;

    TextView tipTot;
    TextView billTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        origBill = (EditText)findViewById(R.id.editBillAmount);
        origTipPerc = (EditText)findViewById(R.id.editPercentAmount);

        tipTot = (TextView)findViewById(R.id.tipTotal);
        billTotal = (TextView)findViewById(R.id.billTotal);

        Button butCalc = (Button)findViewById(R.id.buttonCalculate);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //this method called when "calculate" button clicked, as XML file specifies.
    public void calculate(View view){
        Double enteredBill = Double.valueOf(origBill.getText().toString());
        Double enteredPerc = Double.valueOf(origTipPerc.getText().toString());

        Double tipCalc = enteredBill*(enteredPerc/100);
        Double totalCalc = tipCalc+enteredBill;

        tipCalc = (double)Math.round(tipCalc * 100) / 100;
        totalCalc = (double)Math.round(totalCalc * 100) / 100;


        tipTot.setText("$ "+tipCalc.toString());
        billTotal.setText("$ "+totalCalc.toString());

    }



    
}
