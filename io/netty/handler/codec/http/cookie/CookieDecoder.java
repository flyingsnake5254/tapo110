package io.netty.handler.codec.http.cookie;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.CharBuffer;

public abstract class CookieDecoder
{
  private final InternalLogger logger = InternalLoggerFactory.getInstance(getClass());
  private final boolean strict;
  
  protected CookieDecoder(boolean paramBoolean)
  {
    this.strict = paramBoolean;
  }
  
  protected DefaultCookie initCookie(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != -1) && (paramInt1 != paramInt2))
    {
      if (paramInt3 == -1)
      {
        this.logger.debug("Skipping cookie with null value");
        return null;
      }
      CharBuffer localCharBuffer = CharBuffer.wrap(paramString, paramInt3, paramInt4);
      CharSequence localCharSequence = CookieUtil.unwrapValue(localCharBuffer);
      if (localCharSequence == null)
      {
        this.logger.debug("Skipping cookie because starting quotes are not properly balanced in '{}'", localCharBuffer);
        return null;
      }
      paramString = paramString.substring(paramInt1, paramInt2);
      if (this.strict)
      {
        paramInt1 = CookieUtil.firstInvalidCookieNameOctet(paramString);
        if (paramInt1 >= 0)
        {
          if (this.logger.isDebugEnabled()) {
            this.logger.debug("Skipping cookie because name '{}' contains invalid char '{}'", paramString, Character.valueOf(paramString.charAt(paramInt1)));
          }
          return null;
        }
      }
      boolean bool;
      if (localCharSequence.length() != paramInt4 - paramInt3) {
        bool = true;
      } else {
        bool = false;
      }
      if (this.strict)
      {
        paramInt1 = CookieUtil.firstInvalidCookieValueOctet(localCharSequence);
        if (paramInt1 >= 0)
        {
          if (this.logger.isDebugEnabled()) {
            this.logger.debug("Skipping cookie because value '{}' contains invalid char '{}'", localCharSequence, Character.valueOf(localCharSequence.charAt(paramInt1)));
          }
          return null;
        }
      }
      paramString = new DefaultCookie(paramString, localCharSequence.toString());
      paramString.setWrap(bool);
      return paramString;
    }
    this.logger.debug("Skipping cookie with null name");
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\cookie\CookieDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */