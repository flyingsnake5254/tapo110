package com.google.firebase.crashlytics.internal.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public class SettingsController
  implements SettingsDataProvider
{
  private static final String PREFS_BUILD_INSTANCE_IDENTIFIER = "existing_instance_identifier";
  private static final String SETTINGS_URL_FORMAT = "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings";
  private final AtomicReference<TaskCompletionSource<AppSettingsData>> appSettingsData;
  private final CachedSettingsIo cachedSettingsIo;
  private final Context context;
  private final CurrentTimeProvider currentTimeProvider;
  private final DataCollectionArbiter dataCollectionArbiter;
  private final AtomicReference<Settings> settings;
  private final SettingsJsonParser settingsJsonParser;
  private final SettingsRequest settingsRequest;
  private final SettingsSpiCall settingsSpiCall;
  
  SettingsController(Context paramContext, SettingsRequest paramSettingsRequest, CurrentTimeProvider paramCurrentTimeProvider, SettingsJsonParser paramSettingsJsonParser, CachedSettingsIo paramCachedSettingsIo, SettingsSpiCall paramSettingsSpiCall, DataCollectionArbiter paramDataCollectionArbiter)
  {
    AtomicReference localAtomicReference = new AtomicReference();
    this.settings = localAtomicReference;
    this.appSettingsData = new AtomicReference(new TaskCompletionSource());
    this.context = paramContext;
    this.settingsRequest = paramSettingsRequest;
    this.currentTimeProvider = paramCurrentTimeProvider;
    this.settingsJsonParser = paramSettingsJsonParser;
    this.cachedSettingsIo = paramCachedSettingsIo;
    this.settingsSpiCall = paramSettingsSpiCall;
    this.dataCollectionArbiter = paramDataCollectionArbiter;
    localAtomicReference.set(DefaultSettingsJsonTransform.defaultSettings(paramCurrentTimeProvider));
  }
  
  public static SettingsController create(Context paramContext, String paramString1, IdManager paramIdManager, HttpRequestFactory paramHttpRequestFactory, String paramString2, String paramString3, DataCollectionArbiter paramDataCollectionArbiter)
  {
    String str = paramIdManager.getInstallerPackageName();
    SystemCurrentTimeProvider localSystemCurrentTimeProvider = new SystemCurrentTimeProvider();
    SettingsJsonParser localSettingsJsonParser = new SettingsJsonParser(localSystemCurrentTimeProvider);
    CachedSettingsIo localCachedSettingsIo = new CachedSettingsIo(paramContext);
    paramHttpRequestFactory = new DefaultSettingsSpiCall(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", new Object[] { paramString1 }), paramHttpRequestFactory);
    return new SettingsController(paramContext, new SettingsRequest(paramString1, paramIdManager.getModelName(), paramIdManager.getOsBuildVersionString(), paramIdManager.getOsDisplayVersionString(), paramIdManager, CommonUtils.createInstanceIdFrom(new String[] { CommonUtils.getMappingFileId(paramContext), paramString1, paramString3, paramString2 }), paramString3, paramString2, DeliveryMechanism.determineFrom(str).getId()), localSystemCurrentTimeProvider, localSettingsJsonParser, localCachedSettingsIo, paramHttpRequestFactory, paramDataCollectionArbiter);
  }
  
  private SettingsData getCachedSettingsData(SettingsCacheBehavior paramSettingsCacheBehavior)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = localObject1;
    try
    {
      if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(paramSettingsCacheBehavior))
      {
        JSONObject localJSONObject = this.cachedSettingsIo.readCachedSettings();
        if (localJSONObject != null)
        {
          localObject3 = this.settingsJsonParser.parseSettingsJson(localJSONObject);
          if (localObject3 != null)
          {
            logSettings(localJSONObject, "Loaded cached settings: ");
            long l = this.currentTimeProvider.getCurrentTimeMillis();
            if ((!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(paramSettingsCacheBehavior)) && (((SettingsData)localObject3).isExpired(l)))
            {
              Logger.getLogger().v("Cached settings have expired.");
              localObject3 = localObject1;
              break label160;
            }
            try
            {
              Logger.getLogger().v("Returning cached settings.");
            }
            catch (Exception paramSettingsCacheBehavior)
            {
              break label151;
            }
          }
          else
          {
            Logger.getLogger().e("Failed to parse cached settings data.", null);
            localObject3 = localObject1;
            break label160;
          }
        }
        else
        {
          Logger.getLogger().d("No cached settings data found.");
          localObject3 = localObject1;
        }
      }
    }
    catch (Exception paramSettingsCacheBehavior)
    {
      localObject3 = localObject2;
      label151:
      Logger.getLogger().e("Failed to get cached settings", paramSettingsCacheBehavior);
    }
    label160:
    return (SettingsData)localObject3;
  }
  
  private String getStoredBuildInstanceIdentifier()
  {
    return CommonUtils.getSharedPrefs(this.context).getString("existing_instance_identifier", "");
  }
  
  private void logSettings(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    Logger localLogger = Logger.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramJSONObject.toString());
    localLogger.d(localStringBuilder.toString());
  }
  
  @SuppressLint({"CommitPrefEdits"})
  private boolean setStoredBuildInstanceIdentifier(String paramString)
  {
    SharedPreferences.Editor localEditor = CommonUtils.getSharedPrefs(this.context).edit();
    localEditor.putString("existing_instance_identifier", paramString);
    localEditor.apply();
    return true;
  }
  
  boolean buildInstanceIdentifierChanged()
  {
    return getStoredBuildInstanceIdentifier().equals(this.settingsRequest.instanceId) ^ true;
  }
  
  public Task<AppSettingsData> getAppSettings()
  {
    return ((TaskCompletionSource)this.appSettingsData.get()).getTask();
  }
  
  public Settings getSettings()
  {
    return (Settings)this.settings.get();
  }
  
  public Task<Void> loadSettingsData(SettingsCacheBehavior paramSettingsCacheBehavior, Executor paramExecutor)
  {
    if (!buildInstanceIdentifierChanged())
    {
      paramSettingsCacheBehavior = getCachedSettingsData(paramSettingsCacheBehavior);
      if (paramSettingsCacheBehavior != null)
      {
        this.settings.set(paramSettingsCacheBehavior);
        ((TaskCompletionSource)this.appSettingsData.get()).trySetResult(paramSettingsCacheBehavior.getAppSettingsData());
        return Tasks.forResult(null);
      }
    }
    paramSettingsCacheBehavior = getCachedSettingsData(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
    if (paramSettingsCacheBehavior != null)
    {
      this.settings.set(paramSettingsCacheBehavior);
      ((TaskCompletionSource)this.appSettingsData.get()).trySetResult(paramSettingsCacheBehavior.getAppSettingsData());
    }
    this.dataCollectionArbiter.waitForDataCollectionPermission().onSuccessTask(paramExecutor, new SuccessContinuation()
    {
      @NonNull
      public Task<Void> then(@Nullable Void paramAnonymousVoid)
        throws Exception
      {
        Object localObject = SettingsController.this.settingsSpiCall.invoke(SettingsController.this.settingsRequest, true);
        if (localObject != null)
        {
          paramAnonymousVoid = SettingsController.this.settingsJsonParser.parseSettingsJson((JSONObject)localObject);
          SettingsController.this.cachedSettingsIo.writeCachedSettings(paramAnonymousVoid.getExpiresAtMillis(), (JSONObject)localObject);
          SettingsController.this.logSettings((JSONObject)localObject, "Loaded settings: ");
          localObject = SettingsController.this;
          ((SettingsController)localObject).setStoredBuildInstanceIdentifier(((SettingsController)localObject).settingsRequest.instanceId);
          SettingsController.this.settings.set(paramAnonymousVoid);
          ((TaskCompletionSource)SettingsController.this.appSettingsData.get()).trySetResult(paramAnonymousVoid.getAppSettingsData());
          localObject = new TaskCompletionSource();
          ((TaskCompletionSource)localObject).trySetResult(paramAnonymousVoid.getAppSettingsData());
          SettingsController.this.appSettingsData.set(localObject);
        }
        return Tasks.forResult(null);
      }
    });
  }
  
  public Task<Void> loadSettingsData(Executor paramExecutor)
  {
    return loadSettingsData(SettingsCacheBehavior.USE_CACHE, paramExecutor);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\settings\SettingsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */