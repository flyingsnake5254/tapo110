package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsNdkRegistrar
  implements ComponentRegistrar
{
  private CrashlyticsNativeComponent buildCrashlyticsNdk(ComponentContainer paramComponentContainer)
  {
    return FirebaseCrashlyticsNdk.create((Context)paramComponentContainer.get(Context.class));
  }
  
  public List<Component<?>> getComponents()
  {
    return Arrays.asList(new Component[] { Component.builder(CrashlyticsNativeComponent.class).add(Dependency.required(Context.class)).factory(new b(this)).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-cls-ndk", "18.1.0") });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\CrashlyticsNdkRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */