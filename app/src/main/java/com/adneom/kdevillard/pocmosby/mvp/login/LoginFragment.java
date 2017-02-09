package com.adneom.kdevillard.pocmosby.mvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.test.espresso.core.deps.guava.eventbus.EventBus;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.adneom.kdevillard.pocmosby.R;
import com.adneom.kdevillard.pocmosby.mvp.dashboard.DashboardActivity;
import com.adneom.kdevillard.pocmosby.mvp.model.AccountManager;
import com.adneom.kdevillard.pocmosby.mvp.model.ApiManager;
import com.adneom.kdevillard.pocmosby.mvp.model.AuthCredentials;
import com.adneom.kdevillard.pocmosby.mvp.model.GitHubMember;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by kdevillard on 17-11-16.
 */

public class LoginFragment extends MvpViewStateFragment<LoginView, LoginPresenter> implements LoginView{
    protected LoginPresenter presenter;
    private static final String[] GITHUB_MEMBERS = new String[]{"mojombo", "JakeWharton", "mattt"};
    private Subscription mSubscription;

    @BindView(R.id.email) AutoCompleteTextView username;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.email_sign_in_button) Button loginButton;
    @BindView(R.id.errorView) TextView errorView;
    @BindView(R.id.email_login_form) ViewGroup loginForm;
    @BindView(R.id.rxView) TextView mMembersView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*ButterKnife.setDebug(true);*/
        setRetainInstance(true);

        /*mSubscription = Observable.from(GITHUB_MEMBERS)     //Récupération de l'Observable
                .mapMany(new Func1<String, Observable<GitHubMember>>() {    //Retourne un Observable contenant les 3 objets GitHubMember
                    @Override
                    public Observable<GitHubMember> call(String s) {
                        return ApiManager.getGitHubMember(s);
                    }
                })
                .map(new Func1<GitHubMember, String>() {    //Retourne un Observable contenant les 3 chaines à afficher
                    @Override
                    public String call(GitHubMember gitHubMember) {
                        return gitHubMember.toString();
                    }
                })
                .aggregate(new Func2<String, String, String>() {    //Retourne un Observable contenant plus qu'une chaine combinant les 3 chaines précédentes (permet plus qu'un seul appel à onNext())
                    @Override
                    public String call(String s, String s2) {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.threadPoolForIO())  //Indique sur quel thread sera effectuer les traitements des Observables
                .observeOn(AndroidSchedulers.mainThread())  //Indique que l'on souhaite récupérer le résultat des Observables sur le thread Android principal
                .subscribe(this);   //Inscription (il faut aussi se désinscrire dans le onDestroy*/
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override public ViewState createViewState() {
        return new LoginViewState();
    }

    @Override public LoginPresenter createPresenter() {
        AccountManager accountManager = new AccountManager();
        presenter = new LoginPresenter(accountManager, new EventBus());
        return presenter;
    }

    @OnClick(R.id.email_sign_in_button) public void onLoginClicked() {
        // Check for empty fields
        String uname = username.getText().toString();
        String pass = password.getText().toString();

        loginForm.clearAnimation();

        // Start login
        presenter.doLogin(new AuthCredentials(uname, pass));
    }

    // Called first time the fragment starts
    @Override public void onNewViewStateInstance() {
        showLoginForm();
    }

    @Override public void showLoginForm() {
        //Set the view state
        LoginViewState vs = (LoginViewState) viewState;
        vs.setShowLoginForm();

        errorView.setVisibility(View.GONE);

        setFormEnabled(true);
        //loginButton.setLoading(false);
    }

    @Override public void showError() {
        //Set the view state
        /*LoginViewState vs = (LoginViewState) viewState;
        vs.setShowError();*/

        Toast.makeText(getContext(), "The fields are missing !", Toast.LENGTH_SHORT).show();
        errorView.setVisibility(View.VISIBLE);
        setFormEnabled(true);
    }

    @Override public void showLoading() {
        //Set the view state
        LoginViewState vs = (LoginViewState) viewState;
        vs.setShowLoading();

        errorView.setVisibility(View.GONE);
        setFormEnabled(false);
    }

    private void setFormEnabled(boolean enabled) {
        username.setEnabled(enabled);
        password.setEnabled(enabled);
        loginButton.setEnabled(enabled);
    }

    // Called when login was successful
    @Override public void showSuccessfulLogin() {
        //Set the view state
        LoginViewState vs = (LoginViewState) viewState;
        vs.setShowSuccessfulLogin();

        getActivity().finish();
        //Ici qu'on fait la redirection pour la prochaine View
        Intent homepage = new Intent(getActivity(), DashboardActivity.class);
        startActivity(homepage);
    }

    /**
     * Lorsque tous les Observables ont été appelés
     */
    /*@Override
    public void onCompleted() {

    }*/

    /**
     * Permet de gérer correctement les erreurs
     */
    /*@Override
    public void onError(Throwable e) {
        Toast.makeText(getContext(), "Error Observable", Toast.LENGTH_SHORT).show();
    }*/

    /**
     * Appeler à chaque fois qu'un Observable à fini son traitement.
     * Permet de récupérer le résultat du traitement de l'observable, avant de passer au suivant.
     */
    /*@Override
    //public void onNext(GitHubMember gitHubMember) {
    public void onNext(String member) {
        //mMembersView.setText(String.format(Locale.US, "%s\n%s", gitHubMember.toString(), mMembersView.getText()));
        mMembersView.setText(member);
    }*/

    @Override
    public void onDestroy() {
        //mSubscription.unsubscribe();
        super.onDestroy();
    }
}
