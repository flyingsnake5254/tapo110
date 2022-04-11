package io.netty.util;

public abstract interface BooleanSupplier
{
  public static final BooleanSupplier FALSE_SUPPLIER = new BooleanSupplier()
  {
    public boolean get()
    {
      return false;
    }
  };
  public static final BooleanSupplier TRUE_SUPPLIER = new BooleanSupplier()
  {
    public boolean get()
    {
      return true;
    }
  };
  
  public abstract boolean get()
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\BooleanSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */