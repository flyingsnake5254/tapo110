package org.bouncycastle.util.io.pem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class e
  extends BufferedReader
{
  public e(Reader paramReader)
  {
    super(paramReader);
  }
  
  private b a(String paramString)
    throws IOException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-----END ");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    String str;
    for (;;)
    {
      str = readLine();
      if (str == null) {
        break;
      }
      if (str.indexOf(":") >= 0)
      {
        int i = str.indexOf(':');
        localArrayList.add(new a(str.substring(0, i), str.substring(i + 1).trim()));
      }
      else
      {
        if (str.indexOf((String)localObject) != -1) {
          break;
        }
        localStringBuffer.append(str.trim());
      }
    }
    if (str != null) {
      return new b(paramString, localArrayList, org.bouncycastle.util.encoders.a.a(localStringBuffer.toString()));
    }
    paramString = new StringBuilder();
    paramString.append((String)localObject);
    paramString.append(" not found");
    throw new IOException(paramString.toString());
  }
  
  public b c()
    throws IOException
  {
    String str;
    do
    {
      str = readLine();
    } while ((str != null) && (!str.startsWith("-----BEGIN ")));
    if (str != null)
    {
      str = str.substring(11);
      int i = str.indexOf('-');
      str = str.substring(0, i);
      if (i > 0) {
        return a(str);
      }
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\io\pem\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */