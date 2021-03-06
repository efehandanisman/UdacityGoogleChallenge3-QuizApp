package com.example.android.udacitygooglechallenge3;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;
    String text;
    EditText name;
    EditText textq;
    CheckBox personaldata;
    boolean checkedpersonaldata;
    boolean checkedsocialmedia;
    boolean checkedvr;
    boolean answertrue;
    boolean answertrue2;
    boolean realistic;
    RadioButton answer1;
    RadioGroup episode;
    RadioGroup origin;
    RadioGroup yesno;
    CheckBox Checkboxsocialmedia;
    RadioButton nosedive;
    RadioButton yes;
    CheckBox Checkboxvr;
    RadioButton France;
    RadioButton Germany;
    RadioButton USA;
    CheckBox animals;
    RadioButton Arkangel;
    RadioButton Berightback;
    RadioButton Playtest;
    Button ready;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        personaldata = findViewById(R.id.personaldata);
        Checkboxsocialmedia = findViewById(R.id.socialmedia);
        Checkboxvr = findViewById(R.id.vr);
        answer1 = findViewById(R.id.UK);
        nosedive = findViewById(R.id.Nosedive);
        yes = findViewById(R.id.yes);
        France = findViewById(R.id.France);
        Germany = findViewById(R.id.Germany);
        USA = findViewById(R.id.USA);
        animals = findViewById(R.id.animals);
        Arkangel = findViewById(R.id.Arkangel);
        Berightback = findViewById(R.id.berightback);
        Playtest = findViewById(R.id.Playtest);
        episode = findViewById(R.id.episode);
        origin = findViewById(R.id.origin);
        yesno = findViewById(R.id.yesno);
        textq = findViewById(R.id.textq);
        ready = findViewById(R.id.ready);
    }

    public void ready(View view) {

        if (name.getText().toString().equals("")) {
            name.setError("You can't run away");

        } else if (episode.getCheckedRadioButtonId() == -1) {

            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Alert");
            alert.setMessage("Do you think you can run?");
            alert.setButton(DialogInterface.BUTTON_NEUTRAL, "NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alert.show();

        } else if (yesno.getCheckedRadioButtonId() == -1) {
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Alert");
            alert.setMessage("Do you think you can run?");
            alert.setButton(DialogInterface.BUTTON_NEUTRAL, "NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alert.show();

        } else if (origin.getCheckedRadioButtonId() == -1) {
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Alert");
            alert.setMessage("Do you think you can run?");
            alert.setButton(DialogInterface.BUTTON_NEUTRAL, "NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alert.show();

        } else if (!personaldata.isChecked() && !Checkboxsocialmedia.isChecked() && !Checkboxvr.isChecked() && !animals.isChecked()) {
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Alert");
            alert.setMessage("Do you think you can run?");
            alert.setButton(DialogInterface.BUTTON_NEUTRAL, "NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alert.show();
        } else {

            String text = name.getText().toString();
            String textqcorrect = textq.getText().toString();
            boolean checkedpersonaldata = personaldata.isChecked();
            boolean checkedsocialmedia = Checkboxsocialmedia.isChecked();
            boolean checkedvr = Checkboxvr.isChecked();
            boolean answertrue = answer1.isChecked();
            boolean answertrue2 = nosedive.isChecked();
            boolean realistic = yes.isChecked();
            score = calculateScore(answertrue, answertrue2, checkedsocialmedia, checkedvr, checkedpersonaldata, realistic, textqcorrect);
            ready.setEnabled(false);
            String message = resultsummary(text, score, realistic);
            displayMessage(message);
            {
                if (name.getText().toString().equals("")) {
                    name.setError("You can't run away");

                } else if (textq.getText().toString().equals("")) {
                    name.setError("You have to answer this");
                } else if (episode.getCheckedRadioButtonId() == -1) {

                    AlertDialog alert = new AlertDialog.Builder(this).create();
                    alert.setTitle("Alert");
                    alert.setMessage("Do you think you can run?");
                    alert.setButton(DialogInterface.BUTTON_NEUTRAL, "NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alert.show();

                } else if (yesno.getCheckedRadioButtonId() == -1) {
                    AlertDialog alert = new AlertDialog.Builder(this).create();
                    alert.setTitle("Alert");
                    alert.setMessage("Do you think you can run?");
                    alert.setButton(DialogInterface.BUTTON_NEUTRAL, "NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alert.show();
                } else if (origin.getCheckedRadioButtonId() == -1) {
                    AlertDialog alert = new AlertDialog.Builder(this).create();
                    alert.setTitle("Alert");
                    alert.setMessage("Do you think you can run?");
                    alert.setButton(DialogInterface.BUTTON_NEUTRAL, "NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alert.show();

                } else if (!France.isChecked() && !Germany.isChecked() && !USA.isChecked() && !answer1.isChecked()) {
                    AlertDialog alert = new AlertDialog.Builder(this).create();
                    alert.setTitle("Alert");
                    alert.setMessage("Do you think you can run?");
                    alert.setButton(DialogInterface.BUTTON_NEUTRAL, "NO",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alert.show();
                } else {

                    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                    name.setTextColor(getResources().getColor(R.color.MistyRose));
                    answer1.setTextColor(getResources().getColor(R.color.SpringGreen));
                    nosedive.setTextColor(getResources().getColor(R.color.SpringGreen));
                    yes.setTextColor(getResources().getColor(R.color.SpringGreen));
                    personaldata.setTextColor(getResources().getColor(R.color.SpringGreen));
                    Checkboxsocialmedia.setTextColor(getResources().getColor(R.color.SpringGreen));
                    Checkboxvr.setTextColor(getResources().getColor(R.color.SpringGreen));
                    France.setTextColor(getResources().getColor(R.color.PaleVioletRed));
                    Germany.setTextColor(getResources().getColor(R.color.PaleVioletRed));
                    USA.setTextColor(getResources().getColor(R.color.PaleVioletRed));
                    animals.setTextColor(getResources().getColor(R.color.PaleVioletRed));
                    Arkangel.setTextColor(getResources().getColor(R.color.PaleVioletRed));
                    Berightback.setTextColor(getResources().getColor(R.color.PaleVioletRed));
                    Playtest.setTextColor(getResources().getColor(R.color.PaleVioletRed));
                }
            }
        }
    }


    private String resultsummary(String name, int score, boolean realistic) {
        if (realistic) {
            String message = "Congrats " + name + " you got " + score + " out of 30 points  and find such future realistic.";
            return message;
        } else {
            String message = "You got " + score + " out of 30 points and find such future unrealistic.";
            return message;
        }
    }

    private int calculateScore(boolean answertrue, boolean answertrue2, boolean checkedsocialmedia, boolean checkedvr, boolean checkedpersonaldata, boolean realistic, String textqcorrect) {

        if (answertrue) {
            score += 5;
        }
        if (answertrue2) {
            score += 5;
        }
        if (checkedsocialmedia && checkedvr && checkedpersonaldata && !animals.isChecked()) {
            score += 15;
        }
        if (textqcorrect.equals(2011)) {
            score += 5;
        }
        return score;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score", score);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        score = savedInstanceState.getInt("score");
        text = savedInstanceState.getString("text");
        checkedpersonaldata = savedInstanceState.getBoolean("checkedpersonaldata");
        checkedsocialmedia = savedInstanceState.getBoolean("checkedsocialmedia");
        checkedvr = savedInstanceState.getBoolean("checkedvr");
        answertrue = savedInstanceState.getBoolean("answertrue");
        answertrue2 = savedInstanceState.getBoolean("answertrue2");
        realistic = savedInstanceState.getBoolean("realistic");
    }

    private void displayMessage(String message) {
        TextView result = findViewById(R.id.result);
        result.setText(message);
    }

    public void resetQuiz(View v) {
        score = 0;
        Checkboxsocialmedia.setChecked(false);
        Checkboxvr.setChecked(false);
        animals.setChecked(false);
        personaldata.setChecked(false);
        RadioGroup origin = findViewById(R.id.origin);
        origin.clearCheck();
        RadioGroup episode = findViewById(R.id.episode);
        episode.clearCheck();
        RadioGroup yesno = findViewById(R.id.yesno);
        yesno.clearCheck();
        name.setText("");
        name.setTextColor(getResources().getColor(R.color.Orange));
        answer1.setTextColor(getResources().getColor(R.color.Orange));
        nosedive.setTextColor(getResources().getColor(R.color.Orange));
        yes.setTextColor(getResources().getColor(R.color.Orange));
        personaldata.setTextColor(getResources().getColor(R.color.Orange));
        Checkboxsocialmedia.setTextColor(getResources().getColor(R.color.Orange));
        Checkboxvr.setTextColor(getResources().getColor(R.color.Orange));
        France.setTextColor(getResources().getColor(R.color.Orange));
        Germany.setTextColor(getResources().getColor(R.color.Orange));
        USA.setTextColor(getResources().getColor(R.color.Orange));
        animals.setTextColor(getResources().getColor(R.color.Orange));
        Arkangel.setTextColor(getResources().getColor(R.color.Orange));
        Berightback.setTextColor(getResources().getColor(R.color.Orange));
        Playtest.setTextColor(getResources().getColor(R.color.Orange));
        ready.setEnabled(true);
    }

    public void onClickWhatsApp(View view) {
        PackageManager pm = getPackageManager();
        try {
            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = resultsummary(name.getText().toString(), score, realistic);
            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            waIntent.setPackage("com.whatsapp");
            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, "Wanna play?"));
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
