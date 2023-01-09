package com.vojtechadam.fastcoupons;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MorningFragment extends Fragment {
    Spinner spinner;
    int check = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_morning, container, false);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> types = new ArrayList<String>();

        // Change language
        SharedPreferences pref = getContext().getSharedPreferences("Settings", 0);
        int language = pref.getInt("Language", -1);
        if (language == 0) {
            types.clear();
            types.add("Snídaňové kupóny");
            types.add("Obědové kupóny");
            types.add("Ostatní kupóny");
            TextView text1 = view.findViewById(R.id.text1);
            text1.setText("Obědové kupóny");
            TextView text2 = view.findViewById(R.id.type);
            text2.setText("Typ kupónů");
            TextView text3 = view.findViewById(R.id.text2);
            text3.setText("• Tyto kupóny lze uplatnit od 10:30");
            TextView text4 = view.findViewById(R.id.text3);
            text4.setText("• Některé produkty nemusí být ve všech restauracích");
        } else if (language == 1) {
            types.clear();
            types.add("Morning coupons");
            types.add("Afternoon Coupons");
            types.add("Other Coupons");
            TextView text1 = view.findViewById(R.id.text1);
            text1.setText("Afternoon Coupons");
            TextView text2 = view.findViewById(R.id.type);
            text2.setText("Coupons type");
            TextView text3 = view.findViewById(R.id.text2);
            text3.setText("• You can apply this coupons from 10:30 AM");
            TextView text4 = view.findViewById(R.id.text3);
            text4.setText("• Not all coupons can be applied in all places");
        }

        //Animate buttons
        Button morning1 = view.findViewById(R.id.morning1);
        Button morning2 = view.findViewById(R.id.morning2);

        morning1.setAlpha(0f);
        morning1.setTranslationX(-100);
        morning2.setAlpha(0f);
        morning2.setTranslationX(-100);

        morning1.animate().alpha(1f).translationXBy(100).setDuration(1500);
        morning2.animate().alpha(1f).translationXBy(100).setDuration(1500);

        //Spinner
        spinner = view.findViewById(R.id.idSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, types);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long id) {
                if (++check > 1) {
                    if (parent.getItemAtPosition(pos).toString().equals("Obědové kupóny")) {
                        getParentFragmentManager().beginTransaction().replace(R.id.container, new AfternoonFragment()).commit();
                    }
                    if (parent.getItemAtPosition(pos).toString().equals("Ostatní kupóny")) {
                        getParentFragmentManager().beginTransaction().replace(R.id.container, new OtherFragment()).commit();
                    }
                    if (parent.getItemAtPosition(pos).toString().equals("Afternoon Coupons")) {
                        getParentFragmentManager().beginTransaction().replace(R.id.container, new MorningFragment()).commit();
                    }
                    if (parent.getItemAtPosition(pos).toString().equals("Other Coupons")) {
                        getParentFragmentManager().beginTransaction().replace(R.id.container, new OtherFragment()).commit();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        // Set button listeners
        setListeners(view);
    }

    //
    // COUPONS
    //

    private void setListeners(View view) {
        view.findViewById(R.id.morning1).setOnClickListener(view1 -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setIcon(R.drawable.ic_baseline_free_breakfast_24);
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {
                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 900 23");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Morning1Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {
                        Intent intent = new Intent(getContext(), Morning1Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        });

        view.findViewById(R.id.morning2).setOnClickListener(view1 -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setIcon(R.drawable.ic_baseline_free_breakfast_24);
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {
                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setMessage("Zadej prosím tento kód:\n132 852 34");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Morning2Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {
                        Intent intent = new Intent(getContext(), Morning2Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        });
    }
}