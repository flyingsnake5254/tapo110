package b.d.c.a.j;

import androidx.annotation.NonNull;

public class a
  implements Thread.UncaughtExceptionHandler
{
  private a a;
  
  public a(a parama)
  {
    this.a = parama;
  }
  
  /* Error */
  private String a(Throwable paramThrowable)
  {
    // Byte code:
    //   0: new 23	java/io/StringWriter
    //   3: dup
    //   4: invokespecial 24	java/io/StringWriter:<init>	()V
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aload 4
    //   15: astore 5
    //   17: new 26	java/io/PrintWriter
    //   20: astore 6
    //   22: aload 4
    //   24: astore 5
    //   26: aload 6
    //   28: aload_2
    //   29: invokespecial 29	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   32: aload_1
    //   33: aload 6
    //   35: invokevirtual 35	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   38: aload 6
    //   40: invokevirtual 38	java/io/PrintWriter:close	()V
    //   43: aload_2
    //   44: invokevirtual 42	java/lang/Object:toString	()Ljava/lang/String;
    //   47: areturn
    //   48: astore_1
    //   49: aload 6
    //   51: astore 5
    //   53: goto +25 -> 78
    //   56: astore_1
    //   57: aload 6
    //   59: astore_1
    //   60: goto +7 -> 67
    //   63: astore_1
    //   64: goto +14 -> 78
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 38	java/io/PrintWriter:close	()V
    //   75: ldc 44
    //   77: areturn
    //   78: aload 5
    //   80: ifnull +8 -> 88
    //   83: aload 5
    //   85: invokevirtual 38	java/io/PrintWriter:close	()V
    //   88: aload_1
    //   89: athrow
    //   90: astore_1
    //   91: aload_3
    //   92: astore_1
    //   93: goto -26 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	a
    //   0	96	1	paramThrowable	Throwable
    //   7	37	2	localStringWriter	java.io.StringWriter
    //   9	83	3	localObject1	Object
    //   11	12	4	localObject2	Object
    //   15	69	5	localObject3	Object
    //   20	38	6	localPrintWriter	java.io.PrintWriter
    // Exception table:
    //   from	to	target	type
    //   32	38	48	finally
    //   32	38	56	java/lang/Exception
    //   17	22	63	finally
    //   26	32	63	finally
    //   17	22	90	java/lang/Exception
    //   26	32	90	java/lang/Exception
  }
  
  public void uncaughtException(@NonNull Thread paramThread, @NonNull Throwable paramThrowable)
  {
    this.a.a(a(paramThrowable));
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c\a\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */