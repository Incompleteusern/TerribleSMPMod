package me.Incompleteusern.BrianSMP.common;

import net.fabricmc.api.ModInitializer;
import me.Incompleteusern.BrianSMP.common.init.BrianSMPBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrianSMPMod implements ModInitializer {

	public static String MODID = "brian-smp";

	public static String BRIAN_UUID = "302db6f5-5155-4ca4-8b94-8211544c0c7a";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {


		BrianSMPBlocks.init();
	}
}
