package com.project.redrocketz.configurator.realm;

import android.content.Context;

import com.project.redrocketz.realm.DaggerAppRealmModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Dell on 8/1/2017.
 */

public class RealmConfigurator {

    private RealmConfiguration realmConfiguration;
    private Realm realm;

    public RealmConfigurator(Context context) {
        Realm.init(context);
    }

    public RealmConfigurator() {
        configRealm();
    }

    private void configRealm() {
        realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(0)
                .modules(new DaggerAppRealmModule())
                .name("DaggerApp.realm")
                .build();
        realm = Realm.getInstance(realmConfiguration);
    }

    public RealmConfiguration getRealmConfiguration() {
        return realmConfiguration;
    }

    public Realm getRealm() {
        return realm;
    }
}
