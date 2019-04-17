package com.example.mvp_application;

public interface SayHelloContract {

    interface View{
        void showMessage(String message);
        void showError(String error);
    }

    interface  Presenter{
        void loadMessage();
        void saveName(String firstName, String lastName);
    }
}
