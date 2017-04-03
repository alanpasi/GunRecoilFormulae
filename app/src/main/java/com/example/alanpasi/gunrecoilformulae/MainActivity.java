package com.example.alanpasi.gunrecoilformulae;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etFirearmWeight;
    private EditText etBulletWeight;
    private EditText etBulletVelocity;
    private EditText etPowderWeight;
    private EditText etPowderVelocity;
    private EditText etFirearmVelocity;
    private EditText etRecoil;
    private Button btn_EnergyCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirearmWeight = (EditText) findViewById(R.id.etFirearmWeight);
        etBulletWeight = (EditText) findViewById(R.id.etBulletWeight);
        etBulletVelocity = (EditText) findViewById(R.id.etBulletvelocity);
        etPowderWeight = (EditText) findViewById(R.id.etPowderWeight);
        etPowderVelocity = (EditText) findViewById(R.id.etPowderVelocity);
        etFirearmVelocity = (EditText) findViewById(R.id.etFirearmVelocity);
        etRecoil = (EditText) findViewById(R.id.etRecoil);
        btn_EnergyCalculate = (Button) findViewById(R.id.btn_EnergyCaculate);

        btn_EnergyCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnergyCalculate();
            }
        });

    }

    public void EnergyCalculate(){
        double firearmWeight;
        double bulletWeight;
        double bulletVelocity;
        double powderWeight;
        double powderVelocity;
        double firearmVelocity;
        double freeRecoilEnergy;

        Toast.makeText(this, "Botão pressionado", Toast.LENGTH_SHORT).show();

        firearmWeight = Double.parseDouble(etFirearmWeight.getText().toString());
        bulletWeight = Double.parseDouble(etBulletWeight.getText().toString());
        bulletVelocity = Double.parseDouble(etBulletVelocity.getText().toString());
        powderWeight = Double.parseDouble(etPowderWeight.getText().toString());
        powderVelocity = Double.parseDouble(etPowderVelocity.getText().toString());

        firearmVelocity = (bulletWeight * bulletVelocity + powderWeight * powderVelocity) / (firearmWeight * 7000d);
        freeRecoilEnergy = (firearmWeight * firearmVelocity * firearmVelocity) / (2 * 32.174);

        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");

        etFirearmVelocity.setText(decimalFormat.format(firearmVelocity));
        etRecoil.setText(decimalFormat.format(freeRecoilEnergy));

    }
}
