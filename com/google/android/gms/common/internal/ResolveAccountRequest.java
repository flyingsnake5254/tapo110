package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@SafeParcelable.Class(creator="ResolveAccountRequestCreator")
public class ResolveAccountRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new zam();
  @SafeParcelable.VersionField(id=1)
  private final int zalf;
  @SafeParcelable.Field(getter="getSessionId", id=3)
  private final int zapa;
  @SafeParcelable.Field(getter="getSignInAccountHint", id=4)
  private final GoogleSignInAccount zapb;
  @SafeParcelable.Field(getter="getAccount", id=2)
  private final Account zax;
  
  @SafeParcelable.Constructor
  ResolveAccountRequest(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) Account paramAccount, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) GoogleSignInAccount paramGoogleSignInAccount)
  {
    this.zalf = paramInt1;
    this.zax = paramAccount;
    this.zapa = paramInt2;
    this.zapb = paramGoogleSignInAccount;
  }
  
  public ResolveAccountRequest(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }
  
  public Account getAccount()
  {
    return this.zax;
  }
  
  public int getSessionId()
  {
    return this.zapa;
  }
  
  @Nullable
  public GoogleSignInAccount getSignInAccountHint()
  {
    return this.zapb;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getAccount(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getSessionId());
    SafeParcelWriter.writeParcelable(paramParcel, 4, getSignInAccountHint(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\ResolveAccountRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */