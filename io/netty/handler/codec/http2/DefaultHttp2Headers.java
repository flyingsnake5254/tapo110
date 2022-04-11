package io.netty.handler.codec.http2;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DefaultHeaders;
import io.netty.handler.codec.DefaultHeaders.HeaderEntry;
import io.netty.handler.codec.DefaultHeaders.NameValidator;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.HashingStrategy;

public class DefaultHttp2Headers
  extends DefaultHeaders<CharSequence, CharSequence, Http2Headers>
  implements Http2Headers
{
  static final DefaultHeaders.NameValidator<CharSequence> HTTP2_NAME_VALIDATOR = new DefaultHeaders.NameValidator()
  {
    /* Error */
    public void validateName(CharSequence paramAnonymousCharSequence)
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnull +12 -> 13
      //   4: aload_1
      //   5: invokeinterface 24 1 0
      //   10: ifne +22 -> 32
      //   13: getstatic 30	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   16: ldc 32
      //   18: iconst_1
      //   19: anewarray 5	java/lang/Object
      //   22: dup
      //   23: iconst_0
      //   24: aload_1
      //   25: aastore
      //   26: invokestatic 36	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
      //   29: invokestatic 42	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
      //   32: aload_1
      //   33: instanceof 44
      //   36: ifeq +69 -> 105
      //   39: aload_1
      //   40: checkcast 44	io/netty/util/AsciiString
      //   43: invokestatic 48	io/netty/handler/codec/http2/DefaultHttp2Headers:access$000	()Lio/netty/util/ByteProcessor;
      //   46: invokevirtual 52	io/netty/util/AsciiString:forEachByte	(Lio/netty/util/ByteProcessor;)I
      //   49: istore_2
      //   50: iload_2
      //   51: iconst_m1
      //   52: if_icmpeq +103 -> 155
      //   55: getstatic 30	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   58: ldc 54
      //   60: iconst_1
      //   61: anewarray 5	java/lang/Object
      //   64: dup
      //   65: iconst_0
      //   66: aload_1
      //   67: aastore
      //   68: invokestatic 36	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
      //   71: invokestatic 42	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
      //   74: goto +81 -> 155
      //   77: astore_3
      //   78: getstatic 30	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   81: aload_3
      //   82: ldc 56
      //   84: iconst_1
      //   85: anewarray 5	java/lang/Object
      //   88: dup
      //   89: iconst_0
      //   90: aload_1
      //   91: aastore
      //   92: invokestatic 59	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
      //   95: invokestatic 42	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
      //   98: return
      //   99: astore_1
      //   100: aload_1
      //   101: invokestatic 42	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
      //   104: return
      //   105: iconst_0
      //   106: istore_2
      //   107: iload_2
      //   108: aload_1
      //   109: invokeinterface 24 1 0
      //   114: if_icmpge +41 -> 155
      //   117: aload_1
      //   118: iload_2
      //   119: invokeinterface 63 2 0
      //   124: invokestatic 67	io/netty/util/AsciiString:isUpperCase	(C)Z
      //   127: ifeq +22 -> 149
      //   130: getstatic 30	io/netty/handler/codec/http2/Http2Error:PROTOCOL_ERROR	Lio/netty/handler/codec/http2/Http2Error;
      //   133: ldc 54
      //   135: iconst_1
      //   136: anewarray 5	java/lang/Object
      //   139: dup
      //   140: iconst_0
      //   141: aload_1
      //   142: aastore
      //   143: invokestatic 36	io/netty/handler/codec/http2/Http2Exception:connectionError	(Lio/netty/handler/codec/http2/Http2Error;Ljava/lang/String;[Ljava/lang/Object;)Lio/netty/handler/codec/http2/Http2Exception;
      //   146: invokestatic 42	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
      //   149: iinc 2 1
      //   152: goto -45 -> 107
      //   155: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	156	0	this	2
      //   0	156	1	paramAnonymousCharSequence	CharSequence
      //   49	101	2	i	int
      //   77	5	3	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   39	50	77	finally
      //   39	50	99	io/netty/handler/codec/http2/Http2Exception
    }
  };
  private static final ByteProcessor HTTP2_NAME_VALIDATOR_PROCESSOR = new ByteProcessor()
  {
    public boolean process(byte paramAnonymousByte)
    {
      return AsciiString.isUpperCase(paramAnonymousByte) ^ true;
    }
  };
  private DefaultHeaders.HeaderEntry<CharSequence, CharSequence> firstNonPseudo = this.head;
  
  public DefaultHttp2Headers()
  {
    this(true);
  }
  
  public DefaultHttp2Headers(boolean paramBoolean)
  {
    super(localHashingStrategy, localCharSequenceValueConverter, localNameValidator);
  }
  
  public DefaultHttp2Headers(boolean paramBoolean, int paramInt)
  {
    super(localHashingStrategy, localCharSequenceValueConverter, localNameValidator, paramInt);
  }
  
  public Http2Headers authority(CharSequence paramCharSequence)
  {
    set(Http2Headers.PseudoHeaderName.AUTHORITY.value(), paramCharSequence);
    return this;
  }
  
  public CharSequence authority()
  {
    return (CharSequence)get(Http2Headers.PseudoHeaderName.AUTHORITY.value());
  }
  
  public Http2Headers clear()
  {
    this.firstNonPseudo = this.head;
    return (Http2Headers)super.clear();
  }
  
  public boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return contains(paramCharSequence1, paramCharSequence2, false);
  }
  
  public boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    HashingStrategy localHashingStrategy;
    if (paramBoolean) {
      localHashingStrategy = AsciiString.CASE_INSENSITIVE_HASHER;
    } else {
      localHashingStrategy = AsciiString.CASE_SENSITIVE_HASHER;
    }
    return contains(paramCharSequence1, paramCharSequence2, localHashingStrategy);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (((paramObject instanceof Http2Headers)) && (equals((Http2Headers)paramObject, AsciiString.CASE_SENSITIVE_HASHER))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return hashCode(AsciiString.CASE_SENSITIVE_HASHER);
  }
  
  public Http2Headers method(CharSequence paramCharSequence)
  {
    set(Http2Headers.PseudoHeaderName.METHOD.value(), paramCharSequence);
    return this;
  }
  
  public CharSequence method()
  {
    return (CharSequence)get(Http2Headers.PseudoHeaderName.METHOD.value());
  }
  
  protected final DefaultHeaders.HeaderEntry<CharSequence, CharSequence> newHeaderEntry(int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, DefaultHeaders.HeaderEntry<CharSequence, CharSequence> paramHeaderEntry)
  {
    return new Http2HeaderEntry(paramInt, paramCharSequence1, paramCharSequence2, paramHeaderEntry);
  }
  
  public Http2Headers path(CharSequence paramCharSequence)
  {
    set(Http2Headers.PseudoHeaderName.PATH.value(), paramCharSequence);
    return this;
  }
  
  public CharSequence path()
  {
    return (CharSequence)get(Http2Headers.PseudoHeaderName.PATH.value());
  }
  
  public Http2Headers scheme(CharSequence paramCharSequence)
  {
    set(Http2Headers.PseudoHeaderName.SCHEME.value(), paramCharSequence);
    return this;
  }
  
  public CharSequence scheme()
  {
    return (CharSequence)get(Http2Headers.PseudoHeaderName.SCHEME.value());
  }
  
  public Http2Headers status(CharSequence paramCharSequence)
  {
    set(Http2Headers.PseudoHeaderName.STATUS.value(), paramCharSequence);
    return this;
  }
  
  public CharSequence status()
  {
    return (CharSequence)get(Http2Headers.PseudoHeaderName.STATUS.value());
  }
  
  private final class Http2HeaderEntry
    extends DefaultHeaders.HeaderEntry<CharSequence, CharSequence>
  {
    protected Http2HeaderEntry(CharSequence paramCharSequence1, CharSequence paramCharSequence2, DefaultHeaders.HeaderEntry<CharSequence, CharSequence> paramHeaderEntry)
    {
      super(paramCharSequence2);
      this.value = paramHeaderEntry;
      DefaultHeaders.HeaderEntry localHeaderEntry;
      this.next = localHeaderEntry;
      if (Http2Headers.PseudoHeaderName.hasPseudoHeaderFormat(paramCharSequence2))
      {
        this.after = DefaultHttp2Headers.this.firstNonPseudo;
        this.before = DefaultHttp2Headers.this.firstNonPseudo.before();
      }
      else
      {
        this.after = DefaultHttp2Headers.access$200(DefaultHttp2Headers.this);
        this.before = DefaultHttp2Headers.access$300(DefaultHttp2Headers.this).before();
        if (DefaultHttp2Headers.this.firstNonPseudo == DefaultHttp2Headers.access$400(DefaultHttp2Headers.this)) {
          DefaultHttp2Headers.access$102(DefaultHttp2Headers.this, this);
        }
      }
      pointNeighborsToThis();
    }
    
    protected void remove()
    {
      if (this == DefaultHttp2Headers.this.firstNonPseudo)
      {
        DefaultHttp2Headers localDefaultHttp2Headers = DefaultHttp2Headers.this;
        DefaultHttp2Headers.access$102(localDefaultHttp2Headers, localDefaultHttp2Headers.firstNonPseudo.after());
      }
      super.remove();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */