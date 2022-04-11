package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.m;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends com.google.gson.stream.b
{
  private static final Writer H3 = new a();
  private static final m I3 = new m("closed");
  private final List<i> J3 = new ArrayList();
  private String K3;
  private i L3 = j.a;
  
  public b()
  {
    super(H3);
  }
  
  private i N()
  {
    List localList = this.J3;
    return (i)localList.get(localList.size() - 1);
  }
  
  private void O(i parami)
  {
    if (this.K3 != null)
    {
      if ((!parami.g()) || (l())) {
        ((k)N()).j(this.K3, parami);
      }
      this.K3 = null;
    }
    else if (this.J3.isEmpty())
    {
      this.L3 = parami;
    }
    else
    {
      i locali = N();
      if (!(locali instanceof f)) {
        break label85;
      }
      ((f)locali).j(parami);
    }
    return;
    label85:
    throw new IllegalStateException();
  }
  
  public com.google.gson.stream.b G(long paramLong)
    throws IOException
  {
    O(new m(Long.valueOf(paramLong)));
    return this;
  }
  
  public com.google.gson.stream.b H(Boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean == null) {
      return w();
    }
    O(new m(paramBoolean));
    return this;
  }
  
  public com.google.gson.stream.b I(Number paramNumber)
    throws IOException
  {
    if (paramNumber == null) {
      return w();
    }
    if (!t())
    {
      double d = paramNumber.doubleValue();
      if ((Double.isNaN(d)) || (Double.isInfinite(d)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("JSON forbids NaN and infinities: ");
        localStringBuilder.append(paramNumber);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    O(new m(paramNumber));
    return this;
  }
  
  public com.google.gson.stream.b J(String paramString)
    throws IOException
  {
    if (paramString == null) {
      return w();
    }
    O(new m(paramString));
    return this;
  }
  
  public com.google.gson.stream.b K(boolean paramBoolean)
    throws IOException
  {
    O(new m(Boolean.valueOf(paramBoolean)));
    return this;
  }
  
  public i M()
  {
    if (this.J3.isEmpty()) {
      return this.L3;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected one JSON element but was ");
    localStringBuilder.append(this.J3);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void close()
    throws IOException
  {
    if (this.J3.isEmpty())
    {
      this.J3.add(I3);
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public com.google.gson.stream.b e()
    throws IOException
  {
    f localf = new f();
    O(localf);
    this.J3.add(localf);
    return this;
  }
  
  public void flush()
    throws IOException
  {}
  
  public com.google.gson.stream.b g()
    throws IOException
  {
    k localk = new k();
    O(localk);
    this.J3.add(localk);
    return this;
  }
  
  public com.google.gson.stream.b j()
    throws IOException
  {
    if ((!this.J3.isEmpty()) && (this.K3 == null))
    {
      if ((N() instanceof f))
      {
        List localList = this.J3;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public com.google.gson.stream.b k()
    throws IOException
  {
    if ((!this.J3.isEmpty()) && (this.K3 == null))
    {
      if ((N() instanceof k))
      {
        List localList = this.J3;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public com.google.gson.stream.b u(String paramString)
    throws IOException
  {
    if ((!this.J3.isEmpty()) && (this.K3 == null))
    {
      if ((N() instanceof k))
      {
        this.K3 = paramString;
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public com.google.gson.stream.b w()
    throws IOException
  {
    O(j.a);
    return this;
  }
  
  class a
    extends Writer
  {
    public void close()
      throws IOException
    {
      throw new AssertionError();
    }
    
    public void flush()
      throws IOException
    {
      throw new AssertionError();
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      throw new AssertionError();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */