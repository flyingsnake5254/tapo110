package io.netty.handler.codec.smtp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class SmtpUtils
{
  static List<CharSequence> toUnmodifiableList(CharSequence... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      return Collections.unmodifiableList(Arrays.asList(paramVarArgs));
    }
    return Collections.emptyList();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\SmtpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */