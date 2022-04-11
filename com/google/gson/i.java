package com.google.gson;

import com.google.gson.stream.b;
import java.io.IOException;
import java.io.StringWriter;

public abstract class i
{
  public int a()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public f b()
  {
    if (f()) {
      return (f)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Array: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public k c()
  {
    if (h()) {
      return (k)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Object: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public m d()
  {
    if (i()) {
      return (m)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Primitive: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public String e()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean f()
  {
    return this instanceof f;
  }
  
  public boolean g()
  {
    return this instanceof j;
  }
  
  public boolean h()
  {
    return this instanceof k;
  }
  
  public boolean i()
  {
    return this instanceof m;
  }
  
  public String toString()
  {
    try
    {
      StringWriter localStringWriter = new java/io/StringWriter;
      localStringWriter.<init>();
      Object localObject = new com/google/gson/stream/b;
      ((b)localObject).<init>(localStringWriter);
      ((b)localObject).D(true);
      com.google.gson.internal.i.b(this, (b)localObject);
      localObject = localStringWriter.toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */