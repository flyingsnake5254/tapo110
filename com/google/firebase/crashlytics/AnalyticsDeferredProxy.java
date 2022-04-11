package com.google.firebase.crashlytics;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.inject.Deferred;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsDeferredProxy
{
  private final Deferred<AnalyticsConnector> analyticsConnectorDeferred;
  private volatile AnalyticsEventLogger analyticsEventLogger;
  @GuardedBy("this")
  private final List<BreadcrumbHandler> breadcrumbHandlerList;
  private volatile BreadcrumbSource breadcrumbSource;
  
  public AnalyticsDeferredProxy(Deferred<AnalyticsConnector> paramDeferred)
  {
    this(paramDeferred, new DisabledBreadcrumbSource(), new UnavailableAnalyticsEventLogger());
  }
  
  public AnalyticsDeferredProxy(Deferred<AnalyticsConnector> paramDeferred, @NonNull BreadcrumbSource paramBreadcrumbSource, @NonNull AnalyticsEventLogger paramAnalyticsEventLogger)
  {
    this.analyticsConnectorDeferred = paramDeferred;
    this.breadcrumbSource = paramBreadcrumbSource;
    this.breadcrumbHandlerList = new ArrayList();
    this.analyticsEventLogger = paramAnalyticsEventLogger;
    init();
  }
  
  private void init()
  {
    this.analyticsConnectorDeferred.whenAvailable(new a(this));
  }
  
  @DeferredApi
  private static AnalyticsConnector.AnalyticsConnectorHandle subscribeToAnalyticsEvents(@NonNull AnalyticsConnector paramAnalyticsConnector, @NonNull CrashlyticsAnalyticsListener paramCrashlyticsAnalyticsListener)
  {
    AnalyticsConnector.AnalyticsConnectorHandle localAnalyticsConnectorHandle = paramAnalyticsConnector.registerAnalyticsConnectorListener("clx", paramCrashlyticsAnalyticsListener);
    Object localObject = localAnalyticsConnectorHandle;
    if (localAnalyticsConnectorHandle == null)
    {
      Logger.getLogger().d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
      paramAnalyticsConnector = paramAnalyticsConnector.registerAnalyticsConnectorListener("crash", paramCrashlyticsAnalyticsListener);
      localObject = paramAnalyticsConnector;
      if (paramAnalyticsConnector != null)
      {
        Logger.getLogger().w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
        localObject = paramAnalyticsConnector;
      }
    }
    return (AnalyticsConnector.AnalyticsConnectorHandle)localObject;
  }
  
  public AnalyticsEventLogger getAnalyticsEventLogger()
  {
    return new b(this);
  }
  
  public BreadcrumbSource getDeferredBreadcrumbSource()
  {
    return new c(this);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\AnalyticsDeferredProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */