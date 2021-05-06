package sg.edu.np.prac2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    private final static String TAG = "List Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(TAG, "Create");
        View imageClick = findViewById(R.id.clickImage);
        imageClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            alertBox();
            MediaPlayer media = MediaPlayer.create(ListActivity.this,R.raw.sus);
            media.start();
//            media.release();
//            media = null;

            }
        });
    }
    private int randomNumber(){
        Random ran = new Random();
        int ranValue = ran.nextInt(10000000);
        return ranValue;

    }

    private void alertBox(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Alert!");
        builder.setTitle("Alert!");
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(ListActivity.this,MainActivity.class);
                int ranNo = randomNumber();
                intent.putExtra("Random",ranNo);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}