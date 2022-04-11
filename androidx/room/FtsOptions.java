package androidx.room;

import androidx.annotation.RequiresApi;

public class FtsOptions
{
  public static final String TOKENIZER_ICU = "icu";
  public static final String TOKENIZER_PORTER = "porter";
  public static final String TOKENIZER_SIMPLE = "simple";
  @RequiresApi(21)
  public static final String TOKENIZER_UNICODE61 = "unicode61";
  
  public static enum MatchInfo
  {
    static
    {
      MatchInfo localMatchInfo1 = new MatchInfo("FTS3", 0);
      FTS3 = localMatchInfo1;
      MatchInfo localMatchInfo2 = new MatchInfo("FTS4", 1);
      FTS4 = localMatchInfo2;
      $VALUES = new MatchInfo[] { localMatchInfo1, localMatchInfo2 };
    }
  }
  
  public static enum Order
  {
    static
    {
      Order localOrder1 = new Order("ASC", 0);
      ASC = localOrder1;
      Order localOrder2 = new Order("DESC", 1);
      DESC = localOrder2;
      $VALUES = new Order[] { localOrder1, localOrder2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\FtsOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */