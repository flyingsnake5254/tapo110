package c.a.a;

import android.util.Property;

public abstract interface a
{
  public static final a b = new a();
  
  public abstract float getRevealRadius();
  
  public abstract void setRevealRadius(float paramFloat);
  
  public static class a
    extends Property<a, Float>
  {
    public a()
    {
      super("revealRadius");
    }
    
    public Float a(a parama)
    {
      return Float.valueOf(parama.getRevealRadius());
    }
    
    public void b(a parama, Float paramFloat)
    {
      parama.setRevealRadius(paramFloat.floatValue());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\c\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */