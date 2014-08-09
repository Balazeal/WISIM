package balazeal.app.winnipegsim.game;

import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import balazeal.app.winnipegsim.game.game.Main;


public class MainActivity extends ActionBarActivity {

    /*          General To Do

        todo Solve text display overflow

     */

    private static final String FONT_PATH = "DOSWin.ttf";

    private TextView mainDisplay;
    private TextView inButton;
    private EditText inputField;
    private String inputTemp;
    private Main game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        mainDisplay = (TextView) findViewById(R.id.textDisplay);
        inButton = (TextView) findViewById(R.id.sendButton);
        inputField = (EditText) findViewById(R.id.inputField);
        setFonts();
        setEventListeners();

        game = new Main();
    }

    //Called when the user submits their text
    public void onSubmit(View view){
        String input = inputField.getText().toString();
        clearInputField();
        String result = game.processText(input);
        mainDisplay.setText(result);
        //TODO Do things with the input
    }

    private void clearInputField(){
        inputField.setText("");
    }

    private void setEventListeners(){
        //TODO Set listener to save text currently in EditText, but not submitted
        inputTemp = inputField.getText().toString();
    }

    private void setFonts(){
        Typeface font = Typeface.createFromAsset(getAssets(),FONT_PATH);
        mainDisplay.setTypeface(font);
        inButton.setTypeface(font);
        inputField.setTypeface(font);
    }

    //TODO Ensure state is preserved
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstance){
        super.onRestoreInstanceState(savedInstance);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
