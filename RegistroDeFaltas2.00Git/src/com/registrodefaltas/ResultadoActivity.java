package com.registrodefaltas;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoActivity extends Activity {
	private TextView dtDias, dtInasis, dtAsis;
    private int conversor, contenedor, conversor2, contenedor2, conversor3, contenedor3;
    private String dias, inasistencias, asistencias;
    private Button btn1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.resultado);
	    dtDias = (TextView) findViewById(R.id.dtDias);
	    dtInasis = (TextView) findViewById(R.id.dtInasis);
	    dtAsis = (TextView) findViewById(R.id.dtAsis);
	    btn1 = (Button) findViewById(R.id.btn1);
	    
	}
	
	public void mostrarDatos(View view){
		try{
	    	AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this, "datos", null, 1);
	    	SQLiteDatabase bd = admin.getWritableDatabase();
		    Cursor fila = bd.rawQuery("select dias,inasistencias,asistencias from datos", null);
		    if (fila.moveToFirst()) {
		    	fila.moveToPrevious();
		    	while (fila.moveToNext()) {
		    		conversor = Integer.parseInt(fila.getString(0));
		    		contenedor = contenedor+conversor;
		    		conversor2 = Integer.parseInt(fila.getString(1));
		    		contenedor2 = contenedor2+conversor2;
		    		conversor3 = Integer.parseInt(fila.getString(2));
		    		contenedor3 = contenedor3+conversor3;
		    	} 
		    	dias = "Total anual de dias es de: " + contenedor;
			    dtDias.setText(dias);
			    inasistencias = "Total anual de inasistencias es de: " + contenedor2;
			    dtInasis.setText(inasistencias);
			    asistencias = "Total anual de asistencias es de: " + contenedor3;
			    dtAsis.setText(asistencias);
		    }System.out.println("hasta aca anda 4");
		    fila.close();
		    bd.close();
		    btn1.setEnabled(false);
	    }catch(Exception e){
	    	Toast.makeText(this, "problemas al cargar los datos",
					Toast.LENGTH_SHORT).show();
	    }
	}

}
