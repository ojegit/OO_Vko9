package com.example.oo_vko9;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.io.IOException;

public class AddUsersActivity extends AppCompatActivity {

    int imgId;

    // One Button
    Button btnImgChooser;
    ImageView ivUserPreview;
    Uri uri;

    ActivityResultLauncher<PickVisualMediaRequest> pickMedia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        pickMedia =
        registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri_ -> {
            // Callback is invoked after the user selects a media item or closes the
            // photo picker.
            if (uri_ != null) {
                uri = uri_;
                Log.d("PhotoPicker", "Selected URI: " + uri_);

                //load to preview
                ivUserPreview = (ImageView)findViewById(R.id.ivUserPreview);
                ivUserPreview.setImageURI(uri);


            } else {
                Log.d("PhotoPicker", "No media selected");
            }
        });

    }

    public void onClickReadImage(View view) {
        pickMedia.launch(new PickVisualMediaRequest.Builder()
                .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                .build());

    }


    public void onClickAddUser(View view) {

        RadioGroup rgDegreeProgram = findViewById(R.id.rgDegreeProgram);
        EditText etunimi = findViewById(R.id.editTextEtunimi);
        EditText sukunimi = findViewById(R.id.editTextEtunimi);
        EditText sahkoposti = findViewById(R.id.editTextEtunimi);
        String degreeProgram = "";

        //Check state of the radiobutton
        switch (rgDegreeProgram.getCheckedRadioButtonId()) {
            case R.id.rbTuta:
                degreeProgram = "Tuotantotalous";
                break;
            case R.id.rbTite:
                degreeProgram = "Tietotekniikka";
                break;
            case R.id.rbLT:
                degreeProgram = "Laskennallinen tekniikka";
                break;
            case R.id.rbSate:
                degreeProgram = "Sähkötekniikka";
                break;
        }

        //Add to ArrayList
        User user = new User(String.valueOf(etunimi.getText()),
                String.valueOf(sukunimi.getText()),
                String.valueOf(sahkoposti.getText()), degreeProgram);

        //Permission here!?
        getContentResolver().takePersistableUriPermission(uri,
                Intent.FLAG_GRANT_READ_URI_PERMISSION);
        user.setImageUri(uri);
        UserStorage.getInstance().addUser(user);

    }


}