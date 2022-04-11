package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseBooleanArray
  extends SparseBooleanArray
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new Parcelable.Creator()
  {
    @NonNull
    public ParcelableSparseBooleanArray createFromParcel(@NonNull Parcel paramAnonymousParcel)
    {
      int i = paramAnonymousParcel.readInt();
      ParcelableSparseBooleanArray localParcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i);
      int[] arrayOfInt = new int[i];
      boolean[] arrayOfBoolean = new boolean[i];
      paramAnonymousParcel.readIntArray(arrayOfInt);
      paramAnonymousParcel.readBooleanArray(arrayOfBoolean);
      for (int j = 0; j < i; j++) {
        localParcelableSparseBooleanArray.put(arrayOfInt[j], arrayOfBoolean[j]);
      }
      return localParcelableSparseBooleanArray;
    }
    
    @NonNull
    public ParcelableSparseBooleanArray[] newArray(int paramAnonymousInt)
    {
      return new ParcelableSparseBooleanArray[paramAnonymousInt];
    }
  };
  
  public ParcelableSparseBooleanArray() {}
  
  public ParcelableSparseBooleanArray(int paramInt)
  {
    super(paramInt);
  }
  
  public ParcelableSparseBooleanArray(@NonNull SparseBooleanArray paramSparseBooleanArray)
  {
    super(paramSparseBooleanArray.size());
    for (int i = 0; i < paramSparseBooleanArray.size(); i++) {
      put(paramSparseBooleanArray.keyAt(i), paramSparseBooleanArray.valueAt(i));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    int[] arrayOfInt = new int[size()];
    boolean[] arrayOfBoolean = new boolean[size()];
    for (paramInt = 0; paramInt < size(); paramInt++)
    {
      arrayOfInt[paramInt] = keyAt(paramInt);
      arrayOfBoolean[paramInt] = valueAt(paramInt);
    }
    paramParcel.writeInt(size());
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeBooleanArray(arrayOfBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ParcelableSparseBooleanArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */