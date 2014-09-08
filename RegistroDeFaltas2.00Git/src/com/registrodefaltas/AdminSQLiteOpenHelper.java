package com.registrodefaltas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

	public AdminSQLiteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("Create table if not exists datos(mes text, inasistencias text, dias text, asistencias integer)");
		db.execSQL("Create table if not exists cursos(nombre text, cantidad integer)");	
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists datos");
		db.execSQL("Create table if not exists datos(mes text, inasistencias text, dias text, asistencias integer)");	
		db.execSQL("Create table if not exists cursos(nombre text, cantidad integer)");	}

}
