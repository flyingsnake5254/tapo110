package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.github.mikephil.charting.utils.Utils;

public class Entry
  extends BaseEntry
  implements Parcelable
{
  public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator()
  {
    public Entry createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Entry(paramAnonymousParcel);
    }
    
    public Entry[] newArray(int paramAnonymousInt)
    {
      return new Entry[paramAnonymousInt];
    }
  };
  private float x = 0.0F;
  
  public Entry() {}
  
  public Entry(float paramFloat1, float paramFloat2)
  {
    super(paramFloat2);
    this.x = paramFloat1;
  }
  
  public Entry(float paramFloat1, float paramFloat2, Drawable paramDrawable)
  {
    super(paramFloat2, paramDrawable);
    this.x = paramFloat1;
  }
  
  public Entry(float paramFloat1, float paramFloat2, Drawable paramDrawable, Object paramObject)
  {
    super(paramFloat2, paramDrawable, paramObject);
    this.x = paramFloat1;
  }
  
  public Entry(float paramFloat1, float paramFloat2, Object paramObject)
  {
    super(paramFloat2, paramObject);
    this.x = paramFloat1;
  }
  
  protected Entry(Parcel paramParcel)
  {
    this.x = paramParcel.readFloat();
    setY(paramParcel.readFloat());
    if (paramParcel.readInt() == 1) {
      setData(paramParcel.readParcelable(Object.class.getClassLoader()));
    }
  }
  
  public Entry copy()
  {
    return new Entry(this.x, getY(), getData());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equalTo(Entry paramEntry)
  {
    if (paramEntry == null) {
      return false;
    }
    if (paramEntry.getData() != getData()) {
      return false;
    }
    float f1 = Math.abs(paramEntry.x - this.x);
    float f2 = Utils.FLOAT_EPSILON;
    if (f1 > f2) {
      return false;
    }
    return Math.abs(paramEntry.getY() - getY()) <= f2;
  }
  
  public float getX()
  {
    return this.x;
  }
  
  public void setX(float paramFloat)
  {
    this.x = paramFloat;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Entry, x: ");
    localStringBuilder.append(this.x);
    localStringBuilder.append(" y: ");
    localStringBuilder.append(getY());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.x);
    paramParcel.writeFloat(getY());
    if (getData() != null)
    {
      if ((getData() instanceof Parcelable))
      {
        paramParcel.writeInt(1);
        paramParcel.writeParcelable((Parcelable)getData(), paramInt);
      }
      else
      {
        throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
      }
    }
    else {
      paramParcel.writeInt(0);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\github\mikephil\charting\data\Entry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */