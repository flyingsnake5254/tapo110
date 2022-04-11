package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class IconCompatParcelizer
{
  public static IconCompat read(VersionedParcel paramVersionedParcel)
  {
    IconCompat localIconCompat = new IconCompat();
    localIconCompat.mType = paramVersionedParcel.readInt(localIconCompat.mType, 1);
    localIconCompat.mData = paramVersionedParcel.readByteArray(localIconCompat.mData, 2);
    localIconCompat.mParcelable = paramVersionedParcel.readParcelable(localIconCompat.mParcelable, 3);
    localIconCompat.mInt1 = paramVersionedParcel.readInt(localIconCompat.mInt1, 4);
    localIconCompat.mInt2 = paramVersionedParcel.readInt(localIconCompat.mInt2, 5);
    localIconCompat.mTintList = ((ColorStateList)paramVersionedParcel.readParcelable(localIconCompat.mTintList, 6));
    localIconCompat.mTintModeStr = paramVersionedParcel.readString(localIconCompat.mTintModeStr, 7);
    localIconCompat.onPostParceling();
    return localIconCompat;
  }
  
  public static void write(IconCompat paramIconCompat, VersionedParcel paramVersionedParcel)
  {
    paramVersionedParcel.setSerializationFlags(true, true);
    paramIconCompat.onPreParceling(paramVersionedParcel.isStream());
    int i = paramIconCompat.mType;
    if (-1 != i) {
      paramVersionedParcel.writeInt(i, 1);
    }
    Object localObject = paramIconCompat.mData;
    if (localObject != null) {
      paramVersionedParcel.writeByteArray((byte[])localObject, 2);
    }
    localObject = paramIconCompat.mParcelable;
    if (localObject != null) {
      paramVersionedParcel.writeParcelable((Parcelable)localObject, 3);
    }
    i = paramIconCompat.mInt1;
    if (i != 0) {
      paramVersionedParcel.writeInt(i, 4);
    }
    i = paramIconCompat.mInt2;
    if (i != 0) {
      paramVersionedParcel.writeInt(i, 5);
    }
    localObject = paramIconCompat.mTintList;
    if (localObject != null) {
      paramVersionedParcel.writeParcelable((Parcelable)localObject, 6);
    }
    paramIconCompat = paramIconCompat.mTintModeStr;
    if (paramIconCompat != null) {
      paramVersionedParcel.writeString(paramIconCompat, 7);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\drawable\IconCompatParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */