package com.brillicaservices.gurjas.basicrestaurantapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText usernameText, userAge, quantity;
    Button submitOrder;
    Spinner menuSpinner;

    ArrayList<String> spinnerItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameText = findViewById(R.id.customer_name);
        userAge = findViewById(R.id.customer_age);
        quantity = findViewById(R.id.order_quantity);
        submitOrder = findViewById(R.id.place_order);
        menuSpinner = findViewById(R.id.menu_spinner);

        spinnerItems.add("Select Menu");
        spinnerItems.add("Burger");
        spinnerItems.add("Momos");
        spinnerItems.add("Pizza");
        spinnerItems.add("Mountain Dew");
        spinnerItems.add("Hot Dog");

        menuSpinner.setPrompt(spinnerItems.get(0));

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, spinnerItems);

        menuSpinner.setAdapter(arrayAdapter);

        submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = usernameText.getText().toString();
                int age = Integer.parseInt(userAge.getText().toString());
                int menuQuantity = Integer.parseInt(quantity.getText().toString());
                String menuItem = menuSpinner.getSelectedItem().toString();

                Toast.makeText(getApplicationContext(), "Username is: " + name +
                        "\nYour age is: " + age +
                        "\nOrder quantity is: "+ menuQuantity +
                        "\nMenu name is: " + menuItem,
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
