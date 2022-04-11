package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  extends com.google.gson.stream.a
{
  private static final Reader M3 = new a();
  private static final Object N3 = new Object();
  private Object[] O3 = new Object[32];
  private int P3 = 0;
  private String[] Q3 = new String[32];
  private int[] R3 = new int[32];
  
  public a(i parami)
  {
    super(M3);
    W(parami);
  }
  
  private void S(JsonToken paramJsonToken)
    throws IOException
  {
    if (G() == paramJsonToken) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected ");
    localStringBuilder.append(paramJsonToken);
    localStringBuilder.append(" but was ");
    localStringBuilder.append(G());
    localStringBuilder.append(v());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private Object T()
  {
    return this.O3[(this.P3 - 1)];
  }
  
  private Object U()
  {
    Object[] arrayOfObject = this.O3;
    int i = this.P3 - 1;
    this.P3 = i;
    Object localObject = arrayOfObject[i];
    arrayOfObject[i] = null;
    return localObject;
  }
  
  private void W(Object paramObject)
  {
    int i = this.P3;
    Object[] arrayOfObject = this.O3;
    if (i == arrayOfObject.length)
    {
      i *= 2;
      this.O3 = Arrays.copyOf(arrayOfObject, i);
      this.R3 = Arrays.copyOf(this.R3, i);
      this.Q3 = ((String[])Arrays.copyOf(this.Q3, i));
    }
    arrayOfObject = this.O3;
    i = this.P3;
    this.P3 = (i + 1);
    arrayOfObject[i] = paramObject;
  }
  
  private String v()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" at path ");
    localStringBuilder.append(getPath());
    return localStringBuilder.toString();
  }
  
  public String A()
    throws IOException
  {
    S(JsonToken.NAME);
    Map.Entry localEntry = (Map.Entry)((Iterator)T()).next();
    String str = (String)localEntry.getKey();
    this.Q3[(this.P3 - 1)] = str;
    W(localEntry.getValue());
    return str;
  }
  
  public void C()
    throws IOException
  {
    S(JsonToken.NULL);
    U();
    int i = this.P3;
    if (i > 0)
    {
      int[] arrayOfInt = this.R3;
      i--;
      arrayOfInt[i] += 1;
    }
  }
  
  public String E()
    throws IOException
  {
    Object localObject1 = G();
    Object localObject2 = JsonToken.STRING;
    if ((localObject1 != localObject2) && (localObject1 != JsonToken.NUMBER))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localObject1);
      localStringBuilder.append(v());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    localObject1 = ((m)U()).e();
    int i = this.P3;
    if (i > 0)
    {
      localObject2 = this.R3;
      i--;
      localObject2[i] += 1;
    }
    return (String)localObject1;
  }
  
  public JsonToken G()
    throws IOException
  {
    if (this.P3 == 0) {
      return JsonToken.END_DOCUMENT;
    }
    Object localObject = T();
    if ((localObject instanceof Iterator))
    {
      boolean bool = this.O3[(this.P3 - 2)] instanceof k;
      localObject = (Iterator)localObject;
      if (((Iterator)localObject).hasNext())
      {
        if (bool) {
          return JsonToken.NAME;
        }
        W(((Iterator)localObject).next());
        return G();
      }
      if (bool) {
        localObject = JsonToken.END_OBJECT;
      } else {
        localObject = JsonToken.END_ARRAY;
      }
      return (JsonToken)localObject;
    }
    if ((localObject instanceof k)) {
      return JsonToken.BEGIN_OBJECT;
    }
    if ((localObject instanceof f)) {
      return JsonToken.BEGIN_ARRAY;
    }
    if ((localObject instanceof m))
    {
      localObject = (m)localObject;
      if (((m)localObject).q()) {
        return JsonToken.STRING;
      }
      if (((m)localObject).n()) {
        return JsonToken.BOOLEAN;
      }
      if (((m)localObject).p()) {
        return JsonToken.NUMBER;
      }
      throw new AssertionError();
    }
    if ((localObject instanceof j)) {
      return JsonToken.NULL;
    }
    if (localObject == N3) {
      throw new IllegalStateException("JsonReader is closed");
    }
    throw new AssertionError();
  }
  
  public void Q()
    throws IOException
  {
    if (G() == JsonToken.NAME)
    {
      A();
      this.Q3[(this.P3 - 2)] = "null";
    }
    else
    {
      U();
      i = this.P3;
      if (i > 0) {
        this.Q3[(i - 1)] = "null";
      }
    }
    int i = this.P3;
    if (i > 0)
    {
      int[] arrayOfInt = this.R3;
      i--;
      arrayOfInt[i] += 1;
    }
  }
  
  public void V()
    throws IOException
  {
    S(JsonToken.NAME);
    Map.Entry localEntry = (Map.Entry)((Iterator)T()).next();
    W(localEntry.getValue());
    W(new m((String)localEntry.getKey()));
  }
  
  public void a()
    throws IOException
  {
    S(JsonToken.BEGIN_ARRAY);
    W(((f)T()).iterator());
    this.R3[(this.P3 - 1)] = 0;
  }
  
  public void c()
    throws IOException
  {
    S(JsonToken.BEGIN_OBJECT);
    W(((k)T()).entrySet().iterator());
  }
  
  public void close()
    throws IOException
  {
    this.O3 = new Object[] { N3 };
    this.P3 = 1;
  }
  
  public String getPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    int j;
    for (int i = 0; i < this.P3; i = j + 1)
    {
      Object localObject = this.O3;
      if ((localObject[i] instanceof f))
      {
        i++;
        j = i;
        if ((localObject[i] instanceof Iterator))
        {
          localStringBuilder.append('[');
          localStringBuilder.append(this.R3[i]);
          localStringBuilder.append(']');
          j = i;
        }
      }
      else
      {
        j = i;
        if ((localObject[i] instanceof k))
        {
          i++;
          j = i;
          if ((localObject[i] instanceof Iterator))
          {
            localStringBuilder.append('.');
            localObject = this.Q3;
            j = i;
            if (localObject[i] != null)
            {
              localStringBuilder.append(localObject[i]);
              j = i;
            }
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void j()
    throws IOException
  {
    S(JsonToken.END_ARRAY);
    U();
    U();
    int i = this.P3;
    if (i > 0)
    {
      int[] arrayOfInt = this.R3;
      i--;
      arrayOfInt[i] += 1;
    }
  }
  
  public void k()
    throws IOException
  {
    S(JsonToken.END_OBJECT);
    U();
    U();
    int i = this.P3;
    if (i > 0)
    {
      int[] arrayOfInt = this.R3;
      i--;
      arrayOfInt[i] += 1;
    }
  }
  
  public boolean s()
    throws IOException
  {
    JsonToken localJsonToken = G();
    boolean bool;
    if ((localJsonToken != JsonToken.END_OBJECT) && (localJsonToken != JsonToken.END_ARRAY)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    return a.class.getSimpleName();
  }
  
  public boolean w()
    throws IOException
  {
    S(JsonToken.BOOLEAN);
    boolean bool = ((m)U()).j();
    int i = this.P3;
    if (i > 0)
    {
      int[] arrayOfInt = this.R3;
      i--;
      arrayOfInt[i] += 1;
    }
    return bool;
  }
  
  public double x()
    throws IOException
  {
    JsonToken localJsonToken = G();
    Object localObject = JsonToken.NUMBER;
    if ((localJsonToken != localObject) && (localJsonToken != JsonToken.STRING))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localJsonToken);
      localStringBuilder.append(v());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    double d = ((m)T()).k();
    if ((!t()) && ((Double.isNaN(d)) || (Double.isInfinite(d))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSON forbids NaN and infinities: ");
      ((StringBuilder)localObject).append(d);
      throw new NumberFormatException(((StringBuilder)localObject).toString());
    }
    U();
    int i = this.P3;
    if (i > 0)
    {
      localObject = this.R3;
      i--;
      localObject[i] += 1;
    }
    return d;
  }
  
  public int y()
    throws IOException
  {
    JsonToken localJsonToken1 = G();
    JsonToken localJsonToken2 = JsonToken.NUMBER;
    Object localObject;
    if ((localJsonToken1 != localJsonToken2) && (localJsonToken1 != JsonToken.STRING))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Expected ");
      ((StringBuilder)localObject).append(localJsonToken2);
      ((StringBuilder)localObject).append(" but was ");
      ((StringBuilder)localObject).append(localJsonToken1);
      ((StringBuilder)localObject).append(v());
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    int i = ((m)T()).a();
    U();
    int j = this.P3;
    if (j > 0)
    {
      localObject = this.R3;
      j--;
      localObject[j] += 1;
    }
    return i;
  }
  
  public long z()
    throws IOException
  {
    JsonToken localJsonToken = G();
    Object localObject = JsonToken.NUMBER;
    if ((localJsonToken != localObject) && (localJsonToken != JsonToken.STRING))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localJsonToken);
      localStringBuilder.append(v());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    long l = ((m)T()).l();
    U();
    int i = this.P3;
    if (i > 0)
    {
      localObject = this.R3;
      i--;
      localObject[i] += 1;
    }
    return l;
  }
  
  class a
    extends Reader
  {
    public void close()
      throws IOException
    {
      throw new AssertionError();
    }
    
    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      throw new AssertionError();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */