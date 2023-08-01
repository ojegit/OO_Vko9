package com.example.oo_vko9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserStorage us = UserStorage.getInstance();

        //add some examples
        User user = new User("ABCD","abcd",
                "ABCD.abcd@qwerty.com", "Tuotantotalous");

        //get uri from drawable
        Uri uri = (new Uri.Builder())
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(getResources().getResourcePackageName(R.drawable.portrait_placeholder))
                .appendPath(getResources().getResourceTypeName(R.drawable.portrait_placeholder))
                .appendPath(getResources().getResourceEntryName(R.drawable.portrait_placeholder))
                .build();
        user.setImageUri(uri);
        us.addUser(user);

    }


    public void switchToAddUser(View view) {
        Intent intent = new Intent(this, AddUsersActivity.class);
        startActivity(intent);
    }

    public void switchToUserList(View view) {
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
    }


}