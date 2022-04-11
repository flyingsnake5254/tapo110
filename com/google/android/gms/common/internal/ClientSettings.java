package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@KeepForSdk
@VisibleForTesting
public final class ClientSettings
{
  public static final String KEY_CLIENT_SESSION_ID = "com.google.android.gms.common.internal.ClientSettings.sessionId";
  private final Set<Scope> zabr;
  private final int zabt;
  private final View zabu;
  private final String zabv;
  private final String zabw;
  private final boolean zaby;
  private final Set<Scope> zaob;
  private final Map<Api<?>, OptionalApiSettings> zaoc;
  private final SignInOptions zaod;
  private Integer zaoe;
  private final Account zax;
  
  @KeepForSdk
  public ClientSettings(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, OptionalApiSettings> paramMap, int paramInt, View paramView, String paramString1, String paramString2, SignInOptions paramSignInOptions)
  {
    this(paramAccount, paramSet, paramMap, paramInt, paramView, paramString1, paramString2, paramSignInOptions, false);
  }
  
  public ClientSettings(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, OptionalApiSettings> paramMap, int paramInt, View paramView, String paramString1, String paramString2, SignInOptions paramSignInOptions, boolean paramBoolean)
  {
    this.zax = paramAccount;
    if (paramSet == null) {
      paramAccount = Collections.EMPTY_SET;
    } else {
      paramAccount = Collections.unmodifiableSet(paramSet);
    }
    this.zabr = paramAccount;
    paramSet = paramMap;
    if (paramMap == null) {
      paramSet = Collections.EMPTY_MAP;
    }
    this.zaoc = paramSet;
    this.zabu = paramView;
    this.zabt = paramInt;
    this.zabv = paramString1;
    this.zabw = paramString2;
    this.zaod = paramSignInOptions;
    this.zaby = paramBoolean;
    paramAccount = new HashSet(paramAccount);
    paramSet = paramSet.values().iterator();
    while (paramSet.hasNext()) {
      paramAccount.addAll(((OptionalApiSettings)paramSet.next()).mScopes);
    }
    this.zaob = Collections.unmodifiableSet(paramAccount);
  }
  
  @KeepForSdk
  public static ClientSettings createDefault(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).buildClientSettings();
  }
  
  @Nullable
  @KeepForSdk
  public final Account getAccount()
  {
    return this.zax;
  }
  
  @Deprecated
  @Nullable
  @KeepForSdk
  public final String getAccountName()
  {
    Account localAccount = this.zax;
    if (localAccount != null) {
      return localAccount.name;
    }
    return null;
  }
  
  @KeepForSdk
  public final Account getAccountOrDefault()
  {
    Account localAccount = this.zax;
    if (localAccount != null) {
      return localAccount;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  @KeepForSdk
  public final Set<Scope> getAllRequestedScopes()
  {
    return this.zaob;
  }
  
  @KeepForSdk
  public final Set<Scope> getApplicableScopes(Api<?> paramApi)
  {
    OptionalApiSettings localOptionalApiSettings = (OptionalApiSettings)this.zaoc.get(paramApi);
    if ((localOptionalApiSettings != null) && (!localOptionalApiSettings.mScopes.isEmpty()))
    {
      paramApi = new HashSet(this.zabr);
      paramApi.addAll(localOptionalApiSettings.mScopes);
      return paramApi;
    }
    return this.zabr;
  }
  
  @Nullable
  public final Integer getClientSessionId()
  {
    return this.zaoe;
  }
  
  @KeepForSdk
  public final int getGravityForPopups()
  {
    return this.zabt;
  }
  
  public final Map<Api<?>, OptionalApiSettings> getOptionalApiSettings()
  {
    return this.zaoc;
  }
  
  @Nullable
  public final String getRealClientClassName()
  {
    return this.zabw;
  }
  
  @Nullable
  @KeepForSdk
  public final String getRealClientPackageName()
  {
    return this.zabv;
  }
  
  @KeepForSdk
  public final Set<Scope> getRequiredScopes()
  {
    return this.zabr;
  }
  
  @Nullable
  public final SignInOptions getSignInOptions()
  {
    return this.zaod;
  }
  
  @Nullable
  @KeepForSdk
  public final View getViewForPopups()
  {
    return this.zabu;
  }
  
  public final boolean isSignInClientDisconnectFixEnabled()
  {
    return this.zaby;
  }
  
  public final void setClientSessionId(Integer paramInteger)
  {
    this.zaoe = paramInteger;
  }
  
  @KeepForSdk
  public static final class Builder
  {
    private int zabt = 0;
    private View zabu;
    private String zabv;
    private String zabw;
    private boolean zaby;
    private Map<Api<?>, ClientSettings.OptionalApiSettings> zaoc;
    private SignInOptions zaod = SignInOptions.DEFAULT;
    private ArraySet<Scope> zaof;
    private Account zax;
    
    public final Builder addAllRequiredScopes(Collection<Scope> paramCollection)
    {
      if (this.zaof == null) {
        this.zaof = new ArraySet();
      }
      this.zaof.addAll(paramCollection);
      return this;
    }
    
    public final Builder addRequiredScope(Scope paramScope)
    {
      if (this.zaof == null) {
        this.zaof = new ArraySet();
      }
      this.zaof.add(paramScope);
      return this;
    }
    
    @KeepForSdk
    public final ClientSettings build()
    {
      return new ClientSettings(this.zax, this.zaof, this.zaoc, this.zabt, this.zabu, this.zabv, this.zabw, this.zaod, this.zaby);
    }
    
    public final Builder enableSignInClientDisconnectFix()
    {
      this.zaby = true;
      return this;
    }
    
    public final Builder setAccount(Account paramAccount)
    {
      this.zax = paramAccount;
      return this;
    }
    
    public final Builder setGravityForPopups(int paramInt)
    {
      this.zabt = paramInt;
      return this;
    }
    
    public final Builder setOptionalApiSettingsMap(Map<Api<?>, ClientSettings.OptionalApiSettings> paramMap)
    {
      this.zaoc = paramMap;
      return this;
    }
    
    public final Builder setRealClientClassName(String paramString)
    {
      this.zabw = paramString;
      return this;
    }
    
    @KeepForSdk
    public final Builder setRealClientPackageName(String paramString)
    {
      this.zabv = paramString;
      return this;
    }
    
    public final Builder setSignInOptions(SignInOptions paramSignInOptions)
    {
      this.zaod = paramSignInOptions;
      return this;
    }
    
    public final Builder setViewForPopups(View paramView)
    {
      this.zabu = paramView;
      return this;
    }
  }
  
  public static final class OptionalApiSettings
  {
    public final Set<Scope> mScopes;
    
    public OptionalApiSettings(Set<Scope> paramSet)
    {
      Preconditions.checkNotNull(paramSet);
      this.mScopes = Collections.unmodifiableSet(paramSet);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\ClientSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */