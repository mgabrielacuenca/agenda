package com.example.gabriela.agenda.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gabriela.agenda.Usuario;

import java.util.ArrayList;

public class UsuarioDAO {

    private UsuarioDBHelper usuarioDBHelper;

    public UsuarioDAO(Context context) {
        this.usuarioDBHelper = new UsuarioDBHelper(context);
    }

    public boolean inserirUsuario(Usuario u){
        SQLiteDatabase db = this.usuarioDBHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(UsuarioContract.COLUNA_NOME, u.getNome());
        valores.put(UsuarioContract.COLUNA_TELEFONE, u.getTelefone());
        valores.put(UsuarioContract.COLUNA_EMAIL, u.getEmail());
        valores.put(UsuarioContract.COLUNA_CPF, u.getCpf());


        long newRowId = db.insert(UsuarioContract.NOME_TABELA, null, valores);
        if (newRowId==-1)return false;
        return true;
    }

    public boolean editarUsuario(Usuario u){
        SQLiteDatabase db = this.usuarioDBHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(UsuarioContract.COLUNA_NOME, u.getNome());
        valores.put(UsuarioContract.COLUNA_TELEFONE, u.getTelefone());
        valores.put(UsuarioContract.COLUNA_EMAIL, u.getEmail());
        valores.put(UsuarioContract.COLUNA_CPF, u.getCpf());

        String condicao = UsuarioContract.COLUNA_ID+" = ?";
        String[] argumentosWhere ={String.valueOf(u.getId())};

        int linhasAfetadas = db.update(UsuarioContract.NOME_TABELA, valores, condicao, argumentosWhere);
        if (linhasAfetadas==-1)return false;
        return true;

    }

    public boolean deletarUsuario(Integer id){
        SQLiteDatabase db = this.usuarioDBHelper.getWritableDatabase();
        String condicao = UsuarioContract.COLUNA_ID+" = ?";

        String[] argumentosWhere = {id.toString()};

        int linhasAfetadas = db.delete(UsuarioContract.NOME_TABELA, condicao, argumentosWhere);
        if(linhasAfetadas ==-1)return false;
        return true;

    }


    public ArrayList<Usuario> buscarTodosUsuarios(){
        SQLiteDatabase db = this.usuarioDBHelper.getReadableDatabase();

        String[] colunas = {UsuarioContract.COLUNA_ID, UsuarioContract.COLUNA_NOME, UsuarioContract.COLUNA_TELEFONE, UsuarioContract.COLUNA_EMAIL, UsuarioContract.COLUNA_CPF};
        String ordenar = UsuarioContract.COLUNA_NOME + "ASC";

        Cursor result = db.query(UsuarioContract.NOME_TABELA,colunas,null,null,null,null,null);

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        while (result.moveToNext()){
            Usuario u = new Usuario();
            u.setId(result.getInt(result.getColumnIndex(UsuarioContract.COLUNA_ID)));
            u.setNome(result.getString(result.getColumnIndex(UsuarioContract.COLUNA_NOME)));
            u.setTelefone(result.getString(result.getColumnIndex(UsuarioContract.COLUNA_TELEFONE)));
            u.setEmail(result.getString(result.getColumnIndex(UsuarioContract.COLUNA_EMAIL)));
            u.setCpf(result.getString(result.getColumnIndex(UsuarioContract.COLUNA_CPF)));
            usuarios.add(u);

        }
        return usuarios;

    }

}
