package io.netty.util;

public abstract interface AttributeMap
{
  public abstract <T> Attribute<T> attr(AttributeKey<T> paramAttributeKey);
  
  public abstract <T> boolean hasAttr(AttributeKey<T> paramAttributeKey);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\AttributeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */