package io.netty.buffer;

import io.netty.util.ByteProcessor;

@Deprecated
public abstract interface ByteBufProcessor
  extends ByteProcessor
{
  @Deprecated
  public static final ByteBufProcessor FIND_CR;
  @Deprecated
  public static final ByteBufProcessor FIND_CRLF;
  @Deprecated
  public static final ByteBufProcessor FIND_LF;
  @Deprecated
  public static final ByteBufProcessor FIND_LINEAR_WHITESPACE = new ByteBufProcessor()
  {
    public boolean process(byte paramAnonymousByte)
      throws Exception
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
  @Deprecated
  public static final ByteBufProcessor FIND_NON_CR;
  @Deprecated
  public static final ByteBufProcessor FIND_NON_CRLF;
  @Deprecated
  public static final ByteBufProcessor FIND_NON_LF;
  @Deprecated
  public static final ByteBufProcessor FIND_NON_LINEAR_WHITESPACE = new ByteBufProcessor()
  {
    public boolean process(byte paramAnonymousByte)
      throws Exception
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
  @Deprecated
  public static final ByteBufProcessor FIND_NON_NUL;
  @Deprecated
  public static final ByteBufProcessor FIND_NUL = new ByteBufProcessor()
  {
    public boolean process(byte paramAnonymousByte)
      throws Exception
    {
      boolean bool;
      if (paramAnonymousByte != 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  };
  
  static
  {
    FIND_NON_NUL = new ByteBufProcessor()
    {
      public boolean process(byte paramAnonymousByte)
        throws Exception
      {
        boolean bool;
        if (paramAnonymousByte == 0) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    };
    FIND_CR = new ByteBufProcessor()
    {
      public boolean process(byte paramAnonymousByte)
        throws Exception
      {
        boolean bool;
        if (paramAnonymousByte != 13) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    };
    FIND_NON_CR = new ByteBufProcessor()
    {
      public boolean process(byte paramAnonymousByte)
        throws Exception
      {
        boolean bool;
        if (paramAnonymousByte == 13) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    };
    FIND_LF = new ByteBufProcessor()
    {
      public boolean process(byte paramAnonymousByte)
        throws Exception
      {
        boolean bool;
        if (paramAnonymousByte != 10) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    };
    FIND_NON_LF = new ByteBufProcessor()
    {
      public boolean process(byte paramAnonymousByte)
        throws Exception
      {
        boolean bool;
        if (paramAnonymousByte == 10) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    };
    FIND_CRLF = new ByteBufProcessor()
    {
      public boolean process(byte paramAnonymousByte)
        throws Exception
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
    FIND_NON_CRLF = new ByteBufProcessor()
    {
      public boolean process(byte paramAnonymousByte)
        throws Exception
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
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\buffer\ByteBufProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */