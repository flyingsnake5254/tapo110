package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class DataBufferRef
{
  @KeepForSdk
  protected final DataHolder mDataHolder;
  @KeepForSdk
  protected int mDataRow;
  private int zaln;
  
  @KeepForSdk
  public DataBufferRef(DataHolder paramDataHolder, int paramInt)
  {
    this.mDataHolder = ((DataHolder)Preconditions.checkNotNull(paramDataHolder));
    zag(paramInt);
  }
  
  @KeepForSdk
  protected void copyToBuffer(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.mDataHolder.zaa(paramString, this.mDataRow, this.zaln, paramCharArrayBuffer);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DataBufferRef))
    {
      paramObject = (DataBufferRef)paramObject;
      if ((Objects.equal(Integer.valueOf(((DataBufferRef)paramObject).mDataRow), Integer.valueOf(this.mDataRow))) && (Objects.equal(Integer.valueOf(((DataBufferRef)paramObject).zaln), Integer.valueOf(this.zaln))) && (((DataBufferRef)paramObject).mDataHolder == this.mDataHolder)) {
        return true;
      }
    }
    return false;
  }
  
  @KeepForSdk
  protected boolean getBoolean(String paramString)
  {
    return this.mDataHolder.getBoolean(paramString, this.mDataRow, this.zaln);
  }
  
  @KeepForSdk
  protected byte[] getByteArray(String paramString)
  {
    return this.mDataHolder.getByteArray(paramString, this.mDataRow, this.zaln);
  }
  
  @KeepForSdk
  protected int getDataRow()
  {
    return this.mDataRow;
  }
  
  @KeepForSdk
  protected double getDouble(String paramString)
  {
    return this.mDataHolder.zab(paramString, this.mDataRow, this.zaln);
  }
  
  @KeepForSdk
  protected float getFloat(String paramString)
  {
    return this.mDataHolder.zaa(paramString, this.mDataRow, this.zaln);
  }
  
  @KeepForSdk
  protected int getInteger(String paramString)
  {
    return this.mDataHolder.getInteger(paramString, this.mDataRow, this.zaln);
  }
  
  @KeepForSdk
  protected long getLong(String paramString)
  {
    return this.mDataHolder.getLong(paramString, this.mDataRow, this.zaln);
  }
  
  @KeepForSdk
  protected String getString(String paramString)
  {
    return this.mDataHolder.getString(paramString, this.mDataRow, this.zaln);
  }
  
  @KeepForSdk
  public boolean hasColumn(String paramString)
  {
    return this.mDataHolder.hasColumn(paramString);
  }
  
  @KeepForSdk
  protected boolean hasNull(String paramString)
  {
    return this.mDataHolder.hasNull(paramString, this.mDataRow, this.zaln);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.mDataRow), Integer.valueOf(this.zaln), this.mDataHolder });
  }
  
  @KeepForSdk
  public boolean isDataValid()
  {
    return !this.mDataHolder.isClosed();
  }
  
  @KeepForSdk
  protected Uri parseUri(String paramString)
  {
    paramString = this.mDataHolder.getString(paramString, this.mDataRow, this.zaln);
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString);
  }
  
  protected final void zag(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.mDataHolder.getCount())) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    this.mDataRow = paramInt;
    this.zaln = this.mDataHolder.getWindowIndex(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\data\DataBufferRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */