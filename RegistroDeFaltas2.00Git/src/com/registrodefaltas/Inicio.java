package com.registrodefaltas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.content.Intent;

public class Inicio extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inicio);
	}
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	 
	 public void irCrear(View view) {
	        Intent i = new Intent(this, Crear.class );
	        startActivity(i);
	  }    
	 
	 public void irEditar(View view) {
	        Intent i = new Intent(this, Editar.class );
	        startActivity(i);
	  }    
	 
	 public void irMain(View view) {
	        Intent i = new Intent(this, MainActivity.class );
	        startActivity(i);
	  }    
	 

}
