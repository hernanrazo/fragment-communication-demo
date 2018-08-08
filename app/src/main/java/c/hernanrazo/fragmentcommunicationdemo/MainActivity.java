package c.hernanrazo.fragmentcommunicationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements fragmentOne.fragmentOneListener,
                                                               fragmentTwo.fragmentTwoListener {

    fragmentOne fragmentOne;
    fragmentTwo fragmentTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new fragmentOne();
        fragmentTwo = new fragmentTwo();
        //set both fragments into view
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentOne, fragmentOne)
                .replace(R.id.fragmentTwo, fragmentTwo)
                .commit();
    }

    //callback methods that are used to communicate between fragments
    @Override
    public void onInputOneSent(CharSequence input) {
        fragmentTwo.updateText(input);
    }

    @Override
    public void onInputTwoSent(CharSequence input) {
        fragmentOne.updateText(input);
    }
}
