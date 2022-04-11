package com.tplink.libtpnetwork.Utils;

import b.d.w.c.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class e
{
  public static <T extends Serializable> T a(T paramT)
  {
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
      paramT = (Serializable)((ObjectInputStream)localObject).readObject();
      try
      {
        ((ObjectInputStream)localObject).close();
      }
      catch (Exception localException1) {}
      a.d(localException2.toString());
    }
    catch (Exception localException2)
    {
      paramT = null;
    }
    return paramT;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\Utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */