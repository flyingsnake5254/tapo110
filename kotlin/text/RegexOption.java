package kotlin.text;

public enum RegexOption
  implements f
{
  private final int mask;
  private final int value;
  
  static
  {
    RegexOption localRegexOption1 = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
    IGNORE_CASE = localRegexOption1;
    RegexOption localRegexOption2 = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
    MULTILINE = localRegexOption2;
    RegexOption localRegexOption3 = new RegexOption("LITERAL", 2, 16, 0, 2, null);
    LITERAL = localRegexOption3;
    RegexOption localRegexOption4 = new RegexOption("UNIX_LINES", 3, 1, 0, 2, null);
    UNIX_LINES = localRegexOption4;
    RegexOption localRegexOption5 = new RegexOption("COMMENTS", 4, 4, 0, 2, null);
    COMMENTS = localRegexOption5;
    RegexOption localRegexOption6 = new RegexOption("DOT_MATCHES_ALL", 5, 32, 0, 2, null);
    DOT_MATCHES_ALL = localRegexOption6;
    RegexOption localRegexOption7 = new RegexOption("CANON_EQ", 6, 128, 0, 2, null);
    CANON_EQ = localRegexOption7;
    $VALUES = new RegexOption[] { localRegexOption1, localRegexOption2, localRegexOption3, localRegexOption4, localRegexOption5, localRegexOption6, localRegexOption7 };
  }
  
  private RegexOption(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
    this.mask = paramInt2;
  }
  
  public int getMask()
  {
    return this.mask;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\RegexOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */