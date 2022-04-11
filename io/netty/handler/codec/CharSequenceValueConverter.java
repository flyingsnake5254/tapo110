package io.netty.handler.codec;

import io.netty.util.AsciiString;
import io.netty.util.internal.PlatformDependent;
import java.text.ParseException;
import java.util.Date;

public class CharSequenceValueConverter
  implements ValueConverter<CharSequence>
{
  public static final CharSequenceValueConverter INSTANCE = new CharSequenceValueConverter();
  private static final AsciiString TRUE_ASCII = new AsciiString("true");
  
  public CharSequence convertBoolean(boolean paramBoolean)
  {
    return String.valueOf(paramBoolean);
  }
  
  public CharSequence convertByte(byte paramByte)
  {
    return String.valueOf(paramByte);
  }
  
  public CharSequence convertChar(char paramChar)
  {
    return String.valueOf(paramChar);
  }
  
  public CharSequence convertDouble(double paramDouble)
  {
    return String.valueOf(paramDouble);
  }
  
  public CharSequence convertFloat(float paramFloat)
  {
    return String.valueOf(paramFloat);
  }
  
  public CharSequence convertInt(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public CharSequence convertLong(long paramLong)
  {
    return String.valueOf(paramLong);
  }
  
  public CharSequence convertObject(Object paramObject)
  {
    if ((paramObject instanceof CharSequence)) {
      return (CharSequence)paramObject;
    }
    return paramObject.toString();
  }
  
  public CharSequence convertShort(short paramShort)
  {
    return String.valueOf(paramShort);
  }
  
  public CharSequence convertTimeMillis(long paramLong)
  {
    return DateFormatter.format(new Date(paramLong));
  }
  
  public boolean convertToBoolean(CharSequence paramCharSequence)
  {
    return AsciiString.contentEqualsIgnoreCase(paramCharSequence, TRUE_ASCII);
  }
  
  public byte convertToByte(CharSequence paramCharSequence)
  {
    if (((paramCharSequence instanceof AsciiString)) && (paramCharSequence.length() == 1)) {
      return ((AsciiString)paramCharSequence).byteAt(0);
    }
    return Byte.parseByte(paramCharSequence.toString());
  }
  
  public char convertToChar(CharSequence paramCharSequence)
  {
    return paramCharSequence.charAt(0);
  }
  
  public double convertToDouble(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      return ((AsciiString)paramCharSequence).parseDouble();
    }
    return Double.parseDouble(paramCharSequence.toString());
  }
  
  public float convertToFloat(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      return ((AsciiString)paramCharSequence).parseFloat();
    }
    return Float.parseFloat(paramCharSequence.toString());
  }
  
  public int convertToInt(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      return ((AsciiString)paramCharSequence).parseInt();
    }
    return Integer.parseInt(paramCharSequence.toString());
  }
  
  public long convertToLong(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      return ((AsciiString)paramCharSequence).parseLong();
    }
    return Long.parseLong(paramCharSequence.toString());
  }
  
  public short convertToShort(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      return ((AsciiString)paramCharSequence).parseShort();
    }
    return Short.parseShort(paramCharSequence.toString());
  }
  
  public long convertToTimeMillis(CharSequence paramCharSequence)
  {
    Object localObject = DateFormatter.parseHttpDate(paramCharSequence);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("header can't be parsed into a Date: ");
      ((StringBuilder)localObject).append(paramCharSequence);
      PlatformDependent.throwException(new ParseException(((StringBuilder)localObject).toString(), 0));
      return 0L;
    }
    return ((Date)localObject).getTime();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\CharSequenceValueConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */