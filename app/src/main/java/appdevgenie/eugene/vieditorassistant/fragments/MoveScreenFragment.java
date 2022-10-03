package appdevgenie.eugene.vieditorassistant.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import appdevgenie.eugene.vieditorassistant.ListBaseAdapter;
import appdevgenie.eugene.vieditorassistant.R;

public class MoveScreenFragment extends Fragment {

    private View view;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        view = inflater.inflate(R.layout.vi_main_fragment, container, false);

        initialize();

        return view;
    }

    private void initialize() {

        TextView tvListLabel = (TextView) view.findViewById(R.id.tvListLabel);
        tvListLabel.setText(getString(R.string.move_screen));

        ListView lvMain = (ListView) view.findViewById(R.id.lvListView);

        String[] title = context.getResources().getStringArray(
                R.array.move_screen_title);
        String[] description = context.getResources().getStringArray(
                R.array.move_screen_disc);

        ListBaseAdapter adapter = new ListBaseAdapter(context, title, description);

        lvMain.setAdapter(adapter);
    }

}
