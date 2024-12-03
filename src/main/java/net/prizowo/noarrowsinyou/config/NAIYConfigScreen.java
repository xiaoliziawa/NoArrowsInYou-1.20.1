package net.prizowo.noarrowsinyou.config;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.prizowo.noarrowsinyou.NAIY;

public class NAIYConfigScreen extends Screen {
    private final Screen parent;
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 20;
    private static final int PADDING = 4;
    private static final int CATEGORY_PADDING = 10;

    protected NAIYConfigScreen(Screen parent) {
        super(Component.translatable("naiy.config.title"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        super.init();
        
        int y = 40;
        
        // 将按钮分成两列
        int leftX = this.width / 4 - BUTTON_WIDTH / 2;
        int rightX = this.width * 3/4 - BUTTON_WIDTH / 2;
        
        // 第一行
        addBooleanOption("onlyLocal", leftX, y, "naiy.config.onlylocal");
        addBooleanOption("hideArrows", rightX, y, "naiy.config.hidearrows");
        y += BUTTON_HEIGHT + PADDING;
        
        // 第二行
        addBooleanOption("hideStings", leftX, y, "naiy.config.hidestings");
        addBooleanOption("hideArmor", rightX, y, "naiy.config.hidearmor");
        y += BUTTON_HEIGHT + PADDING;
        
        // 第三行
        addBooleanOption("hideHeldItem", leftX, y, "naiy.config.hidehelditem");
        addBooleanOption("hideHead", rightX, y, "naiy.config.hidehead");
        y += BUTTON_HEIGHT + PADDING;
        
        // 第四行
        addBooleanOption("hideElytra", leftX, y, "naiy.config.hideelytra");
        addBooleanOption("hideRiptide", rightX, y, "naiy.config.hideriptide");
        y += BUTTON_HEIGHT + PADDING;
        
        // 第五行
        addBooleanOption("render", leftX, y, "naiy.config.render");
        addBooleanOption("hideShoulderParrot", rightX, y, "naiy.config.hideshoulderparrot");
        y += BUTTON_HEIGHT + PADDING;
        
        // 第六行
        addBooleanOption("hideHorseArmor", leftX, y, "naiy.config.hidehorsearmor");
        addBooleanOption("hideCatCollar", rightX, y, "naiy.config.hidecatcollar");
        y += BUTTON_HEIGHT + PADDING;
        
        // 第七行
        addBooleanOption("hideWolfCollar", leftX, y, "naiy.config.hidewolfcollar");
        addBooleanOption("hideDolphinHeldItem", rightX, y, "naiy.config.hidedolphinhelditem");
        y += BUTTON_HEIGHT + PADDING;
        
        // 第八行
        addBooleanOption("hideFoxHeldItem", leftX, y, "naiy.config.hidefoxhelditem");
        addBooleanOption("hideEndermanBlock", rightX, y, "naiy.config.hideendermanblock");
        y += BUTTON_HEIGHT + PADDING;

        // Done button at the bottom
        this.addRenderableWidget(Button.builder(
            Component.translatable("naiy.config.done"),
            (button) -> this.minecraft.setScreen(this.parent))
            .pos(this.width / 2 - 100, this.height - 27)
            .size(200, 20)
            .build());
    }

    private void addCategoryLabel(int x, int y, String translationKey) {
        if (this.minecraft != null) {
            GuiGraphics graphics = new GuiGraphics(this.minecraft, this.minecraft.renderBuffers().bufferSource());
            graphics.drawString(this.font, Component.translatable(translationKey), x, y, 0xFFFFFF);
        }
    }

    private void addBooleanOption(String optionName, int x, int y, String translationKey) {
        boolean currentValue = false;
        try {
            currentValue = NAIY.getConfig().getClass().getField(optionName).getBoolean(NAIY.getConfig());
        } catch (Exception e) {
            // 如果获取字段失败，使用默认值 false
        }

        final boolean finalCurrentValue = currentValue;
        this.addRenderableWidget(CycleButton.onOffBuilder(finalCurrentValue)
            .create(
                x, y,
                BUTTON_WIDTH, BUTTON_HEIGHT,
                Component.translatable(translationKey),
                (button, value) -> {
                    try {
                        NAIY.getConfig().getClass().getField(optionName).set(NAIY.getConfig(), value);
                    } catch (Exception e) {
                        // 如果设置字段失败，记录错误但不中断程序
                        e.printStackTrace();
                    }
                }
            ));
    }

    public static void register() {
        ModLoadingContext.get().registerExtensionPoint(
            ConfigScreenHandler.ConfigScreenFactory.class,
            () -> new ConfigScreenHandler.ConfigScreenFactory(
                (mc, screen) -> new NAIYConfigScreen(screen)
            )
        );
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, 15, 0xFFFFFF);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics) {
        super.renderBackground(guiGraphics);
    }
}
