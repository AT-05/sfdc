package salesforce.salesforceapp;

import java.util.HashMap;

public class SalesforceEnums {

  public enum Skin {
    CLASSIC("Classic"),
    LIGHT("Lightning");

    private String skinName;

    private Skin(String skinName) {
      this.skinName = skinName;
    }

    public String getSkinName() {
      return skinName;
    }

    private static final HashMap<String, Skin> BY_SKIN_MAP = new HashMap<>();

    static {
      for (Skin skin : Skin.values()) {
        BY_SKIN_MAP.put(skin.getSkinName(), skin);
      }
    }

    public static Skin getSkinEnumBySkinName(String skinName) {
      return BY_SKIN_MAP.get(skinName);
    }
  }
}
