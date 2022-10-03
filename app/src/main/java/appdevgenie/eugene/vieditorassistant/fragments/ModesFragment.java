package appdevgenie.eugene.vieditorassistant.fragments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import appdevgenie.eugene.vieditorassistant.R;

public class ModesFragment extends Fragment {

    private View view;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        view = inflater.inflate(R.layout.modes_about, container, false);

        initialize();

        return view;
    }

    private void initialize() {

        TextView tvListLabel = view.findViewById(R.id.tvListLabel);
        tvListLabel.setText(getString(R.string.modes));

        TextView tvModes = view.findViewById(R.id.tvInfoAboutModes);

        String data = readTextFile(context, R.raw.modes_vi);
        tvModes.setText(data);

    }

    public static String readTextFile(Context ctx, int resId) {
        InputStream inputStream = ctx.getResources().openRawResource(resId);

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedreader = new BufferedReader(inputStreamReader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = bufferedreader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
        } catch (IOException e) {
            return null;
        }
        return stringBuilder.toString();
    }

}
