package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.util.o0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class u
{
  private static final Pattern a = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
  public int b = -1;
  public int c = -1;
  
  private boolean b(String paramString)
  {
    paramString = a.matcher(paramString);
    if (paramString.find()) {}
    try
    {
      int i = Integer.parseInt((String)o0.i(paramString.group(1)), 16);
      int j = Integer.parseInt((String)o0.i(paramString.group(2)), 16);
      if ((i > 0) || (j > 0))
      {
        this.b = i;
        this.c = j;
        return true;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return false;
  }
  
  public boolean a()
  {
    boolean bool;
    if ((this.b != -1) && (this.c != -1)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean c(Metadata paramMetadata)
  {
    for (int i = 0; i < paramMetadata.d(); i++)
    {
      Object localObject = paramMetadata.c(i);
      if ((localObject instanceof CommentFrame))
      {
        localObject = (CommentFrame)localObject;
        if (("iTunSMPB".equals(((CommentFrame)localObject).f)) && (b(((CommentFrame)localObject).q))) {
          return true;
        }
      }
      else if ((localObject instanceof InternalFrame))
      {
        localObject = (InternalFrame)localObject;
        if (("com.apple.iTunes".equals(((InternalFrame)localObject).d)) && ("iTunSMPB".equals(((InternalFrame)localObject).f)) && (b(((InternalFrame)localObject).q))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean d(int paramInt)
  {
    int i = paramInt >> 12;
    paramInt &= 0xFFF;
    if ((i <= 0) && (paramInt <= 0)) {
      return false;
    }
    this.b = i;
    this.c = paramInt;
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */