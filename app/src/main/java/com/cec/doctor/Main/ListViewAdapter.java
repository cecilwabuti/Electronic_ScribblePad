package com.cec.doctor.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cec.doctor.Main.AnimalNames;
import com.cec.doctor.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<AnimalNames> animalNamesList;
    private ArrayList<AnimalNames> arraylist;

  ListViewAdapter(Context context, Collection<? extends AnimalNames> animalNamesList) {
      //    variables
      this.animalNamesList = (List<AnimalNames>) animalNamesList;
      inflater = LayoutInflater.from(context);
      this.arraylist = new ArrayList<>();
      this.arraylist.addAll(animalNamesList);
  }

    public boolean getFilter() {
      return true;
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return animalNamesList.size();
    }

    @Override
    public Object getItem(int position) {
        return animalNamesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_items, null);
            // Locate the TextViews in listview_item.xml

            holder.name = view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(animalNamesList.get(position).getAnimalName());
        return view;
        }

    // Filter Class
    void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        animalNamesList.clear();
        if (charText.length() == 0) {
            animalNamesList.addAll(arraylist);
        } else {
            for (AnimalNames wp : arraylist) {
                if (wp.getAnimalName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    animalNamesList.add(wp);
                }
            }
        notifyDataSetChanged();

    }
  }
//    public class ListItemDetail extends AppCompatActivity {

//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.list_view_items);
//            Intent intent = getIntent();
//            int position = intent.getIntExtra("position", 0);
//
//            // Here we turn your string.xml in an array
//            String[] myKeys = getResources().getStringArray(R.array.sections);
//
//            TextView myTextView = findViewById(R.id.nameLabel);
//            myTextView.setText(myKeys[position]);
//        }
//

}
