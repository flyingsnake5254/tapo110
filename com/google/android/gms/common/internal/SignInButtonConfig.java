package com.google.android.gms.common.internal;

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

@SafeParcelable.Class(creator="SignInButtonConfigCreator")
public class SignInButtonConfig
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zao();
  @SafeParcelable.VersionField(id=1)
  private final int zalf;
  @Deprecated
  @SafeParcelable.Field(getter="getScopes", id=4)
  private final Scope[] zany;
  @SafeParcelable.Field(getter="getButtonSize", id=2)
  private final int zapd;
  @SafeParcelable.Field(getter="getColorScheme", id=3)
  private final int zape;
  
  @SafeParcelable.Constructor
  SignInButtonConfig(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) int paramInt2, @SafeParcelable.Param(id=3) int paramInt3, @SafeParcelable.Param(id=4) Scope[] paramArrayOfScope)
  {
    this.zalf = paramInt1;
    this.zapd = paramInt2;
    this.zape = paramInt3;
    this.zany = paramArrayOfScope;
  }
  
  public SignInButtonConfig(int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
  {
    this(1, paramInt1, paramInt2, null);
  }
  
  public int getButtonSize()
  {
    return this.zapd;
  }
  
  public int getColorScheme()
  {
    return this.zape;
  }
  
  @Deprecated
  public Scope[] getScopes()
  {
    return this.zany;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeInt(paramParcel, 2, getButtonSize());
    SafeParcelWriter.writeInt(paramParcel, 3, getColorScheme());
    SafeParcelWriter.writeTypedArray(paramParcel, 4, getScopes(), paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\SignInButtonConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */