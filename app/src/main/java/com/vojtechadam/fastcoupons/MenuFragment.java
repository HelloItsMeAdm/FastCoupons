package com.vojtechadam.fastcoupons;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Change language
        SharedPreferences pref = getContext().getSharedPreferences("Settings", 0);
        int language = pref.getInt("Language", -1);
        if (language == 1) {
            TextView tutorials_mcd = view.findViewById(R.id.tutorials_mcd);
            tutorials_mcd.setText("Tutorials - McDonald's");
            Button tutorial_kupon = view.findViewById(R.id.tutorial_kupon);
            tutorial_kupon.setText("How to use coupons?");
            TextView tutorial_pay = view.findViewById(R.id.tutorial_pay);
            tutorial_pay.setText("Pay cash at the tablet");
            TextView other = view.findViewById(R.id.other);
            other.setText("Other");
            Button share = view.findViewById(R.id.share);
            share.setText("Share application");
            Button about = view.findViewById(R.id.about);
            about.setText("About Fast Coupons");
            Button settings = view.findViewById(R.id.settings);
            settings.setText("Settings");
        }

        //Buttons
        view.findViewById(R.id.tutorial_kupon).setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new TutorialKuponFragment()).commit();
        });
        view.findViewById(R.id.tutorial_pay).setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new TutorialPayFragment()).commit();
        });
        view.findViewById(R.id.share).setOnClickListener(view1 -> {
            if (language == 0) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String subject = "Máš hlad, jsi v Mekáči nebo KFC, ale máš málo peněz? Tak je potom tato aplikace přímo pro tebe!\n\nStahuj aplikaci Fast Coupons na https://beacons.page/helloitsmeadm";
                i.putExtra(android.content.Intent.EXTRA_TEXT, subject);
                startActivity(Intent.createChooser(i, "Vyber, komu to posleš!"));
            } else if (language == 1) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String subject = "You're hungry, you're at McDonald's or KFC, but you're short on cash? Then this app is for you!\n\nDownload the Fast Coupons app at https://beacons.page/helloitsmeadm";
                i.putExtra(android.content.Intent.EXTRA_TEXT, subject);
                startActivity(Intent.createChooser(i, "Choose who you send it to!"));
            }
        });
        view.findViewById(R.id.changelog).setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new ChangeLogFragment()).commit();
        });
        view.findViewById(R.id.about).setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new InfoFragment()).commit();
        });
        view.findViewById(R.id.settings).setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new SettingsFragment()).commit();
        });
    }
}