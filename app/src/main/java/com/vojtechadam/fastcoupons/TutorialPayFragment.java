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

public class TutorialPayFragment extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tutorial_pay, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Change language
        SharedPreferences pref = getContext().getSharedPreferences("Settings", 0);
        int language = pref.getInt("Language", -1);
        if (language == 1) {
            Button nav = view.findViewById(R.id.nav);
            nav.setText("Back");
            TextView title = view.findViewById(R.id.title);
            title.setText("How do I pay cash when ordering from Tablet?");
            TextView content = view.findViewById(R.id.content);
            content.setText("1) After selecting all the things you want to do, you put 'Pay'\n2) Then 'Continue' and say that you WAN'T to donate to charity because you are a good person\n3) Now you wait about 30 seconds, for the payment to go through\n4) The tablet says the payment didn't go through okay, so you put 'Cancel'\n5) And now you just click that you want to pay at the checkout\n6) With the ticket, run to the checkout, pay it and you're done!");
            TextView note = view.findViewById(R.id.note);
            note.setText("Sometimes it happens that at the checkout they don't give you the coupon for that order and give it to you at full price. Be careful of this, just point it out to them.");
        }

        view.findViewById(R.id.nav).setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container,new MenuFragment()).commit();
        });
    }
}
