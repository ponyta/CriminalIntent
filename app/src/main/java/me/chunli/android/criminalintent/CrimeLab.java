package me.chunli.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Singleton class containing all crimes.
 */
public class CrimeLab {
    private static CrimeLab INSTANCE;

    private List<Crime> crimes;

    public static CrimeLab getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new CrimeLab(context);
        }
        return INSTANCE;
    }

    /* TODO: use context */
    private CrimeLab(Context context) {
        crimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            crime.setRequiresPolice(false);
            crimes.add(crime);
        }
    }

    public Crime atPosition(int position) {
        return crimes.get(position);
    }

    public int getLength() {
        return crimes.size();
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : crimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
