package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	private int acak;
	private Button tombol_tebak;
	private EditText input;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// TODO: bind layout di sini
		this.input = findViewById(R.id.number_input);
		this.tombol_tebak = findViewById(R.id.guess_button);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random r = new Random();
		this.acak = r.nextInt(100 - 1);
	}

	public void handleGuess(View view) {
		String input = this.input.getText().toString();

		if (input.matches("")) {
			Toast.makeText(this, "Masukan Angka (1-100)!", Toast.LENGTH_SHORT).show();
		} else {
			int angka = Integer.parseInt(input);

			if (this.acak == angka) {
				this.tombol_tebak.setEnabled(false);
				Toast.makeText(this, R.string.right_answer, Toast.LENGTH_SHORT).show();
			} else if (angka < this.acak) {
				Toast.makeText(this, R.string.lt_answer, Toast.LENGTH_SHORT).show();
			} else  {
				Toast.makeText(this, R.string.gt_answer, Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void handleReset(View view) {
		this.input.setText("");
		this.tombol_tebak.setEnabled(true);
		this.initRandomNumber();
	}
}