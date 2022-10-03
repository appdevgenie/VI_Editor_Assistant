package appdevgenie.eugene.vieditorassistant.fragments;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import appdevgenie.eugene.vieditorassistant.R;

public class InfoDialogBoxFragment extends DialogFragment {

    private View view;
    private String sLabel, sInfo;

    public InfoDialogBoxFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_box, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {

            sLabel = bundle.getString("label");
            sInfo = bundle.getString("info");
        }


        setUpVariables();
        return view;
    }

    private void setUpVariables() {

        setCancelable(false);

        Window window = getDialog().getWindow();
        if (window != null) {

            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        }

        TextView tvLabel = (TextView) view.findViewById(R.id.tvDialogBoxLabel);
        TextView tvInfo = (TextView) view.findViewById(R.id.tvDialogBoxInfo);

        tvLabel.setText(sLabel);
        tvInfo.setText(sInfo);

        Button bOK = (Button) view.findViewById(R.id.bDialogBoxOk);
        bOK.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                dismiss();
            }
        });

    }


}
