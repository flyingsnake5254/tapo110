package io.netty.handler.codec.xml;

public class XmlElementEnd
  extends XmlElement
{
  public XmlElementEnd(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XmlElementStart{");
    localStringBuilder.append(super.toString());
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\xml\XmlElementEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */