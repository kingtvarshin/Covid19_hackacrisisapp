package com.example.covid19tracker.ui.shops;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShopsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShopsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is shops fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}