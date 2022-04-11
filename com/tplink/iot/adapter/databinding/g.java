package com.tplink.iot.adapter.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.Observable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;

public final class g
{
  public static final <T extends Parcelable> T a(T paramT)
  {
    j.e(paramT, "obj");
    Parcel localParcel = Parcel.obtain();
    j.d(localParcel, "Parcel.obtain()");
    localParcel.writeParcelable(paramT, 0);
    localParcel.setDataPosition(0);
    paramT = localParcel.readParcelable(paramT.getClass().getClassLoader());
    localParcel.recycle();
    return paramT;
  }
  
  public static final <T extends Serializable> T b(T paramT)
  {
    j.e(paramT, "obj");
    try
    {
      Object localObject = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject).<init>();
      ObjectOutputStream localObjectOutputStream = new java/io/ObjectOutputStream;
      localObjectOutputStream.<init>((OutputStream)localObject);
      localObjectOutputStream.writeObject(paramT);
      localObjectOutputStream.close();
      paramT = new java/io/ByteArrayInputStream;
      paramT.<init>(((ByteArrayOutputStream)localObject).toByteArray());
      localObject = new java/io/ObjectInputStream;
      ((ObjectInputStream)localObject).<init>(paramT);
      paramT = ((ObjectInputStream)localObject).readObject();
      if (paramT != null)
      {
        paramT = (Serializable)paramT;
        try
        {
          ((ObjectInputStream)localObject).close();
        }
        catch (Exception localException1)
        {
          break label93;
        }
      }
      else
      {
        paramT = new java/lang/NullPointerException;
        paramT.<init>("null cannot be cast to non-null type T");
        throw paramT;
      }
    }
    catch (Exception localException2)
    {
      paramT = null;
      label93:
      localException2.printStackTrace();
    }
    return paramT;
  }
  
  public static final Object c(Object paramObject, int paramInt)
  {
    if (paramObject == null) {}
    int j;
    do
    {
      do
      {
        do
        {
          return null;
          if (!(paramObject instanceof Object[])) {
            break;
          }
          paramObject = (Object[])paramObject;
          if (paramObject.length == 0) {
            i = 1;
          } else {
            i = 0;
          }
        } while (i != 0);
        i = paramInt;
        if (paramInt >= paramObject.length) {
          i = paramObject.length - 1;
        }
        return paramObject[i];
        if (!(paramObject instanceof List)) {
          break;
        }
        paramObject = (List)paramObject;
      } while (((List)paramObject).isEmpty());
      i = paramInt;
      if (paramInt >= ((List)paramObject).size()) {
        i = ((List)paramObject).size() - 1;
      }
      localObject = ((List)paramObject).get(i);
      break;
      localObject = paramObject;
      if (!paramObject.getClass().isArray()) {
        break;
      }
      j = Array.getLength(paramObject);
    } while (j == 0);
    int i = paramInt;
    if (paramInt >= j) {
      i = j - 1;
    }
    Object localObject = Array.get(paramObject, i);
    return localObject;
  }
  
  public static final int d(Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = 0;
    } else if ((paramObject instanceof Object[])) {
      i = ((Object[])paramObject).length;
    } else if ((paramObject instanceof List)) {
      i = ((List)paramObject).size();
    } else if (paramObject.getClass().isArray()) {
      i = Array.getLength(paramObject);
    } else {
      i = 1;
    }
    return i;
  }
  
  public static final Object e(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof Observable))
    {
      localObject = paramObject;
    }
    else if ((paramObject instanceof c))
    {
      localObject = ((c)paramObject).a();
    }
    else if ((paramObject instanceof Serializable))
    {
      localObject = b((Serializable)paramObject);
    }
    else
    {
      localObject = paramObject;
      if ((paramObject instanceof Parcelable)) {
        localObject = a((Parcelable)paramObject);
      }
    }
    return localObject;
  }
  
  public static final void f(Object paramObject, ArrayList<Object> paramArrayList)
  {
    j.e(paramArrayList, "des");
    if (paramObject == null)
    {
      paramArrayList.add(null);
    }
    else
    {
      boolean bool = paramObject instanceof List;
      int i = 0;
      if ((!bool) && (!(paramObject instanceof Object[])) && (!paramObject.getClass().isArray()))
      {
        if (paramArrayList.size() == 0) {
          paramArrayList.add(e(paramObject));
        } else if ((j.a(paramArrayList.get(0), paramObject) ^ true)) {
          paramArrayList.set(0, e(paramObject));
        }
      }
      else
      {
        int j = d(paramObject);
        while (i < j)
        {
          Object localObject1 = c(paramObject, i);
          Object localObject2;
          if ((!(localObject1 instanceof List)) && (!(localObject1 instanceof Object[]))) {
            if (localObject1 != null)
            {
              localObject2 = localObject1.getClass();
              if ((localObject2 != null) && (((Class)localObject2).isArray() == true)) {}
            }
            else
            {
              if (paramArrayList.size() <= i)
              {
                paramArrayList.add(e(localObject1));
                break label284;
              }
              if (!(j.a(localObject1, paramArrayList.get(i)) ^ true)) {
                break label284;
              }
              paramArrayList.set(i, e(localObject1));
              break label284;
            }
          }
          if (paramArrayList.size() <= i)
          {
            localObject2 = new ArrayList();
            paramArrayList.add(localObject2);
            f(localObject1, (ArrayList)localObject2);
          }
          else if ((j.a(localObject1, paramArrayList.get(i)) ^ true))
          {
            localObject2 = paramArrayList.get(i);
            Objects.requireNonNull(localObject2, "null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Any?> /* = java.util.ArrayList<kotlin.Any?> */");
            f(localObject1, (ArrayList)localObject2);
          }
          label284:
          i++;
        }
        i = paramArrayList.size() - 1;
        if (i >= j) {
          for (;;)
          {
            paramArrayList.remove(i);
            if (i == j) {
              break;
            }
            i--;
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\databinding\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */