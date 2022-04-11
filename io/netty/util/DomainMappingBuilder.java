package io.netty.util;

@Deprecated
public final class DomainMappingBuilder<V>
{
  private final DomainNameMappingBuilder<V> builder;
  
  public DomainMappingBuilder(int paramInt, V paramV)
  {
    this.builder = new DomainNameMappingBuilder(paramInt, paramV);
  }
  
  public DomainMappingBuilder(V paramV)
  {
    this.builder = new DomainNameMappingBuilder(paramV);
  }
  
  public DomainMappingBuilder<V> add(String paramString, V paramV)
  {
    this.builder.add(paramString, paramV);
    return this;
  }
  
  public DomainNameMapping<V> build()
  {
    return this.builder.build();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\DomainMappingBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */