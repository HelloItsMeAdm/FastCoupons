package com.vojtechadam.fastcoupons;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment = null;
    boolean isPressed = false;
    private static final int PERMISSION_REQUEST_CODE = 200;
    String download_url = "";

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enable night-mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        // hange language
        SharedPreferences pref = MainActivity.this.getSharedPreferences("Settings", 0);
        int language = pref.getInt("Language", -1);

        //Enabling fragment
        chipNavigationBar = findViewById(R.id.chipNavigation);
        chipNavigationBar.setItemSelected(R.id.mcdonalds, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new AfternoonFragment()).commit();

        //Nekopíruj

        //Fragment function
        chipNavigationBar.setOnItemSelectedListener(i -> {
            switch (i) {
                case R.id.mcdonalds:
                    fragment = new AfternoonFragment();
                    break;
                case R.id.kfc:
                    if (language == 0) {
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Již brzy!", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    } else if (language == 1) {
                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Coming soon!", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                    chipNavigationBar.setItemSelected(R.id.mcdonalds, true);
                    break;
                case R.id.other:
                    fragment = new MenuFragment();
                    break;
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });

        //Check internet connection
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();

        if (networkinfo != null && networkinfo.isConnected()) {
            //Device HAS connection
            new RetrieveHTMLStringTask().execute("https://pastebin.com/raw/qsxYuqs4");
            System.out.println("Device has valid internet connection!");
        } else {
            //Device HAS NOT connection
            System.out.println("Device has not valid internet connection! Skipping VersionCheck...");
            if (language == 0) {
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Offline režim!", Snackbar.LENGTH_LONG)
                        .setAction("VÍCE", v -> {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                            builder1.setTitle("Offline režim");
                            builder1.setIcon(R.drawable.ic_baseline_wifi_off_24);
                            builder1.setMessage("Pokud se nepletu, tak aktuálně nemáš přístup k internetu, že? To znamená, že třeba nebudeš moct aktualizovat aplikaci :/");
                            builder1.setCancelable(true);

                            builder1.setPositiveButton(
                                    "Beru na vědomí!",
                                    (dialogInterface, i) -> {
                                    });
                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                        });
                snackbar.show();
            }
            if (language == 1) {
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Offline mode!", Snackbar.LENGTH_LONG)
                        .setAction("MORE", v -> {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                            builder1.setTitle("Offline mode");
                            builder1.setIcon(R.drawable.ic_baseline_wifi_off_24);
                            builder1.setMessage("Unless I'm mistaken, you don't currently have internet access, do you? That means you might not be able to update the app :/");
                            builder1.setCancelable(true);

                            builder1.setPositiveButton(
                                    "Noted!",
                                    (dialogInterface, i) -> {
                                    });
                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                        });
                snackbar.show();
            }
        }
    }

    //Update handle

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    class RetrieveHTMLStringTask extends AsyncTask<String, Void, String> {
        private String result = "";
        private String version = "";

        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                result = stringBuilder.toString();

                JSONObject json = new JSONObject(result);
                version = json.getString("version");
                download_url = json.getString("url");

                bufferedReader.close();
            } catch (MalformedURLException e) {
                System.out.println("Malformed URL: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("I/O Error: " + e.getMessage());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return "";
        }

        protected void onPostExecute(String result) {
            String version = getResources().getString(R.string.version_raw);
            // Change language
            SharedPreferences pref = MainActivity.this.getSharedPreferences("Settings", 0);
            int language = pref.getInt("Language", -1);

            if (this.version.equals(version)) {
                System.out.println("Version UpToDate! (" + version + ")");
            } else {
                if (language == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                    builder.setTitle("Update Manager");
                    builder.setIcon(R.drawable.ic_baseline_cloud_download_24);
                    builder.setMessage("Je dostupná nová verze!\n\nNejnovější verze -> " + this.version + "\nAktuální verze -> " + version);
                    builder.setCancelable(true);

                    builder.setPositiveButton(
                            "Aktualizovat",
                            (dialogInterface, i) -> {
                                if (checkPermission()) {
                                    UpdateApp updateApp = new UpdateApp();
                                    updateApp.setContext(MainActivity.this);
                                    updateApp.execute(download_url);
                                } else {
                                    requestPermission();
                                }
                            });
                    builder.setNegativeButton(
                            "Připomenout později",
                            (dialogInterface, i) -> {
                            });
                    builder.show();
                } else if (language == 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
                    builder.setTitle("Update Manager");
                    builder.setIcon(R.drawable.ic_baseline_cloud_download_24);
                    builder.setMessage("A new version is available!\n\nLatest version -> " + this.version + "\nYour version -> " + version);
                    builder.setCancelable(true);

                    builder.setPositiveButton(
                            "Update",
                            (dialogInterface, i) -> {
                                if (checkPermission()) {
                                    UpdateApp updateApp = new UpdateApp();
                                    updateApp.setContext(MainActivity.this);
                                    updateApp.execute(download_url);
                                } else {
                                    requestPermission();
                                }
                            });
                    builder.setNegativeButton(
                            "Later",
                            (dialogInterface, i) -> {
                            });
                    builder.show();
                }
            }
        }
    }

    //Double-back exit

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        // Change language
        SharedPreferences pref = MainActivity.this.getSharedPreferences("Settings", 0);
        int language = pref.getInt("Language", -1);
        if (isPressed) {
            finishAffinity();
            System.exit(0);
        } else {
            if (language == 0) {
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Ještě jednou a vypnu se!", Snackbar.LENGTH_SHORT);
                snackbar.show();
                isPressed = true;
            } else if (language == 1) {
                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "One more time and I'll shut down!", Snackbar.LENGTH_SHORT);
                snackbar.show();
                isPressed = true;
            }
        }
        Runnable runnable = () -> isPressed = false;
        new Handler().postDelayed(runnable, 2000);
    }

    // Downloading and installing apk

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {

                boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                if (locationAccepted && cameraAccepted) {
                    UpdateApp updateApp = new UpdateApp();
                    updateApp.setContext(MainActivity.this);
                    updateApp.execute(download_url);
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }

    public class UpdateApp extends AsyncTask<String, Integer, String> {
        private ProgressDialog mPDialog;
        private Context mContext;
        // Change language
        SharedPreferences pref = MainActivity.this.getSharedPreferences("Settings", 0);
        int language = pref.getInt("Language", -1);

        void setContext(Activity context) {
            mContext = context;
            context.runOnUiThread(() -> {
                mPDialog = new ProgressDialog(mContext);
                if (language == 0) {
                    mPDialog.setTitle("Aktualizace");
                    mPDialog.setMessage("Probíhá stahování nové verze...");
                    mPDialog.setIndeterminate(true);
                    mPDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    mPDialog.setCancelable(true);
                    mPDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "Zrušit stahování", (dialogInterface, i) -> {
                        Toast.makeText(mContext, "Stahování zrušeno!", Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(getIntent());
                    });
                    mPDialog.setOnCancelListener(dialogInterface -> {
                        Toast.makeText(mContext, "Stahování zrušeno!", Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(getIntent());
                    });
                    mPDialog.setProgressNumberFormat("");
                    mPDialog.show();
                } else if (language == 1) {
                    mPDialog.setTitle("Update");
                    mPDialog.setMessage("Downloading new version...");
                    mPDialog.setIndeterminate(true);
                    mPDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    mPDialog.setCancelable(true);
                    mPDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel downloading", (dialogInterface, i) -> {
                        Toast.makeText(mContext, "Downloading stopped!", Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(getIntent());
                    });
                    mPDialog.setOnCancelListener(dialogInterface -> {
                        Toast.makeText(mContext, "Downloading stopped!", Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(getIntent());
                    });
                    mPDialog.setProgressNumberFormat("");
                    mPDialog.show();
                }
            });
        }

        @Override
        protected String doInBackground(String... arg0) {
            try {
                URL url = new URL(arg0[0]);
                HttpURLConnection c = (HttpURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.setDoOutput(true);
                c.connect();
                int lenghtOfFile = c.getContentLength();

                String PATH = Objects.requireNonNull(mContext.getExternalFilesDir(null)).getAbsolutePath();
                File file = new File(PATH);
                boolean isCreate = file.mkdirs();
                File outputFile = new File(file, "fastcoupons.apk");
                if (outputFile.exists()) {
                    boolean isDelete = outputFile.delete();
                }
                FileOutputStream fos = new FileOutputStream(outputFile);

                InputStream is = c.getInputStream();

                byte[] buffer = new byte[1024];
                int len1;
                long total = 0;
                while ((len1 = is.read(buffer)) != -1) {
                    total += len1;
                    fos.write(buffer, 0, len1);
                    publishProgress((int) ((total * 100) / lenghtOfFile));
                }
                fos.close();
                is.close();
                if (mPDialog != null)
                    mPDialog.dismiss();
                installApk();
            } catch (Exception e) {
                Log.e("UpdateAPP", "Update error! " + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (mPDialog != null)
                mPDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (mPDialog != null) {
                mPDialog.setIndeterminate(false);
                mPDialog.setMax(100);
                mPDialog.setProgress(values[0]);
                mPDialog.setProgressNumberFormat("");
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (mPDialog != null)
                mPDialog.dismiss();
            if (result != null)
                if (language == 0) {
                    Toast.makeText(mContext, "Chyba při stahování:\n" + result, Toast.LENGTH_LONG).show();
                } else if (language == 1) {
                    Toast.makeText(mContext, "Download error:\n" + result, Toast.LENGTH_LONG).show();
                }
            else
                if (language == 0) {
                    Toast.makeText(mContext, "Soubor stažen!", Toast.LENGTH_SHORT).show();
                } else if (language == 1) {
                    Toast.makeText(mContext, "File downloaded!", Toast.LENGTH_SHORT).show();
                }
        }

        private void installApk() {
            try {
                String PATH = Objects.requireNonNull(mContext.getExternalFilesDir(null)).getAbsolutePath();
                File file = new File(PATH + "/fastcoupons.apk");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if (Build.VERSION.SDK_INT >= 24) {
                    Uri downloaded_apk = FileProvider.getUriForFile(mContext, mContext.getApplicationContext().getPackageName() + ".provider", file);
                    intent.setDataAndType(downloaded_apk, "application/vnd.android.package-archive");
                    List<ResolveInfo> resInfoList = mContext.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                    for (ResolveInfo resolveInfo : resInfoList) {
                        mContext.grantUriPermission(mContext.getApplicationContext().getPackageName() + ".provider", downloaded_apk, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    }
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(intent);
                } else {
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true);
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}