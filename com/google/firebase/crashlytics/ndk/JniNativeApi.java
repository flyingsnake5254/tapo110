package com.google.firebase.crashlytics.ndk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class JniNativeApi
  implements NativeApi
{
  private static final boolean LIB_CRASHLYTICS_LOADED;
  private Context context;
  
  static
  {
    boolean bool;
    try
    {
      System.loadLibrary("crashlytics");
      bool = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("libcrashlytics could not be loaded. This APK may not have been compiled for this device's architecture. NDK crashes will not be reported to Crashlytics:\n");
      localStringBuilder.append(localUnsatisfiedLinkError.getLocalizedMessage());
      localLogger.e(localStringBuilder.toString());
      bool = false;
    }
    LIB_CRASHLYTICS_LOADED = bool;
  }
  
  public JniNativeApi(Context paramContext)
  {
    this.context = paramContext;
  }
  
  @TargetApi(21)
  public static void addSplitSourceDirs(List<String> paramList, ApplicationInfo paramApplicationInfo)
  {
    paramApplicationInfo = paramApplicationInfo.splitSourceDirs;
    if (paramApplicationInfo != null) {
      Collections.addAll(paramList, paramApplicationInfo);
    }
  }
  
  public static boolean isAtLeastLollipop()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private native boolean nativeInit(String[] paramArrayOfString, Object paramObject);
  
  public boolean initialize(String paramString, AssetManager paramAssetManager)
  {
    Object localObject1 = makePackagePaths(Build.CPU_ABI);
    int i = localObject1.length;
    boolean bool1 = false;
    if (i < 2) {
      return false;
    }
    Object localObject2 = localObject1[0];
    localObject1 = localObject1[1];
    boolean bool2 = bool1;
    if (LIB_CRASHLYTICS_LOADED)
    {
      bool2 = bool1;
      if (nativeInit(new String[] { localObject2, localObject1, paramString }, paramAssetManager)) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public String[] makePackagePaths(String paramString)
  {
    try
    {
      Object localObject1 = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 9216);
      Object localObject2 = new java/util/ArrayList;
      ((ArrayList)localObject2).<init>(10);
      ((List)localObject2).add(((PackageInfo)localObject1).applicationInfo.sourceDir);
      if (isAtLeastLollipop()) {
        addSplitSourceDirs((List)localObject2, ((PackageInfo)localObject1).applicationInfo);
      }
      Object localObject3 = ((PackageInfo)localObject1).applicationInfo.sharedLibraryFiles;
      if (localObject3 != null) {
        Collections.addAll((Collection)localObject2, (Object[])localObject3);
      }
      localObject3 = new java/util/ArrayList;
      ((ArrayList)localObject3).<init>(10);
      Object localObject4 = new java/io/File;
      ((File)localObject4).<init>(((PackageInfo)localObject1).applicationInfo.nativeLibraryDir);
      localObject4 = ((File)localObject4).getParentFile();
      Object localObject5;
      if (localObject4 != null)
      {
        localObject5 = new java/io/File;
        ((File)localObject5).<init>((File)localObject4, paramString);
        ((List)localObject3).add(((File)localObject5).getPath());
        if (paramString.startsWith("arm64"))
        {
          localObject5 = new java/io/File;
          ((File)localObject5).<init>((File)localObject4, "arm64");
          ((List)localObject3).add(((File)localObject5).getPath());
        }
        else if (paramString.startsWith("arm"))
        {
          localObject5 = new java/io/File;
          ((File)localObject5).<init>((File)localObject4, "arm");
          ((List)localObject3).add(((File)localObject5).getPath());
        }
      }
      localObject4 = ((List)localObject2).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        if (str.endsWith(".apk"))
        {
          localObject5 = new java/lang/StringBuilder;
          ((StringBuilder)localObject5).<init>();
          ((StringBuilder)localObject5).append(str);
          ((StringBuilder)localObject5).append("!/lib/");
          ((StringBuilder)localObject5).append(paramString);
          ((List)localObject3).add(((StringBuilder)localObject5).toString());
        }
      }
      ((List)localObject3).add(System.getProperty("java.library.path"));
      ((List)localObject3).add(((PackageInfo)localObject1).applicationInfo.nativeLibraryDir);
      localObject1 = File.pathSeparator;
      paramString = TextUtils.join((CharSequence)localObject1, (Iterable)localObject2);
      localObject2 = TextUtils.join((CharSequence)localObject1, (Iterable)localObject3);
      return new String[] { paramString, localObject2 };
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      Logger.getLogger().e("Unable to compose package paths", paramString);
      throw new RuntimeException(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\ndk\JniNativeApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */