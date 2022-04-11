package kotlin.jvm;

public class KotlinReflectionNotSupportedError
  extends Error
{
  public KotlinReflectionNotSupportedError()
  {
    super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
  }
  
  public KotlinReflectionNotSupportedError(String paramString)
  {
    super(paramString);
  }
  
  public KotlinReflectionNotSupportedError(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public KotlinReflectionNotSupportedError(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\KotlinReflectionNotSupportedError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */