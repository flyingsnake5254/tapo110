package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import com.jcraft.jzlib.JZlib.WrapperType;

final class ZlibUtil
{
  static JZlib.WrapperType convertWrapperType(ZlibWrapper paramZlibWrapper)
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[paramZlibWrapper.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            paramZlibWrapper = JZlib.W_ANY;
          } else {
            throw new Error();
          }
        }
        else {
          paramZlibWrapper = JZlib.W_GZIP;
        }
      }
      else {
        paramZlibWrapper = JZlib.W_ZLIB;
      }
    }
    else {
      paramZlibWrapper = JZlib.W_NONE;
    }
    return paramZlibWrapper;
  }
  
  static CompressionException deflaterException(Deflater paramDeflater, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(')');
    if (paramDeflater.msg != null)
    {
      paramString = new StringBuilder();
      paramString.append(": ");
      paramString.append(paramDeflater.msg);
      paramDeflater = paramString.toString();
    }
    else
    {
      paramDeflater = "";
    }
    localStringBuilder.append(paramDeflater);
    return new CompressionException(localStringBuilder.toString());
  }
  
  static void fail(Deflater paramDeflater, String paramString, int paramInt)
  {
    throw deflaterException(paramDeflater, paramString, paramInt);
  }
  
  static void fail(Inflater paramInflater, String paramString, int paramInt)
  {
    throw inflaterException(paramInflater, paramString, paramInt);
  }
  
  static DecompressionException inflaterException(Inflater paramInflater, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(')');
    if (paramInflater.msg != null)
    {
      paramString = new StringBuilder();
      paramString.append(": ");
      paramString.append(paramInflater.msg);
      paramInflater = paramString.toString();
    }
    else
    {
      paramInflater = "";
    }
    localStringBuilder.append(paramInflater);
    return new DecompressionException(localStringBuilder.toString());
  }
  
  static int wrapperOverhead(ZlibWrapper paramZlibWrapper)
  {
    int i = 1.$SwitchMap$io$netty$handler$codec$compression$ZlibWrapper[paramZlibWrapper.ordinal()];
    int j = 2;
    int k;
    if (i != 1)
    {
      k = j;
      if (i != 2) {
        if (i != 3)
        {
          if (i == 4) {
            k = j;
          } else {
            throw new Error();
          }
        }
        else {
          k = 10;
        }
      }
    }
    else
    {
      k = 0;
    }
    return k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\ZlibUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */