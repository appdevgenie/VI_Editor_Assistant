package appdevgenie.eugene.vieditorassistant.fragments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import appdevgenie.eugene.vieditorassistant.R;


public class InfoFragment extends Fragment implements View.OnClickListener {

    private static String APP_PACKAGE_NAME;

    private View view;
    private Context context;
    private String couldNotOpen;
    private String version;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.info, container, false);

        initialise();

        return view;
    }

    private void initialise() {

        context = getActivity();

        couldNotOpen = "Could not open Play store";

        TextView tvListLabel = (TextView) view.findViewById(R.id.tvListLabel);
        tvListLabel.setText(getString(R.string.info));

        APP_PACKAGE_NAME = getActivity().getPackageName();

        TextView tvVersion = (TextView) view.findViewById(R.id.tvInfoVersion);

        try {
            version = getActivity().getPackageManager().getPackageInfo(
                    getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {

            e.printStackTrace();
        }

        String ver = "Ver. " + version;
        tvVersion.setText(ver);


        Button bRate = (Button) view.findViewById(R.id.bInfoRate);
        Button bDisclaimer = (Button) view.findViewById(R.id.bInfoDisclaimer);


        bRate.setOnClickListener(this);
        bDisclaimer.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        FragmentManager manager;

        Bundle bundle = new Bundle();

        switch (v.getId()) {
            case R.id.bInfoRate:

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=" + APP_PACKAGE_NAME));

                if (!GoToPlayStore(intent)) {
                    intent.setData(Uri
                            .parse("https://play.google.com/store/apps/details?id="
                                    + APP_PACKAGE_NAME));

                    if (!GoToPlayStore(intent)) {

                        Toast.makeText(context, couldNotOpen, Toast.LENGTH_LONG)
                                .show();
                    }
                }

                break;


            case R.id.bInfoDisclaimer:

                String label = "Disclaimer";
                String info = getResources().getString(R.string.disclaimer_text);

                manager = getFragmentManager();
                bundle.putString("label", label);
                bundle.putString("info", info);
                InfoDialogBoxFragment infoDialogBox = new InfoDialogBoxFragment();
                infoDialogBox.setArguments(bundle);
                infoDialogBox.show(manager, "infoDialogBox");

                break;


            default:
                break;
        }

    }

    private boolean GoToPlayStore(Intent intent) {

        try {

            startActivity(intent);
            return true;

        } catch (ActivityNotFoundException e) {

            return false;
        }

    }
}
