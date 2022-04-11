package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
@SafeParcelable.Class(creator="FieldMappingDictionaryEntryCreator")
public final class zal
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zal> CREATOR = new zao();
  @SafeParcelable.Field(id=2)
  final String className;
  @SafeParcelable.VersionField(id=1)
  private final int versionCode;
  @SafeParcelable.Field(id=3)
  final ArrayList<zam> zaqy;
  
  @SafeParcelable.Constructor
  zal(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) ArrayList<zam> paramArrayList)
  {
    this.versionCode = paramInt;
    this.className = paramString;
    this.zaqy = paramArrayList;
  }
  
  zal(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    this.versionCode = 1;
    this.className = paramString;
    if (paramMap == null)
    {
      paramString = null;
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        paramString = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (String)localIterator.next();
        localArrayList.add(new zam(paramString, (FastJsonResponse.Field)paramMap.get(paramString)));
      }
    }
    this.zaqy = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.className, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zaqy, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\server\response\zal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */