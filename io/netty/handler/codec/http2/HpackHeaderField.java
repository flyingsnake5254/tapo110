package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

class HpackHeaderField
{
  static final int HEADER_ENTRY_OVERHEAD = 32;
  final CharSequence name;
  final CharSequence value;
  
  HpackHeaderField(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    this.name = ((CharSequence)ObjectUtil.checkNotNull(paramCharSequence1, "name"));
    this.value = ((CharSequence)ObjectUtil.checkNotNull(paramCharSequence2, "value"));
  }
  
  static long sizeOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return paramCharSequence1.length() + paramCharSequence2.length() + 32;
  }
  
  public final boolean equalsForTest(HpackHeaderField paramHpackHeaderField)
  {
    boolean bool;
    if ((HpackUtil.equalsVariableTime(this.name, paramHpackHeaderField.name)) && (HpackUtil.equalsVariableTime(this.value, paramHpackHeaderField.value))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  final int size()
  {
    return this.name.length() + this.value.length() + 32;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(": ");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\HpackHeaderField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */