package com.tplink.libtpnetwork.cameranetwork.bean.listing;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.k;
import com.tplink.libtpnetwork.cameranetwork.util.c;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

public class ColumnFilter<T>
  implements Filter
{
  public static final String TYPE_BOOLEAN = "boolean";
  public static final String TYPE_DATE = "date";
  public static final String TYPE_DATETIME = "datetime";
  public static final String TYPE_DOUBLE = "double";
  public static final String TYPE_FLOAT = "float";
  public static final String TYPE_INTEGER = "integer";
  public static final String TYPE_LIST = "list";
  public static final String TYPE_LONG = "long";
  public static final String TYPE_OBJECT = "object";
  public static final String TYPE_STRING = "string";
  private String key;
  private Operation operation;
  private String type;
  private T value;
  
  public ColumnFilter() {}
  
  public ColumnFilter(String paramString, T paramT, Operation paramOperation)
  {
    this.key = paramString;
    this.value = paramT;
    this.operation = paramOperation;
    this.type = getType(paramT);
  }
  
  public ColumnFilter(String paramString1, T paramT, String paramString2, Operation paramOperation)
  {
    this.key = paramString1;
    this.value = paramT;
    this.operation = paramOperation;
    this.type = paramString2;
  }
  
  public static String getType(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof String)) {
      return "string";
    }
    if ((paramObject instanceof Integer)) {
      return "integer";
    }
    if ((paramObject instanceof Long)) {
      return "long";
    }
    if ((paramObject instanceof Float)) {
      return "float";
    }
    if ((paramObject instanceof Double)) {
      return "double";
    }
    if ((paramObject instanceof Date)) {
      return "datetime";
    }
    if ((paramObject instanceof Boolean)) {
      return "boolean";
    }
    return "string";
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public Operation getOperation()
  {
    return this.operation;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public T getValue()
  {
    return (T)this.value;
  }
  
  public void setKey(String paramString)
  {
    this.key = paramString;
  }
  
  public void setOperation(Operation paramOperation)
  {
    this.operation = paramOperation;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setValue(T paramT)
  {
    setValue(paramT, getType(paramT));
  }
  
  public void setValue(T paramT, String paramString)
  {
    this.value = paramT;
    this.type = paramString;
  }
  
  public static final class ColumnFilterDeserializer
    implements h<ColumnFilter>
  {
    public ColumnFilter deserialize(i parami, Type paramType, g paramg)
      throws JsonParseException
    {
      k localk = parami.c();
      String str = c.b(localk, "key");
      if (localk.o("type")) {
        parami = localk.n("type").e();
      } else {
        parami = "string";
      }
      boolean bool = localk.o("value");
      paramg = null;
      if (bool) {
        paramType = localk.n("value");
      } else {
        paramType = null;
      }
      ColumnFilter localColumnFilter = new ColumnFilter();
      if (paramType.f())
      {
        localColumnFilter.setValue(c.a(paramType.b()), parami);
      }
      else
      {
        paramType = paramg;
        if (localk.o("value")) {
          paramType = localk.n("value").e();
        }
        parami.hashCode();
        int i = -1;
        switch (parami.hashCode())
        {
        default: 
          break;
        case 1958052158: 
          if (parami.equals("integer")) {
            i = 8;
          }
          break;
        case 1793702779: 
          if (parami.equals("datetime")) {
            i = 7;
          }
          break;
        case 97526364: 
          if (parami.equals("float")) {
            i = 6;
          }
          break;
        case 64711720: 
          if (parami.equals("boolean")) {
            i = 5;
          }
          break;
        case 3327612: 
          if (parami.equals("long")) {
            i = 4;
          }
          break;
        case 3076014: 
          if (parami.equals("date")) {
            i = 3;
          }
          break;
        case -891985903: 
          if (parami.equals("string")) {
            i = 2;
          }
          break;
        case -1023368385: 
          if (parami.equals("object")) {
            i = 1;
          }
          break;
        case -1325958191: 
          if (parami.equals("double")) {
            i = 0;
          }
          break;
        }
        switch (i)
        {
        default: 
          break;
        case 8: 
          localColumnFilter.setValue(Integer.valueOf(Integer.parseInt(paramType)));
          break;
        case 6: 
          localColumnFilter.setValue(Float.valueOf(Float.parseFloat(paramType)));
          break;
        case 5: 
          localColumnFilter.setValue(Boolean.valueOf(Boolean.parseBoolean(paramType)));
          break;
        case 4: 
          localColumnFilter.setValue(Long.valueOf(Long.parseLong(paramType)));
          break;
        }
      }
      try
      {
        localColumnFilter.setValue(c.d(paramType));
      }
      catch (ParseException parami)
      {
        label542:
        for (;;) {}
      }
      localColumnFilter.setValue(paramType);
      break label542;
      localColumnFilter.setValue(paramType, parami);
      break label542;
      localColumnFilter.setValue(Double.valueOf(Double.parseDouble(paramType)));
      parami = localk.n("operation").e();
      localColumnFilter.setKey(str);
      localColumnFilter.setOperation(Operation.valueOf(parami));
      return localColumnFilter;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\listing\ColumnFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */