package com.example.gabriela.agenda.DAO;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gabriela.agenda.R;

public class UsuarioViewHolder extends RecyclerView.ViewHolder {

    TextView nome;
    TextView telefone;
    TextView email;
    TextView cpf;
    Button botao;
    Button botao2;



    public UsuarioViewHolder(@NonNull View itemView) {
        super(itemView);
        nome = itemView.findViewById(R.id.txtNome);
        telefone = itemView.findViewById(R.id.txtTel);
        email = itemView.findViewById(R.id.txtEmail);
        cpf = itemView.findViewById(R.id.txtCpf);
        botao = itemView.findViewById(R.id.btnDelete);
        botao2 = itemView.findViewById(R.id.btnAlterar);

    }
}