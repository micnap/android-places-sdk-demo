package com.mickeywilliamson.placesandroid;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;
import java.util.List;

/*
    This app created for a Places SDK demo. See https://youtu.be/YqIFoNCzVk0.
    This activity demonstrates the Places' AutocompleteSupportFragment widget.
 */
public class AutocompleteFragmentActivity extends AppCompatActivity {

    private PlacesClient placesClient;
    private TextView mName;
    private TextView mAddress;
    private TextView mPhone;
    private TextView mWeb;
    private ImageView mImage;
    private TextView mImageAttribution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete_fragment);

        setTitle(getString(R.string.fragment_autocomplete));

        mName = findViewById(R.id.name);
        mAddress = findViewById(R.id.address);
        mPhone = findViewById(R.id.phone);
        mWeb = findViewById(R.id.web);
        mImage = findViewById(R.id.image);
        mImageAttribution = findViewById(R.id.photo_attribution);

        // Initialize and create a new Places client instance.
        Places.initialize(getApplicationContext(), GlobalApplication.getKey(this));
        placesClient = Places.createClient(this);

        // Set up the Places AutoCompleteSupportFragment widget.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment) getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Set the fields we want returned from the widget result.
        autocompleteFragment.setPlaceFields(Arrays.asList(
                Place.Field.NAME,
                Place.Field.ADDRESS,
                Place.Field.PHONE_NUMBER,
                Place.Field.WEBSITE_URI,
                Place.Field.PHOTO_METADATAS)
        );

        // Set a listener on the widgets from which we'll get the place that the user chose from the list.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull final Place place) {

                // TODO: Extract duplicate code from below and AutoCompleteActivityActivity.java into method.
                List<PhotoMetadata> photoMetadataList = place.getPhotoMetadatas();

                if (photoMetadataList != null) {

                    PhotoMetadata photoMetadata = photoMetadataList.get(0);

                    final String attributions = photoMetadata.getAttributions();

                    // Create a FetchPhotoRequest.
                    FetchPhotoRequest photoRequest = FetchPhotoRequest.builder(photoMetadata)
                            .build();

                    placesClient.fetchPhoto(photoRequest).addOnSuccessListener(new OnSuccessListener<FetchPhotoResponse>() {
                        @Override
                        public void onSuccess(FetchPhotoResponse fetchPhotoResponse) {
                            Bitmap bitmap = fetchPhotoResponse.getBitmap();
                            mImage.setImageBitmap(bitmap);
                            mImage.setContentDescription("Image of " + place.getName());

                            // In versions N and greater, the fromHtml method has an additional flag parameter
                            // which determines how the HTML is displayed.
                            // See https://stackoverflow.com/questions/37904739/html-fromhtml-deprecated-in-android-n/37905107#answer-40241338
                            // for a comparison of the available flags.
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                mImageAttribution.setMovementMethod(LinkMovementMethod.getInstance());
                                mImageAttribution.setText(Html.fromHtml("Photo attribution: " + attributions, Html.FROM_HTML_MODE_LEGACY));
                            }
                            else {
                                mImageAttribution.setMovementMethod(LinkMovementMethod.getInstance());
                                mImageAttribution.setText(Html.fromHtml("Photo attribution: " + attributions));
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            if (exception instanceof ApiException) {
                                // TODO: Handle error with given status code.
                                Log.e("IMAGE ERROR", "Place not found: " + exception.getMessage());
                            }
                        }
                    });
                }

                mName.setText(place.getName());
                mAddress.setText(place.getAddress());
                mPhone.setText(place.getPhoneNumber());
                mWeb.setText(place.getWebsiteUri().toString());
            }

            @Override
            public void onError(@NonNull Status status) {
                Log.i("ERROR", "An error occurred: " + status);
            }
        });
    }
}
