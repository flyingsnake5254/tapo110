package com.hannesdorfmann.mosby3;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.customview.view.AbsSavedState;

public class MosbySavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<MosbySavedState> CREATOR = ParcelableCompat.newCreator(new a());
  private String c;
  
  protected MosbySavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.c = paramParcel.readString();
  }
  
  public MosbySavedState(Parcelable paramParcelable, String paramString)
  {
    super(paramParcelable);
    this.c = paramString;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.c);
  }
  
  static final class a
    implements ParcelableCompatCreatorCallbacks<MosbySavedState>
  {
    public MosbySavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = MosbySavedState.class.getClassLoader();
      }
      return new MosbySavedState(paramParcel, localClassLoader);
    }
    
    public MosbySavedState[] b(int paramInt)
    {
      return new MosbySavedState[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\hannesdorfmann\mosby3\MosbySavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */