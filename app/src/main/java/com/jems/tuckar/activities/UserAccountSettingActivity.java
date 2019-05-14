package com.jems.tuckar.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jems.tuckar.R;
import com.jems.tuckar.fragments.ResetPasswordFragment;
import com.jems.tuckar.fragments.UserInformationFragment;
import com.jems.tuckar.utils.ChangeBackground;
import com.jems.tuckar.utils.ImageUtils;
import com.squareup.picasso.Picasso;

public class UserAccountSettingActivity extends AppCompatActivity {

    private final int REQUEST_CODE_GALLERY = 0;
    private final int REQUEST_CODE_CAMERA = 1;
    private ImageView imgViewProfile;
    private FragmentManager manager;
    private Button btUserGeneralInfo, btResetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account_setting);

        initViews();

        manager = getSupportFragmentManager();

        showUserGeneralInfo(null);
    }

    /**************** Init Views  *****************/
    private void initViews() {
        imgViewProfile = findViewById(R.id.image_profile);
        btResetPassword = findViewById(R.id.bt_reset_password);
        btUserGeneralInfo = findViewById(R.id.bt_user_general_info);
    }

    /****************  add profile image onClick  *****************/
    public void changeProfileImageOnClick(View view) {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle(R.string.select_action);
        pictureDialog.setCancelable(false);
        String[] pictureDialogItems = {getString(R.string.take_photo_from_camera), getString(R.string.choose_photo_from_gallery)
                , getString(R.string.remove_photo)};
        pictureDialog.setItems(pictureDialogItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                     //   takePhotoFromCamera();
                        break;
                    case 1:
                       // choosePhotoFromGallery();
                        break;
                    case 2:
                       // removePhoto();
                        break;
                }
            }
        });
        pictureDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        pictureDialog.show();
    }

   /* *//**************** On Activity Result *****************//*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_GALLERY) {
                Uri selectedImageUri = resultData.getData();
               // imgViewProfile.setImageURI(selectedImageUri);
                *//* OR *//*
                ImageUtils.setImage(this, String.valueOf(selectedImageUri), imgViewProfile);

            }

            if (requestCode == REQUEST_CODE_CAMERA) {
                Bundle extras = resultData.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imgViewProfile.setImageBitmap(imageBitmap);

                //little bit slow white set image into image view
               *//* Uri photoCaptured = resultData.getData();
                imgViewProfile.setImageURI(photoCaptured);*//*
            }

        }
    }

    *//****************  Choose Photo From Gallery  *****************//*
    public void choosePhotoFromGallery() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, getString(R.string.select_picture)), REQUEST_CODE_GALLERY);
      *//*  if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(Intent.createChooser(intent, getString(R.string.select_picture)), REQUEST_CODE_GALLERY);
        }*//*

    }

    *//****************  Take Photo from Camera  *****************//*
    public void takePhotoFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
       *//* if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CODE_CAMERA);
        }*//*

    }*/

    /****************  back Arrow OnClick  *****************/
    public void backArrowOnClick(View view) {
        onBackPressed();
    }

    /****************  Remove Photo  *****************/
    private void removePhoto() {
        imgViewProfile.setImageResource(R.drawable.profile_default_image);
    }

    /****************  button General Info OnClick  *****************/
    public void showUserGeneralInfo(View view) {
        ChangeBackground.onClickView(btUserGeneralInfo, btResetPassword);
        UserInformationFragment fragment = new UserInformationFragment();

        manager.beginTransaction().replace(R.id.ll_fragment_container, fragment).commit();
    }


    /****************  Button Reset Password OnClick  *****************/
    public void resetPassword(View view) {
        ChangeBackground.onClickView(btResetPassword, btUserGeneralInfo);
        manager.beginTransaction().replace(R.id.ll_fragment_container, new ResetPasswordFragment()).commit();
    }

    /****************    *****************/


    /****************    *****************/
}
