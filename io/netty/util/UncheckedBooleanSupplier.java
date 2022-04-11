package io.netty.util;

public abstract interface UncheckedBooleanSupplier
  extends BooleanSupplier
{
  public static final UncheckedBooleanSupplier FALSE_SUPPLIER = new UncheckedBooleanSupplier()
  {
    public boolean get()
    {
      return false;
    }
  };
  public static final UncheckedBooleanSupplier TRUE_SUPPLIER = new UncheckedBooleanSupplier()
  {
    public boolean get()
    {
      return true;
    }
  };
  
  public abstract boolean get();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\UncheckedBooleanSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */