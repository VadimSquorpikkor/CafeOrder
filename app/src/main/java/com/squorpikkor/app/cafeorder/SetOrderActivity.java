package com.squorpikkor.app.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import static com.squorpikkor.app.cafeorder.LoginActivity.PASSWORD;
import static com.squorpikkor.app.cafeorder.LoginActivity.USER_NAME;

public class SetOrderActivity extends AppCompatActivity {

    public static final String ORDER = "order";
    ImageView buttonOrder;
    Spinner coffeeSpinner;
    Spinner teaSpinner;
    CheckBox milkCheck;
    CheckBox sugarCheck;
    CheckBox lemonCheck;
    RadioButton radioTea;
    RadioButton radioCoffee;
    String name;
    String password;
    TextView helloUser;
    TextView chooseDrinkType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_order);

        helloUser = findViewById(R.id.hello_client);
        milkCheck = findViewById(R.id.check_milk);
        sugarCheck = findViewById(R.id.check_sugar);
        lemonCheck = findViewById(R.id.check_lemon);
        buttonOrder = findViewById(R.id.button_order);
        coffeeSpinner = findViewById(R.id.coffee_spinner);
        teaSpinner = findViewById(R.id.tea_spinner);
        radioTea = findViewById(R.id.radio_tea);
        radioCoffee = findViewById(R.id.radio_coffee);
        chooseDrinkType = findViewById(R.id.add_to_drink);

        Intent intent = getIntent();
        name = intent.getStringExtra(USER_NAME);
        password = intent.getStringExtra(PASSWORD);

        helloUser.setText(String.format(getString(R.string.hello_what_your_drink), name));
        chooseDrinkType.setText(String.format(getString(R.string.add_to_drink), getString(R.string.tea)));

        coffeeSpinner.setVisibility(View.GONE);

        radioTea.setOnClickListener(view -> {
            lemonCheck.setVisibility(View.VISIBLE);
            coffeeSpinner.setVisibility(View.GONE);
            teaSpinner.setVisibility(View.VISIBLE);
            chooseDrinkType.setText(String.format(getString(R.string.add_to_drink), getString(R.string.tea)));
        });

        radioCoffee.setOnClickListener(view -> {
            lemonCheck.setVisibility(View.GONE);
            coffeeSpinner.setVisibility(View.VISIBLE);
            teaSpinner.setVisibility(View.GONE);
            chooseDrinkType.setText(String.format(getString(R.string.add_to_drink), getString(R.string.coffee)));
        });

        buttonOrder.setOnClickListener(view -> {
            String drinkType = getString(R.string.tea);
            if (radioTea.isChecked())drinkType = getString(R.string.coffee);
            String additional = "";
            if (milkCheck.isChecked()) additional = getString(R.string.milk) + " ";
            if (sugarCheck.isChecked()) additional += getString(R.string.sugar) + " ";
            if (lemonCheck.isChecked() && radioTea.isChecked()) additional += getString(R.string.lemon) + " ";
            String type = teaSpinner.getSelectedItem().toString();
            if (radioCoffee.isChecked()) type = coffeeSpinner.getSelectedItem().toString();
            String order = String.format(getString(R.string.order), name, password, drinkType, additional, type);

            Intent orderIntent = new Intent(this, OrderActivity.class);
            orderIntent.putExtra(ORDER, order);
            startActivity(orderIntent);
        });

    }
}