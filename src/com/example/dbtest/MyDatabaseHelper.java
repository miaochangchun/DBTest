package com.example.dbtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper{

	public static final String CREATE_BOOK = "create table Book(" +
			"id integer primary key autoincrement," +
			"author text," +
			"price real," +
			"pages integer," +
			"name text," +
			"category_id integer);" ;
	public static final String CREATE_CATEGORY = "create table Category(" +
			"id integer primary key autoincrement," +
			"category_name text," +
			"category_code integer);";
	private Context mContext;
	
	public MyDatabaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase dbDatabase) {
		dbDatabase.execSQL(CREATE_BOOK);
		dbDatabase.execSQL(CREATE_CATEGORY);
		Toast.makeText(mContext, "Create Sucess!", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase dbDatabase, int oldVersion, int newVersion) {
		switch (oldVersion) {
		case 1:
			dbDatabase.execSQL(CREATE_CATEGORY);
		case 2:
			dbDatabase.execSQL("alter table Book add column category_id integer");
		default:
		}
	}

}
