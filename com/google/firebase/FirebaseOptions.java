package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

public final class FirebaseOptions
{
  private static final String API_KEY_RESOURCE_NAME = "google_api_key";
  private static final String APP_ID_RESOURCE_NAME = "google_app_id";
  private static final String DATABASE_URL_RESOURCE_NAME = "firebase_database_url";
  private static final String GA_TRACKING_ID_RESOURCE_NAME = "ga_trackingId";
  private static final String GCM_SENDER_ID_RESOURCE_NAME = "gcm_defaultSenderId";
  private static final String PROJECT_ID_RESOURCE_NAME = "project_id";
  private static final String STORAGE_BUCKET_RESOURCE_NAME = "google_storage_bucket";
  private final String apiKey;
  private final String applicationId;
  private final String databaseUrl;
  private final String gaTrackingId;
  private final String gcmSenderId;
  private final String projectId;
  private final String storageBucket;
  
  private FirebaseOptions(@NonNull String paramString1, @NonNull String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7)
  {
    Preconditions.checkState(Strings.isEmptyOrWhitespace(paramString1) ^ true, "ApplicationId must be set.");
    this.applicationId = paramString1;
    this.apiKey = paramString2;
    this.databaseUrl = paramString3;
    this.gaTrackingId = paramString4;
    this.gcmSenderId = paramString5;
    this.storageBucket = paramString6;
    this.projectId = paramString7;
  }
  
  @Nullable
  public static FirebaseOptions fromResource(@NonNull Context paramContext)
  {
    StringResourceValueReader localStringResourceValueReader = new StringResourceValueReader(paramContext);
    paramContext = localStringResourceValueReader.getString("google_app_id");
    if (TextUtils.isEmpty(paramContext)) {
      return null;
    }
    return new FirebaseOptions(paramContext, localStringResourceValueReader.getString("google_api_key"), localStringResourceValueReader.getString("firebase_database_url"), localStringResourceValueReader.getString("ga_trackingId"), localStringResourceValueReader.getString("gcm_defaultSenderId"), localStringResourceValueReader.getString("google_storage_bucket"), localStringResourceValueReader.getString("project_id"));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof FirebaseOptions;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (FirebaseOptions)paramObject;
    bool1 = bool2;
    if (Objects.equal(this.applicationId, ((FirebaseOptions)paramObject).applicationId))
    {
      bool1 = bool2;
      if (Objects.equal(this.apiKey, ((FirebaseOptions)paramObject).apiKey))
      {
        bool1 = bool2;
        if (Objects.equal(this.databaseUrl, ((FirebaseOptions)paramObject).databaseUrl))
        {
          bool1 = bool2;
          if (Objects.equal(this.gaTrackingId, ((FirebaseOptions)paramObject).gaTrackingId))
          {
            bool1 = bool2;
            if (Objects.equal(this.gcmSenderId, ((FirebaseOptions)paramObject).gcmSenderId))
            {
              bool1 = bool2;
              if (Objects.equal(this.storageBucket, ((FirebaseOptions)paramObject).storageBucket))
              {
                bool1 = bool2;
                if (Objects.equal(this.projectId, ((FirebaseOptions)paramObject).projectId)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  @NonNull
  public String getApiKey()
  {
    return this.apiKey;
  }
  
  @NonNull
  public String getApplicationId()
  {
    return this.applicationId;
  }
  
  @Nullable
  public String getDatabaseUrl()
  {
    return this.databaseUrl;
  }
  
  @Nullable
  @KeepForSdk
  public String getGaTrackingId()
  {
    return this.gaTrackingId;
  }
  
  @Nullable
  public String getGcmSenderId()
  {
    return this.gcmSenderId;
  }
  
  @Nullable
  public String getProjectId()
  {
    return this.projectId;
  }
  
  @Nullable
  public String getStorageBucket()
  {
    return this.storageBucket;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("applicationId", this.applicationId).add("apiKey", this.apiKey).add("databaseUrl", this.databaseUrl).add("gcmSenderId", this.gcmSenderId).add("storageBucket", this.storageBucket).add("projectId", this.projectId).toString();
  }
  
  public static final class Builder
  {
    private String apiKey;
    private String applicationId;
    private String databaseUrl;
    private String gaTrackingId;
    private String gcmSenderId;
    private String projectId;
    private String storageBucket;
    
    public Builder() {}
    
    public Builder(@NonNull FirebaseOptions paramFirebaseOptions)
    {
      this.applicationId = paramFirebaseOptions.applicationId;
      this.apiKey = paramFirebaseOptions.apiKey;
      this.databaseUrl = paramFirebaseOptions.databaseUrl;
      this.gaTrackingId = paramFirebaseOptions.gaTrackingId;
      this.gcmSenderId = paramFirebaseOptions.gcmSenderId;
      this.storageBucket = paramFirebaseOptions.storageBucket;
      this.projectId = paramFirebaseOptions.projectId;
    }
    
    @NonNull
    public FirebaseOptions build()
    {
      return new FirebaseOptions(this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, this.storageBucket, this.projectId, null);
    }
    
    @NonNull
    public Builder setApiKey(@NonNull String paramString)
    {
      this.apiKey = Preconditions.checkNotEmpty(paramString, "ApiKey must be set.");
      return this;
    }
    
    @NonNull
    public Builder setApplicationId(@NonNull String paramString)
    {
      this.applicationId = Preconditions.checkNotEmpty(paramString, "ApplicationId must be set.");
      return this;
    }
    
    @NonNull
    public Builder setDatabaseUrl(@Nullable String paramString)
    {
      this.databaseUrl = paramString;
      return this;
    }
    
    @NonNull
    @KeepForSdk
    public Builder setGaTrackingId(@Nullable String paramString)
    {
      this.gaTrackingId = paramString;
      return this;
    }
    
    @NonNull
    public Builder setGcmSenderId(@Nullable String paramString)
    {
      this.gcmSenderId = paramString;
      return this;
    }
    
    @NonNull
    public Builder setProjectId(@Nullable String paramString)
    {
      this.projectId = paramString;
      return this;
    }
    
    @NonNull
    public Builder setStorageBucket(@Nullable String paramString)
    {
      this.storageBucket = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\FirebaseOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */