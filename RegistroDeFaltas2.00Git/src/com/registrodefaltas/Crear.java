package com.registrodefaltas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

public class Crear extends Activity {
	
	private EditText txtNomcur, txtCantalu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.crear);
		crearTabla();
		txtNomcur = (EditText) findViewById(R.id.txtNomcur);
		txtCantalu = (EditText) findViewById(R.id.txtCantalu);
	}
		
	

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	public void onCrear(View view) {

		String sNom = txtNomcur.getText().toString();
		String sCant = txtCantalu.getText().toString();
		
		try {
			AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
					"cursos", null, 1);
			SQLiteDatabase bd = admin.getWritableDatabase();
			ContentValues registrar = new ContentValues();
			registrar.put("nombre", sNom);
			registrar.put("cantidad", sCant);
			bd.insert("cursos", null, registrar);
			bd.close();
			Toast.makeText(this, "Se cargaron los datos del Curso.",
					Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			Toast.makeText(this, "Error al cargar los datos en la base",
					Toast.LENGTH_SHORT).show();
		}System.out.println("onCrear");

	}
	
	private void crearTabla() {
		// TODO Auto-generated method stub
		try {
			AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
					"cursos", null, 1);
			SQLiteDatabase bd = admin.getWritableDatabase();
			admin.onCreate(bd);
			bd.close();
		} catch (Exception e) {
			Toast.makeText(this, "Error al crear la base de datos",
					Toast.LENGTH_SHORT).show();
		}System.out.println("crearTabla");

	}
	
	public void onAtrasC(View view) {
        Intent i = new Intent(this, Inicio.class );
        startActivity(i);
  }   

}
