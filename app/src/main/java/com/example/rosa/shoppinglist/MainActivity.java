package com.example.rosa.shoppinglist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private TextView item1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item1 = (TextView) findViewById(R.id.menu_1);
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            //	Show	both	the	header	and	the	message	views.	If	isVisible	is
            //	false	or	missing	from	the	bundle,	use	the	default	layout.
            if (isVisible) {
//                mReplyHeadTextView.setVisibility(View.VISIBLE);
//                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
//                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Sekarang Activity Baru!", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");

        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Sekarang Habis Restart!", Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public void goToRecentList(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                item1.setText(reply);
//                mReplyHeadTextView.setVisibility(View.VISIBLE);
//                mReplyTextView.setText(reply);
//                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }



//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        // If the heading is visible, we have a message that needs to be saved.
//        // Otherwise we're still using default layout.
//        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
//            outState.putBoolean("reply_visible", true);
//            outState.putString("reply_text", mReplyTextView.getText().toString());
//        }
//    }


}
