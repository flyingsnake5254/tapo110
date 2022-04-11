package io.netty.handler.codec.xml;

public class XmlDocumentStart
{
  private final String encoding;
  private final String encodingScheme;
  private final boolean standalone;
  private final String version;
  
  public XmlDocumentStart(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    this.encoding = paramString1;
    this.version = paramString2;
    this.standalone = paramBoolean;
    this.encodingScheme = paramString3;
  }
  
  public String encoding()
  {
    return this.encoding;
  }
  
  public String encodingScheme()
  {
    return this.encodingScheme;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (XmlDocumentStart)paramObject;
      if (this.standalone != ((XmlDocumentStart)paramObject).standalone) {
        return false;
      }
      String str = this.encoding;
      if (str != null ? !str.equals(((XmlDocumentStart)paramObject).encoding) : ((XmlDocumentStart)paramObject).encoding != null) {
        return false;
      }
      str = this.encodingScheme;
      if (str != null ? !str.equals(((XmlDocumentStart)paramObject).encodingScheme) : ((XmlDocumentStart)paramObject).encodingScheme != null) {
        return false;
      }
      str = this.version;
      paramObject = ((XmlDocumentStart)paramObject).version;
      return str != null ? str.equals(paramObject) : paramObject == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.encoding;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.version;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    int m = this.standalone;
    str = this.encodingScheme;
    if (str != null) {
      i = str.hashCode();
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  public boolean standalone()
  {
    return this.standalone;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XmlDocumentStart{encoding='");
    localStringBuilder.append(this.encoding);
    localStringBuilder.append('\'');
    localStringBuilder.append(", version='");
    localStringBuilder.append(this.version);
    localStringBuilder.append('\'');
    localStringBuilder.append(", standalone=");
    localStringBuilder.append(this.standalone);
    localStringBuilder.append(", encodingScheme='");
    localStringBuilder.append(this.encodingScheme);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String version()
  {
    return this.version;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlDocumentStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */