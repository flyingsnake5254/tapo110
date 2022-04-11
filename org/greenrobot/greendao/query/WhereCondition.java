package org.greenrobot.greendao.query;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;

public abstract interface WhereCondition
{
  public abstract void appendTo(StringBuilder paramStringBuilder, String paramString);
  
  public abstract void appendValuesTo(List<Object> paramList);
  
  public static abstract class AbstractCondition
    implements WhereCondition
  {
    protected final boolean hasSingleValue;
    protected final Object value;
    protected final Object[] values;
    
    public AbstractCondition()
    {
      this.hasSingleValue = false;
      this.value = null;
      this.values = null;
    }
    
    public AbstractCondition(Object paramObject)
    {
      this.value = paramObject;
      this.hasSingleValue = true;
      this.values = null;
    }
    
    public AbstractCondition(Object[] paramArrayOfObject)
    {
      this.value = null;
      this.hasSingleValue = false;
      this.values = paramArrayOfObject;
    }
    
    public void appendValuesTo(List<Object> paramList)
    {
      if (this.hasSingleValue)
      {
        paramList.add(this.value);
      }
      else
      {
        Object[] arrayOfObject = this.values;
        if (arrayOfObject != null)
        {
          int i = arrayOfObject.length;
          for (int j = 0; j < i; j++) {
            paramList.add(arrayOfObject[j]);
          }
        }
      }
    }
  }
  
  public static class PropertyCondition
    extends WhereCondition.AbstractCondition
  {
    public final String op;
    public final Property property;
    
    public PropertyCondition(Property paramProperty, String paramString)
    {
      this.property = paramProperty;
      this.op = paramString;
    }
    
    public PropertyCondition(Property paramProperty, String paramString, Object paramObject)
    {
      super();
      this.property = paramProperty;
      this.op = paramString;
    }
    
    public PropertyCondition(Property paramProperty, String paramString, Object[] paramArrayOfObject)
    {
      super();
      this.property = paramProperty;
      this.op = paramString;
    }
    
    private static Object checkValueForType(Property paramProperty, Object paramObject)
    {
      if ((paramObject != null) && (paramObject.getClass().isArray())) {
        throw new DaoException("Illegal value: found array, but simple object required");
      }
      paramProperty = paramProperty.type;
      if (paramProperty == Date.class)
      {
        if ((paramObject instanceof Date)) {
          return Long.valueOf(((Date)paramObject).getTime());
        }
        if ((paramObject instanceof Long)) {
          return paramObject;
        }
        paramProperty = new StringBuilder();
        paramProperty.append("Illegal date value: expected java.util.Date or Long for value ");
        paramProperty.append(paramObject);
        throw new DaoException(paramProperty.toString());
      }
      if ((paramProperty == Boolean.TYPE) || (paramProperty == Boolean.class))
      {
        if ((paramObject instanceof Boolean)) {
          return Integer.valueOf(((Boolean)paramObject).booleanValue());
        }
        if ((paramObject instanceof Number))
        {
          int i = ((Number)paramObject).intValue();
          if ((i != 0) && (i != 1))
          {
            paramProperty = new StringBuilder();
            paramProperty.append("Illegal boolean value: numbers must be 0 or 1, but was ");
            paramProperty.append(paramObject);
            throw new DaoException(paramProperty.toString());
          }
        }
        else if ((paramObject instanceof String))
        {
          paramProperty = (String)paramObject;
          if ("TRUE".equalsIgnoreCase(paramProperty)) {
            return Integer.valueOf(1);
          }
          if ("FALSE".equalsIgnoreCase(paramProperty)) {
            return Integer.valueOf(0);
          }
          paramProperty = new StringBuilder();
          paramProperty.append("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was ");
          paramProperty.append(paramObject);
          throw new DaoException(paramProperty.toString());
        }
      }
      return paramObject;
    }
    
    private static Object[] checkValuesForType(Property paramProperty, Object[] paramArrayOfObject)
    {
      for (int i = 0; i < paramArrayOfObject.length; i++) {
        paramArrayOfObject[i] = checkValueForType(paramProperty, paramArrayOfObject[i]);
      }
      return paramArrayOfObject;
    }
    
    public void appendTo(StringBuilder paramStringBuilder, String paramString)
    {
      SqlUtils.appendProperty(paramStringBuilder, paramString, this.property).append(this.op);
    }
  }
  
  public static class StringCondition
    extends WhereCondition.AbstractCondition
  {
    protected final String string;
    
    public StringCondition(String paramString)
    {
      this.string = paramString;
    }
    
    public StringCondition(String paramString, Object paramObject)
    {
      super();
      this.string = paramString;
    }
    
    public StringCondition(String paramString, Object... paramVarArgs)
    {
      super();
      this.string = paramString;
    }
    
    public void appendTo(StringBuilder paramStringBuilder, String paramString)
    {
      paramStringBuilder.append(this.string);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\WhereCondition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */