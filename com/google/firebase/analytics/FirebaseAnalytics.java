package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzee;
import com.google.android.gms.measurement.internal.zzhx;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class FirebaseAnalytics
{
  private static volatile FirebaseAnalytics zza;
  private final zzee zzb;
  private ExecutorService zzc;
  
  public FirebaseAnalytics(zzee paramzzee)
  {
    Preconditions.checkNotNull(paramzzee);
    this.zzb = paramzzee;
  }
  
  @Keep
  @NonNull
  @RequiresPermission(allOf={"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
  public static FirebaseAnalytics getInstance(@NonNull Context paramContext)
  {
    if (zza == null) {
      try
      {
        if (zza == null)
        {
          zzee localzzee = zzee.zza(paramContext, null, null, null, null);
          paramContext = new com/google/firebase/analytics/FirebaseAnalytics;
          paramContext.<init>(localzzee);
          zza = paramContext;
        }
      }
      finally {}
    }
    return zza;
  }
  
  @Keep
  @Nullable
  public static zzhx getScionFrontendApiImplementation(Context paramContext, @Nullable Bundle paramBundle)
  {
    paramContext = zzee.zza(paramContext, null, null, null, paramBundle);
    if (paramContext == null) {
      return null;
    }
    return new zzc(paramContext);
  }
  
  /* Error */
  @NonNull
  public com.google.android.gms.tasks.Task<String> getAppInstanceId()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: getfield 72	com/google/firebase/analytics/FirebaseAnalytics:zzc	Ljava/util/concurrent/ExecutorService;
    //   7: ifnonnull +38 -> 45
    //   10: new 74	com/google/firebase/analytics/zza
    //   13: astore_1
    //   14: getstatic 80	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   17: astore_2
    //   18: new 82	java/util/concurrent/ArrayBlockingQueue
    //   21: astore_3
    //   22: aload_3
    //   23: bipush 100
    //   25: invokespecial 85	java/util/concurrent/ArrayBlockingQueue:<init>	(I)V
    //   28: aload_1
    //   29: aload_0
    //   30: iconst_0
    //   31: iconst_1
    //   32: ldc2_w 86
    //   35: aload_2
    //   36: aload_3
    //   37: invokespecial 90	com/google/firebase/analytics/zza:<init>	(Lcom/google/firebase/analytics/FirebaseAnalytics;IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V
    //   40: aload_0
    //   41: aload_1
    //   42: putfield 72	com/google/firebase/analytics/FirebaseAnalytics:zzc	Ljava/util/concurrent/ExecutorService;
    //   45: aload_0
    //   46: getfield 72	com/google/firebase/analytics/FirebaseAnalytics:zzc	Ljava/util/concurrent/ExecutorService;
    //   49: astore_3
    //   50: ldc 2
    //   52: monitorexit
    //   53: new 92	com/google/firebase/analytics/zzb
    //   56: astore_1
    //   57: aload_1
    //   58: aload_0
    //   59: invokespecial 95	com/google/firebase/analytics/zzb:<init>	(Lcom/google/firebase/analytics/FirebaseAnalytics;)V
    //   62: aload_3
    //   63: aload_1
    //   64: invokestatic 101	com/google/android/gms/tasks/Tasks:call	(Ljava/util/concurrent/Executor;Ljava/util/concurrent/Callable;)Lcom/google/android/gms/tasks/Task;
    //   67: astore_3
    //   68: aload_3
    //   69: areturn
    //   70: astore_3
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    //   76: astore_3
    //   77: aload_0
    //   78: getfield 38	com/google/firebase/analytics/FirebaseAnalytics:zzb	Lcom/google/android/gms/internal/measurement/zzee;
    //   81: iconst_5
    //   82: ldc 103
    //   84: aconst_null
    //   85: aconst_null
    //   86: aconst_null
    //   87: invokevirtual 107	com/google/android/gms/internal/measurement/zzee:zzC	(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   90: aload_3
    //   91: invokestatic 111	com/google/android/gms/tasks/Tasks:forException	(Ljava/lang/Exception;)Lcom/google/android/gms/tasks/Task;
    //   94: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	FirebaseAnalytics
    //   13	51	1	localObject1	Object
    //   17	19	2	localTimeUnit	TimeUnit
    //   21	48	3	localObject2	Object
    //   70	5	3	localObject3	Object
    //   76	15	3	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   3	45	70	finally
    //   45	53	70	finally
    //   71	74	70	finally
    //   0	3	76	java/lang/RuntimeException
    //   53	68	76	java/lang/RuntimeException
    //   74	76	76	java/lang/RuntimeException
  }
  
  @Keep
  @NonNull
  public String getFirebaseInstanceId()
  {
    try
    {
      String str = (String)Tasks.await(FirebaseInstallations.getInstance().getId(), 30000L, TimeUnit.MILLISECONDS);
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IllegalStateException(localInterruptedException);
    }
    catch (TimeoutException localTimeoutException)
    {
      throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
    }
    catch (ExecutionException localExecutionException)
    {
      throw new IllegalStateException(localExecutionException.getCause());
    }
  }
  
  public void logEvent(@NonNull @Size(max=40L, min=1L) String paramString, @Nullable Bundle paramBundle)
  {
    this.zzb.zzg(paramString, paramBundle);
  }
  
  public void resetAnalyticsData()
  {
    this.zzb.zzs();
  }
  
  public void setAnalyticsCollectionEnabled(boolean paramBoolean)
  {
    this.zzb.zzp(Boolean.valueOf(paramBoolean));
  }
  
  public void setConsent(@NonNull Map<ConsentType, ConsentStatus> paramMap)
  {
    Bundle localBundle = new Bundle();
    ConsentStatus localConsentStatus = (ConsentStatus)paramMap.get(ConsentType.AD_STORAGE);
    int i;
    if (localConsentStatus != null)
    {
      i = localConsentStatus.ordinal();
      if (i != 0)
      {
        if (i == 1) {
          localBundle.putString("ad_storage", "denied");
        }
      }
      else {
        localBundle.putString("ad_storage", "granted");
      }
    }
    paramMap = (ConsentStatus)paramMap.get(ConsentType.ANALYTICS_STORAGE);
    if (paramMap != null)
    {
      i = paramMap.ordinal();
      if (i != 0)
      {
        if (i == 1) {
          localBundle.putString("analytics_storage", "denied");
        }
      }
      else {
        localBundle.putString("analytics_storage", "granted");
      }
    }
    this.zzb.zzr(localBundle);
  }
  
  @Deprecated
  @Keep
  @MainThread
  public void setCurrentScreen(@NonNull Activity paramActivity, @Nullable @Size(max=36L, min=1L) String paramString1, @Nullable @Size(max=36L, min=1L) String paramString2)
  {
    this.zzb.zzo(paramActivity, paramString1, paramString2);
  }
  
  public void setDefaultEventParameters(@Nullable Bundle paramBundle)
  {
    this.zzb.zzJ(paramBundle);
  }
  
  public void setSessionTimeoutDuration(long paramLong)
  {
    this.zzb.zzt(paramLong);
  }
  
  public void setUserId(@Nullable String paramString)
  {
    this.zzb.zzn(paramString);
  }
  
  public void setUserProperty(@NonNull @Size(max=24L, min=1L) String paramString1, @Nullable @Size(max=36L) String paramString2)
  {
    this.zzb.zzj(null, paramString1, paramString2, false);
  }
  
  public static enum ConsentStatus
  {
    static
    {
      ConsentStatus localConsentStatus1 = new ConsentStatus("GRANTED", 0);
      GRANTED = localConsentStatus1;
      ConsentStatus localConsentStatus2 = new ConsentStatus("DENIED", 1);
      DENIED = localConsentStatus2;
      zza = new ConsentStatus[] { localConsentStatus1, localConsentStatus2 };
    }
  }
  
  public static enum ConsentType
  {
    static
    {
      ConsentType localConsentType1 = new ConsentType("AD_STORAGE", 0);
      AD_STORAGE = localConsentType1;
      ConsentType localConsentType2 = new ConsentType("ANALYTICS_STORAGE", 1);
      ANALYTICS_STORAGE = localConsentType2;
      zza = new ConsentType[] { localConsentType1, localConsentType2 };
    }
  }
  
  public static class Event
  {
    @NonNull
    public static final String ADD_PAYMENT_INFO = "add_payment_info";
    @NonNull
    public static final String ADD_SHIPPING_INFO = "add_shipping_info";
    @NonNull
    public static final String ADD_TO_CART = "add_to_cart";
    @NonNull
    public static final String ADD_TO_WISHLIST = "add_to_wishlist";
    @NonNull
    public static final String AD_IMPRESSION = "ad_impression";
    @NonNull
    public static final String APP_OPEN = "app_open";
    @NonNull
    public static final String BEGIN_CHECKOUT = "begin_checkout";
    @NonNull
    public static final String CAMPAIGN_DETAILS = "campaign_details";
    @Deprecated
    @NonNull
    public static final String CHECKOUT_PROGRESS = "checkout_progress";
    @NonNull
    public static final String EARN_VIRTUAL_CURRENCY = "earn_virtual_currency";
    @Deprecated
    @NonNull
    public static final String ECOMMERCE_PURCHASE = "ecommerce_purchase";
    @NonNull
    public static final String GENERATE_LEAD = "generate_lead";
    @NonNull
    public static final String JOIN_GROUP = "join_group";
    @NonNull
    public static final String LEVEL_END = "level_end";
    @NonNull
    public static final String LEVEL_START = "level_start";
    @NonNull
    public static final String LEVEL_UP = "level_up";
    @NonNull
    public static final String LOGIN = "login";
    @NonNull
    public static final String POST_SCORE = "post_score";
    @Deprecated
    @NonNull
    public static final String PRESENT_OFFER = "present_offer";
    @NonNull
    public static final String PURCHASE = "purchase";
    @Deprecated
    @NonNull
    public static final String PURCHASE_REFUND = "purchase_refund";
    @NonNull
    public static final String REFUND = "refund";
    @NonNull
    public static final String REMOVE_FROM_CART = "remove_from_cart";
    @NonNull
    public static final String SCREEN_VIEW = "screen_view";
    @NonNull
    public static final String SEARCH = "search";
    @NonNull
    public static final String SELECT_CONTENT = "select_content";
    @NonNull
    public static final String SELECT_ITEM = "select_item";
    @NonNull
    public static final String SELECT_PROMOTION = "select_promotion";
    @Deprecated
    @NonNull
    public static final String SET_CHECKOUT_OPTION = "set_checkout_option";
    @NonNull
    public static final String SHARE = "share";
    @NonNull
    public static final String SIGN_UP = "sign_up";
    @NonNull
    public static final String SPEND_VIRTUAL_CURRENCY = "spend_virtual_currency";
    @NonNull
    public static final String TUTORIAL_BEGIN = "tutorial_begin";
    @NonNull
    public static final String TUTORIAL_COMPLETE = "tutorial_complete";
    @NonNull
    public static final String UNLOCK_ACHIEVEMENT = "unlock_achievement";
    @NonNull
    public static final String VIEW_CART = "view_cart";
    @NonNull
    public static final String VIEW_ITEM = "view_item";
    @NonNull
    public static final String VIEW_ITEM_LIST = "view_item_list";
    @NonNull
    public static final String VIEW_PROMOTION = "view_promotion";
    @NonNull
    public static final String VIEW_SEARCH_RESULTS = "view_search_results";
  }
  
  public static class Param
  {
    @NonNull
    public static final String ACHIEVEMENT_ID = "achievement_id";
    @NonNull
    public static final String ACLID = "aclid";
    @NonNull
    public static final String AD_FORMAT = "ad_format";
    @NonNull
    public static final String AD_PLATFORM = "ad_platform";
    @NonNull
    public static final String AD_SOURCE = "ad_source";
    @NonNull
    public static final String AD_UNIT_NAME = "ad_unit_name";
    @NonNull
    public static final String AFFILIATION = "affiliation";
    @NonNull
    public static final String CAMPAIGN = "campaign";
    @NonNull
    public static final String CHARACTER = "character";
    @Deprecated
    @NonNull
    public static final String CHECKOUT_OPTION = "checkout_option";
    @Deprecated
    @NonNull
    public static final String CHECKOUT_STEP = "checkout_step";
    @NonNull
    public static final String CONTENT = "content";
    @NonNull
    public static final String CONTENT_TYPE = "content_type";
    @NonNull
    public static final String COUPON = "coupon";
    @NonNull
    public static final String CP1 = "cp1";
    @NonNull
    public static final String CREATIVE_NAME = "creative_name";
    @NonNull
    public static final String CREATIVE_SLOT = "creative_slot";
    @NonNull
    public static final String CURRENCY = "currency";
    @NonNull
    public static final String DESTINATION = "destination";
    @NonNull
    public static final String DISCOUNT = "discount";
    @NonNull
    public static final String END_DATE = "end_date";
    @NonNull
    public static final String EXTEND_SESSION = "extend_session";
    @NonNull
    public static final String FLIGHT_NUMBER = "flight_number";
    @NonNull
    public static final String GROUP_ID = "group_id";
    @NonNull
    public static final String INDEX = "index";
    @NonNull
    public static final String ITEMS = "items";
    @NonNull
    public static final String ITEM_BRAND = "item_brand";
    @NonNull
    public static final String ITEM_CATEGORY = "item_category";
    @NonNull
    public static final String ITEM_CATEGORY2 = "item_category2";
    @NonNull
    public static final String ITEM_CATEGORY3 = "item_category3";
    @NonNull
    public static final String ITEM_CATEGORY4 = "item_category4";
    @NonNull
    public static final String ITEM_CATEGORY5 = "item_category5";
    @NonNull
    public static final String ITEM_ID = "item_id";
    @Deprecated
    @NonNull
    public static final String ITEM_LIST = "item_list";
    @NonNull
    public static final String ITEM_LIST_ID = "item_list_id";
    @NonNull
    public static final String ITEM_LIST_NAME = "item_list_name";
    @Deprecated
    @NonNull
    public static final String ITEM_LOCATION_ID = "item_location_id";
    @NonNull
    public static final String ITEM_NAME = "item_name";
    @NonNull
    public static final String ITEM_VARIANT = "item_variant";
    @NonNull
    public static final String LEVEL = "level";
    @NonNull
    public static final String LEVEL_NAME = "level_name";
    @NonNull
    public static final String LOCATION = "location";
    @NonNull
    public static final String LOCATION_ID = "location_id";
    @NonNull
    public static final String MEDIUM = "medium";
    @NonNull
    public static final String METHOD = "method";
    @NonNull
    public static final String NUMBER_OF_NIGHTS = "number_of_nights";
    @NonNull
    public static final String NUMBER_OF_PASSENGERS = "number_of_passengers";
    @NonNull
    public static final String NUMBER_OF_ROOMS = "number_of_rooms";
    @NonNull
    public static final String ORIGIN = "origin";
    @NonNull
    public static final String PAYMENT_TYPE = "payment_type";
    @NonNull
    public static final String PRICE = "price";
    @NonNull
    public static final String PROMOTION_ID = "promotion_id";
    @NonNull
    public static final String PROMOTION_NAME = "promotion_name";
    @NonNull
    public static final String QUANTITY = "quantity";
    @NonNull
    public static final String SCORE = "score";
    @NonNull
    public static final String SCREEN_CLASS = "screen_class";
    @NonNull
    public static final String SCREEN_NAME = "screen_name";
    @NonNull
    public static final String SEARCH_TERM = "search_term";
    @NonNull
    public static final String SHIPPING = "shipping";
    @NonNull
    public static final String SHIPPING_TIER = "shipping_tier";
    @Deprecated
    @NonNull
    public static final String SIGN_UP_METHOD = "sign_up_method";
    @NonNull
    public static final String SOURCE = "source";
    @NonNull
    public static final String START_DATE = "start_date";
    @NonNull
    public static final String SUCCESS = "success";
    @NonNull
    public static final String TAX = "tax";
    @NonNull
    public static final String TERM = "term";
    @NonNull
    public static final String TRANSACTION_ID = "transaction_id";
    @NonNull
    public static final String TRAVEL_CLASS = "travel_class";
    @NonNull
    public static final String VALUE = "value";
    @NonNull
    public static final String VIRTUAL_CURRENCY_NAME = "virtual_currency_name";
  }
  
  public static class UserProperty
  {
    @NonNull
    public static final String ALLOW_AD_PERSONALIZATION_SIGNALS = "allow_personalized_ads";
    @NonNull
    public static final String SIGN_UP_METHOD = "sign_up_method";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\analytics\FirebaseAnalytics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */