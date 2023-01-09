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

public class TutorialKuponFragment extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tutorial_kupon, container, false);
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
            title.setText("How about codes?");
            TextView tablet = view.findViewById(R.id.tablet);
            tablet.setText("On the tablet");
            TextView tablet_content = view.findViewById(R.id.tablet_content);
            tablet_content.setText("1) Find the code of the food you're craving\n2) On the tablet (top right) press the 'I have a coupon'\n3) Select Barcode\n4) Press 'Enter manually'\n5) Copy the code from the app\n6) Press 'Confirm' and you're done!");
            TextView cashdesk = view.findViewById(R.id.cashdesk);
            cashdesk.setText("At the ticket office");
            TextView cashdesk_content = view.findViewById(R.id.cashdesk_content);
            cashdesk_content.setText("1) You find the code of the food you want\n2) At the cashier you show the coupon\n3) Here it is possible that the cashier will send you somewhere, but it does not matter, you have to argue with her :)\n4) If you won the argument, you will get your food, if not you will probably be thrown out of the restaurant and you will be hungry :D");
        }

        view.findViewById(R.id.nav).setOnClickListener(view1 -> {
            getParentFragmentManager().beginTransaction().replace(R.id.container, new MenuFragment()).commit();
        });
    }
}