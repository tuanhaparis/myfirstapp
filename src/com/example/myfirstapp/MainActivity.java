package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Set the text view as the activity layout
        setContentView(R.layout.activity_display_message);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	
        switch(item.getItemId()) {
        	case R.id.action_search:
        		openSearch();
        		return true;
        	case R.id.action_settings:
        		openSetting();
        		return true;
        	default:
        		return super.onOptionsItemSelected(item);

        }
    }
    private void openSetting() {
		// TODO Auto-generated method stub
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	String message = "Chao cac ban, cac ban dang o trang setting";
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
		
	}


	private void openSearch() {
		// TODO Auto-generated method stub
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	String message = "Chao cac ban, cac ban dang o trang search";
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
		
	}


	/** Called when the user clicks the Send button */
    public void sendMessage(View view){
    	//Do something in response to button
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
}
