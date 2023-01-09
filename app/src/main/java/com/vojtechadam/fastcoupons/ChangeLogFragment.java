package com.vojtechadam.fastcoupons;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class ChangeLogFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_changelog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Change language
        SharedPreferences pref = getContext().getSharedPreferences("Settings", 0);
        int language = pref.getInt("Language", -1);
        if (language == 1) {
            Button button1 = view.findViewById(R.id.nav);
            button1.setText("Back");
            TextView whatchanged = view.findViewById(R.id.whatchanged);
            whatchanged.setText("Changelog");
            TextView update122_title = view.findViewById(R.id.update122_title);
            update122_title.setText("Version 1.2.2");
            TextView update122_content = view.findViewById(R.id.update122_content);
            update122_content.setText("• Added category 'Settings'\n• Option to change language\n• Graphics changes");
            TextView update121_title = view.findViewById(R.id.update121_title);
            update121_title.setText("Version 1.2.1");
            TextView update121_content = view.findViewById(R.id.update121_content);
            update121_content.setText("• Removed ads\n• Optimization");
            TextView update120_title = view.findViewById(R.id.update120_title);
            update120_title.setText("Version 1.2.0");
            TextView update120_content = view.findViewById(R.id.update120_content);
            update120_content.setText("• Modified app style\n• Modified icon\n• Modified app name\n• New app update system");
            TextView update110_title = view.findViewById(R.id.update110_title);
            update110_title.setText("Version 1.1.0");
            TextView update110_content = view.findViewById(R.id.update110_content);
            update110_content.setText("• Modified app launching\n• Now shows introduction on first launch\n• Added option to share the app\n• FINALLY finished coupons at checkout\n• Modified some information messages\n• App update now goes directly in the app\n• Modified some texts\n• Added category 'What's new?' (logically)\n• Modified style of buttons for coupons");
        }

        view.findViewById(R.id.nav).setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container,new MenuFragment()).commit();
        });
    }
}