package com.jems.tuckar.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jems.tuckar.R;
import com.jems.tuckar.utils.ImageUtils;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserInformationFragment extends Fragment implements View.OnClickListener {

    private static final int REQUEST_CODE_CAMERA = 1;
    private static final int REQUEST_CODE_GALLERY = 0;
    private CircleImageView imgViewProfile;
    private ImageView imgCaptured;
    private Uri imgUri;

    public UserInformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_information, container, false);
        imgViewProfile = view.findViewById(R.id.image_profile);
        imgCaptured = view.findViewById(R.id.img_capture);
        imgCaptured.setOnClickListener(this);

        return view;
    }


    /****************  add profile image onClick  *****************/
    public void changeProfileImage() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(getActivity());
        pictureDialog.setTitle(R.string.select_action);
        pictureDialog.setCancelable(false);
        String[] pictureDialogItems = {getString(R.string.take_photo_from_camera), getString(R.string.choose_photo_from_gallery)
                , getString(R.string.remove_photo)};
        pictureDialog.setItems(pictureDialogItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        takePhotoFromCamera();
                        break;
                    case 1:
                        choosePhotoFromGallery();
                        break;
                    case 2:
                        removePhoto();
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

    /**************** On Activity Result *****************/
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_GALLERY) {
                Uri selectedImageUri = resultData.getData();
                // imgViewProfile.setImageURI(selectedImageUri);
                /* OR */
                ImageUtils.setImage(getActivity(), String.valueOf(selectedImageUri), imgViewProfile);

            }

            if (requestCode == REQUEST_CODE_CAMERA) {
                Bundle extras = resultData.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imgViewProfile.setImageBitmap(imageBitmap);

                //little bit slow white set image into image view
               /* Uri photoCaptured = resultData.getData();
                imgViewProfile.setImageURI(photoCaptured);*/
            }

        }
    }

    /****************  Choose Photo From Gallery  *****************/
    private void choosePhotoFromGallery() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(Intent.createChooser(intent, getString(R.string.select_picture)), REQUEST_CODE_GALLERY);
        }

    }

    /****************  Take Photo from Camera  *****************/
    private void takePhotoFromCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
       /* if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CODE_CAMERA);
        }*/

    }

    private void removePhoto() {
        imgViewProfile.setImageResource(R.drawable.profile_default_image);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_capture:
                changeProfileImage();
                break;
        }
    }
}
