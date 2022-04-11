package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseArray
  extends SparseArray<Parcelable>
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = new Parcelable.ClassLoaderCreator()
  {
    @Nullable
    public ParcelableSparseArray createFromParcel(@NonNull Parcel paramAnonymousParcel)
    {
      return new ParcelableSparseArray(paramAnonymousParcel, null);
    }
    
    @NonNull
    public ParcelableSparseArray createFromParcel(@NonNull Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
    {
      return new ParcelableSparseArray(paramAnonymousParcel, paramAnonymousClassLoader);
    }
    
    @NonNull
    public ParcelableSparseArray[] newArray(int paramAnonymousInt)
    {
      return new ParcelableSparseArray[paramAnonymousInt];
    }
  };
  
  public ParcelableSparseArray() {}
  
  public ParcelableSparseArray(@NonNull Parcel paramParcel, @Nullable ClassLoader paramClassLoader)
  {
    int i = paramParcel.readInt();
    int[] arrayOfInt = new int[i];
    paramParcel.readIntArray(arrayOfInt);
    paramParcel = paramParcel.readParcelableArray(paramClassLoader);
    for (int j = 0; j < i; j++) {
      put(arrayOfInt[j], paramParcel[j]);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    int i = size();
    int[] arrayOfInt = new int[i];
    Parcelable[] arrayOfParcelable = new Parcelable[i];
    for (int j = 0; j < i; j++)
    {
      arrayOfInt[j] = keyAt(j);
      arrayOfParcelable[j] = ((Parcelable)valueAt(j));
    }
    paramParcel.writeInt(i);
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\internal\ParcelableSparseArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */