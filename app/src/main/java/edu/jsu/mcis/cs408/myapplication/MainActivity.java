package edu.jsu.mcis.cs408.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;
    private EditText addMemoText, deleteMemoId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.output);

        getAllMemos(findViewById(R.id.output));
    }

    //Add an entry to the database
    public void addMemo(View v) {
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        addMemoText = (EditText) findViewById(R.id.addText);

        Pad memo = new Pad(addMemoText.getText().toString());

        db.addMemo(memo);

        getAllMemos(v);
    }

    //Delete an entry from the database
    public void deleteMemo(View v) {
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        deleteMemoId = (EditText) findViewById(R.id.deleteText);

        int id = Integer.parseInt(deleteMemoId.getText().toString());

        db.deleteMemo(id);

        getAllMemos(v);
    }

    //Update the output text to show memos
    public void getAllMemos(View v) {
        DatabaseHandler db = new DatabaseHandler(this, null, null, 1);
        String memos = db.getAllMemos();
        output.setText(memos);
    }
}
