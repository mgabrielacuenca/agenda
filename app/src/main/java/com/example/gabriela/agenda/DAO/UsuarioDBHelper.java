package com.example.gabriela.agenda.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioDBHelper extends SQLiteOpenHelper {

    private static  final String SQL_CREATE=
            "CREATE TABLE "+UsuarioContract.NOME_TABELA+"( "+ UsuarioContract.COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +UsuarioContract.COLUNA_NOME+" TEXT, "+UsuarioContract.COLUNA_TELEFONE+" TEXT, "+UsuarioContract.COLUNA_EMAIL+" TEXT, "+UsuarioContract.COLUNA_CPF+" TEXT)";


    private  static final String SQL_DELETE = "DROP TABLE  IF EXISTS "+UsuarioContract.NOME_TABELA;

    public static final  int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "Agenda.db";



    public UsuarioDBHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE);
        onCreate(db);

    }
}

