package io.netty.handler.codec.string;

import io.netty.buffer.ByteBufUtil;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public final class LineSeparator
{
  public static final LineSeparator DEFAULT = new LineSeparator(StringUtil.NEWLINE);
  public static final LineSeparator UNIX = new LineSeparator("\n");
  public static final LineSeparator WINDOWS = new LineSeparator("\r\n");
  private final String value;
  
  public LineSeparator(String paramString)
  {
    this.value = ((String)ObjectUtil.checkNotNull(paramString, "lineSeparator"));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof LineSeparator)) {
      return false;
    }
    Object localObject = (LineSeparator)paramObject;
    paramObject = this.value;
    localObject = ((LineSeparator)localObject).value;
    if (paramObject != null) {
      bool = ((String)paramObject).equals(localObject);
    } else if (localObject != null) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    String str = this.value;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    return ByteBufUtil.hexDump(this.value.getBytes(CharsetUtil.UTF_8));
  }
  
  public String value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\string\LineSeparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */