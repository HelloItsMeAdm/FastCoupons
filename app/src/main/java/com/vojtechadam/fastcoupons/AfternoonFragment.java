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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AfternoonFragment extends Fragment {
    Spinner spinner;
    int check = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_afternoon, container, false);
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
        Button afternoon1 = view.findViewById(R.id.afternoon1);
        Button afternoon2 = view.findViewById(R.id.afternoon2);
        Button afternoon3 = view.findViewById(R.id.afternoon3);
        Button afternoon4 = view.findViewById(R.id.afternoon4);
        Button afternoon5 = view.findViewById(R.id.afternoon5);
        Button afternoon6 = view.findViewById(R.id.afternoon6);
        Button afternoon7 = view.findViewById(R.id.afternoon7);
        Button afternoon8 = view.findViewById(R.id.afternoon8);
        Button afternoon9 = view.findViewById(R.id.afternoon9);
        Button afternoon10 = view.findViewById(R.id.afternoon10);
        Button afternoon11 = view.findViewById(R.id.afternoon11);
        Button afternoon12 = view.findViewById(R.id.afternoon12);
        Button afternoon13 = view.findViewById(R.id.afternoon13);
        Button afternoon14 = view.findViewById(R.id.afternoon14);
        Button afternoon15 = view.findViewById(R.id.afternoon15);
        Button afternoon16 = view.findViewById(R.id.afternoon16);
        Button afternoon17 = view.findViewById(R.id.afternoon17);
        Button afternoon18 = view.findViewById(R.id.afternoon18);
        Button afternoon19 = view.findViewById(R.id.afternoon19);
        Button afternoon20 = view.findViewById(R.id.afternoon20);
        Button afternoon21 = view.findViewById(R.id.afternoon21);
        Button afternoon22 = view.findViewById(R.id.afternoon22);
        Button afternoon23 = view.findViewById(R.id.afternoon23);

        afternoon1.setAlpha(0f);
        afternoon1.setTranslationX(-100);
        afternoon2.setAlpha(0f);
        afternoon2.setTranslationX(-100);
        afternoon3.setAlpha(0f);
        afternoon3.setTranslationX(-100);
        afternoon4.setAlpha(0f);
        afternoon4.setTranslationX(-100);
        afternoon5.setAlpha(0f);
        afternoon5.setTranslationX(-100);
        afternoon6.setAlpha(0f);
        afternoon6.setTranslationX(-100);
        afternoon7.setAlpha(0f);
        afternoon7.setTranslationX(-100);
        afternoon8.setAlpha(0f);
        afternoon8.setTranslationX(-100);
        afternoon9.setAlpha(0f);
        afternoon9.setTranslationX(-100);
        afternoon10.setAlpha(0f);
        afternoon10.setTranslationX(-100);
        afternoon11.setAlpha(0f);
        afternoon11.setTranslationX(-100);
        afternoon12.setAlpha(0f);
        afternoon12.setTranslationX(-100);
        afternoon13.setAlpha(0f);
        afternoon13.setTranslationX(-100);
        afternoon14.setAlpha(0f);
        afternoon14.setTranslationX(-100);
        afternoon15.setAlpha(0f);
        afternoon15.setTranslationX(-100);
        afternoon16.setAlpha(0f);
        afternoon16.setTranslationX(-100);
        afternoon17.setAlpha(0f);
        afternoon17.setTranslationX(-100);
        afternoon18.setAlpha(0f);
        afternoon18.setTranslationX(-100);
        afternoon19.setAlpha(0f);
        afternoon19.setTranslationX(-100);
        afternoon20.setAlpha(0f);
        afternoon20.setTranslationX(-100);
        afternoon21.setAlpha(0f);
        afternoon21.setTranslationX(-100);
        afternoon22.setAlpha(0f);
        afternoon22.setTranslationX(-100);
        afternoon23.setAlpha(0f);
        afternoon23.setTranslationX(-100);

        afternoon1.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon2.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon3.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon4.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon5.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon6.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon7.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon8.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon9.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon10.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon11.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon12.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon13.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon14.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon15.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon16.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon17.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon18.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon19.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon20.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon21.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon22.animate().alpha(1f).translationXBy(100).setDuration(1500);
        afternoon23.animate().alpha(1f).translationXBy(100).setDuration(1500);

        //Spinner
        spinner = view.findViewById(R.id.idSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, types);
        spinner.setAdapter(adapter);
        spinner.setSelection(1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long id) {
                if (++check > 1) {
                    if (parent.getItemAtPosition(pos).toString().equals("Snídaňové kupóny")) {
                        getParentFragmentManager().beginTransaction().replace(R.id.container, new MorningFragment()).commit();
                    }
                    if (parent.getItemAtPosition(pos).toString().equals("Ostatní kupóny")) {
                        getParentFragmentManager().beginTransaction().replace(R.id.container, new OtherFragment()).commit();
                    }
                    if (parent.getItemAtPosition(pos).toString().equals("Morning coupons")) {
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
        view.findViewById(R.id.afternoon1).setOnClickListener(view1 -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {
                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 901 22");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon1Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {
                        Intent intent = new Intent(getContext(), Afternoon1Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        });

        view.findViewById(R.id.afternoon2).setOnClickListener(view1 -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 900 30");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon2Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {
                        Intent intent = new Intent(getContext(), Afternoon2Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
        });

        view.findViewById(R.id.afternoon3).setOnClickListener(view1 -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 900 61");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon3Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon3Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon4).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 850 12");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon4Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon4Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon5).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 711 76");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon5Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon5Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon6).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 900 54");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon6Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon6Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon7).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 850 43");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon7Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon7Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon8).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 900 78");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon8Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon8Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon9).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 850 81");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon9Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon9Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon10).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 900 92");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon10Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon10Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon11).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 900 74");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon11Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon11Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon12).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 850 36");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon12Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon12Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon13).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 850 29");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon13Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon13Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon14).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kód (Jen u tabletu)",
                    (dialogInterface, i) -> {

                        AlertDialog.Builder builder11 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                        builder11.setTitle("Kód (Barcode)");
                        builder11.setIcon(R.drawable.ic_baseline_qr_code_scanner_24);
                        builder11.setMessage("Zadej prosím tento kód:\n132 901 15");
                        builder11.setCancelable(true);
                        setListeners(view);

                        builder11.setPositiveButton(
                                "Hotovo!",
                                (dialogInterface1, i1) -> {
                                    Toast.makeText(getContext(), "GRATULUJU a přeji dobrou chuť :P", Toast.LENGTH_SHORT).show();
                                    setListeners(view);
                                });
                        builder11.setNegativeButton(
                                "Nefunguje",
                                (dialogInterface12, i12) -> {
                                    Intent intent = new Intent(getContext(), Afternoon14Activity.class);
                                    startActivity(intent);
                                });
                        AlertDialog alert11 = builder11.create();
                        alert11.show();
                    });
            builder1.setNegativeButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon14Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });


        view.findViewById(R.id.afternoon15).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon15Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon16).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon16Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon17).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon17Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon18).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon18Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon19).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon19Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon20).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon20Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon21).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon21Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon22).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon22Activity.class);
                        startActivity(intent);
                    });
            builder1.setNeutralButton(
                    "Zrušit",
                    (dialogInterface, i) -> {
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        });
        view.findViewById(R.id.afternoon23).setOnClickListener(view1 -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_DARK);
            builder1.setTitle("Typ kupónu");
            builder1.setMessage("Jak chceš kupón zobrazit?");
            builder1.setIcon(R.drawable.ic_baseline_fastfood_24);
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Kupón z aplikace",
                    (dialogInterface, i) -> {

                        Intent intent = new Intent(getContext(), Afternoon23Activity.class);
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