package com.example.tarea1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView asciiArt = findViewById(R.id.asciiArt);

        String homer =
                "              ___  _____\n" +
                        "            .'/,-Y\"     \"~-.\n" +
                        "            l.Y             ^.\n" +
                        "            /\\               _\\_      \"Doh!\"\n" +
                        "           i            ___/\"   \"\\\n" +
                        "           |          /\"   \"\\   o !\n" +
                        "           l         ]     o !__./\n" +
                        "            \\ _  _    \\.___./    \"~\\\n" +
                        "             X \\/ \\            ___./\n" +
                        "            ( \\ ___.   _..--~~\"   ~`-.\n" +
                        "             ` Z,--   /               \\\n" +
                        "               \\__.  (   /       ______)\n" +
                        "                 \\   l  /-----~~\" /\n" +
                        "                  Y   \\          /\n" +
                        "                  |    \"x______.^\n" +
                        "                  |           \\      -Row\n" +
                        "                  j            Y\n" +
                        "\n" +
                        "                    ->Homer<-";

        asciiArt.setText(homer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}