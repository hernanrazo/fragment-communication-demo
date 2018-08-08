package c.hernanrazo.fragmentcommunicationdemo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class fragmentTwo extends Fragment {

    private EditText editTextTwo;
    private Button sendBtnTwo;
    private fragmentTwo.fragmentTwoListener listener;

    public fragmentTwo() {}

    //set interface for fragment communication
    public interface fragmentTwoListener {
        void onInputTwoSent(CharSequence input);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);

        //initialize components
        editTextTwo= v.findViewById(R.id.edit_textTwo);
        sendBtnTwo = v.findViewById(R.id.sendButtonTwo);
        sendBtnTwo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                CharSequence input = editTextTwo.getText();
                listener.onInputTwoSent(input);
            }
        });

        return v;
    }

    //method for taking data from activity into fragment
    public void updateText(CharSequence text) {
        editTextTwo.setText(text);
    }

    //set onAttach callback that keeps track of fragment attachments
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof fragmentTwo.fragmentTwoListener) {
            listener = (fragmentTwo.fragmentTwoListener) context;
        }
        else {
            throw new RuntimeException(context.toString() +
                    " forgot to implement fragmentTwoListener." );
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}