package com.example.a803bo.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class TimeOutDialogFragment extends DialogFragment {

    public static TimeOutDialogFragment newInstance(int hunted) {
        TimeOutDialogFragment timeOutFrag = new TimeOutDialogFragment();
        Bundle args = new Bundle();
        args.putInt("hunted", hunted);
        timeOutFrag.setArguments(args);
        return timeOutFrag;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        int hunted = getArguments().getInt("hunted");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Time\'s up! \n You hunted up "+hunted+" items.")
                .setPositiveButton("Return to Start", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        getActivity().finish();
                    }
                });
        //I wonder if this is where onCancel goes
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
