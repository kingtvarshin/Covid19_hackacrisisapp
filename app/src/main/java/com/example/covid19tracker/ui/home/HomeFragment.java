package com.example.covid19tracker.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.covid19tracker.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ArrayList<String> selectedItems = new ArrayList<>();
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.individual_score);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        FloatingActionButton fab = root.findViewById(R.id.btshow);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer score=0;
                for(String item:selectedItems){
                    score=score + returnScoreValue(item);
                }
                textView.setText(String.valueOf(score));
                // Toast.makeText(getActivity(), score.toString(), Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }

    public void onStart(){
        super.onStart();
        ListView listView= getActivity().findViewById(R.id.list_view);
        //set multiple selection mode
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items={"Cough","Cold","Diarrhea","Sore Throat","Body Aches","Headache", "Fever",
                "Breathing Difficulty", "Fatigue", "Travelled Recently", "Travelled to an infected area", "Direct Contact with patient"};
        //supply data items to ListView
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.checklist_row,R.id.checklist_row,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView) view).getText().toString();
                if(selectedItems.contains(selectedItem))
                    selectedItems.remove(selectedItem);
                else
                    selectedItems.add(selectedItem);

            }

        });
    }

    private Integer returnScoreValue(String symptom) {
        switch(symptom) {
            case "Cough":
            case "Cold":
            case "Diarrhea":
            case "Sore Throat":
            case "Body Aches":
            case "Headache":
            case "Fever":
                return 1;
            case "Breathing Difficulty":
            case "Fatigue":
                return 2;
            case "Travelled Recently":
            case "Travelled to an infected area":
            case "Direct Contact with patient":
                return 3;
            default:
                return 0;
        }
    }
}