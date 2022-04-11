package com.tplink.libtpcontrols.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ActionSheetParams
  implements Parcelable
{
  public static final Parcelable.Creator<ActionSheetParams> CREATOR = new a();
  CharSequence c = null;
  int d = -1;
  int f = -1;
  int q = -1;
  boolean x = false;
  boolean y = false;
  
  public int a()
  {
    return this.q;
  }
  
  public CharSequence b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.x;
  }
  
  public boolean f()
  {
    return this.y;
  }
  
  public void h(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void i(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public void l(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
  }
  
  public void m(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void n(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    CharSequence localCharSequence = this.c;
    if (localCharSequence != null) {
      paramParcel.writeString(localCharSequence.toString());
    } else {
      paramParcel.writeString("");
    }
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.q);
    if (this.x) {
      paramParcel.writeInt(1);
    } else {
      paramParcel.writeInt(0);
    }
  }
  
  static final class a
    implements Parcelable.Creator<ActionSheetParams>
  {
    public ActionSheetParams a(Parcel paramParcel)
    {
      ActionSheetParams localActionSheetParams = new ActionSheetParams();
      localActionSheetParams.l(paramParcel.readString());
      localActionSheetParams.n(paramParcel.readInt());
      localActionSheetParams.m(paramParcel.readInt());
      localActionSheetParams.h(paramParcel.readInt());
      boolean bool;
      if (paramParcel.readInt() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      localActionSheetParams.i(bool);
      return localActionSheetParams;
    }
    
    public ActionSheetParams[] b(int paramInt)
    {
      return new ActionSheetParams[0];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\model\ActionSheetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */