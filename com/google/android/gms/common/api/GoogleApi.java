package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collection;
import java.util.Collections;

@KeepForSdk
public class GoogleApi<O extends Api.ApiOptions>
{
  private final Api<O> mApi;
  private final Context mContext;
  private final int mId;
  private final O zabh;
  private final zai<O> zabi;
  private final Looper zabj;
  private final GoogleApiClient zabk;
  private final StatusExceptionMapper zabl;
  protected final GoogleApiManager zabm;
  
  @MainThread
  @KeepForSdk
  public GoogleApi(@NonNull Activity paramActivity, Api<O> paramApi, @Nullable O paramO, Settings paramSettings)
  {
    Preconditions.checkNotNull(paramActivity, "Null activity is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    Context localContext = paramActivity.getApplicationContext();
    this.mContext = localContext;
    this.mApi = paramApi;
    this.zabh = paramO;
    this.zabj = paramSettings.zabo;
    paramApi = zai.zaa(paramApi, paramO);
    this.zabi = paramApi;
    this.zabk = new zabp(this);
    paramO = GoogleApiManager.zab(localContext);
    this.zabm = paramO;
    this.mId = paramO.zabd();
    this.zabl = paramSettings.zabn;
    if (!(paramActivity instanceof GoogleApiActivity)) {
      zaae.zaa(paramActivity, paramO, paramApi);
    }
    paramO.zaa(this);
  }
  
  @Deprecated
  @KeepForSdk
  public GoogleApi(@NonNull Activity paramActivity, Api<O> paramApi, @Nullable O paramO, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramActivity, paramApi, paramO, new GoogleApi.Settings.Builder().setMapper(paramStatusExceptionMapper).setLooper(paramActivity.getMainLooper()).build());
  }
  
  @KeepForSdk
  protected GoogleApi(@NonNull Context paramContext, Api<O> paramApi, Looper paramLooper)
  {
    Preconditions.checkNotNull(paramContext, "Null context is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramLooper, "Looper must not be null.");
    paramContext = paramContext.getApplicationContext();
    this.mContext = paramContext;
    this.mApi = paramApi;
    this.zabh = null;
    this.zabj = paramLooper;
    this.zabi = zai.zaa(paramApi);
    this.zabk = new zabp(this);
    paramContext = GoogleApiManager.zab(paramContext);
    this.zabm = paramContext;
    this.mId = paramContext.zabd();
    this.zabl = new ApiExceptionMapper();
  }
  
  @Deprecated
  @KeepForSdk
  public GoogleApi(@NonNull Context paramContext, Api<O> paramApi, @Nullable O paramO, Looper paramLooper, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramContext, paramApi, paramO, new GoogleApi.Settings.Builder().setLooper(paramLooper).setMapper(paramStatusExceptionMapper).build());
  }
  
  @KeepForSdk
  public GoogleApi(@NonNull Context paramContext, Api<O> paramApi, @Nullable O paramO, Settings paramSettings)
  {
    Preconditions.checkNotNull(paramContext, "Null context is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    paramContext = paramContext.getApplicationContext();
    this.mContext = paramContext;
    this.mApi = paramApi;
    this.zabh = paramO;
    this.zabj = paramSettings.zabo;
    this.zabi = zai.zaa(paramApi, paramO);
    this.zabk = new zabp(this);
    paramContext = GoogleApiManager.zab(paramContext);
    this.zabm = paramContext;
    this.mId = paramContext.zabd();
    this.zabl = paramSettings.zabn;
    paramContext.zaa(this);
  }
  
  @Deprecated
  @KeepForSdk
  public GoogleApi(@NonNull Context paramContext, Api<O> paramApi, @Nullable O paramO, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramContext, paramApi, paramO, new GoogleApi.Settings.Builder().setMapper(paramStatusExceptionMapper).build());
  }
  
  private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zaa(int paramInt, @NonNull T paramT)
  {
    paramT.zau();
    this.zabm.zaa(this, paramInt, paramT);
    return paramT;
  }
  
  private final <TResult, A extends Api.AnyClient> Task<TResult> zaa(int paramInt, @NonNull TaskApiCall<A, TResult> paramTaskApiCall)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.zabm.zaa(this, paramInt, paramTaskApiCall, localTaskCompletionSource, this.zabl);
    return localTaskCompletionSource.getTask();
  }
  
  @KeepForSdk
  public GoogleApiClient asGoogleApiClient()
  {
    return this.zabk;
  }
  
  @KeepForSdk
  protected ClientSettings.Builder createClientSettingsBuilder()
  {
    ClientSettings.Builder localBuilder = new ClientSettings.Builder();
    Object localObject = this.zabh;
    if ((localObject instanceof Api.ApiOptions.HasGoogleSignInAccountOptions))
    {
      localObject = ((Api.ApiOptions.HasGoogleSignInAccountOptions)localObject).getGoogleSignInAccount();
      if (localObject != null)
      {
        localObject = ((GoogleSignInAccount)localObject).getAccount();
        break label69;
      }
    }
    localObject = this.zabh;
    if ((localObject instanceof Api.ApiOptions.HasAccountOptions)) {
      localObject = ((Api.ApiOptions.HasAccountOptions)localObject).getAccount();
    } else {
      localObject = null;
    }
    label69:
    localBuilder = localBuilder.setAccount((Account)localObject);
    localObject = this.zabh;
    if ((localObject instanceof Api.ApiOptions.HasGoogleSignInAccountOptions))
    {
      localObject = ((Api.ApiOptions.HasGoogleSignInAccountOptions)localObject).getGoogleSignInAccount();
      if (localObject != null)
      {
        localObject = ((GoogleSignInAccount)localObject).getRequestedScopes();
        break label113;
      }
    }
    localObject = Collections.emptySet();
    label113:
    return localBuilder.addAllRequiredScopes((Collection)localObject).setRealClientClassName(this.mContext.getClass().getName()).setRealClientPackageName(this.mContext.getPackageName());
  }
  
  @KeepForSdk
  protected Task<Boolean> disconnectService()
  {
    return this.zabm.zac(this);
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(@NonNull T paramT)
  {
    return zaa(2, paramT);
  }
  
  @KeepForSdk
  public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> paramTaskApiCall)
  {
    return zaa(2, paramTaskApiCall);
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(@NonNull T paramT)
  {
    return zaa(0, paramT);
  }
  
  @KeepForSdk
  public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> paramTaskApiCall)
  {
    return zaa(0, paramTaskApiCall);
  }
  
  @Deprecated
  @KeepForSdk
  public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(@NonNull T paramT, U paramU)
  {
    Preconditions.checkNotNull(paramT);
    Preconditions.checkNotNull(paramU);
    Preconditions.checkNotNull(paramT.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(paramU.getListenerKey(), "Listener has already been released.");
    Preconditions.checkArgument(paramT.getListenerKey().equals(paramU.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
    return this.zabm.zaa(this, paramT, paramU);
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(@NonNull RegistrationMethods<A, ?> paramRegistrationMethods)
  {
    Preconditions.checkNotNull(paramRegistrationMethods);
    Preconditions.checkNotNull(paramRegistrationMethods.zajz.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(paramRegistrationMethods.zaka.getListenerKey(), "Listener has already been released.");
    return this.zabm.zaa(this, paramRegistrationMethods.zajz, paramRegistrationMethods.zaka);
  }
  
  @KeepForSdk
  public Task<Boolean> doUnregisterEventListener(@NonNull ListenerHolder.ListenerKey<?> paramListenerKey)
  {
    Preconditions.checkNotNull(paramListenerKey, "Listener key cannot be null.");
    return this.zabm.zaa(this, paramListenerKey);
  }
  
  @KeepForSdk
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(@NonNull T paramT)
  {
    return zaa(1, paramT);
  }
  
  @KeepForSdk
  public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> paramTaskApiCall)
  {
    return zaa(1, paramTaskApiCall);
  }
  
  public final Api<O> getApi()
  {
    return this.mApi;
  }
  
  @KeepForSdk
  public O getApiOptions()
  {
    return this.zabh;
  }
  
  @KeepForSdk
  public Context getApplicationContext()
  {
    return this.mContext;
  }
  
  public final int getInstanceId()
  {
    return this.mId;
  }
  
  @KeepForSdk
  public Looper getLooper()
  {
    return this.zabj;
  }
  
  @KeepForSdk
  public <L> ListenerHolder<L> registerListener(@NonNull L paramL, String paramString)
  {
    return ListenerHolders.createListenerHolder(paramL, this.zabj, paramString);
  }
  
  @WorkerThread
  public Api.Client zaa(Looper paramLooper, GoogleApiManager.zaa<O> paramzaa)
  {
    ClientSettings localClientSettings = createClientSettingsBuilder().build();
    return this.mApi.zai().buildClient(this.mContext, paramLooper, localClientSettings, this.zabh, paramzaa, paramzaa);
  }
  
  public zace zaa(Context paramContext, Handler paramHandler)
  {
    return new zace(paramContext, paramHandler, createClientSettingsBuilder().build());
  }
  
  public final zai<O> zak()
  {
    return this.zabi;
  }
  
  @KeepForSdk
  public static class Settings
  {
    @KeepForSdk
    public static final Settings DEFAULT_SETTINGS = new Builder().build();
    public final StatusExceptionMapper zabn;
    public final Looper zabo;
    
    @KeepForSdk
    private Settings(StatusExceptionMapper paramStatusExceptionMapper, Account paramAccount, Looper paramLooper)
    {
      this.zabn = paramStatusExceptionMapper;
      this.zabo = paramLooper;
    }
    
    @KeepForSdk
    public static class Builder
    {
      private Looper zabj;
      private StatusExceptionMapper zabl;
      
      @KeepForSdk
      public GoogleApi.Settings build()
      {
        if (this.zabl == null) {
          this.zabl = new ApiExceptionMapper();
        }
        if (this.zabj == null) {
          this.zabj = Looper.getMainLooper();
        }
        return new GoogleApi.Settings(this.zabl, null, this.zabj, null);
      }
      
      @KeepForSdk
      public Builder setLooper(Looper paramLooper)
      {
        Preconditions.checkNotNull(paramLooper, "Looper must not be null.");
        this.zabj = paramLooper;
        return this;
      }
      
      @KeepForSdk
      public Builder setMapper(StatusExceptionMapper paramStatusExceptionMapper)
      {
        Preconditions.checkNotNull(paramStatusExceptionMapper, "StatusExceptionMapper must not be null.");
        this.zabl = paramStatusExceptionMapper;
        return this;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\GoogleApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */