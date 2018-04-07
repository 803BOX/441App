package com.example.a803bo.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class CompleteDialogFragment extends DialogFragment {


    public static CompleteDialogFragment newInstance(int time) {
        CompleteDialogFragment completeFrag = new CompleteDialogFragment();
        Bundle args = new Bundle();
        args.putInt("time", time);
        completeFrag.setArguments(args);
        return completeFrag;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        int time = getArguments().getInt("time");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("That\'s everything!\nYou finished the hunt in "+time+" seconds.")
                .setPositiveButton("Return to Start", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        getActivity().finish();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
