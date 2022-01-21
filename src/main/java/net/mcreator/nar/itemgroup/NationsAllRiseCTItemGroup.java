
package net.mcreator.nar.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.nar.item.NationsAllRiseTokenItem;
import net.mcreator.nar.NarModElements;

@NarModElements.ModElement.Tag
public class NationsAllRiseCTItemGroup extends NarModElements.ModElement {
	public NationsAllRiseCTItemGroup(NarModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnations_all_rise_ct") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NationsAllRiseTokenItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
