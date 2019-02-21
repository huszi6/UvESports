package com.example.uvesports;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class D1Adapter extends ArrayAdapter<D1> {

    private Context context;
    private List<D1> d1;

    public D1Adapter(Context context, List<D1> list){
        super(context,R.layout.item_d1, list);
        this.context = context;
        this.d1 = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_d1, parent, false);

        TextView d1_date = convertView.findViewById(R.id.d1_date);
        TextView d1_league = convertView.findViewById(R.id.d1_league);
        TextView d1_teams = convertView.findViewById(R.id.d1_teams);
        TextView d1_pick = convertView.findViewById(R.id.d1_pick);
        TextView d1_odds = convertView.findViewById(R.id.d1_odds);
        TextView d1_outcome = convertView.findViewById(R.id.d1_outcome);

        d1_date.setText(d1.get(position).getDate_of());
        d1_league.setText(d1.get(position).getLeague());
        d1_teams.setText(d1.get(position).getTeams());
        d1_pick.setText(d1.get(position).getPick());
        d1_odds.setText(d1.get(position).getOdds());
        d1_outcome.setText(d1.get(position).getOutcome());

        return convertView;
    }
}
