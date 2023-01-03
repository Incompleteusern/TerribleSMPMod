package me.Incompleteusern.BrianSMP.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.Incompleteusern.BrianSMP.common.BrianSMPMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public final class Utils {

    public static UUID BRIAN_UUID = UUID.fromString("302db6f5-5155-4ca4-8b94-8211544c0c7a");

    public static GameProfile BRIAN_GAME_PROFILE = null;

    private Utils() {
    }

    public static boolean isBrian(Entity entity) {
        if (!(entity instanceof PlayerEntity player)) return false;
        return player.getUuid().equals(BRIAN_UUID);
    }

    @Nullable
    private static GameProfile getBrianGameProfile() {
        if (BRIAN_GAME_PROFILE != null) return BRIAN_GAME_PROFILE;

        String trimmedUUID = BRIAN_UUID.toString().replace("-", "");

        URL url;
        try {
            url = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + trimmedUUID);
        } catch (MalformedURLException e) {
            BrianSMPMod.LOGGER.warn("Failed to load Brian skull texture", e);
            return null;
        }

        GameProfile profile;
        try (InputStreamReader read = new InputStreamReader(url.openStream())) {
            JsonObject object = JsonParser.parseReader(read).getAsJsonObject();

            String name = object.get("name").getAsString();
            String texture = object.get("properties").getAsJsonArray().get(0).getAsJsonObject().get("value").getAsString();

            profile = new GameProfile(BRIAN_UUID, name);
            profile.getProperties().put("textures", new Property(null, texture));
        } catch (IOException e) {
            BrianSMPMod.LOGGER.warn("Failed to load Brian skull texture", e);
            return null;
        }

        BRIAN_GAME_PROFILE = profile;

        return profile;
    }

    public static ItemStack getBrianSkull() {
        ItemStack itemStack = Items.PLAYER_HEAD.getDefaultStack();

        GameProfile profile = getBrianGameProfile();

        if (profile != null) {
            NbtCompound skullData = new NbtCompound();
            NbtHelper.writeGameProfile(skullData, profile);
            itemStack.getOrCreateNbt().put("SkullOwner", skullData);
        }

        return itemStack;
    }
}
