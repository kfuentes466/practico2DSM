package sv.edu.udb.thesalon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class login extends AppCompatActivity {

    private TextView txtvAppName;
    private ImageView imgvLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        txtvAppName = findViewById(R.id.txtvAppNames);
        imgvLogo = findViewById(R.id.imgvLogos);

    }

    public void login(View view){
        Intent intent = new Intent(getApplicationContext(), mainMenu.class);
        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String>(imgvLogo, "logo_transition");
        pairs[1] = new Pair<View, String>(txtvAppName, "appName_transition");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(login.this, pairs);
            startActivity(intent, options.toBundle());
            finish();
        }else{
            startActivity(intent);
            finish();
        }
    }
}