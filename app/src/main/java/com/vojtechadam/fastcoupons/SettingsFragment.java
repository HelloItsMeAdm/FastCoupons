package com.vojtechadam.fastcoupons;

import android.app.AlertDialog;
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
import androidx.fragment.app.FragmentActivity;

import org.jetbrains.annotations.NotNull;

public class SettingsFragment extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences pref = getContext().getSharedPreferences("Settings", 0);
        SharedPreferences.Editor editor = pref.edit();

        // Change language
        int language = pref.getInt("Language", -1);
        if (language == 1) {
            Button button1 = view.findViewById(R.id.nav);
            button1.setText("Back");
            TextView title = view.findViewById(R.id.title);
            title.setText("Settings");
            Button button2 = view.findViewById(R.id.language);
            button2.setText("Language");
        }

        final CharSequence[] items = {"Čeština", "English"};

        view.findViewById(R.id.language).setOnClickListener(view1 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setIcon(R.drawable.ic_baseline_translate_24);
            builder.setSingleChoiceItems(items, language, (dialog, item) -> {
                if (items[item] == "Čeština") {
                    editor.putInt("Language", 0);
                    editor.commit();
                } else if (items[item] == "English") {
                    editor.putInt("Language", 1);
                    editor.commit();
                }
            });
            if (language == 0) {
                builder.setTitle("Změnit jazyk");
                builder.setPositiveButton("Potvrdit",
                        (dialog, id) -> {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
                            builder2.setTitle("Vyžadován restart");
                            builder2.setMessage("Pro správné fungování aplikace je vyžadován restart.");
                            builder2.setCancelable(false);
                            builder2.setNegativeButton("Restartovat",
                                    (dialog2, id2) -> {
                                        System.exit(2);
                                    });
                            AlertDialog alert2 = builder2.create();
                            alert2.show();
                        });
                builder.setNegativeButton("Zrušit",
                        (dialog, id) -> {
                        });
            } else if (language == 1) {
                builder.setTitle("Change language");
                builder.setPositiveButton("Confirm",
                        (dialog, id) -> {
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
                            builder2.setTitle("Restart required");
                            builder2.setMessage("A restart is required for the application to function properly.");
                            builder2.setCancelable(false);
                            builder2.setNegativeButton("Restart",
                                    (dialog2, id2) -> {
                                        System.exit(2);
                                    });
                            AlertDialog alert2 = builder2.create();
                            alert2.show();
                        });
                builder.setNegativeButton("Cancel",
                        (dialog, id) -> {
                        });
            }
            AlertDialog alert = builder.create();
            alert.show();
        });
        view.findViewById(R.id.nav).setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new MenuFragment()).commit();
        });
    }
}