package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
public class FirebaseInstallationsRegistrar
  implements ComponentRegistrar
{
  public List<Component<?>> getComponents()
  {
    return Arrays.asList(new Component[] { Component.builder(FirebaseInstallationsApi.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.optionalProvider(HeartBeatInfo.class)).add(Dependency.optionalProvider(UserAgentPublisher.class)).factory(e.a).build(), LibraryVersionComponent.create("fire-installations", "17.0.0") });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\FirebaseInstallationsRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */