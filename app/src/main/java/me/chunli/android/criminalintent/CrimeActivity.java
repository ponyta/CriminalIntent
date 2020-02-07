package me.chunli.android.criminalintent;

import androidx.fragment.app.Fragment;

public class CrimeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
