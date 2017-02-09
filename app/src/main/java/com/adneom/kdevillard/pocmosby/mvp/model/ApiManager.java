package com.adneom.kdevillard.pocmosby.mvp.model;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by kdevillard on 24-11-16.
 */
//Helper aux appels REST
public class ApiManager {
    private interface ApiManagerService {
        @GET("/users/{username}")
        GitHubMember getMember(@Path("username") String username);
    }

    private static final RestAdapter restAdapter = new RestAdapter.Builder()
            .setServer("https://api.github.com")
            .build();

    private static final ApiManagerService apiManager = restAdapter.create(ApiManagerService.class);

    /*public static Observable<GitHubMember> getGitHubMember(final String username) {
        return Observable.create(new Observable.OnSubscribeFunc<GitHubMember>() {
            @Override
            public Subscription onSubscribe(Observer<? super GitHubMember> observer) {
                try {
                    GitHubMember member = apiManager.getMember(username);
                    observer.onNext(member);    //Permet d'envoyer le résultat
                    observer.onCompleted();     //Indique qu'il n'y a plus rien à faire
                } catch (Exception e) {
                    observer.onError(e);
                }
                return Subscriptions.empty();   //On aurait pu aussi appeler une méthode unsubscribe. Permet de désallouer les ressources quand un Observer se désinscrit de cet Observable
            }
        }).subscribeOn(Schedulers.threadPoolForIO());
    }*/
}
