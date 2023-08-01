package com.example.oo_vko9;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserListHolder extends RecyclerView.ViewHolder {
    ImageView ivUser;
    TextView etunimi, sukunimi, sahkoposti, degreeProgram;


    public UserListHolder(@NonNull View itemView) {
        super(itemView);
        ivUser = itemView.findViewById(R.id.ivUser);
        etunimi = itemView.findViewById(R.id.txtEtunimi);
        sukunimi = itemView.findViewById(R.id.txtSukunimi);
        sahkoposti = itemView.findViewById(R.id.txtSahkoposti);
        degreeProgram = itemView.findViewById(R.id.txtDegreeProgram);
    }
}
