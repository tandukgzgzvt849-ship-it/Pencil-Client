package ru.pencilclient;

public class Module {
    private final String name;
    private final ModuleCategory category;
    private boolean enabled;

    public Module(String name, ModuleCategory category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public ModuleCategory getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void toggle() {
        enabled = !enabled;
    }
}
