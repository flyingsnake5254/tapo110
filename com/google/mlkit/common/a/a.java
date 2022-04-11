package com.google.mlkit.common.a;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import java.util.EnumMap;
import java.util.Map;

public class a
{
  private static final Map<BaseModel, String> a = new EnumMap(BaseModel.class);
  @VisibleForTesting
  private static final Map<BaseModel, String> b = new EnumMap(BaseModel.class);
  @Nullable
  private final String c;
  @Nullable
  private final BaseModel d;
  private String e;
  
  @KeepForSdk
  public String a()
  {
    return this.e;
  }
  
  @KeepForSdk
  public String b()
  {
    String str = this.c;
    if (str != null) {
      return str;
    }
    return (String)b.get(this.d);
  }
  
  @KeepForSdk
  public String c()
  {
    String str = this.c;
    if (str != null) {
      return str;
    }
    str = String.valueOf((String)b.get(this.d));
    if (str.length() != 0) {
      return "COM.GOOGLE.BASE_".concat(str);
    }
    return new String("COM.GOOGLE.BASE_");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return (Objects.equal(this.c, ((a)paramObject).c)) && (Objects.equal(this.d, ((a)paramObject).d));
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.c, this.d });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */