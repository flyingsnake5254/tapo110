package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@KeepForSdk
@SafeParcelable.Class(creator="ClientIdentityCreator")
@SafeParcelable.Reserved({1000})
public class ClientIdentity
  extends AbstractSafeParcelable
{
  @KeepForSdk
  public static final Parcelable.Creator<ClientIdentity> CREATOR = new zab();
  @Nullable
  @SafeParcelable.Field(defaultValueUnchecked="null", id=2)
  private final String packageName;
  @SafeParcelable.Field(defaultValueUnchecked="0", id=1)
  private final int uid;
  
  @SafeParcelable.Constructor
  public ClientIdentity(@SafeParcelable.Param(id=1) int paramInt, @Nullable @SafeParcelable.Param(id=2) String paramString)
  {
    this.uid = paramInt;
    this.packageName = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof ClientIdentity)))
    {
      paramObject = (ClientIdentity)paramObject;
      if ((((ClientIdentity)paramObject).uid == this.uid) && (Objects.equal(((ClientIdentity)paramObject).packageName, this.packageName))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.uid;
  }
  
  public String toString()
  {
    int i = this.uid;
    String str = this.packageName;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 12);
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.uid);
    SafeParcelWriter.writeString(paramParcel, 2, this.packageName, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\ClientIdentity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */