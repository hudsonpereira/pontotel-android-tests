package br.com.hudsonpereira.pontoteltest.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.hudsonpereira.pontoteltest.R;
import br.com.hudsonpereira.pontoteltest.api.model.User;

/**
 * Created by hudson on 31/01/18.
 */

public class UsersAdapter extends ArrayAdapter<User>{

    public UsersAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Lookup view for data population
        TextView tvId = convertView.findViewById(R.id.id);
        TextView tvName = convertView.findViewById(R.id.name);
        TextView tvPwd = convertView.findViewById(R.id.pwd);

        // Populate the data into the template view using the data object
        tvId.setText("ID: " + user.getId());
        tvName.setText("Name: " + user.getName());
        tvPwd.setText("Pwd: " + user.getPwd());

        // Return the completed view to render on screen
        return convertView;
    }
}
