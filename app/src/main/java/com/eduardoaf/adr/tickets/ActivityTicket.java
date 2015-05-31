package com.eduardoaf.adr.tickets;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/**
 * @author Eduardo A.F.
 * @link www.eduardoaf.com
 * @version 1.0.0
 * @name ActivityTicket
 * @file ActivityTicket.java
 * @date 31-05-2015 22:11 (SPAIN)
 * @observations:
 *  Examples:https://github.com/eacevedof/prj_androidtest/tree/master/app/src/main/java/com/example/ioedu/firstapp
 * @requires:
 */
public class ActivityTicket extends Activity
{

    private Button butCalculate;
    private EditText edtTicketValue;
    private EditText edtPaymentAmount;
    private EditText edtTickets;
    private EditText edtCash;
    private EditText edtHavingTickets;
    private EditText edtHavingCash;

    private String sTicketValue;
    private String sPaymentAmount;
    private String sTickets;
    private String sCash;
    private String sHavingTickets;
    private String sHavingCash;

    @Override
    public void onCreate(Bundle oBundle)
    {
        //onCreate: protected void onCreate
        super.onCreate(oBundle);
        setContentView(R.layout.ticket);
        //instancia las cajas de texto
        this.load_edittexts();
        //instancia los botones y crea su listener
        this.load_buttons();
        this.set_ticketvalue("2.4");
    }

    private void load_buttons()
    {
        this.butCalculate = (Button) findViewById(R.id.butCalculate);
        this.butCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                float fTicketValue = get_ticketvalue(true);
                float fPaymentAmount = get_paymentamount(true);
                calculate_cash_and_tickets(fTicketValue, fPaymentAmount);
            }
        });
    }

    private void load_edittexts()
    {
        this.edtTicketValue = (EditText) findViewById(R.id.edtTicketValue);
        this.edtPaymentAmount = (EditText) findViewById(R.id.edtPaymentAmount);
        this.edtTickets = (EditText) findViewById(R.id.edtTickets);
        this.edtCash = (EditText) findViewById(R.id.edtCash);
        this.edtHavingTickets = (EditText) findViewById(R.id.edtHavingTickets);
        this.edtHavingCash = (EditText) findViewById(R.id.edtHavingCash);
    }

    private void calculate_cash_and_tickets(float fTicketValue, float fPaymentAmount)
    {
        float fResult = 0, fTicketAmount=0;
        float fRest = 0, fTickets=0, fCash=0;

        if(fTicketValue!=0)
        {
            fRest = fPaymentAmount%fTicketValue;
            //Numero de tickets
            fTickets = fPaymentAmount/fTicketValue;
            fTickets = (float)Math.floor((double)fTickets);
            //si hay resto
            if(fRest>0)
            {
                double dRound = 0;
                fCash = fPaymentAmount-(fTicketValue*fTickets);
                Log.d("raw cash",String.valueOf(fCash));
                dRound = (double)fCash;
                Log.d("raw cash in double",String.valueOf(dRound));
                dRound = Math.round(dRound * 100.0) / 100.0;
                Log.d("double rounded",String.valueOf(dRound));
                fCash = (float) dRound;
                Log.d("double to float cash",String.valueOf(fCash));
            }
        }
        else
        {
            fCash = fPaymentAmount;
        }

        this.set_tickets(String.valueOf(fTickets));
        this.set_cash(String.valueOf(fCash));
    }

    private String get_ticketvalue(){ return this.edtTicketValue.getText().toString();}
    private Float get_ticketvalue(boolean isFloat){ return Float.parseFloat(this.edtTicketValue.getText().toString());}
    private String get_paymentamount(){ return this.edtPaymentAmount.getText().toString();}
    private Float get_paymentamount(boolean isFloat){ return Float.parseFloat(this.edtPaymentAmount.getText().toString());}
    private String get_tickets(){ return this.edtTickets.getText().toString();}
    private String get_cash(){ return this.edtCash.getText().toString();}
    private String get_having_tickets(){ return this.edtHavingTickets.getText().toString();}
    private String get_having_cash(){ return this.edtHavingCash.getText().toString();}

    private void set_ticketvalue(String sValue){this.edtTicketValue.setText(sValue);}
    private void set_paymentamount(String sValue){this.edtPaymentAmount.setText(sValue);}
    private void set_tickets(String sValue){this.edtTickets.setText(sValue);}
    private void set_cash(String sValue){this.edtCash.setText(sValue);}
    private void set_having_tickets(String sValue){this.edtHavingTickets.setText(sValue);}
    private void set_having_cash(String sValue){this.edtHavingCash.setText(sValue);}

}//ActivityTicket 1.0.0
