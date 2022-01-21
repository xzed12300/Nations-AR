package net.mcreator.nar.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.block.BlockState;

import net.mcreator.nar.NarModVariables;
import net.mcreator.nar.NarMod;

import java.util.Map;
import java.util.HashMap;

public class NationNameUpdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarMod.LOGGER.warn("Failed to load dependency world for procedure NationNameUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarMod.LOGGER.warn("Failed to load dependency x for procedure NationNameUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarMod.LOGGER.warn("Failed to load dependency y for procedure NationNameUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarMod.LOGGER.warn("Failed to load dependency z for procedure NationNameUpdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarMod.LOGGER.warn("Failed to load dependency entity for procedure NationNameUpdate!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				NarMod.LOGGER.warn("Failed to load dependency guistate for procedure NationNameUpdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if (!world.isRemote()) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putString("nname", (new Object() {
					public String getText() {
						TextFieldWidget _tf = (TextFieldWidget) guistate.get("text:cname");
						if (_tf != null) {
							return _tf.getText();
						}
						return "";
					}
				}.getText()));
			if (world instanceof World)
				((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if ((NarModVariables.MapVariables.get(world).dbug).equals("true")) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Name Set"), (false));
			}
		}
	}
}
