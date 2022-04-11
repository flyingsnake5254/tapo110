package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.apache.commons.lang.f;

public class ColorHSBAttributeValue
{
  private static final int HEX_CHAR_COUNT = 16;
  private static final int MULTIPLIER;
  public static final char[] TOKEN_CHARS;
  private IntegerAttributeValue b;
  private IntegerAttributeValue h;
  private String id = generateId();
  private IntegerAttributeValue s;
  
  static
  {
    char[] arrayOfChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    TOKEN_CHARS = arrayOfChar;
    MULTIPLIER = arrayOfChar.length / 16;
  }
  
  public static ColorHSBAttributeValueBuilder builder()
  {
    return new ColorHSBAttributeValueBuilder(null);
  }
  
  private static String generateId()
  {
    String str = UUID.randomUUID().toString().toUpperCase();
    StringBuilder localStringBuilder = new StringBuilder(str.length());
    for (int i = 0; i < str.length(); i++)
    {
      char c = str.charAt(i);
      if (Character.isDigit(c)) {
        localStringBuilder.append(TOKEN_CHARS[(randomInt(MULTIPLIER) * 16 + (c - '0'))]);
      } else if (isAlphabeticCompat(c)) {
        localStringBuilder.append(TOKEN_CHARS[(randomInt(MULTIPLIER) * 16 + 10 + (c - 'A'))]);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean isAlphabeticCompat(int paramInt)
  {
    if (f.h(1.7F)) {
      return Character.isAlphabetic(paramInt);
    }
    boolean bool;
    if ((!Character.isLetter(paramInt)) && (Character.getType(paramInt) != 10)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static int randomInt(int paramInt)
  {
    return new Random().nextInt(paramInt);
  }
  
  public IntegerAttributeValue getB()
  {
    return this.b;
  }
  
  public IntegerAttributeValue getH()
  {
    return this.h;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public IntegerAttributeValue getS()
  {
    return this.s;
  }
  
  public boolean isRegisteredIn(List<ColorHSBAttributeValue> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (!TextUtils.isEmpty(this.id)))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (ColorHSBAttributeValue)localIterator.next();
        if ((paramList != null) && (!TextUtils.isEmpty(paramList.getId())) && (paramList.getId().equals(this.id))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isValid()
  {
    boolean bool1 = TextUtils.isEmpty(this.id);
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (!bool1)
    {
      IntegerAttributeValue localIntegerAttributeValue = this.h;
      bool3 = bool2;
      if (localIntegerAttributeValue != null)
      {
        bool3 = bool2;
        if (this.s != null) {
          if (this.b == null)
          {
            bool3 = bool2;
          }
          else
          {
            bool3 = bool2;
            if (localIntegerAttributeValue.isValid())
            {
              bool3 = bool2;
              if (this.s.isValid())
              {
                bool3 = bool2;
                if (this.b.isValid()) {
                  bool3 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool3;
  }
  
  public void setB(IntegerAttributeValue paramIntegerAttributeValue)
  {
    this.b = paramIntegerAttributeValue;
  }
  
  public void setH(IntegerAttributeValue paramIntegerAttributeValue)
  {
    this.h = paramIntegerAttributeValue;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setS(IntegerAttributeValue paramIntegerAttributeValue)
  {
    this.s = paramIntegerAttributeValue;
  }
  
  public static final class ColorHSBAttributeValueBuilder
  {
    private IntegerAttributeValue b;
    private IntegerAttributeValue h;
    private String id;
    private IntegerAttributeValue s;
    
    public static ColorHSBAttributeValueBuilder aColorHSBAttributeValue()
    {
      return new ColorHSBAttributeValueBuilder();
    }
    
    public ColorHSBAttributeValueBuilder b(IntegerAttributeValue paramIntegerAttributeValue)
    {
      this.b = paramIntegerAttributeValue;
      return this;
    }
    
    public ColorHSBAttributeValue build()
    {
      ColorHSBAttributeValue localColorHSBAttributeValue = new ColorHSBAttributeValue();
      if (TextUtils.isEmpty(this.id)) {
        localColorHSBAttributeValue.setId(ColorHSBAttributeValue.access$100());
      } else {
        localColorHSBAttributeValue.setId(this.id);
      }
      localColorHSBAttributeValue.setH(this.h);
      localColorHSBAttributeValue.setS(this.s);
      localColorHSBAttributeValue.setB(this.b);
      return localColorHSBAttributeValue;
    }
    
    public ColorHSBAttributeValueBuilder h(IntegerAttributeValue paramIntegerAttributeValue)
    {
      this.h = paramIntegerAttributeValue;
      return this;
    }
    
    public ColorHSBAttributeValueBuilder id(String paramString)
    {
      this.id = paramString;
      return this;
    }
    
    public ColorHSBAttributeValueBuilder s(IntegerAttributeValue paramIntegerAttributeValue)
    {
      this.s = paramIntegerAttributeValue;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\bean\lightstrip\lightingeffect\attributes\ColorHSBAttributeValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */