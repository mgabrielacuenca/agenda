package com.example.gabriela.agenda.DAO;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gabriela.agenda.MainActivity;
import com.example.gabriela.agenda.R;
import com.example.gabriela.agenda.Usuario;

import java.io.Serializable;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewHolder> {

    private List<Usuario> usuarios;
    private Context c;

    public UsuarioAdapter(List<Usuario> usuario, Context c) {
        this.usuarios = usuario;
        this.c = c;
    }


    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View l = LayoutInflater.from(c).inflate(R.layout.list,viewGroup,false);


        UsuarioViewHolder vh = new UsuarioViewHolder(l);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder usuarioViewHolder, int posicao) {

        final Usuario usuario = usuarios.get(posicao);
        usuarioViewHolder.nome.setText(usuario.getNome());
        usuarioViewHolder.telefone.setText(usuario.getTelefone());
        usuarioViewHolder.email.setText(usuario.getEmail());
        usuarioViewHolder.cpf.setText(usuario.getCpf());

        usuarioViewHolder.botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioDAO dao = new UsuarioDAO(v.getContext());
                dao.deletarUsuario(usuario.getId());
                remover(usuario);
            }
        });

        usuarioViewHolder.botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Activity at = enviarActivity(v);
               Intent i = new Intent(at, Alterar.class);
               i.addFlags(i.FLAG_ACTIVITY_NO_ANIMATION);
               i.putExtra("usuario", (Serializable) usuario);
               at.startActivity(i);


            }
        });

    }

    public void remover(Usuario u){
        int posicao = usuarios.indexOf(u);
        usuarios.remove(posicao);
        notifyItemRemoved(posicao);
    }

    private Activity enviarActivity(View v){
        Context c = v.getContext();
        while (c instanceof ContextWrapper){
            if (c instanceof Activity){
                return (Activity) c;
            }
            c = ((ContextWrapper) c).getBaseContext();
        }
        return null;
    }

    @Override
    public int getItemCount() {

        return this.usuarios.size();
    }
}
