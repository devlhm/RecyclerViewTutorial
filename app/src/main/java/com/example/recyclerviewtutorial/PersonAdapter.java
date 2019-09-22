package com.example.recyclerviewtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<Person> people;
    private ItemClicked activity;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list) {
        this.people = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPreference;
        TextView tvName, tvSurname;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            ivPreference = itemView.findViewById(R.id.ivPreference);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(people.indexOf(view.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {

        Person person = people.get(position);

        holder.itemView.setTag(person);

        holder.tvName.setText(person.getName());
        holder.tvSurname.setText(person.getSurname());

        String preference = person.getPreference();

        if(preference.equals("bus")) {
            holder.ivPreference.setImageResource(R.drawable.bus_icon);
        } else {
            holder.ivPreference.setImageResource(R.drawable.airplane_icon);
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
