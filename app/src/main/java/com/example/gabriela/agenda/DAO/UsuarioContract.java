package com.example.gabriela.agenda.DAO;

import android.provider.BaseColumns;

public class UsuarioContract implements BaseColumns {

    private UsuarioContract() {

    }

    public static final String NOME_TABELA = "contatinhos";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_TELEFONE = "telefone";
    public static final String COLUNA_EMAIL = "email";
    public static final String COLUNA_CPF = "cpf";
}
