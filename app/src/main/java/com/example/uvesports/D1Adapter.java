package com.example.uvesports;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class D1Adapter extends ArrayAdapter<D1> {

    private Context context;
    private List<D1> d1;
    int [] d1_status_list = new int[] {R.drawable.ic_check_black_24dp, R.drawable.ic_clear_black_24dp, R.drawable.ic_remove_black_24dp};



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
        ImageView d1_status = convertView.findViewById(R.id.ic_d1_status);


        d1_date.setText(d1.get(position).getDate_of());
        d1_league.setText(d1.get(position).getLeague());
        d1_teams.setText(d1.get(position).getTeams());
        d1_pick.setText(d1.get(position).getPick());
        d1_odds.setText(d1.get(position).getOdds());
        d1_outcome.setText(d1.get(position).getOutcome());

        switch(d1_outcome.getText().toString()) {
            case "WIN":
                d1_outcome.setTextColor(Color.parseColor("#10A881"));
                d1_status.setImageResource(d1_status_list[0]);
                break;
            case "LOSE":
                d1_outcome.setTextColor(Color.parseColor("#FF4848"));
                d1_status.setImageResource(d1_status_list[1]);
                break;
            case "PUSH" :
                d1_outcome.setTextColor(Color.parseColor("#99AAAB"));
                d1_status.setImageResource(d1_status_list[2]);
                break;

        }

        /*if(d1_outcome.getText().toString().equals("WIN")){
            d1_outcome.setTextColor(Color.parseColor("#10A881"));
            d1_status.setImageResource(d1_status_list[0]);
        }
        else if (d1_outcome.getText().toString().equals("LOSE"))
        {
            d1_outcome.setTextColor(Color.parseColor("#FF4848"));
            d1_status.setImageResource(d1_status_list[1]);
        }
        else
            d1_outcome.setTextColor(Color.parseColor("#99AAAB"));
            d1_status.setImageResource(d1_status_list[2]);*/



        return convertView;
    }
}
