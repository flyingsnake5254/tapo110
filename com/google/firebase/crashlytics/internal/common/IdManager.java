package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdManager
  implements InstallIdProvider
{
  public static final String DEFAULT_VERSION_NAME = "0.0";
  private static final String FORWARD_SLASH_REGEX = Pattern.quote("/");
  private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
  static final String PREFKEY_ADVERTISING_ID = "crashlytics.advertising.id";
  static final String PREFKEY_FIREBASE_IID = "firebase.installation.id";
  static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
  static final String PREFKEY_LEGACY_INSTALLATION_UUID = "crashlytics.installation.id";
  private static final String SYNTHETIC_FID_PREFIX = "SYN_";
  private final Context appContext;
  private final String appIdentifier;
  private String crashlyticsInstallId;
  private final DataCollectionArbiter dataCollectionArbiter;
  private final FirebaseInstallationsApi firebaseInstallationsApi;
  private final InstallerPackageNameProvider installerPackageNameProvider;
  
  public IdManager(Context paramContext, String paramString, FirebaseInstallationsApi paramFirebaseInstallationsApi, DataCollectionArbiter paramDataCollectionArbiter)
  {
    if (paramContext != null)
    {
      if (paramString != null)
      {
        this.appContext = paramContext;
        this.appIdentifier = paramString;
        this.firebaseInstallationsApi = paramFirebaseInstallationsApi;
        this.dataCollectionArbiter = paramDataCollectionArbiter;
        this.installerPackageNameProvider = new InstallerPackageNameProvider();
        return;
      }
      throw new IllegalArgumentException("appIdentifier must not be null");
    }
    throw new IllegalArgumentException("appContext must not be null");
  }
  
  @NonNull
  private String createAndCacheCrashlyticsInstallId(String paramString, SharedPreferences paramSharedPreferences)
  {
    try
    {
      String str = formatId(UUID.randomUUID().toString());
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Created new Crashlytics installation ID: ");
      localStringBuilder.append(str);
      localStringBuilder.append(" for FID: ");
      localStringBuilder.append(paramString);
      localLogger.v(localStringBuilder.toString());
      paramSharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", paramString).apply();
      return str;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static String createSyntheticFid()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SYN_");
    localStringBuilder.append(UUID.randomUUID().toString());
    return localStringBuilder.toString();
  }
  
  @Nullable
  private String fetchTrueFid()
  {
    Object localObject = this.firebaseInstallationsApi.getId();
    String str;
    try
    {
      localObject = (String)Utils.awaitEvenIfOnMainThread((Task)localObject);
    }
    catch (Exception localException)
    {
      Logger.getLogger().w("Failed to retrieve Firebase Installations ID.", localException);
      str = null;
    }
    return str;
  }
  
  private static String formatId(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = ID_PATTERN.matcher(paramString).replaceAll("").toLowerCase(Locale.US);
    }
    return paramString;
  }
  
  static boolean isSyntheticFid(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramString.startsWith("SYN_"))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private String readCachedCrashlyticsInstallId(SharedPreferences paramSharedPreferences)
  {
    return paramSharedPreferences.getString("crashlytics.installation.id", null);
  }
  
  private String removeForwardSlashesIn(String paramString)
  {
    return paramString.replaceAll(FORWARD_SLASH_REGEX, "");
  }
  
  public String getAppIdentifier()
  {
    return this.appIdentifier;
  }
  
  @NonNull
  public String getCrashlyticsInstallId()
  {
    try
    {
      Object localObject1 = this.crashlyticsInstallId;
      if (localObject1 != null) {
        return (String)localObject1;
      }
      Logger.getLogger().v("Determining Crashlytics installation ID...");
      SharedPreferences localSharedPreferences = CommonUtils.getSharedPrefs(this.appContext);
      Object localObject3 = localSharedPreferences.getString("firebase.installation.id", null);
      Object localObject4 = Logger.getLogger();
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("Cached Firebase Installation ID: ");
      ((StringBuilder)localObject1).append((String)localObject3);
      ((Logger)localObject4).v(((StringBuilder)localObject1).toString());
      if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled())
      {
        localObject4 = fetchTrueFid();
        localObject1 = Logger.getLogger();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Fetched Firebase Installation ID: ");
        localStringBuilder.append((String)localObject4);
        ((Logger)localObject1).v(localStringBuilder.toString());
        localObject1 = localObject4;
        if (localObject4 == null) {
          if (localObject3 == null) {
            localObject1 = createSyntheticFid();
          } else {
            localObject1 = localObject3;
          }
        }
        if (((String)localObject1).equals(localObject3)) {
          this.crashlyticsInstallId = readCachedCrashlyticsInstallId(localSharedPreferences);
        } else {
          this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId((String)localObject1, localSharedPreferences);
        }
      }
      else if (isSyntheticFid((String)localObject3))
      {
        this.crashlyticsInstallId = readCachedCrashlyticsInstallId(localSharedPreferences);
      }
      else
      {
        this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(createSyntheticFid(), localSharedPreferences);
      }
      if (this.crashlyticsInstallId == null)
      {
        Logger.getLogger().w("Unable to determine Crashlytics Install Id, creating a new one.");
        this.crashlyticsInstallId = createAndCacheCrashlyticsInstallId(createSyntheticFid(), localSharedPreferences);
      }
      localObject3 = Logger.getLogger();
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("Crashlytics installation ID: ");
      ((StringBuilder)localObject1).append(this.crashlyticsInstallId);
      ((Logger)localObject3).v(((StringBuilder)localObject1).toString());
      localObject1 = this.crashlyticsInstallId;
      return (String)localObject1;
    }
    finally {}
  }
  
  public String getInstallerPackageName()
  {
    return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
  }
  
  public String getModelName()
  {
    return String.format(Locale.US, "%s/%s", new Object[] { removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL) });
  }
  
  public String getOsBuildVersionString()
  {
    return removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
  }
  
  public String getOsDisplayVersionString()
  {
    return removeForwardSlashesIn(Build.VERSION.RELEASE);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\common\IdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */