package com.example.exemplo3_sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Banco extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String NAME = "banco1";

    public Banco(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public Banco(Context context){
        super(context, NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("##","Criando a tabela...");
        db.execSQL("create table if not exists pessoal "+
                "(_id integer primary key autoincrement, nome text,"+
                " profissao text, cpf text)");
        Log.d("##","Tabela criada com sucesso");
    }

    public void saveData(Pessoa p){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("nome", p.getNome());
        content.put("cpf", p.getCpf());
        content.put("profissao", p.getProfissao());
        long res = db.insert("pessoal", null, content);
        db.close();
        if (res == -1) Log.d("##", "Dados não foram inseridos");
        else Log.d("##", "Dados foram inseridos");
    }
    
    @SuppressLint("Range")
    public ArrayList<Pessoa> buscaDados(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("pessoal",null,null,null,null,null,null);
        ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
        if (cursor.moveToFirst()){
            do{
                Pessoa pp = new Pessoa();
                pp.setId((int)cursor.getLong(cursor.getColumnIndex("_id")));
                pp.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                pp.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
                pp.setProfissao(cursor.getString(cursor.getColumnIndex("profissao")));
            } while (cursor.moveToNext());
            db.close();
        }
        return lista;
    }
    public void atualizaProfissao(String antiga, String nova){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put("profissao", nova);
        String[] where = new String[]{antiga};

        int conta = db.update("pessoal", content, "profissao=?",where);
        db.close();

        if (conta>0) Log.d("##","Atualizados: "+Integer.toString(conta));
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
