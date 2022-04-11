package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator="WebImageCreator")
public final class WebImage
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR = new zae();
  @SafeParcelable.VersionField(id=1)
  private final int zalf;
  @SafeParcelable.Field(getter="getWidth", id=3)
  private final int zane;
  @SafeParcelable.Field(getter="getHeight", id=4)
  private final int zanf;
  @SafeParcelable.Field(getter="getUrl", id=2)
  private final Uri zang;
  
  @SafeParcelable.Constructor
  WebImage(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) Uri paramUri, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) int paramInt3)
  {
    this.zalf = paramInt1;
    this.zang = paramUri;
    this.zane = paramInt2;
    this.zanf = paramInt3;
  }
  
  public WebImage(Uri paramUri)
    throws IllegalArgumentException
  {
    this(paramUri, 0, 0);
  }
  
  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri != null)
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0)) {
        return;
      }
      throw new IllegalArgumentException("width and height must not be negative");
    }
    throw new IllegalArgumentException("url cannot be null");
  }
  
  @KeepForSdk
  public WebImage(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    this(zaa(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }
  
  private static Uri zaa(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("url")) {}
    try
    {
      paramJSONObject = Uri.parse(paramJSONObject.getString("url"));
    }
    catch (JSONException paramJSONObject)
    {
      for (;;) {}
    }
    paramJSONObject = null;
    return paramJSONObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof WebImage)))
    {
      paramObject = (WebImage)paramObject;
      if ((Objects.equal(this.zang, ((WebImage)paramObject).zang)) && (this.zane == ((WebImage)paramObject).zane) && (this.zanf == ((WebImage)paramObject).zanf)) {
        return true;
      }
    }
    return false;
  }
  
  public final int getHeight()
  {
    return this.zanf;
  }
  
  public final Uri getUrl()
  {
    return this.zang;
  }
  
  public final int getWidth()
  {
    return this.zane;
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zang, Integer.valueOf(this.zane), Integer.valueOf(this.zanf) });
  }
  
  @KeepForSdk
  public final JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.zang.toString());
      localJSONObject.put("width", this.zane);
      localJSONObject.put("height", this.zanf);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "Image %dx%d %s", new Object[] { Integer.valueOf(this.zane), Integer.valueOf(this.zanf), this.zang.toString() });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeParcelable(paramParcel, 2, getUrl(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getWidth());
    SafeParcelWriter.writeInt(paramParcel, 4, getHeight());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\images\WebImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */