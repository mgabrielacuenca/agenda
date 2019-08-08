package com.example.gabriela.agenda.DAO;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gabriela.agenda.R;
import com.example.gabriela.agenda.Usuario;

public class Alterar extends AppCompatActivity {

    EditText nome;
    EditText telefone;
    EditText email;
    EditText cpf;
    Usuario usuarioEditar = null;
    Button botao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        Intent i = getIntent();
        if(i.hasExtra("usuario")){
            usuarioEditar = (Usuario) i.getSerializableExtra("usuario");

            nome = findViewById(R.id.edNome);
            telefone = findViewById(R.id.edTel);
            email = findViewById(R.id.edEmail);
            cpf = findViewById(R.id.edCpf);

            nome.setText(usuarioEditar.getNome());
            telefone.setText(usuarioEditar.getTelefone());
            email.setText(usuarioEditar.getEmail());
            cpf.setText(usuarioEditar.getCpf());
        }


        botao.findViewById(R.id.btnAlterar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioDAO dao = new UsuarioDAO(getBaseContext());

                Usuario u = new Usuario(usuarioEditar.getId(), usuarioEditar.getNome().toString(), usuarioEditar.getTelefone().toString(), usuarioEditar.getEmail().toString(), usuarioEditar.getCpf().toString());

                dao.editarUsuario(u);


            }
        });

    }
}
