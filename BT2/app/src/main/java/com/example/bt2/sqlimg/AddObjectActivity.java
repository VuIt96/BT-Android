package com.example.bt2.sqlimg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bt2.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddObjectActivity extends AppCompatActivity {
    Button btAddObject, btCancelAdd;
    ImageButton imgCamera, imgFolder;
    ImageView imgImgView;
    EditText etNameObject, etDescription;
    int REQUEST_CODE_CAMERA = 123;
    int REQUEST_CODE_FOLDER = 222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_object);
        initEvent();
        setListener();
    }

    private void setListener() {

        btAddObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chuyen data img sang byte
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imgImgView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] hinhanh = byteArrayOutputStream.toByteArray();
                SQLImageActivity.dataBaseImage.InsertObject(
                        etNameObject.getText().toString().trim(),
                        etDescription.getText().toString().trim(),
                        hinhanh
                );
                Toast.makeText(AddObjectActivity.this, " thanh cong", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddObjectActivity.this, SQLImageActivity.class));
            }
        });
        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);
//                ActivityCompat.requestPermissions(
//                        AddObjectActivity.this,
//                        new String[]{Manifest.permission.CAMERA},
//                        REQUEST_CODE_CAMERA
//                );

            }
        });
        imgFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_FOLDER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgImgView.setImageBitmap(bitmap);
        }
        if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgImgView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initEvent() {
        btAddObject = (Button) findViewById(R.id.btAddObject);
        btCancelAdd = (Button) findViewById(R.id.btCancelAdd);
        imgCamera = (ImageButton) findViewById(R.id.imgCamera);
        imgFolder = (ImageButton) findViewById(R.id.imgFolder);
        imgImgView = (ImageView) findViewById(R.id.imgImgView);
        etNameObject = (EditText) findViewById(R.id.etNameObject);
        etDescription = (EditText) findViewById(R.id.etDescription);
    }
}
