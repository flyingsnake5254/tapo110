package com.samskivert.mustache;

public class c
{
  public static final f.i a;
  public static final f.i b = new a();
  
  static
  {
    String[] arrayOfString1 = { "<", "&lt;" };
    String[] arrayOfString2 = { ">", "&gt;" };
    String[] arrayOfString3 = { "`", "&#x60;" };
    String[] arrayOfString4 = { "=", "&#x3D;" };
    a = a(new String[][] { { "&", "&amp;" }, { "'", "&#39;" }, { "\"", "&quot;" }, arrayOfString1, arrayOfString2, arrayOfString3, arrayOfString4 });
  }
  
  public static f.i a(String[]... paramVarArgs)
  {
    return new b(paramVarArgs);
  }
  
  static final class a
    implements f.i
  {
    public String a(String paramString)
    {
      return paramString;
    }
  }
  
  static final class b
    implements f.i
  {
    b(String[][] paramArrayOfString) {}
    
    public String a(String paramString)
    {
      for (String[] arrayOfString1 : this.a) {
        paramString = paramString.replace(arrayOfString1[0], arrayOfString1[1]);
      }
      return paramString;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\samskivert\mustache\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */