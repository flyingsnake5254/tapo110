package com.google.firebase.messaging;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.android.datatransport.f;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
public class FirebaseMessagingRegistrar
  implements ComponentRegistrar
{
  @Keep
  @NonNull
  public List<Component<?>> getComponents()
  {
    return Arrays.asList(new Component[] { Component.builder(FirebaseMessaging.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.optional(FirebaseInstanceIdInternal.class)).add(Dependency.optionalProvider(UserAgentPublisher.class)).add(Dependency.optionalProvider(HeartBeatInfo.class)).add(Dependency.optional(f.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.required(Subscriber.class)).factory(FirebaseMessagingRegistrar..Lambda.0.$instance).alwaysEager().build(), LibraryVersionComponent.create("fire-fcm", "22.0.0") });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\FirebaseMessagingRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */