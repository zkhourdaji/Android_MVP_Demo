package com.example.mvp_application;

public class SayHelloPresenter implements SayHelloContract.Presenter {

    private Person mPerson;
    private SayHelloContract.View mView;

    public SayHelloPresenter(SayHelloContract.View view, person){
        //mPerson = new Person();
        mView = view;
    }


    @Override
    public void loadMessage() {
        if (mPerson.getFirstName() == null && mPerson.getLastName() == null){
            mView.showError("No Person found");
            return;
        }
        else {
            String message = "Hi " + mPerson.getFirstName() +"!";
            mView.showMessage(message);
        }

    }

    @Override
    public void saveName(String firstName, String lastName) {
        mPerson.setFirstName(firstName);
        mPerson.setLastName(lastName);
    }
}
