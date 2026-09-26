package ru.pencilclient;

public class ModuleCategory {
    public static final ModuleCategory VISUAL = new ModuleCategory("Visual");
    public static final ModuleCategory COMBAT = new ModuleCategory("Combat");
    public static final ModuleCategory MISC = new ModuleCategory("Misc");
    public static final ModuleCategory CONFIG = new ModuleCategory("Config");
    public static final ModuleCategory PLAYER = new ModuleCategory("Player");
    public static final ModuleCategory MOVEMENT = new ModuleCategory("Movement");

    private final String displayName;

    private ModuleCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static ModuleCategory[] values() {
        return new ModuleCategory[] { VISUAL, COMBAT, MISC, CONFIG, PLAYER, MOVEMENT };
    }
}
