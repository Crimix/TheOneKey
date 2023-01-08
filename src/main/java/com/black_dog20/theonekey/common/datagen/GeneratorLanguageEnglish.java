package com.black_dog20.theonekey.common.datagen;

import com.black_dog20.bml.datagen.BaseLanguageProvider;
import com.black_dog20.theonekey.TheOneKey;
import net.minecraft.ChatFormatting;
import net.minecraft.data.DataGenerator;

import static com.black_dog20.theonekey.common.utils.Translations.*;

public class GeneratorLanguageEnglish extends BaseLanguageProvider {

    public GeneratorLanguageEnglish(DataGenerator gen) {
        super(gen, TheOneKey.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addPrefixed(KEY_CATEGORY, "The One Key");
        addPrefixed(KEY_ONE_KEY, "Active held item");
        addPrefixed(TOOLTIP_TO, "to");
        addPrefixed(TOOLTIP_SHOW, style("[", ChatFormatting.GRAY) + style("Left Alt", ChatFormatting.GOLD) + style("] to show TheOneKey keys", ChatFormatting.GRAY));
        addPrefixed(TOOLTIP_PROVIDED, "Keys provided by TheOneKey", ChatFormatting.WHITE);
    }

    @Override
    public String getName() {
        return "The One Key: Languages: en_us";
    }
}
