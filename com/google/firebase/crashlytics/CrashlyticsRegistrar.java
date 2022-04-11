package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsRegistrar
  implements ComponentRegistrar
{
  private FirebaseCrashlytics buildCrashlytics(ComponentContainer paramComponentContainer)
  {
    FirebaseApp localFirebaseApp = (FirebaseApp)paramComponentContainer.get(FirebaseApp.class);
    Provider localProvider = paramComponentContainer.getProvider(CrashlyticsNativeComponent.class);
    Deferred localDeferred = paramComponentContainer.getDeferred(AnalyticsConnector.class);
    return FirebaseCrashlytics.init(localFirebaseApp, (FirebaseInstallationsApi)paramComponentContainer.get(FirebaseInstallationsApi.class), localProvider, localDeferred);
  }
  
  public List<Component<?>> getComponents()
  {
    return Arrays.asList(new Component[] { Component.builder(FirebaseCrashlytics.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.optionalProvider(CrashlyticsNativeComponent.class)).add(Dependency.deferred(AnalyticsConnector.class)).factory(new d(this)).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-cls", "18.1.0") });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\CrashlyticsRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */