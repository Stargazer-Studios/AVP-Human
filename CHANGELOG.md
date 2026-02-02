# v0.1.5

## ✍️ Developer Notes
- For help or other questions, concerns, etc. check out our Discord server: https://discord.gg/wp7mvmbkVb

## ☢️ Breaking Changes
- N/A

## ✨ What's New
- N/A

## ♻️ Changes
- WY ape armor is equal to titanium in terms of defense and toughness.
- WY Commando and WY Elite armors can now be repaired with plastic blocks in addition to steel ingots.

## 🐞 Fixes
- Fixed WY ape armor using lead for repair ingredients.
  - Titanium, padding blocks or plastic blocks can now be used for repair, instead.

## 🧪 Experimental
- N/A

## 🛠 Data Pack
- Added repair ingredient tags for all armors:
  - `avp_human:mk50_armor_repair_ingredients`.
  - `avp_human:pressure_armor_repair_ingredients`.
  - `avp_human:steel_armor_repair_ingredients`.
  - `avp_human:tactical_armor_repair_ingredients`.
  - `avp_human:titanium_armor_repair_ingredients`.
  - `avp_human:wy_commando_armor_repair_ingredients`.
  - `avp_human:wy_elite_armor_repair_ingredients`.

## 🔬 Technical Changes
- Property access now uses default values instead of throwing exceptions when properties are missing.
- Added `HumanProperty` record that couples property keys with their default values for simpler access.