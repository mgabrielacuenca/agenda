package com.example.gabriela.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gabriela.agenda.DAO.UsuarioAdapter;
import com.example.gabriela.agenda.DAO.UsuarioDAO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        RecyclerView rv = findViewById(R.id.lista);
        List<Usuario> usuario = new ArrayList<Usuario>();

        UsuarioDAO dao = new UsuarioDAO(MainActivity.this);
        ArrayList<Usuario> usuarios = dao.buscarTodosUsuarios();

        UsuarioAdapter adapter = new UsuarioAdapter(usuarios,this);
        rv.setAdapter(adapter);

        RecyclerView.LayoutManager layout  = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rv.setLayoutManager(layout);


    }
    public void chamarTelaCadastro(View view){

        Intent intent = new Intent(MainActivity.this, telaCadastro.class);
        startActivity(intent);
    }
}