package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class BreadcrumbAnalyticsEventReceiver
  implements AnalyticsEventReceiver, BreadcrumbSource
{
  private static final String BREADCRUMB_NAME_KEY = "name";
  private static final String BREADCRUMB_PARAMS_KEY = "parameters";
  private static final String BREADCRUMB_PREFIX = "$A$:";
  @Nullable
  private BreadcrumbHandler breadcrumbHandler;
  
  @NonNull
  private static String serializeEvent(@NonNull String paramString, @NonNull Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject2.put(str, paramBundle.get(str));
    }
    localJSONObject1.put("name", paramString);
    localJSONObject1.put("parameters", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  public void onEvent(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    BreadcrumbHandler localBreadcrumbHandler = this.breadcrumbHandler;
    if (localBreadcrumbHandler != null) {
      try
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("$A$:");
        localStringBuilder.append(serializeEvent(paramString, paramBundle));
        localBreadcrumbHandler.handleBreadcrumb(localStringBuilder.toString());
      }
      catch (JSONException paramString)
      {
        Logger.getLogger().w("Unable to serialize Firebase Analytics event to breadcrumb.");
      }
    }
  }
  
  public void registerBreadcrumbHandler(@Nullable BreadcrumbHandler paramBreadcrumbHandler)
  {
    this.breadcrumbHandler = paramBreadcrumbHandler;
    Logger.getLogger().d("Registered Firebase Analytics event receiver for breadcrumbs");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\analytics\BreadcrumbAnalyticsEventReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */