package c.hernanrazo.fragmentcommunicationdemo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class fragmentOne extends Fragment {

    private EditText editTextOne;
    private Button sendBtnOne;
    private fragmentOneListener listener;

    public fragmentOne() {}

    //set interface for fragment communication
    public interface fragmentOneListener {
        void onInputOneSent(CharSequence input);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        //initialize components
        editTextOne = v.findViewById(R.id.edit_textOne);
        sendBtnOne = v.findViewById(R.id.sendButtonOne);

        //set listener for when button is clicked
        sendBtnOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //set listener for sending text using interface method
                CharSequence input = editTextOne.getText();
                listener.onInputOneSent(input);
            }
        });

        return v;
    }

    //method for taking data from activity into fragment
    public void updateText(CharSequence text) {
        editTextOne.setText(text);
    }

    //set onAttach callback that keeps track of fragment attachments
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof fragmentOneListener) {
            listener = (fragmentOneListener) context;
        }
        else {
            throw new RuntimeException(context.toString() +
                    " forgot to implement fragmentOneListener." );
        }
    }

    //set listener to null when detached
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}