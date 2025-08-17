package com.Lenvill;

@net.minecraftforge.common.config.Config(modid = MFRLegacyFeatures.MODID)
public class Config {

    @net.minecraftforge.common.config.Config.Comment("Zyrridium Vein Size")
    public static int zyrridiumSize = 8;

    @net.minecraftforge.common.config.Config.Comment("Zyrridium Frequency Max")
    public static int zyrridiumFrequencyMax = 8;

    @net.minecraftforge.common.config.Config.Comment("Zyrridium Frequency Min")
    public static int zyrridiumFrequencyMin = 8;

    @net.minecraftforge.common.config.Config.Comment("Zyrridium Layer Max")
    public static int zyrridiumLayerMax = 96;

    @net.minecraftforge.common.config.Config.Comment("Zyrridium Layer Min")
    public static int zyrridiumLayerMin = 8;

    @net.minecraftforge.common.config.Config.Comment("Zyrridium Rarity")
    public static float zyrridiumRarity = 1.0f;

    @net.minecraftforge.common.config.Config.Comment("Tool for debugging")
    public static boolean advancedLogging = false;
}
