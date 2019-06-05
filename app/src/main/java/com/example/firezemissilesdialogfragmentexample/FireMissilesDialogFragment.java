package com.example.firezemissilesdialogfragmentexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/*
The code below was taken from https://developer.android.com/guide/topics/ui/dialogs#DialogFragment.
I would like to stress that the copyright probably belongs to Google and this is in no way my own creative product.
This merely serves as a complete tutorial example to show how the Fire Ze Missiles snippet could be implemented.
*/

public class FireMissilesDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        String dataToBePassed = "Missiles away!";
                        Intent yourOtherIntentVariable = new Intent(getActivity().getApplicationContext(),MainActivity.class);
                        yourOtherIntentVariable.putExtra("yourUniqueIntentKey", dataToBePassed); //This key should correspond to the key in line 38 of MainActivity
                        startActivity(yourOtherIntentVariable);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
