package com.example.gabriela.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.gabriela.agenda.DAO.UsuarioDAO;

public class telaCadastro extends AppCompatActivity {

    EditText nome;
    EditText telefone;
    EditText email;
    EditText cpf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        nome = findViewById(R.id.edNome);
        telefone = findViewById(R.id.edTel);
        email = findViewById(R.id.edEmail);
        cpf = findViewById(R.id.edCpf);

    }

    public void inserirUsuario(View view){
        UsuarioDAO dao = new UsuarioDAO(getBaseContext());
        Usuario u = new Usuario(nome.getText().toString(), telefone.getText().toString(), email.getText().toString(), cpf.getText().toString());
        dao.inserirUsuario(u);
    }
}
