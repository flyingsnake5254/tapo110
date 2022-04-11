package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class RemoteMessageCreator
  implements Parcelable.Creator<RemoteMessage>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void writeToParcel(RemoteMessage paramRemoteMessage, Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, paramRemoteMessage.bundle, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  @NonNull
  public RemoteMessage createFromParcel(@NonNull Parcel paramParcel)
  {
    int i = SafeParcelReader.validateObjectHeader(paramParcel);
    Bundle localBundle = null;
    while (paramParcel.dataPosition() < i)
    {
      int j = SafeParcelReader.readHeader(paramParcel);
      if (SafeParcelReader.getFieldId(j) != 2) {
        SafeParcelReader.skipUnknownField(paramParcel, j);
      } else {
        localBundle = SafeParcelReader.createBundle(paramParcel, j);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, i);
    return new RemoteMessage(localBundle);
  }
  
  @NonNull
  public RemoteMessage[] newArray(int paramInt)
  {
    return new RemoteMessage[paramInt];
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\RemoteMessageCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */