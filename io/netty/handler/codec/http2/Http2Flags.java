package io.netty.handler.codec.http2;

public final class Http2Flags
{
  public static final short ACK = 1;
  public static final short END_HEADERS = 4;
  public static final short END_STREAM = 1;
  public static final short PADDED = 8;
  public static final short PRIORITY = 32;
  private short value;
  
  public Http2Flags() {}
  
  public Http2Flags(short paramShort)
  {
    this.value = ((short)paramShort);
  }
  
  public Http2Flags ack(boolean paramBoolean)
  {
    return setFlag(paramBoolean, (short)1);
  }
  
  public boolean ack()
  {
    return isFlagSet((short)1);
  }
  
  public Http2Flags endOfHeaders(boolean paramBoolean)
  {
    return setFlag(paramBoolean, (short)4);
  }
  
  public boolean endOfHeaders()
  {
    return isFlagSet((short)4);
  }
  
  public Http2Flags endOfStream(boolean paramBoolean)
  {
    return setFlag(paramBoolean, (short)1);
  }
  
  public boolean endOfStream()
  {
    return isFlagSet((short)1);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (Http2Flags.class != paramObject.getClass()) {
      return false;
    }
    if (this.value != ((Http2Flags)paramObject).value) {
      bool = false;
    }
    return bool;
  }
  
  public int getNumPriorityBytes()
  {
    int i;
    if (priorityPresent()) {
      i = 5;
    } else {
      i = 0;
    }
    return i;
  }
  
  public int getPaddingPresenceFieldLength()
  {
    return paddingPresent();
  }
  
  public int hashCode()
  {
    return 31 + this.value;
  }
  
  public boolean isFlagSet(short paramShort)
  {
    boolean bool;
    if ((paramShort & this.value) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Http2Flags paddingPresent(boolean paramBoolean)
  {
    return setFlag(paramBoolean, (short)8);
  }
  
  public boolean paddingPresent()
  {
    return isFlagSet((short)8);
  }
  
  public Http2Flags priorityPresent(boolean paramBoolean)
  {
    return setFlag(paramBoolean, (short)32);
  }
  
  public boolean priorityPresent()
  {
    return isFlagSet((short)32);
  }
  
  public Http2Flags setFlag(boolean paramBoolean, short paramShort)
  {
    if (paramBoolean) {
      this.value = ((short)(short)(this.value | paramShort));
    } else {
      this.value = ((short)(short)(this.value & (paramShort ^ 0xFFFFFFFF)));
    }
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("value = ");
    localStringBuilder.append(this.value);
    localStringBuilder.append(" (");
    if (ack()) {
      localStringBuilder.append("ACK,");
    }
    if (endOfHeaders()) {
      localStringBuilder.append("END_OF_HEADERS,");
    }
    if (endOfStream()) {
      localStringBuilder.append("END_OF_STREAM,");
    }
    if (priorityPresent()) {
      localStringBuilder.append("PRIORITY_PRESENT,");
    }
    if (paddingPresent()) {
      localStringBuilder.append("PADDING_PRESENT,");
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public short value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2Flags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */