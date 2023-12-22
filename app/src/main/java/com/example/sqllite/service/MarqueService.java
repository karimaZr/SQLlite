package com.example.sqllite.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sqllite.classes.Etudiant;
import com.example.sqllite.classes.Marque;
import com.example.sqllite.util.MySQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class MarqueService {
    private static final String TABLE_NAME ="marque";

    private static final String KEY_ID = "id";
    private static final String KEY_CODE = "code";
    private static final String KEY_MARQUE ="marque";
    private static String [] COLUMNS = {KEY_ID, KEY_CODE, KEY_MARQUE};
    private MySQLiteHelper helper;
    public MarqueService(Context context) {
        this.helper = new MySQLiteHelper(context);
    }

    public void create(Marque e){
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CODE, e.getCode());
        values.put(KEY_MARQUE, e.getMarque());
        db.insert(TABLE_NAME,
                null,
                values);
        Log.d("insert", e.getMarque());
        db.close();
    }

    public void update(Marque e){
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, e.getId());
        values.put(KEY_CODE, e.getCode());
        values.put(KEY_MARQUE, e.getMarque());

        db.update(TABLE_NAME,
                values,
                "id = ?",
                new String[]{e.getId()+""});
        db.close();
    }
    public Marque findById(int id){
        Marque e = null;
        SQLiteDatabase db = this.helper.getReadableDatabase();
        Cursor c;
        c = db.query(TABLE_NAME,
                COLUMNS,
                "id = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if(c.moveToFirst()){
            e = new Marque();
            e.setId(c.getInt(0));
            e.setCode(c.getString(1));
            e.setMarque(c.getString(2));
        }
        db.close();
        return e;
    }

    public void delete(Marque e){
        SQLiteDatabase db = this.helper.getWritableDatabase();
        db.delete(TABLE_NAME,
                "id = ?",
                new String[]{String.valueOf(e.getId())});
        db.close();
    }

    public List<Marque> findAll(){
        List<Marque> eds = new ArrayList<>();
        String req ="select * from "+TABLE_NAME;
        SQLiteDatabase db = this.helper.getReadableDatabase();
        Cursor c = db.rawQuery(req, null);
        Marque m = null;
        if(c.moveToFirst()){
            do{
                m=new Marque();
                m.setId(c.getInt(0));
                m.setCode(c.getString(1));
                m.setMarque(c.getString(2));
                eds.add(m);
                Log.d("id = ", m.getId()+"");
            }while(c.moveToNext());
        }
        return eds;
    }
}




