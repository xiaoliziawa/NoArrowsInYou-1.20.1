package net.prizowo.noarrowsinyou.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class NAIYConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    private static NAIYConfig INSTANCE;

    // 实际存储的值
    public boolean onlyLocal = true;
    public boolean hideArrows = true;
    public boolean hideStings = true;
    public boolean hideArmor = false;
    public boolean hideHeldItem = false;
    public boolean hideHead = false;
    public boolean hideElytra = false;
    public boolean hideRiptide = false;
    public boolean render = true;
    public boolean hideShoulderParrot = false;
    public boolean hideHorseArmor = false;
    public boolean hideCatCollar = false;
    public boolean hideWolfCollar = false;
    public boolean hideDolphinHeldItem = false;
    public boolean hideFoxHeldItem = false;
    public boolean hideEndermanBlock = false;
    public boolean rightArm = true;
    public boolean leftArm = true;
    public boolean resize = false;
    public int resX = 1;
    public int resY = 1;
    public int resZ = 1;

    // ForgeConfigSpec 值
    private final ForgeConfigSpec.BooleanValue onlyLocalSpec;
    private final ForgeConfigSpec.BooleanValue hideArrowsSpec;
    private final ForgeConfigSpec.BooleanValue hideStingsSpec;
    private final ForgeConfigSpec.BooleanValue hideArmorSpec;
    private final ForgeConfigSpec.BooleanValue hideHeldItemSpec;
    private final ForgeConfigSpec.BooleanValue hideHeadSpec;
    private final ForgeConfigSpec.BooleanValue hideElytraSpec;
    private final ForgeConfigSpec.BooleanValue hideRiptideSpec;
    private final ForgeConfigSpec.BooleanValue renderSpec;
    private final ForgeConfigSpec.BooleanValue hideShoulderParrotSpec;
    private final ForgeConfigSpec.BooleanValue hideHorseArmorSpec;
    private final ForgeConfigSpec.BooleanValue hideCatCollarSpec;
    private final ForgeConfigSpec.BooleanValue hideWolfCollarSpec;
    private final ForgeConfigSpec.BooleanValue hideDolphinHeldItemSpec;
    private final ForgeConfigSpec.BooleanValue hideFoxHeldItemSpec;
    private final ForgeConfigSpec.BooleanValue hideEndermanBlockSpec;
    private final ForgeConfigSpec.BooleanValue rightArmSpec;
    private final ForgeConfigSpec.BooleanValue leftArmSpec;
    private final ForgeConfigSpec.BooleanValue resizeSpec;
    private final ForgeConfigSpec.IntValue resXSpec;
    private final ForgeConfigSpec.IntValue resYSpec;
    private final ForgeConfigSpec.IntValue resZSpec;

    static {
        BUILDER.push("General");
        INSTANCE = new NAIYConfig(BUILDER);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    private NAIYConfig(ForgeConfigSpec.Builder builder) {
        onlyLocalSpec = builder.comment("Only affect local player").define("onlyLocal", onlyLocal);
        hideArrowsSpec = builder.define("hideArrows", hideArrows);
        hideStingsSpec = builder.define("hideStings", hideStings);
        hideArmorSpec = builder.define("hideArmor", hideArmor);
        hideHeldItemSpec = builder.define("hideHeldItem", hideHeldItem);
        hideHeadSpec = builder.define("hideHead", hideHead);
        hideElytraSpec = builder.define("hideElytra", hideElytra);
        hideRiptideSpec = builder.define("hideRiptide", hideRiptide);
        renderSpec = builder.define("render", render);
        hideShoulderParrotSpec = builder.define("hideShoulderParrot", hideShoulderParrot);
        hideHorseArmorSpec = builder.define("hideHorseArmor", hideHorseArmor);
        hideCatCollarSpec = builder.define("hideCatCollar", hideCatCollar);
        hideWolfCollarSpec = builder.define("hideWolfCollar", hideWolfCollar);
        hideDolphinHeldItemSpec = builder.define("hideDolphinHeldItem", hideDolphinHeldItem);
        hideFoxHeldItemSpec = builder.define("hideFoxHeldItem", hideFoxHeldItem);
        hideEndermanBlockSpec = builder.define("hideEndermanBlock", hideEndermanBlock);
        rightArmSpec = builder.define("rightArm", rightArm);
        leftArmSpec = builder.define("leftArm", leftArm);
        resizeSpec = builder.define("resize", resize);
        resXSpec = builder.defineInRange("resX", resX, 1, 100);
        resYSpec = builder.defineInRange("resY", resY, 1, 100);
        resZSpec = builder.defineInRange("resZ", resZ, 1, 100);
    }

    public static void register() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, SPEC);
    }

    public static NAIYConfig get() {
        return INSTANCE;
    }

    // Getter methods
    public boolean onlyLocal() { return onlyLocal; }
    public boolean hideArrows() { return hideArrows; }
    public boolean hideStings() { return hideStings; }
    public boolean hideArmor() { return hideArmor; }
    public boolean hideHeldItem() { return hideHeldItem; }
    public boolean hideHead() { return hideHead; }
    public boolean hideElytra() { return hideElytra; }
    public boolean hideRiptide() { return hideRiptide; }
    public boolean render() { return render; }
    public boolean hideShoulderParrot() { return hideShoulderParrot; }
    public boolean hideHorseArmor() { return hideHorseArmor; }
    public boolean hideCatCollar() { return hideCatCollar; }
    public boolean hideWolfCollar() { return hideWolfCollar; }
    public boolean hideDolphinHeldItem() { return hideDolphinHeldItem; }
    public boolean hideFoxHeldItem() { return hideFoxHeldItem; }
    public boolean hideEndermanBlock() { return hideEndermanBlock; }
    public boolean rightArm() { return rightArm; }
    public boolean leftArm() { return leftArm; }
    public boolean resize() { return resize; }
    public int resX() { return resX; }
    public int resY() { return resY; }
    public int resZ() { return resZ; }
}
