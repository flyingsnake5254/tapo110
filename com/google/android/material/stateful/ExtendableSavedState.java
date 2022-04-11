package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

public class ExtendableSavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new Parcelable.ClassLoaderCreator()
  {
    @Nullable
    public ExtendableSavedState createFromParcel(@NonNull Parcel paramAnonymousParcel)
    {
      return new ExtendableSavedState(paramAnonymousParcel, null, null);
    }
    
    @NonNull
    public ExtendableSavedState createFromParcel(@NonNull Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
    {
      return new ExtendableSavedState(paramAnonymousParcel, paramAnonymousClassLoader, null);
    }
    
    @NonNull
    public ExtendableSavedState[] newArray(int paramAnonymousInt)
    {
      return new ExtendableSavedState[paramAnonymousInt];
    }
  };
  @NonNull
  public final SimpleArrayMap<String, Bundle> extendableStates;
  
  private ExtendableSavedState(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    int i = paramParcel.readInt();
    paramClassLoader = new String[i];
    paramParcel.readStringArray(paramClassLoader);
    Bundle[] arrayOfBundle = new Bundle[i];
    paramParcel.readTypedArray(arrayOfBundle, Bundle.CREATOR);
    this.extendableStates = new SimpleArrayMap(i);
    for (int j = 0; j < i; j++) {
      this.extendableStates.put(paramClassLoader[j], arrayOfBundle[j]);
    }
  }
  
  public ExtendableSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
    this.extendableStates = new SimpleArrayMap();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtendableSavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" states=");
    localStringBuilder.append(this.extendableStates);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    int i = this.extendableStates.size();
    paramParcel.writeInt(i);
    String[] arrayOfString = new String[i];
    Bundle[] arrayOfBundle = new Bundle[i];
    for (paramInt = 0; paramInt < i; paramInt++)
    {
      arrayOfString[paramInt] = ((String)this.extendableStates.keyAt(paramInt));
      arrayOfBundle[paramInt] = ((Bundle)this.extendableStates.valueAt(paramInt));
    }
    paramParcel.writeStringArray(arrayOfString);
    paramParcel.writeTypedArray(arrayOfBundle, 0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\stateful\ExtendableSavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */