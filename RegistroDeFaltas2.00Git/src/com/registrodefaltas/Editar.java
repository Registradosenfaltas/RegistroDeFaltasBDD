package com.registrodefaltas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.database.sqlite.SQLiteDatabase;

public class Editar extends Activity {
	
	private Spinner spinnerEditar;
	private SQLiteDatabase db;
	private EditText txtEdit;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editar);
		System.out.println("hasta aca anda 0");
			
			txtEdit =  (EditText) findViewById(R.id.txtEdit);
			spinnerEditar = (Spinner) this.findViewById(R.id.spinnerEditar);
			
	    
			Cursor cur = db.rawQuery("SELECT nombre AS _id, nombre FROM cursos", null);
			startManagingCursor(cur);
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
