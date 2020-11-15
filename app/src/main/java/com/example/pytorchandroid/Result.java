package com.example.pytorchandroid;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import android.widget.ImageView;
import android.widget.TextView;
=======
=======
>>>>>>> Stashed changes
import androidx.core.content.FileProvider;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
>>>>>>> Stashed changes

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< Updated upstream
        Bitmap imageBitmap = (Bitmap) getIntent().getBundleExtra("imagedata").get("data");
=======
        position = getIntent().getIntExtra("imagedata", 0);

        filePaths = new ArrayList<String>();
        filePaths = getFilePaths();

        final int truePosition = filePaths.size()-1-position;
        final Bitmap bmp = processFilePath(filePaths.get(truePosition));
        final String pred = getIntent().getStringExtra("pred");

        //byte[] byteArray = getIntent().getByteArrayExtra("imagedata");
        //Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
>>>>>>> Stashed changes

<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes


        ImageView imageView = findViewById(R.id.image);
        imageView.setImageBitmap(imageBitmap);

        TextView textView = findViewById(R.id.label);
        textView.setText(pred);

<<<<<<< Updated upstream
       // TextView ImageID = findViewById(R.id.label);
       // textView.setText(pred);
=======
        share1 = (Button)findViewById(R.id.share);
        share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Results.java", "Share button clicked");

                //shares the text result
                Intent sendIntent = new Intent();
                sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TITLE, pred);
                Uri bmpUri = null;
                try {
                File file = new File(filePaths.get(truePosition));
                FileOutputStream out = new FileOutputStream(file);
                bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
                    Log.d("Results.java", "bmp compressed");
                    out.close();

                    bmpUri = FileProvider.getUriForFile(Result.this,  BuildConfig.APPLICATION_ID + ".provider", file);;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                sendIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
                sendIntent.setType("image/*");

                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(sendIntent, "Share via"));
                }



//                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                sharingIntent.setType("*/*");
//                String shareBody = "Here is the share content body";
//                sharingIntent.putExtra(Intent.EXTRA_STREAM, filePaths.get(truePosition));
//                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

    }

    private static ArrayList<String> getFilePaths(){
        ArrayList<String> filePaths = new ArrayList<String>();

        File directory = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator, "MyCameraApp");

        // check for directory
        if (directory.isDirectory())
        {
            // getting list of file paths
            File[] listFiles = directory.listFiles();

            // Check for count
            if (listFiles.length > 0)
            {

                for (int i = 0; i < listFiles.length; i++)
                {

                    String filePath = listFiles[i].getAbsolutePath();
                    filePaths.add(filePath);

                }
            }
            else
            {
                // image directory is empty
                String emptyError = "Album is empty";
            }

        }
        return filePaths;
    }
>>>>>>> Stashed changes

        //set button to return to main
        
    }

}