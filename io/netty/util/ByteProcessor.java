package io.netty.util;

public abstract interface ByteProcessor
{
  public static final ByteProcessor FIND_ASCII_SPACE;
  public static final ByteProcessor FIND_COMMA;
  public static final ByteProcessor FIND_CR;
  public static final ByteProcessor FIND_CRLF;
  public static final ByteProcessor FIND_LF;
  public static final ByteProcessor FIND_LINEAR_WHITESPACE = new ByteProcessor()
  {
    public boolean process(byte paramAnonymousByte)
    {
      boolean bool;
      if ((paramAnonymousByte != 32) && (paramAnonymousByte != 9)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  };
  public static final ByteProcessor FIND_NON_CR;
  public static final ByteProcessor FIND_NON_CRLF;
  public static final ByteProcessor FIND_NON_LF;
  public static final ByteProcessor FIND_NON_LINEAR_WHITESPACE = new ByteProcessor()
  {
    public boolean process(byte paramAnonymousByte)
    {
      boolean bool;
      if ((paramAnonymousByte != 32) && (paramAnonymousByte != 9)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  };
  public static final ByteProcessor FIND_NON_NUL;
  public static final ByteProcessor FIND_NUL = new IndexOfProcessor((byte)0);
  public static final ByteProcessor FIND_SEMI_COLON;
  
  static
  {
    FIND_NON_NUL = new IndexNotOfProcessor((byte)0);
    FIND_CR = new IndexOfProcessor((byte)13);
    FIND_NON_CR = new IndexNotOfProcessor((byte)13);
    FIND_LF = new IndexOfProcessor((byte)10);
    FIND_NON_LF = new IndexNotOfProcessor((byte)10);
    FIND_SEMI_COLON = new IndexOfProcessor((byte)59);
    FIND_COMMA = new IndexOfProcessor((byte)44);
    FIND_ASCII_SPACE = new IndexOfProcessor((byte)32);
    FIND_CRLF = new ByteProcessor()
    {
      public boolean process(byte paramAnonymousByte)
      {
        boolean bool;
        if ((paramAnonymousByte != 13) && (paramAnonymousByte != 10)) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    };
    FIND_NON_CRLF = new ByteProcessor()
    {
      public boolean process(byte paramAnonymousByte)
      {
        boolean bool;
        if ((paramAnonymousByte != 13) && (paramAnonymousByte != 10)) {
          bool = false;
        } else {
          bool = true;
        }
        return bool;
      }
    };
  }
  
  public abstract boolean process(byte paramByte)
    throws Exception;
  
  public static class IndexNotOfProcessor
    implements ByteProcessor
  {
    private final byte byteToNotFind;
    
    public IndexNotOfProcessor(byte paramByte)
    {
      this.byteToNotFind = ((byte)paramByte);
    }
    
    public boolean process(byte paramByte)
    {
      boolean bool;
      if (paramByte == this.byteToNotFind) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public static class IndexOfProcessor
    implements ByteProcessor
  {
    private final byte byteToFind;
    
    public IndexOfProcessor(byte paramByte)
    {
      this.byteToFind = ((byte)paramByte);
    }
    
    public boolean process(byte paramByte)
    {
      boolean bool;
      if (paramByte != this.byteToFind) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\ByteProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */