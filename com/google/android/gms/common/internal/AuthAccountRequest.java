package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator="AuthAccountRequestCreator")
public class AuthAccountRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zaa();
  @SafeParcelable.VersionField(id=1)
  private final int zalf;
  @Deprecated
  @SafeParcelable.Field(id=2)
  private final IBinder zanx;
  @SafeParcelable.Field(id=3)
  private final Scope[] zany;
  @SafeParcelable.Field(id=4)
  private Integer zanz;
  @SafeParcelable.Field(id=5)
  private Integer zaoa;
  @SafeParcelable.Field(id=6, type="android.accounts.Account")
  private Account zax;
  
  @SafeParcelable.Constructor
  AuthAccountRequest(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) IBinder paramIBinder, @SafeParcelable.Param(id=3) Scope[] paramArrayOfScope, @SafeParcelable.Param(id=4) Integer paramInteger1, @SafeParcelable.Param(id=5) Integer paramInteger2, @SafeParcelable.Param(id=6) Account paramAccount)
  {
    this.zalf = paramInt;
    this.zanx = paramIBinder;
    this.zany = paramArrayOfScope;
    this.zanz = paramInteger1;
    this.zaoa = paramInteger2;
    this.zax = paramAccount;
  }
  
  public AuthAccountRequest(Account paramAccount, Set<Scope> paramSet)
  {
    this(3, null, (Scope[])paramSet.toArray(new Scope[paramSet.size()]), null, null, (Account)Preconditions.checkNotNull(paramAccount));
  }
  
  @Deprecated
  public AuthAccountRequest(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet)
  {
    this(3, paramIAccountAccessor.asBinder(), (Scope[])paramSet.toArray(new Scope[paramSet.size()]), null, null, null);
  }
  
  public Account getAccount()
  {
    Object localObject = this.zax;
    if (localObject == null)
    {
      localObject = this.zanx;
      if (localObject != null) {
        localObject = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface((IBinder)localObject));
      } else {
        localObject = null;
      }
    }
    return (Account)localObject;
  }
  
  @Nullable
  public Integer getOauthPolicy()
  {
    return this.zanz;
  }
  
  @Nullable
  public Integer getPolicyAction()
  {
    return this.zaoa;
  }
  
  public Set<Scope> getScopes()
  {
    return new HashSet(Arrays.asList(this.zany));
  }
  
  public AuthAccountRequest setOauthPolicy(@Nullable Integer paramInteger)
  {
    this.zanz = paramInteger;
    return this;
  }
  
  public AuthAccountRequest setPolicyAction(@Nullable Integer paramInteger)
  {
    this.zaoa = paramInteger;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zanx, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zany, paramInt, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 4, this.zanz, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 5, this.zaoa, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.zax, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\AuthAccountRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */