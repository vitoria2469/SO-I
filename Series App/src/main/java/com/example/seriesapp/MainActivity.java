package com.example.seriesapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        private EditText etTermos;
        private Button btnCalcular;
        private TextView tvResultado;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            etTermos = findViewById(R.id.etTermos);
            btnCalcular = findViewById(R.id.btnCalcular);
            tvResultado = findViewById(R.id.tvResultado);

            btnCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcularSerie();
                }
            });
        }

        private void calcularSerie() {
            try {
                int n = Integer.parseInt(etTermos.getText().toString());

                if (n <= 0 || n >= 20) {
                    Toast.makeText(this, "Digite um número entre 1 e 19!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double H = 0;
                StringBuilder serieBuilder = new StringBuilder("H = ");

                for (int i = 1; i <= n; i++) {
                    int coeficiente = (i % 2 == 1) ? 1 : 2;
                    int termo = i + 1;

                    if (i > 1) {
                        serieBuilder.append(" + ");
                    }

                    serieBuilder.append(coeficiente).append("*").append(termo);

                    H += coeficiente * termo;
                }

                //serieBuilder.append("Valor de H = ").append(H);
                //tvResultado.setText(serieBuilder.toString());
                tvResultado.setText(String.format("Valor de H = %.0f", H));

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Digite um número válido!", Toast.LENGTH_SHORT).show();
            }
        }
}