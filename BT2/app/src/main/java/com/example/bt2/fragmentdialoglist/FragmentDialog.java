package com.example.bt2.fragmentdialoglist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class FragmentDialog extends DialogFragment {
    DialogDeleteData deleteData;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        deleteData = (DialogDeleteData) getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Thong bao");
        builder.setMessage("Ban co muon xoa sp nay khong?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteData.deleteValue(true);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteData.deleteValue(false);
            }
        });
        Dialog dialog = builder.create();
        return dialog;
    }
}
