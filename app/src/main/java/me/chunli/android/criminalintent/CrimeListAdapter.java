package me.chunli.android.criminalintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CrimeListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private static final int CRIME_ITEM_HOLDER = 0;
    private static final int CONTACT_POLICE_ITEM_HOLDER = 1;

    private Context context;
    private CrimeLab crimeLab;

    public CrimeListAdapter(Context context) {
        this.context = context;
        this.crimeLab = CrimeLab.getInstance(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == CRIME_ITEM_HOLDER) {
            return new CrimeHolder(inflater, parent);
        } else if (viewType == CONTACT_POLICE_ITEM_HOLDER) {
            return new ContactPoliceHolder(inflater, parent);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return crimeLab.atPosition(position).isRequiresPolice() ?
                CONTACT_POLICE_ITEM_HOLDER : CRIME_ITEM_HOLDER;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case CRIME_ITEM_HOLDER:
                bindCrimeHolder((CrimeHolder) holder, position);
                break;
            case CONTACT_POLICE_ITEM_HOLDER:
                bindContactPoliceHolder((ContactPoliceHolder) holder, position);
                break;
        }
    }

    private void bindCrimeHolder(@NonNull CrimeHolder holder, int position) {
        Crime crime = crimeLab.atPosition(position);
        holder.crimeTitle.setText(crime.getTitle());
        holder.crimeDate.setText(crime.getFormattedDateTime());
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, crime.getTitle() + " clicked!",
                    Toast.LENGTH_SHORT)
                    .show();
        });
    }

    private void bindContactPoliceHolder(@NonNull ContactPoliceHolder holder,
                                         int position) {
        Crime crime = crimeLab.atPosition(position);
        holder.crimeTitle.setText(crime.getTitle());
        holder.contactPolice.setOnClickListener(v -> {
            Toast.makeText(context, "Police called!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return crimeLab.getLength();
    }

    class CrimeHolder extends ViewHolder {
        private TextView crimeTitle;
        private TextView crimeDate;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            crimeTitle = itemView.findViewById(R.id.crime_title);
            crimeDate = itemView.findViewById(R.id.crime_date);
        }
    }

    class ContactPoliceHolder extends ViewHolder {
        private TextView crimeTitle;
        private Button contactPolice;

        public ContactPoliceHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_police_crime, parent, false));
            crimeTitle = itemView.findViewById(R.id.crime_title);
            contactPolice = itemView.findViewById(R.id.contact_police);
        }
    }
}
