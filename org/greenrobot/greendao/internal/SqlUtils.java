package org.greenrobot.greendao.internal;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;

public class SqlUtils
{
  private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
  
  public static StringBuilder appendColumn(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public static StringBuilder appendColumn(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(".\"");
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public static StringBuilder appendColumns(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      appendColumn(paramStringBuilder, paramString, paramArrayOfString[j]);
      if (j < i - 1) {
        paramStringBuilder.append(',');
      }
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder appendColumns(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      paramStringBuilder.append('"');
      paramStringBuilder.append(paramArrayOfString[j]);
      paramStringBuilder.append('"');
      if (j < i - 1) {
        paramStringBuilder.append(',');
      }
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder appendColumnsEqValue(StringBuilder paramStringBuilder, String paramString, String[] paramArrayOfString)
  {
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      appendColumn(paramStringBuilder, paramString, paramArrayOfString[i]).append("=?");
      if (i < paramArrayOfString.length - 1) {
        paramStringBuilder.append(',');
      }
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      appendColumn(paramStringBuilder, paramArrayOfString[i]).append("=?");
      if (i < paramArrayOfString.length - 1) {
        paramStringBuilder.append(',');
      }
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder appendPlaceholders(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < paramInt; i++) {
      if (i < paramInt - 1) {
        paramStringBuilder.append("?,");
      } else {
        paramStringBuilder.append('?');
      }
    }
    return paramStringBuilder;
  }
  
  public static StringBuilder appendProperty(StringBuilder paramStringBuilder, String paramString, Property paramProperty)
  {
    if (paramString != null)
    {
      paramStringBuilder.append(paramString);
      paramStringBuilder.append('.');
    }
    paramStringBuilder.append('"');
    paramStringBuilder.append(paramProperty.columnName);
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public static String createSqlCount(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SELECT COUNT(*) FROM \"");
    localStringBuilder.append(paramString);
    localStringBuilder.append('"');
    return localStringBuilder.toString();
  }
  
  public static String createSqlDelete(String paramString, String[] paramArrayOfString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('"');
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append('"');
    localObject = ((StringBuilder)localObject).toString();
    paramString = new StringBuilder("DELETE FROM ");
    paramString.append((String)localObject);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      paramString.append(" WHERE ");
      appendColumnsEqValue(paramString, (String)localObject, paramArrayOfString);
    }
    return paramString.toString();
  }
  
  public static String createSqlInsert(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    paramString1 = new StringBuilder(paramString1);
    paramString1.append('"');
    paramString1.append(paramString2);
    paramString1.append('"');
    paramString1.append(" (");
    appendColumns(paramString1, paramArrayOfString);
    paramString1.append(") VALUES (");
    appendPlaceholders(paramString1, paramArrayOfString.length);
    paramString1.append(')');
    return paramString1.toString();
  }
  
  public static String createSqlSelect(String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramString2 != null) && (paramString2.length() >= 0))
    {
      if (paramBoolean) {
        localObject = "SELECT DISTINCT ";
      } else {
        localObject = "SELECT ";
      }
      Object localObject = new StringBuilder((String)localObject);
      appendColumns((StringBuilder)localObject, paramString2, paramArrayOfString).append(" FROM ");
      ((StringBuilder)localObject).append('"');
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append('"');
      ((StringBuilder)localObject).append(' ');
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(' ');
      return ((StringBuilder)localObject).toString();
    }
    throw new DaoException("Table alias required");
  }
  
  public static String createSqlSelectCountStar(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
    localStringBuilder.append('"');
    localStringBuilder.append(paramString1);
    localStringBuilder.append('"');
    localStringBuilder.append(' ');
    if (paramString2 != null)
    {
      localStringBuilder.append(paramString2);
      localStringBuilder.append(' ');
    }
    return localStringBuilder.toString();
  }
  
  public static String createSqlUpdate(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('"');
    localStringBuilder.append(paramString);
    localStringBuilder.append('"');
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder("UPDATE ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" SET ");
    appendColumnsEqualPlaceholders(localStringBuilder, paramArrayOfString1);
    localStringBuilder.append(" WHERE ");
    appendColumnsEqValue(localStringBuilder, paramString, paramArrayOfString2);
    return localStringBuilder.toString();
  }
  
  public static String escapeBlobArgument(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("X'");
    localStringBuilder.append(toHex(paramArrayOfByte));
    localStringBuilder.append('\'');
    return localStringBuilder.toString();
  }
  
  public static String toHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar2 = HEX_ARRAY;
      arrayOfChar1[k] = ((char)arrayOfChar2[(j >>> 4)]);
      arrayOfChar1[(k + 1)] = ((char)arrayOfChar2[(j & 0xF)]);
    }
    return new String(arrayOfChar1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\internal\SqlUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */