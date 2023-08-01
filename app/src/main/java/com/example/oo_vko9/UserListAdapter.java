package com.example.oo_vko9;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListHolder> {
    private Context context;
    private ArrayList<User> users = new ArrayList<User>();

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserListHolder(LayoutInflater.from(context).inflate(R.layout.list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserListHolder holder, int position) {
        //what about the image?
        holder.etunimi.setText(String.valueOf(users.get(position).getFirstName()));
        holder.sukunimi.setText(String.valueOf(users.get(position).getLastName()));
        holder.sahkoposti.setText(String.valueOf(users.get(position).getEmail()));
        holder.degreeProgram.setText(String.valueOf(users.get(position).getDegreeProgram()));

        //grant permission
        //context.grantUriPermission(context.getPackageName(),
        //        users.get(position).getImageUri(), Intent.FLAG_GRANT_READ_URI_PERMISSION);

        holder.ivUser.setImageURI(users.get(position).getImageUri());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
