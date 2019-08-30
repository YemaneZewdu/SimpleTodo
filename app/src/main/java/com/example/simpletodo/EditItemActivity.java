package com.example.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.simpletodo.MainActivity.ITEM_POSITION;
import static com.example.simpletodo.MainActivity.ITEM_TEXT;
public class EditItemActivity extends AppCompatActivity {

    // track edit text
    EditText etItemText;
    //position of edited item in the list
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        //resolve edit text from layout
        etItemText = (EditText) findViewById(R.id.etItemText);
        //set edit text value from intent extra
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        // update position from intent extra
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        //update the title bar of the activity
        getSupportActionBar().setTitle("Edit Item");

    }
    // handler for save button
    public void onSaveItem(View v){
        //prepare new intent for result
        Intent intent = new Intent();
        //pass updated item text as extra
        intent.putExtra(ITEM_TEXT,etItemText.getText().toString());
        //pass original position as extra
        intent.putExtra(ITEM_POSITION,position);
        //set the intent as the result of the activity
        setResult(RESULT_OK, intent);
        //close the activity and redirect to main
        finish();
    }
}
