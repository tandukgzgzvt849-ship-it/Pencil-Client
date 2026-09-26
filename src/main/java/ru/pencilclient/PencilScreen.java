package ru.pencilclient;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class PencilScreen extends Screen {
    private final ModuleCategory[] categories = ModuleCategory.values();
    private ModuleCategory selectedCategory = ModuleCategory.VISUAL;

    public PencilScreen() {
        super(Text.literal("Pencil Client"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        int panelX = 24;
        int panelY = 24;
        int panelWidth = width - 48;
        int panelHeight = height - 48;
        context.fill(panelX, panelY, panelX + panelWidth, panelY + panelHeight, 0xB0121218);

        context.drawCenteredTextWithShadow(textRenderer, Text.literal("Pencil Client"), width / 2, 38, 0xFFFFFFFF);

        int tabWidth = 120;
        int tabHeight = 24;
        int tabStartX = 54;
        int tabStartY = 68;

        for (int i = 0; i < categories.length; i++) {
            ModuleCategory category = categories[i];
            int x = tabStartX + i * (tabWidth + 12);
            int y = tabStartY;

            boolean hovered = mouseX >= x && mouseX <= x + tabWidth && mouseY >= y && mouseY <= y + tabHeight;
            int color = selectedCategory == category ? 0xFF2D8B57 : hovered ? 0xFF2B2F36 : 0xFF1A1D22;
            context.fill(x, y, x + tabWidth, y + tabHeight, color);
            context.drawTextWithShadow(textRenderer, Text.literal(category.getDisplayName()), x + 14, y + 7, 0xFFFFFFFF);
        }

        int contentX = 54;
        int contentY = 108;
        int contentWidth = width - 108;
        int contentHeight = height - 150;
        context.fill(contentX, contentY, contentX + contentWidth, contentY + contentHeight, 0xCC11161C);

        int listX = contentX + 18;
        int listY = contentY + 18;
        int listWidth = contentWidth - 36;

        for (Module module : PencilClient.MODULES.getByCategory(selectedCategory)) {
            int rowHeight = 26;
            boolean hovered = mouseX >= listX && mouseX <= listX + listWidth && mouseY >= listY && mouseY <= listY + rowHeight;
            int boxColor = module.isEnabled() ? 0xFF2F9E44 : hovered ? 0xFF272D34 : 0xFF171B20;
            context.fill(listX, listY, listX + listWidth, listY + rowHeight, boxColor);
            context.drawTextWithShadow(textRenderer, Text.literal(module.getName()), listX + 12, listY + 8, 0xFFFFFFFF);
            context.drawTextWithShadow(textRenderer, Text.literal(module.isEnabled() ? "ON" : "OFF"), listX + listWidth - 40, listY + 8, 0xFFFFFFFF);
            listY += rowHeight + 8;
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button != 0) {
            return super.mouseClicked(mouseX, mouseY, button);
        }

        int tabWidth = 120;
        int tabHeight = 24;
        int tabStartX = 54;
        int tabStartY = 68;

        for (int i = 0; i < categories.length; i++) {
            ModuleCategory category = categories[i];
            int x = tabStartX + i * (tabWidth + 12);
            int y = tabStartY;

            if (mouseX >= x && mouseX <= x + tabWidth && mouseY >= y && mouseY <= y + tabHeight) {
                selectedCategory = category;
                return true;
            }
        }

        int listX = 72;
        int listY = 126;
        int listWidth = width - 150;

        for (Module module : PencilClient.MODULES.getByCategory(selectedCategory)) {
            int rowHeight = 26;
            if (mouseX >= listX && mouseX <= listX + listWidth && mouseY >= listY && mouseY <= listY + rowHeight) {
                module.toggle();
                return true;
            }
            listY += rowHeight + 8;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) {
            close();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
