package io.netty.handler.codec.http2;

import io.netty.util.collection.CharObjectHashMap;
import io.netty.util.internal.ObjectUtil;

public final class Http2Settings
  extends CharObjectHashMap<Long>
{
  private static final int DEFAULT_CAPACITY = 13;
  private static final Long FALSE = Long.valueOf(0L);
  private static final Long TRUE = Long.valueOf(1L);
  
  public Http2Settings()
  {
    this(13);
  }
  
  public Http2Settings(int paramInt)
  {
    super(paramInt);
  }
  
  public Http2Settings(int paramInt, float paramFloat)
  {
    super(paramInt, paramFloat);
  }
  
  public static Http2Settings defaultSettings()
  {
    return new Http2Settings().maxHeaderListSize(8192L);
  }
  
  private static void verifyStandardSetting(int paramInt, Long paramLong)
  {
    ObjectUtil.checkNotNull(paramLong, "value");
    StringBuilder localStringBuilder;
    switch (paramInt)
    {
    default: 
      break;
    case 6: 
      if ((paramLong.longValue() < 0L) || (paramLong.longValue() > 4294967295L))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Setting MAX_HEADER_LIST_SIZE is invalid: ");
        localStringBuilder.append(paramLong);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      break;
    case 5: 
      if (!Http2CodecUtil.isMaxFrameSizeValid(paramLong.intValue()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Setting MAX_FRAME_SIZE is invalid: ");
        localStringBuilder.append(paramLong);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      break;
    case 4: 
      if ((paramLong.longValue() < 0L) || (paramLong.longValue() > 2147483647L))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Setting INITIAL_WINDOW_SIZE is invalid: ");
        localStringBuilder.append(paramLong);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      break;
    case 3: 
      if ((paramLong.longValue() < 0L) || (paramLong.longValue() > 4294967295L))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Setting MAX_CONCURRENT_STREAMS is invalid: ");
        localStringBuilder.append(paramLong);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      break;
    case 2: 
      if ((paramLong.longValue() != 0L) && (paramLong.longValue() != 1L))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Setting ENABLE_PUSH is invalid: ");
        localStringBuilder.append(paramLong);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      break;
    case 1: 
      if ((paramLong.longValue() < 0L) || (paramLong.longValue() > 4294967295L))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Setting HEADER_TABLE_SIZE is invalid: ");
        localStringBuilder.append(paramLong);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      break;
    }
  }
  
  public Http2Settings copyFrom(Http2Settings paramHttp2Settings)
  {
    clear();
    putAll(paramHttp2Settings);
    return this;
  }
  
  public Integer getIntValue(char paramChar)
  {
    Long localLong = (Long)get(paramChar);
    if (localLong == null) {
      return null;
    }
    return Integer.valueOf(localLong.intValue());
  }
  
  public Http2Settings headerTableSize(long paramLong)
  {
    put('\001', Long.valueOf(paramLong));
    return this;
  }
  
  public Long headerTableSize()
  {
    return (Long)get('\001');
  }
  
  public Http2Settings initialWindowSize(int paramInt)
  {
    put('\004', Long.valueOf(paramInt));
    return this;
  }
  
  public Integer initialWindowSize()
  {
    return getIntValue('\004');
  }
  
  protected String keyToString(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return super.keyToString(paramChar);
    case '\006': 
      return "MAX_HEADER_LIST_SIZE";
    case '\005': 
      return "MAX_FRAME_SIZE";
    case '\004': 
      return "INITIAL_WINDOW_SIZE";
    case '\003': 
      return "MAX_CONCURRENT_STREAMS";
    case '\002': 
      return "ENABLE_PUSH";
    }
    return "HEADER_TABLE_SIZE";
  }
  
  public Http2Settings maxConcurrentStreams(long paramLong)
  {
    put('\003', Long.valueOf(paramLong));
    return this;
  }
  
  public Long maxConcurrentStreams()
  {
    return (Long)get('\003');
  }
  
  public Http2Settings maxFrameSize(int paramInt)
  {
    put('\005', Long.valueOf(paramInt));
    return this;
  }
  
  public Integer maxFrameSize()
  {
    return getIntValue('\005');
  }
  
  public Http2Settings maxHeaderListSize(long paramLong)
  {
    put('\006', Long.valueOf(paramLong));
    return this;
  }
  
  public Long maxHeaderListSize()
  {
    return (Long)get('\006');
  }
  
  public Http2Settings pushEnabled(boolean paramBoolean)
  {
    Long localLong;
    if (paramBoolean) {
      localLong = TRUE;
    } else {
      localLong = FALSE;
    }
    put('\002', localLong);
    return this;
  }
  
  public Boolean pushEnabled()
  {
    Long localLong = (Long)get('\002');
    if (localLong == null) {
      return null;
    }
    return Boolean.valueOf(TRUE.equals(localLong));
  }
  
  public Long put(char paramChar, Long paramLong)
  {
    verifyStandardSetting(paramChar, paramLong);
    return (Long)super.put(paramChar, paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */