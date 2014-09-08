package com.registrodefaltas;

import com.registrodefaltas.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Spinner spinner1;
	// private String contenidoAsis,contenidoInas, contenidoMedia,
	// contenidoPor;//Aquí guardaremos el contenido del cuadro de texto para
	// pasarselo a la siguiente actividad
	private EditText txtAlum, txtDias, txtInas;
	private TextView lblAsis, lblInas, lblMedia, lblPor;
	private String sAlum, sDias, sInas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		crearTabla();
		//borrarcrearTabla();
		txtDias = (EditText) findViewById(R.id.txtDias);
		txtInas = (EditText) findViewById(R.id.txtInas);
		lblAsis = (TextView) findViewById(R.id.lblAsis);
		lblInas = (TextView) findViewById(R.id.lblInas);
		lblMedia = (TextView) findViewById(R.id.lblMedia);
		lblPor = (TextView) findViewById(R.id.lblPor);
		//spinner1 = (Spinner) findViewById(R.id.spinnerEditar);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onCalcGuard(View view) {

		sAlum = txtAlum.getText().toString();
		sDias = txtDias.getText().toString();
		sInas = txtInas.getText().toString();

		int iAlum = Integer.parseInt(sAlum);
		int iDias = Integer.parseInt(sDias);
		float iInas = Float.parseFloat(sInas);
		int asis = (int) ((iAlum * iDias) - iInas);
		float asist = asis;
		float media = asist / iDias;
		float por = (asist * 100) / (iAlum * iDias);
		lblAsis.setText(asist + "");
		lblInas.setText("" + iInas);
		lblMedia.setText("" + media + " %");
		lblPor.setText("" + por + " %");
		try {
			AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
					"datos", null, 1);
			SQLiteDatabase bd = admin.getWritableDatabase();
			String selec = spinner1.getSelectedItem().toString();
			ContentValues registro = new ContentValues();
			registro.put("mes", selec);
			registro.put("inasistencias", sInas);
			registro.put("dias", sDias);
			registro.put("asistencias", asis);
			bd.insert("datos", null, registro);
			bd.close();
			Toast.makeText(this, "Se cargaron los datos del mes.",
					Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			Toast.makeText(this, "Error al cargar los datos en la base",
					Toast.LENGTH_SHORT).show();
		}System.out.println("hasta aca anda 1");

	}

	public void crearTabla() {
		try {
			AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
					"datos", null, 1);
			SQLiteDatabase bd = admin.getWritableDatabase();
			admin.onCreate(bd);
			bd.close();
		} catch (Exception e) {
			Toast.makeText(this, "Error al crear la base de datos",
					Toast.LENGTH_SHORT).show();
		}System.out.println("hasta aca anda 2");

	}

	public void borrarcrearTabla() {
		// metodo que permite borrar la tabla
		try {
			AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
					"datos", null, 1);
			SQLiteDatabase bd = admin.getWritableDatabase();
			admin.onUpgrade(bd, 0, 1);
			bd.close();
		} catch (Exception e) {
			Toast.makeText(this, "problemas al borrar la tabla",
					Toast.LENGTH_SHORT).show();
		}System.out.println("hasta aca anda 3");
	}
	
	public void calcular(View view) {

		sAlum = txtAlum.getText().toString();
		sDias = txtDias.getText().toString();
		sInas = txtInas.getText().toString();

		int iAlum = Integer.parseInt(sAlum);
		int iDias = Integer.parseInt(sDias);
		float iInas = Float.parseFloat(sInas);
		int asis = (int) ((iAlum * iDias) - iInas);
		float asist = asis;
		float media = asist / iDias;
		float por = (asist * 100) / (iAlum * iDias);
		lblAsis.setText(asist + "");
		lblInas.setText("" + iInas);
		lblMedia.setText("" + media + " %");
		lblPor.setText("" + por + " %");
		
	}
		
	

	public void limpiar(View view) {

		txtAlum.setText("");
		txtDias.setText("");
		txtInas.setText("");
		lblAsis.setText("");
		lblInas.setText("");
		lblMedia.setText("");
		lblPor.setText("");

	}

	public void irSegundaAc(View view) {

		Intent i = new Intent(this, ResultadoActivity.class);// Creamos un nuevo
																// intent para
																// llamar a la
																// siguiente
																// actividad
		startActivity(i);// Ejecutamos la actividad para que muestre la segunda
							// actividad

	}
	
	public void onAtrasA(View view) {
        Intent i = new Intent(this, Inicio.class );
        startActivity(i);
  }

}
