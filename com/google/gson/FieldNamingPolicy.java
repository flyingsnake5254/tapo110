package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

public enum FieldNamingPolicy
  implements c
{
  static
  {
    a locala = new a("IDENTITY", 0);
    IDENTITY = locala;
    b localb = new b("UPPER_CAMEL_CASE", 1);
    UPPER_CAMEL_CASE = localb;
    c localc = new c("UPPER_CAMEL_CASE_WITH_SPACES", 2);
    UPPER_CAMEL_CASE_WITH_SPACES = localc;
    d locald = new d("LOWER_CASE_WITH_UNDERSCORES", 3);
    LOWER_CASE_WITH_UNDERSCORES = locald;
    e locale = new e("LOWER_CASE_WITH_DASHES", 4);
    LOWER_CASE_WITH_DASHES = locale;
    f localf = new f("LOWER_CASE_WITH_DOTS", 5);
    LOWER_CASE_WITH_DOTS = localf;
    $VALUES = new FieldNamingPolicy[] { locala, localb, localc, locald, locale, localf };
  }
  
  static String separateCamelCase(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramString1.length();
    for (int j = 0; j < i; j++)
    {
      char c = paramString1.charAt(j);
      if ((Character.isUpperCase(c)) && (localStringBuilder.length() != 0)) {
        localStringBuilder.append(paramString2);
      }
      localStringBuilder.append(c);
    }
    return localStringBuilder.toString();
  }
  
  static String upperCaseFirstLetter(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; (!Character.isLetter(paramString.charAt(j))) && (j < i - 1); j++) {}
    char c = paramString.charAt(j);
    if (Character.isUpperCase(c)) {
      return paramString;
    }
    c = Character.toUpperCase(c);
    if (j == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(c);
      localStringBuilder.append(paramString.substring(1));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, j));
    localStringBuilder.append(c);
    localStringBuilder.append(paramString.substring(j + 1));
    return localStringBuilder.toString();
  }
  
  enum a
  {
    a()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return paramField.getName();
    }
  }
  
  enum b
  {
    b()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return FieldNamingPolicy.upperCaseFirstLetter(paramField.getName());
    }
  }
  
  enum c
  {
    c()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(paramField.getName(), " "));
    }
  }
  
  enum d
  {
    d()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return FieldNamingPolicy.separateCamelCase(paramField.getName(), "_").toLowerCase(Locale.ENGLISH);
    }
  }
  
  enum e
  {
    e()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return FieldNamingPolicy.separateCamelCase(paramField.getName(), "-").toLowerCase(Locale.ENGLISH);
    }
  }
  
  enum f
  {
    f()
    {
      super(paramInt, null);
    }
    
    public String translateName(Field paramField)
    {
      return FieldNamingPolicy.separateCamelCase(paramField.getName(), ".").toLowerCase(Locale.ENGLISH);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\FieldNamingPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */