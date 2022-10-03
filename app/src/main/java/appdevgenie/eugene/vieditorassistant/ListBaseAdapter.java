package appdevgenie.eugene.vieditorassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListBaseAdapter extends BaseAdapter {

    //ArrayList<SingleRow> list;
    Context context;
    String[] title;
    String[] description;

    public ListBaseAdapter(Context context, String[] titles, String[] descriptions) {

        this.context = context;
        this.title = titles;
        this.description = descriptions;

       /* list = new ArrayList<SingleRow>();

        for (int i = 0; i < title.length; i++) {

            list.add(new SingleRow(title[i], description[i]));
        }
*/
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        if (row == null) {

            /*LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(R.layout.command_double_row, parent, false);*/

            row = LayoutInflater.from(context).inflate(R.layout.command_double_row, parent, false);

        }

        TextView tit = row.findViewById(R.id.tvCommandTitle);
        TextView desc = row.findViewById(R.id.tvCommandDescription);

       // SingleRow temp = list.get(position);

        tit.setText(title[position]);
        desc.setText(description[position]);

        return row;
    }


    /*class SingleRow {

        String title;
        String description;

        public SingleRow(String title, String description) {

            this.title = title;
            this.description = description;
        }
    }*/

}