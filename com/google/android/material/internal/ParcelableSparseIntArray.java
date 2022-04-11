package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseIntArray
  extends SparseIntArray
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new Parcelable.Creator()
  {
    @NonNull
    public ParcelableSparseIntArray createFromParcel(@NonNull Parcel paramAnonymousParcel)
    {
      int i = paramAnonymousParcel.readInt();
      ParcelableSparseIntArray localParcelableSparseIntArray = new ParcelableSparseIntArray(i);
      int[] arrayOfInt1 = new int[i];
      int[] arrayOfInt2 = new int[i];
      paramAnonymousParcel.readIntArray(arrayOfInt1);
      paramAnonymousParcel.readIntArray(arrayOfInt2);
      for (int j = 0; j < i; j++) {
        localParcelableSparseIntArray.put(arrayOfInt1[j], arrayOfInt2[j]);
      }
      return localParcelableSparseIntArray;
    }
    
    @NonNull
    public ParcelableSparseIntArray[] newArray(int paramAnonymousInt)
    {
      return new ParcelableSparseIntArray[paramAnonymousInt];
    }
  };
  
  public ParcelableSparseIntArray() {}
  
  public ParcelableSparseIntArray(int paramInt)
  {
    super(paramInt);
  }
  
  public ParcelableSparseIntArray(@NonNull SparseIntArray paramSparseIntArray)
  {
    for (int i = 0; i < paramSparseIntArray.size(); i++) {
      put(paramSparseIntArray.keyAt(i), paramSparseIntArray.valueAt(i));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    int[] arrayOfInt1 = new int[size()];
    int[] arrayOfInt2 = new int[size()];
    for (paramInt = 0; paramInt < size(); paramInt++)
    {
      arrayOfInt1[paramInt] = keyAt(paramInt);
      arrayOfInt2[paramInt] = valueAt(paramInt);
    }
    paramParcel.writeInt(size());
    paramParcel.writeIntArray(arrayOfInt1);
    paramParcel.writeIntArray(arrayOfInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ParcelableSparseIntArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */