package com.assignment.xiaoduo.week3lab;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    EditText firstName, lastName, motherName, birthCity, firstCar;
    Button clear, submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = (EditText)findViewById(R.id.firstName_et);
        lastName = (EditText)findViewById(R.id.lastName_et);
        motherName = (EditText)findViewById(R.id.motherName_et);
        birthCity = (EditText)findViewById(R.id.birthCity_et);
        firstCar = (EditText)findViewById(R.id.firstCar_et);
        submit = (Button) findViewById(R.id.submit);
        clear = (Button) findViewById(R.id.clear);

        firstName.setText("Elliott");
        lastName.setText("Wilson");
        motherName.setText("Kerr");
        birthCity.setText("Brisbane");
        firstCar.setText("Toyota");


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                firstName.setText("");
                lastName.setText("");
                motherName.setText("");
                birthCity.setText("");
                firstCar.setText("");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if(firstName.getText().equals(""))
                {
                    alert("Please input first name");
                }else if(firstName.getText().length() < 4)
                {
                    alert("First name must be longer than 3 characters");
                }else if(lastName.getText().equals(""))
                {
                    alert("Please input last name");
                }else if(lastName.getText().length() < 3)
                {
                    alert("Last name must be longer than 3 characters");
                }else if(motherName.getText().equals(""))
                {
                    alert("Please input mother's maiden name");
                }else if(motherName.getText().length() < 3)
                {
                    alert("Mother's maiden name must be longer than 2 characters");
                }else if(birthCity.getText().equals(""))
                {
                    alert("Please input the city your were born");
                }else if(birthCity.getText().length() < 4)
                {
                    alert("City's name must be longer than 3 characters");
                }else if(firstCar.getText().equals(""))
                {
                    alert("Please input first car name");
                }else
                {
                    String generatedFirstName = firstName.getText().toString().substring(0,3)+lastName.getText().toString().substring(0,2);
                    String generatedLastName =  motherName.getText().toString().substring(0,2)+birthCity.getText().toString().substring(0,3);
                    String generatedPlanet =  lastName.getText().toString().substring(lastName.getText().toString().length()-2,lastName.getText().toString().length())+firstCar.getText().toString();
                    generatedFirstName = format(generatedFirstName);
                    generatedLastName = format(generatedLastName);
                    generatedPlanet = format(generatedPlanet);
                    Intent intent = new Intent(MainActivity.this, GenerateNameActivity.class);
                    intent.putExtra("generatedName",generatedFirstName+" "+generatedLastName+" "+generatedPlanet);
                    startActivity(intent);
                }
            }
        });
    }


    public String format(String text)
    {
        text = text.toLowerCase();
        text = text.substring(0,1).toUpperCase()+text.substring(1,text.length());
        return text;
    }
    public void alert(String text)
    {
        new AlertDialog.Builder(this)
                .setTitle("Wrong input")
                .setMessage(text)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                }).setIcon(android.R.drawable.ic_dialog_alert)
                .show();
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
}
