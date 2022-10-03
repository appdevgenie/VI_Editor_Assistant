package appdevgenie.eugene.vieditorassistant.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import appdevgenie.eugene.vieditorassistant.R;

public class ViMainFragment extends Fragment implements OnItemClickListener {

    private MainListHandler handler;
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
        tvListLabel.setText(getString(R.string.vi_commands));

        ListView lvMain = (ListView) view.findViewById(R.id.lvListView);

        String[] mainMenuTitles = context.getResources().getStringArray(R.array.vi_main);
        String[] mainMenuSubTitles = context.getResources().getStringArray(R.array.vi_main_desc);
        int[] images = new int[]{R.drawable.modes, R.drawable.about, R.drawable.start,
                R.drawable.exit, R.drawable.insert, R.drawable.delete, R.drawable.copy,
                R.drawable.search, R.drawable.paste, R.drawable.move_cursor, R.drawable.move_screen,
                R.drawable.other, R.drawable.info};

        MainMenuListAdapter mainMenuListAdapter =
                new MainMenuListAdapter(context, mainMenuTitles, mainMenuSubTitles, images);

        lvMain.setAdapter(mainMenuListAdapter);

        lvMain.setOnItemClickListener(this);

    }

    public interface MainListHandler {

        void onHandleMainListClicked(int position);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        handler.onHandleMainListClicked(position);

    }

    @Override
    public void onAttach(Context activity) {

        super.onAttach(activity);

        try {

            handler = (MainListHandler) getActivity();

        } catch (ClassCastException e) {

            e.printStackTrace();
        }
    }

    private class MainMenuListAdapter extends BaseAdapter {

        String[] title, description;
        int[] image;
        Context context;

        MainMenuListAdapter(Context ctx, String[] titles, String[] descriptions, int[] images) {

            this.context = ctx;
            this.title = titles;
            this.description = descriptions;
            this.image = images;
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View row = view;

            if (row == null) {

                LayoutInflater inflater = (LayoutInflater)
                        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.lv_main_row, viewGroup, false);
            }

            TextView tit = (TextView) row.findViewById(R.id.tvMainMenuListItem);
            TextView desc = (TextView) row.findViewById(R.id.tvMainMenuListSubItem);
            ImageView iv = (ImageView) row.findViewById(R.id.ivMainMenuListItem);

            tit.setText(title[i]);
            desc.setText(description[i]);
            iv.setImageResource(image[i]);

            return row;
        }
    }

}
