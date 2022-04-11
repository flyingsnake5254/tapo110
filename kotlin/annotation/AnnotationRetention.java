package kotlin.annotation;

public enum AnnotationRetention
{
  static
  {
    AnnotationRetention localAnnotationRetention1 = new AnnotationRetention("SOURCE", 0);
    SOURCE = localAnnotationRetention1;
    AnnotationRetention localAnnotationRetention2 = new AnnotationRetention("BINARY", 1);
    BINARY = localAnnotationRetention2;
    AnnotationRetention localAnnotationRetention3 = new AnnotationRetention("RUNTIME", 2);
    RUNTIME = localAnnotationRetention3;
    $VALUES = new AnnotationRetention[] { localAnnotationRetention1, localAnnotationRetention2, localAnnotationRetention3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\annotation\AnnotationRetention.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */