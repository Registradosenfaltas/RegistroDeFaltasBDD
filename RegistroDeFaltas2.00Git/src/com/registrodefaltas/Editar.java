package com.registrodefaltas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

public class Editar extends Activity {
	
	private Spinner spinnerEditar;
	private SQLiteDatabase db;
	private EditText txtEdit;
	private String edicion, selec;
	private ContentValues registro;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editar);
		System.out.println("hasta aca anda 0");
		
			AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"cursos", null, 1);
			db = admin.getWritableDatabase();
			txtEdit =  (EditText) findViewById(R.id.txtEdit);
			spinnerEditar = (Spinner) this.findViewById(R.id.spinnerEditar);
			System.out.println("hasta aca anda 0.5");
	    
			Cursor cur = db.rawQuery("SELECT nombre as _id, nombre FROM cursos", null);
			System.out.println("hasta aca anda 1");
		
			String[] from = new String[] { "nombre" };
	        int[] to = new int[] { android.R.id.text1 };
	        System.out.println("hasta aca anda 2");
	        
	        SimpleCursorAdapter mAdapter = 
	       		new SimpleCursorAdapter(this,android.R.layout.simple_spinner_item, cur, from, to);
	        		        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        		        spinnerEditar.setAdapter(mAdapter);
	        		        System.out.println("hasta aca anda 3");
	}
	
	public void onGuardarE(View view) {
		try {
		AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
				"datos", null, 1);
		db = admin.getWritableDatabase();
		
		edicion = txtEdit.getText().toString();
		selec = spinnerEditar.getSelectedItem().toString();
		registro = new ContentValues();
		registro.put(selec, edicion);
		db.insert("datos", null, registro);
		db.close();
		Toast.makeText(this, "Se editaron correctamente los datos.",
				Toast.LENGTH_SHORT).show();
	} catch (Exception e) {
		Toast.makeText(this, "Error al editar los datos.",
				Toast.LENGTH_SHORT).show();
	}System.out.println("hasta aca anda 1");

  }   

	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	public void onAtrasE(View view) {
        Intent i = new Intent(this, Inicio.class );
        startActivity(i);
  }   

}
