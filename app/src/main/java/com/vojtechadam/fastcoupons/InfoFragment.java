package com.vojtechadam.fastcoupons;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class InfoFragment extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
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
            TextView about = view.findViewById(R.id.about);
            about.setText("About application");
            TextView content = view.findViewById(R.id.content);
            content.setText("• This app is for testing purposes only, the author is not responsible for any abuse\n• This app is against TOS McDonald's and KFC, so be happy that you got it so cheap thanks to me :)\n• Do you want to support me? Click the button below!\n• The development of this app started on 14.6.2021!");
            Button web = view.findViewById(R.id.web);
            web.setText("I wan't to support!");
        }

        view.findViewById(R.id.web).setOnClickListener(view1 -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://beacons.page/helloitsmeadm"));
            startActivity(browserIntent);
        });
        view.findViewById(R.id.nav).setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new MenuFragment()).commit();
        });
    }
}
