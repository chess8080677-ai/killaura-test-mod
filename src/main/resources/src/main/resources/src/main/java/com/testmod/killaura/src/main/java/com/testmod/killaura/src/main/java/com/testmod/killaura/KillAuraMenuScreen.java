package com.testmod.killaura;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class KillAuraMenuScreen extends Screen {

    public KillAuraMenuScreen() {
        super(Text.literal("KillAura Test Menu"));
    }

    @Override
    protected void init() {
        this.addDrawableChild(ButtonWidget.builder(
            Text.literal("KillAura: " + (KillAuraModule.killauraEnabled ? "ON" : "OFF")),
            btn -> {
                KillAuraModule.killauraEnabled = !KillAuraModule.killauraEnabled;
                btn.setMessage(Text.literal("KillAura: " + (KillAuraModule.killauraEnabled ? "ON" : "OFF")));
            }
        ).dimensions(this.width / 2 - 100, 60, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(
            Text.literal("Extended Reach: " + (KillAuraModule.reachEnabled ? "ON" : "OFF")),
            btn -> {
                KillAuraModule.reachEnabled = !KillAuraModule.reachEnabled;
                btn.setMessage(Text.literal("Extended Reach: " + (KillAuraModule.reachEnabled ? "ON" : "OFF")));
            }
        ).dimensions(this.width / 2 - 100, 90, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(
            Text.literal("Close"),
            btn -> this.close()
        ).dimensions(this.width / 2 - 100, 130, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 30, 0xFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
