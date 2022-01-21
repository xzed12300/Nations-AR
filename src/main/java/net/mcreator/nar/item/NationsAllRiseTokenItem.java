
package net.mcreator.nar.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.nar.itemgroup.NationsAllRiseCTItemGroup;
import net.mcreator.nar.NarModElements;

@NarModElements.ModElement.Tag
public class NationsAllRiseTokenItem extends NarModElements.ModElement {
	@ObjectHolder("nar:nations_all_rise_token")
	public static final Item block = null;

	public NationsAllRiseTokenItem(NarModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(NationsAllRiseCTItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("nations_all_rise_token");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
