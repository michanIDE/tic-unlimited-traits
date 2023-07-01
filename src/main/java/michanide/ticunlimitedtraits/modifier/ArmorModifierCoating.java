package michanide.ticunlimitedtraits.modifier;

import c4.conarm.lib.modifiers.ArmorModifierTrait;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.modifiers.TinkerGuiException;
import slimeknights.tconstruct.library.utils.TagUtil;

public class ArmorModifierCoating extends ArmorModifierTrait {
  
  public static final String EXTRA_TRAIT_IDENTIFIER = "extratrait";

  public ArmorModifierCoating() {
    super("armor.ticunlimitedtraits.coating", 0x777777, 32767, 1);

    addAspects(new CoatingAspect());
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
    NBTTagList modifierList = TagUtil.getModifiersTagList(rootCompound);
    for(int i = 0; i < modifierList.tagCount(); i++) {
        NBTTagCompound tag = modifierList.getCompoundTagAt(i);
        ModifierNBT data = ModifierNBT.readTag(tag);
        if(data.identifier.startsWith(EXTRA_TRAIT_IDENTIFIER)) {
          modifierList.removeTag(i);
        }
      }
  }

  private static class CoatingAspect extends ModifierAspect {

    @Override
    public boolean canApply(ItemStack stack, ItemStack original) throws TinkerGuiException {
      NBTTagList modifierList = TagUtil.getModifiersTagList(original);
      for(int i = 0; i < modifierList.tagCount(); i++) {
        NBTTagCompound tag = modifierList.getCompoundTagAt(i);
        ModifierNBT data = ModifierNBT.readTag(tag);
        if(data.identifier.startsWith(EXTRA_TRAIT_IDENTIFIER)) {
          return true;
        }
      }
      throw new TinkerGuiException(Util.translate("gui.error.armor.ticunlimitedtraits.coating_no_extratrait"));
    }

    @Override
    public void updateNBT(NBTTagCompound root, NBTTagCompound modifierTag) {
      // nothing to do
    }


  }
}
