package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.time.Clock;
import com.google.firebase.installations.time.SystemClock;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Utils
{
  private static final Pattern API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");
  private static final String APP_ID_IDENTIFICATION_SUBSTRING = ":";
  public static final long AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS = TimeUnit.HOURS.toSeconds(1L);
  private static Utils singleton;
  private final Clock clock;
  
  private Utils(Clock paramClock)
  {
    this.clock = paramClock;
  }
  
  public static Utils getInstance()
  {
    return getInstance(SystemClock.getInstance());
  }
  
  public static Utils getInstance(Clock paramClock)
  {
    if (singleton == null) {
      singleton = new Utils(paramClock);
    }
    return singleton;
  }
  
  static boolean isValidApiKeyFormat(@Nullable String paramString)
  {
    return API_KEY_FORMAT.matcher(paramString).matches();
  }
  
  static boolean isValidAppIdFormat(@Nullable String paramString)
  {
    return paramString.contains(":");
  }
  
  public long currentTimeInMillis()
  {
    return this.clock.currentTimeMillis();
  }
  
  public long currentTimeInSecs()
  {
    return TimeUnit.MILLISECONDS.toSeconds(currentTimeInMillis());
  }
  
  public long getRandomDelayForSyncPrevention()
  {
    return (Math.random() * 1000.0D);
  }
  
  public boolean isAuthTokenExpired(@NonNull PersistedInstallationEntry paramPersistedInstallationEntry)
  {
    if (TextUtils.isEmpty(paramPersistedInstallationEntry.getAuthToken())) {
      return true;
    }
    return paramPersistedInstallationEntry.getTokenCreationEpochInSecs() + paramPersistedInstallationEntry.getExpiresInSecs() < currentTimeInSecs() + AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\installations\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */