package com.google.firebase;

import android.os.Build;
import android.os.Build.VERSION;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.ArrayList;
import java.util.List;

public class FirebaseCommonRegistrar
  implements ComponentRegistrar
{
  private static final String ANDROID_INSTALLER = "android-installer";
  private static final String ANDROID_PLATFORM = "android-platform";
  private static final String DEVICE_BRAND = "device-brand";
  private static final String DEVICE_MODEL = "device-model";
  private static final String DEVICE_NAME = "device-name";
  private static final String FIREBASE_ANDROID = "fire-android";
  private static final String FIREBASE_COMMON = "fire-core";
  private static final String KOTLIN = "kotlin";
  private static final String MIN_SDK = "android-min-sdk";
  private static final String TARGET_SDK = "android-target-sdk";
  
  private static String safeValue(String paramString)
  {
    return paramString.replace(' ', '_').replace('/', '_');
  }
  
  public List<Component<?>> getComponents()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(DefaultUserAgentPublisher.component());
    localArrayList.add(DefaultHeartBeatInfo.component());
    localArrayList.add(LibraryVersionComponent.create("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
    localArrayList.add(LibraryVersionComponent.create("fire-core", "20.0.0"));
    localArrayList.add(LibraryVersionComponent.create("device-name", safeValue(Build.PRODUCT)));
    localArrayList.add(LibraryVersionComponent.create("device-model", safeValue(Build.DEVICE)));
    localArrayList.add(LibraryVersionComponent.create("device-brand", safeValue(Build.BRAND)));
    localArrayList.add(LibraryVersionComponent.fromContext("android-target-sdk", c.a));
    localArrayList.add(LibraryVersionComponent.fromContext("android-min-sdk", d.a));
    localArrayList.add(LibraryVersionComponent.fromContext("android-platform", e.a));
    localArrayList.add(LibraryVersionComponent.fromContext("android-installer", b.a));
    String str = KotlinDetector.detectVersion();
    if (str != null) {
      localArrayList.add(LibraryVersionComponent.create("kotlin", str));
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\FirebaseCommonRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */