package com.example.covid19tracker.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("WHO and UNICEF to partner on pandemic response through COVID-19 Solidarity Response Fund\n" +
                "\n" +
                "IPA, WHO and UNICEF launch Read the World on International Children’s Book Day to support children and young people in isolation\n" +
                "\n" +
                "Medical Product Alert N°3/2020\n" +
                "\n" +
                "Joint Statement by QU Dongyu, Tedros Adhanom Ghebreyesus and Roberto Azevedo, Directors-General of the Food and Agriculture Organization of the United Nations (FAO), the World Health Organization (WHO) and the World Trade Organization (WTO)\n" +
                "\n" +
                "WHO releases guidelines to help countries maintain essential health services during the COVID-19 pandemic\n");
    }

    public LiveData<String> getText() {
        return mText;
    }
}