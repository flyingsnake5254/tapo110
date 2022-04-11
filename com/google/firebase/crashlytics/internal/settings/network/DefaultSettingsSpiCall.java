package com.google.firebase.crashlytics.internal.settings.network;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class DefaultSettingsSpiCall
  implements SettingsSpiCall
{
  static final String ACCEPT_JSON_VALUE = "application/json";
  static final String ANDROID_CLIENT_TYPE = "android";
  static final String BUILD_VERSION_PARAM = "build_version";
  static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
  static final String DISPLAY_VERSION_PARAM = "display_version";
  static final String HEADER_ACCEPT = "Accept";
  static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
  static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
  static final String HEADER_DEVICE_MODEL = "X-CRASHLYTICS-DEVICE-MODEL";
  static final String HEADER_GOOGLE_APP_ID = "X-CRASHLYTICS-GOOGLE-APP-ID";
  static final String HEADER_INSTALLATION_ID = "X-CRASHLYTICS-INSTALLATION-ID";
  static final String HEADER_OS_BUILD_VERSION = "X-CRASHLYTICS-OS-BUILD-VERSION";
  static final String HEADER_OS_DISPLAY_VERSION = "X-CRASHLYTICS-OS-DISPLAY-VERSION";
  static final String HEADER_USER_AGENT = "User-Agent";
  static final String INSTANCE_PARAM = "instance";
  static final String SOURCE_PARAM = "source";
  private final Logger logger;
  private final HttpRequestFactory requestFactory;
  private final String url;
  
  public DefaultSettingsSpiCall(String paramString, HttpRequestFactory paramHttpRequestFactory)
  {
    this(paramString, paramHttpRequestFactory, Logger.getLogger());
  }
  
  DefaultSettingsSpiCall(String paramString, HttpRequestFactory paramHttpRequestFactory, Logger paramLogger)
  {
    if (paramString != null)
    {
      this.logger = paramLogger;
      this.requestFactory = paramHttpRequestFactory;
      this.url = paramString;
      return;
    }
    throw new IllegalArgumentException("url must not be null.");
  }
  
  private HttpGetRequest applyHeadersTo(HttpGetRequest paramHttpGetRequest, SettingsRequest paramSettingsRequest)
  {
    applyNonNullHeader(paramHttpGetRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", paramSettingsRequest.googleAppId);
    applyNonNullHeader(paramHttpGetRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
    applyNonNullHeader(paramHttpGetRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.getVersion());
    applyNonNullHeader(paramHttpGetRequest, "Accept", "application/json");
    applyNonNullHeader(paramHttpGetRequest, "X-CRASHLYTICS-DEVICE-MODEL", paramSettingsRequest.deviceModel);
    applyNonNullHeader(paramHttpGetRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", paramSettingsRequest.osBuildVersion);
    applyNonNullHeader(paramHttpGetRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", paramSettingsRequest.osDisplayVersion);
    applyNonNullHeader(paramHttpGetRequest, "X-CRASHLYTICS-INSTALLATION-ID", paramSettingsRequest.installIdProvider.getCrashlyticsInstallId());
    return paramHttpGetRequest;
  }
  
  private void applyNonNullHeader(HttpGetRequest paramHttpGetRequest, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramHttpGetRequest.header(paramString1, paramString2);
    }
  }
  
  private JSONObject getJsonObjectFrom(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      Logger localLogger2 = this.logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to parse settings JSON from ");
      localStringBuilder.append(this.url);
      localLogger2.w(localStringBuilder.toString(), localException);
      Logger localLogger1 = this.logger;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Settings response ");
      localStringBuilder.append(paramString);
      localLogger1.w(localStringBuilder.toString());
    }
    return null;
  }
  
  private Map<String, String> getQueryParamsFor(SettingsRequest paramSettingsRequest)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("build_version", paramSettingsRequest.buildVersion);
    localHashMap.put("display_version", paramSettingsRequest.displayVersion);
    localHashMap.put("source", Integer.toString(paramSettingsRequest.source));
    paramSettingsRequest = paramSettingsRequest.instanceId;
    if (!TextUtils.isEmpty(paramSettingsRequest)) {
      localHashMap.put("instance", paramSettingsRequest);
    }
    return localHashMap;
  }
  
  protected HttpGetRequest createHttpGetRequest(Map<String, String> paramMap)
  {
    HttpGetRequest localHttpGetRequest = this.requestFactory.buildHttpGetRequest(this.url, paramMap);
    paramMap = new StringBuilder();
    paramMap.append("Crashlytics Android SDK/");
    paramMap.append(CrashlyticsCore.getVersion());
    return localHttpGetRequest.header("User-Agent", paramMap.toString()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
  }
  
  JSONObject handleResponse(HttpResponse paramHttpResponse)
  {
    int i = paramHttpResponse.code();
    Logger localLogger = this.logger;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Settings response code was: ");
    localStringBuilder.append(i);
    localLogger.v(localStringBuilder.toString());
    if (requestWasSuccessful(i))
    {
      paramHttpResponse = getJsonObjectFrom(paramHttpResponse.body());
    }
    else
    {
      localLogger = this.logger;
      paramHttpResponse = new StringBuilder();
      paramHttpResponse.append("Settings request failed; (status: ");
      paramHttpResponse.append(i);
      paramHttpResponse.append(") from ");
      paramHttpResponse.append(this.url);
      localLogger.e(paramHttpResponse.toString());
      paramHttpResponse = null;
    }
    return paramHttpResponse;
  }
  
  public JSONObject invoke(SettingsRequest paramSettingsRequest, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      try
      {
        Map localMap = getQueryParamsFor(paramSettingsRequest);
        paramSettingsRequest = applyHeadersTo(createHttpGetRequest(localMap), paramSettingsRequest);
        Logger localLogger = this.logger;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Requesting settings from ");
        localStringBuilder.append(this.url);
        localLogger.d(localStringBuilder.toString());
        localLogger = this.logger;
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Settings query params were: ");
        localStringBuilder.append(localMap);
        localLogger.v(localStringBuilder.toString());
        paramSettingsRequest = handleResponse(paramSettingsRequest.execute());
      }
      catch (IOException paramSettingsRequest)
      {
        this.logger.e("Settings request failed.", paramSettingsRequest);
        paramSettingsRequest = null;
      }
      return paramSettingsRequest;
    }
    throw new RuntimeException("An invalid data collection token was used.");
  }
  
  boolean requestWasSuccessful(int paramInt)
  {
    boolean bool;
    if ((paramInt != 200) && (paramInt != 201) && (paramInt != 202) && (paramInt != 203)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\settings\network\DefaultSettingsSpiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */