package io.netty.resolver.dns;

final class UnixResolverOptions
{
  private final int attempts;
  private final int ndots;
  private final int timeout;
  
  UnixResolverOptions(int paramInt1, int paramInt2, int paramInt3)
  {
    this.ndots = paramInt1;
    this.timeout = paramInt2;
    this.attempts = paramInt3;
  }
  
  static Builder newBuilder()
  {
    return new Builder(null);
  }
  
  int attempts()
  {
    return this.attempts;
  }
  
  int ndots()
  {
    return this.ndots;
  }
  
  int timeout()
  {
    return this.timeout;
  }
  
  static final class Builder
  {
    private int attempts = 16;
    private int ndots = 1;
    private int timeout = 5;
    
    UnixResolverOptions build()
    {
      return new UnixResolverOptions(this.ndots, this.timeout, this.attempts);
    }
    
    void setAttempts(int paramInt)
    {
      this.attempts = paramInt;
    }
    
    void setNdots(int paramInt)
    {
      this.ndots = paramInt;
    }
    
    void setTimeout(int paramInt)
    {
      this.timeout = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\dns\UnixResolverOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */