package ru.pencilclient;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        modules.add(new Module("Fullbright", ModuleCategory.VISUAL));
        modules.add(new Module("ESP", ModuleCategory.VISUAL));
        modules.add(new Module("KillAura", ModuleCategory.COMBAT));
        modules.add(new Module("AutoClicker", ModuleCategory.COMBAT));
        modules.add(new Module("NoFall", ModuleCategory.MISC));
        modules.add(new Module("Timer", ModuleCategory.MISC));
        modules.add(new Module("FastPlace", ModuleCategory.CONFIG));
        modules.add(new Module("Nametags", ModuleCategory.CONFIG));
        modules.add(new Module("Sneak", ModuleCategory.PLAYER));
        modules.add(new Module("Speed", ModuleCategory.PLAYER));
        modules.add(new Module("Sprint", ModuleCategory.MOVEMENT));
        modules.add(new Module("Fly", ModuleCategory.MOVEMENT));
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getByCategory(ModuleCategory category) {
        List<Module> result = new ArrayList<>();
        for (Module module : modules) {
            if (module.getCategory() == category) {
                result.add(module);
            }
        }
        return result;
    }
}
