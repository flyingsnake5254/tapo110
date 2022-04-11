package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@KeepForSdk
@KeepName
@SafeParcelable.Class(creator="DataHolderCreator", validate=true)
public final class DataHolder
  extends AbstractSafeParcelable
  implements Closeable
{
  @KeepForSdk
  public static final Parcelable.Creator<DataHolder> CREATOR = new zac();
  private static final Builder zaly = new zab(new String[0], null);
  private boolean mClosed = false;
  @SafeParcelable.VersionField(id=1000)
  private final int zalf;
  @SafeParcelable.Field(getter="getColumns", id=1)
  private final String[] zalq;
  private Bundle zalr;
  @SafeParcelable.Field(getter="getWindows", id=2)
  private final CursorWindow[] zals;
  @SafeParcelable.Field(getter="getStatusCode", id=3)
  private final int zalt;
  @SafeParcelable.Field(getter="getMetadata", id=4)
  private final Bundle zalu;
  private int[] zalv;
  private int zalw;
  private boolean zalx = true;
  
  @SafeParcelable.Constructor
  DataHolder(@SafeParcelable.Param(id=1000) int paramInt1, @SafeParcelable.Param(id=1) String[] paramArrayOfString, @SafeParcelable.Param(id=2) CursorWindow[] paramArrayOfCursorWindow, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) Bundle paramBundle)
  {
    this.zalf = paramInt1;
    this.zalq = paramArrayOfString;
    this.zals = paramArrayOfCursorWindow;
    this.zalt = paramInt2;
    this.zalu = paramBundle;
  }
  
  @KeepForSdk
  public DataHolder(Cursor paramCursor, int paramInt, Bundle paramBundle)
  {
    this(new com.google.android.gms.common.sqlite.CursorWrapper(paramCursor), paramInt, paramBundle);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt, Bundle paramBundle)
  {
    this(Builder.zaa(paramBuilder), zaa(paramBuilder, -1), paramInt, null);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this(Builder.zaa(paramBuilder), zaa(paramBuilder, -1), paramInt1, paramBundle);
  }
  
  private DataHolder(com.google.android.gms.common.sqlite.CursorWrapper paramCursorWrapper, int paramInt, Bundle paramBundle)
  {
    this(paramCursorWrapper.getColumnNames(), zaa(paramCursorWrapper), paramInt, paramBundle);
  }
  
  @KeepForSdk
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    this.zalf = 1;
    this.zalq = ((String[])Preconditions.checkNotNull(paramArrayOfString));
    this.zals = ((CursorWindow[])Preconditions.checkNotNull(paramArrayOfCursorWindow));
    this.zalt = paramInt;
    this.zalu = paramBundle;
    zaca();
  }
  
  @KeepForSdk
  public static Builder builder(String[] paramArrayOfString)
  {
    return new Builder(paramArrayOfString, null, null);
  }
  
  @KeepForSdk
  public static DataHolder empty(int paramInt)
  {
    return new DataHolder(zaly, paramInt, null);
  }
  
  private final void zaa(String paramString, int paramInt)
  {
    Bundle localBundle = this.zalr;
    if ((localBundle != null) && (localBundle.containsKey(paramString)))
    {
      if (!isClosed())
      {
        if ((paramInt >= 0) && (paramInt < this.zalw)) {
          return;
        }
        throw new CursorIndexOutOfBoundsException(paramInt, this.zalw);
      }
      throw new IllegalArgumentException("Buffer is closed.");
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "No such column: ".concat(paramString);
    } else {
      paramString = new String("No such column: ");
    }
    throw new IllegalArgumentException(paramString);
  }
  
  private static CursorWindow[] zaa(Builder paramBuilder, int paramInt)
  {
    int i = Builder.zaa(paramBuilder).length;
    int j = 0;
    if (i == 0) {
      return new CursorWindow[0];
    }
    Object localObject1;
    if ((paramInt >= 0) && (paramInt < Builder.zab(paramBuilder).size())) {
      localObject1 = Builder.zab(paramBuilder).subList(0, paramInt);
    } else {
      localObject1 = Builder.zab(paramBuilder);
    }
    int k = ((List)localObject1).size();
    Object localObject2 = new CursorWindow(false);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject2);
    ((CursorWindow)localObject2).setNumColumns(Builder.zaa(paramBuilder).length);
    paramInt = 0;
    i = 0;
    while (paramInt < k) {
      try
      {
        boolean bool = ((CursorWindow)localObject2).allocRow();
        Object localObject3;
        if (!bool)
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>(72);
          ((StringBuilder)localObject2).append("Allocating additional cursor window for large data set (row ");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(")");
          Log.d("DataHolder", ((StringBuilder)localObject2).toString());
          localObject3 = new android/database/CursorWindow;
          ((CursorWindow)localObject3).<init>(false);
          ((CursorWindow)localObject3).setStartPosition(paramInt);
          ((CursorWindow)localObject3).setNumColumns(Builder.zaa(paramBuilder).length);
          localArrayList.add(localObject3);
          localObject2 = localObject3;
          if (!((CursorWindow)localObject3).allocRow())
          {
            Log.e("DataHolder", "Unable to allocate row to hold data.");
            localArrayList.remove(localObject3);
            return (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
          }
        }
        Map localMap = (Map)((List)localObject1).get(paramInt);
        int m = 0;
        bool = true;
        while ((m < Builder.zaa(paramBuilder).length) && (bool))
        {
          localObject3 = Builder.zaa(paramBuilder)[m];
          Object localObject4 = localMap.get(localObject3);
          if (localObject4 == null)
          {
            bool = ((CursorWindow)localObject2).putNull(paramInt, m);
          }
          else if ((localObject4 instanceof String))
          {
            bool = ((CursorWindow)localObject2).putString((String)localObject4, paramInt, m);
          }
          else if ((localObject4 instanceof Long))
          {
            bool = ((CursorWindow)localObject2).putLong(((Long)localObject4).longValue(), paramInt, m);
          }
          else if ((localObject4 instanceof Integer))
          {
            bool = ((CursorWindow)localObject2).putLong(((Integer)localObject4).intValue(), paramInt, m);
          }
          else if ((localObject4 instanceof Boolean))
          {
            long l;
            if (((Boolean)localObject4).booleanValue()) {
              l = 1L;
            } else {
              l = 0L;
            }
            bool = ((CursorWindow)localObject2).putLong(l, paramInt, m);
          }
          else if ((localObject4 instanceof byte[]))
          {
            bool = ((CursorWindow)localObject2).putBlob((byte[])localObject4, paramInt, m);
          }
          else if ((localObject4 instanceof Double))
          {
            bool = ((CursorWindow)localObject2).putDouble(((Double)localObject4).doubleValue(), paramInt, m);
          }
          else
          {
            if (!(localObject4 instanceof Float)) {
              break label539;
            }
            bool = ((CursorWindow)localObject2).putDouble(((Float)localObject4).floatValue(), paramInt, m);
          }
          m++;
          continue;
          label539:
          paramBuilder = new java/lang/IllegalArgumentException;
          localObject1 = String.valueOf(localObject4);
          i = String.valueOf(localObject3).length();
          paramInt = ((String)localObject1).length();
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>(i + 32 + paramInt);
          ((StringBuilder)localObject2).append("Unsupported object for column ");
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append(": ");
          ((StringBuilder)localObject2).append((String)localObject1);
          paramBuilder.<init>(((StringBuilder)localObject2).toString());
          throw paramBuilder;
        }
        if (!bool)
        {
          if (i == 0)
          {
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>(74);
            ((StringBuilder)localObject3).append("Couldn't populate window data for row ");
            ((StringBuilder)localObject3).append(paramInt);
            ((StringBuilder)localObject3).append(" - allocating new window.");
            Log.d("DataHolder", ((StringBuilder)localObject3).toString());
            ((CursorWindow)localObject2).freeLastRow();
            localObject2 = new android/database/CursorWindow;
            ((CursorWindow)localObject2).<init>(false);
            ((CursorWindow)localObject2).setStartPosition(paramInt);
            ((CursorWindow)localObject2).setNumColumns(Builder.zaa(paramBuilder).length);
            localArrayList.add(localObject2);
            paramInt--;
            i = 1;
          }
          else
          {
            paramBuilder = new com/google/android/gms/common/data/DataHolder$zaa;
            paramBuilder.<init>("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
            throw paramBuilder;
          }
        }
        else {
          i = 0;
        }
        paramInt++;
      }
      catch (RuntimeException paramBuilder)
      {
        i = localArrayList.size();
        for (paramInt = j; paramInt < i; paramInt++) {
          ((CursorWindow)localArrayList.get(paramInt)).close();
        }
        throw paramBuilder;
      }
    }
    return (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
  }
  
  private static CursorWindow[] zaa(com.google.android.gms.common.sqlite.CursorWrapper paramCursorWrapper)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      int i = paramCursorWrapper.getCount();
      CursorWindow localCursorWindow = paramCursorWrapper.getWindow();
      if ((localCursorWindow != null) && (localCursorWindow.getStartPosition() == 0))
      {
        localCursorWindow.acquireReference();
        paramCursorWrapper.setWindow(null);
        localArrayList.add(localCursorWindow);
        j = localCursorWindow.getNumRows();
      }
      int k;
      for (int j = 0; (j < i) && (paramCursorWrapper.moveToPosition(j)); j = k + j)
      {
        localCursorWindow = paramCursorWrapper.getWindow();
        if (localCursorWindow != null)
        {
          localCursorWindow.acquireReference();
          paramCursorWrapper.setWindow(null);
        }
        else
        {
          localCursorWindow = new android/database/CursorWindow;
          localCursorWindow.<init>(false);
          localCursorWindow.setStartPosition(j);
          paramCursorWrapper.fillWindow(j, localCursorWindow);
        }
        if (localCursorWindow.getNumRows() == 0) {
          break;
        }
        localArrayList.add(localCursorWindow);
        k = localCursorWindow.getStartPosition();
        j = localCursorWindow.getNumRows();
      }
      return (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
    }
    finally
    {
      paramCursorWrapper.close();
    }
  }
  
  @KeepForSdk
  public final void close()
  {
    try
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        for (int i = 0;; i++)
        {
          CursorWindow[] arrayOfCursorWindow = this.zals;
          if (i >= arrayOfCursorWindow.length) {
            break;
          }
          arrayOfCursorWindow[i].close();
        }
      }
      return;
    }
    finally {}
  }
  
  protected final void finalize()
    throws Throwable
  {
    try
    {
      if ((this.zalx) && (this.zals.length > 0) && (!isClosed()))
      {
        close();
        String str = toString();
        int i = String.valueOf(str).length();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(i + 178);
        localStringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
        localStringBuilder.append(str);
        localStringBuilder.append(")");
        Log.e("DataBuffer", localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  @KeepForSdk
  public final boolean getBoolean(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return Long.valueOf(this.zals[paramInt2].getLong(paramInt1, this.zalr.getInt(paramString))).longValue() == 1L;
  }
  
  @KeepForSdk
  public final byte[] getByteArray(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getBlob(paramInt1, this.zalr.getInt(paramString));
  }
  
  @KeepForSdk
  public final int getCount()
  {
    return this.zalw;
  }
  
  @KeepForSdk
  public final int getInteger(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getInt(paramInt1, this.zalr.getInt(paramString));
  }
  
  @KeepForSdk
  public final long getLong(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getLong(paramInt1, this.zalr.getInt(paramString));
  }
  
  @KeepForSdk
  public final Bundle getMetadata()
  {
    return this.zalu;
  }
  
  @KeepForSdk
  public final int getStatusCode()
  {
    return this.zalt;
  }
  
  @KeepForSdk
  public final String getString(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getString(paramInt1, this.zalr.getInt(paramString));
  }
  
  @KeepForSdk
  public final int getWindowIndex(int paramInt)
  {
    int i = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.zalw)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    int[] arrayOfInt;
    int j;
    for (;;)
    {
      arrayOfInt = this.zalv;
      j = i;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (paramInt < arrayOfInt[i])
      {
        j = i - 1;
        break;
      }
      i++;
    }
    paramInt = j;
    if (j == arrayOfInt.length) {
      paramInt = j - 1;
    }
    return paramInt;
  }
  
  @KeepForSdk
  public final boolean hasColumn(String paramString)
  {
    return this.zalr.containsKey(paramString);
  }
  
  @KeepForSdk
  public final boolean hasNull(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].isNull(paramInt1, this.zalr.getInt(paramString));
  }
  
  @KeepForSdk
  public final boolean isClosed()
  {
    try
    {
      boolean bool = this.mClosed;
      return bool;
    }
    finally {}
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringArray(paramParcel, 1, this.zalq, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.zals, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getStatusCode());
    SafeParcelWriter.writeBundle(paramParcel, 4, getMetadata(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zalf);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    if ((paramInt & 0x1) != 0) {
      close();
    }
  }
  
  public final float zaa(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getFloat(paramInt1, this.zalr.getInt(paramString));
  }
  
  public final void zaa(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    zaa(paramString, paramInt1);
    this.zals[paramInt2].copyStringToBuffer(paramInt1, this.zalr.getInt(paramString), paramCharArrayBuffer);
  }
  
  public final double zab(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getDouble(paramInt1, this.zalr.getInt(paramString));
  }
  
  public final void zaca()
  {
    this.zalr = new Bundle();
    int i = 0;
    Object localObject;
    for (int j = 0;; j++)
    {
      localObject = this.zalq;
      if (j >= localObject.length) {
        break;
      }
      this.zalr.putInt(localObject[j], j);
    }
    this.zalv = new int[this.zals.length];
    int k = 0;
    for (j = i;; j++)
    {
      localObject = this.zals;
      if (j >= localObject.length) {
        break;
      }
      this.zalv[j] = k;
      i = localObject[j].getStartPosition();
      k += this.zals[j].getNumRows() - (k - i);
    }
    this.zalw = k;
  }
  
  @KeepForSdk
  public static class Builder
  {
    private final String[] zalq;
    private final ArrayList<HashMap<String, Object>> zalz;
    private final String zama;
    private final HashMap<Object, Integer> zamb;
    private boolean zamc;
    private String zamd;
    
    private Builder(String[] paramArrayOfString, String paramString)
    {
      this.zalq = ((String[])Preconditions.checkNotNull(paramArrayOfString));
      this.zalz = new ArrayList();
      this.zama = paramString;
      this.zamb = new HashMap();
      this.zamc = false;
      this.zamd = null;
    }
    
    @KeepForSdk
    public DataHolder build(int paramInt)
    {
      return new DataHolder(this, paramInt, null, null);
    }
    
    @KeepForSdk
    public DataHolder build(int paramInt, Bundle paramBundle)
    {
      return new DataHolder(this, paramInt, paramBundle, -1, null);
    }
    
    @KeepForSdk
    public Builder withRow(ContentValues paramContentValues)
    {
      Asserts.checkNotNull(paramContentValues);
      HashMap localHashMap = new HashMap(paramContentValues.size());
      Iterator localIterator = paramContentValues.valueSet().iterator();
      while (localIterator.hasNext())
      {
        paramContentValues = (Map.Entry)localIterator.next();
        localHashMap.put((String)paramContentValues.getKey(), paramContentValues.getValue());
      }
      return zaa(localHashMap);
    }
    
    public Builder zaa(HashMap<String, Object> paramHashMap)
    {
      Asserts.checkNotNull(paramHashMap);
      Object localObject = this.zama;
      if (localObject == null) {}
      Integer localInteger;
      for (;;)
      {
        i = -1;
        break label77;
        localObject = paramHashMap.get(localObject);
        if (localObject != null)
        {
          localInteger = (Integer)this.zamb.get(localObject);
          if (localInteger != null) {
            break;
          }
          this.zamb.put(localObject, Integer.valueOf(this.zalz.size()));
        }
      }
      int i = localInteger.intValue();
      label77:
      if (i == -1)
      {
        this.zalz.add(paramHashMap);
      }
      else
      {
        this.zalz.remove(i);
        this.zalz.add(i, paramHashMap);
      }
      this.zamc = false;
      return this;
    }
  }
  
  public static final class zaa
    extends RuntimeException
  {
    public zaa(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\data\DataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */