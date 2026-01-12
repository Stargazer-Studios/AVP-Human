# v0.1.2

## ✍️ Developer Notes
- For help or other questions, concerns, etc. check out our Discord server: https://discord.gg/wp7mvmbkVb

## ✨ What's New
- WY commando armor can now be dyed.
- WY elite armor can now be dyed.
- Marines can now equip any armor given to them so long as it is better than their currently equipped armor.
  - Marines by default spawn with a full set of either tactical armor or tactical camo armor.
- Added wy commando armor item textures.
  - Thanks to Davianortis for contributing these!

## ♻️ Changes
- Updated wy commando armor model/textures.
- Updated wy elite armor model/textures.
- Reduced accuracy required for marines to pathfind to fire resistance items.
- Reduced accuracy required for marines to pathfind to weapon items.
- Marine aggression towards mobs is now controlled by the `#avp_human:hated_by_marines` entity type tag.
- Marines will now target mobs under any of the following conditions:
  - The mob is part of the `#avp_human:hated_by_marines` entity type tag.
  - The mob is targeting them.
  - The mob is targeting their leader (if they have a leader).
  - The mob is targeting an allied marine (a marine with no leader or the same leader).
  - The mob was attacked by their leader (if they have a leader).

## 🐞 Fixes
- Fixed "lastHurtMob" field not being set when entities shoot mobs with guns.
- Fixed marines not using a full nether chitin armor set to prevent fire damage.
- Fixed marines not using a full nether chitin armor set to prevent lava damage.
- Fixed marines not attacking the closest monsters to them first.
- Fixed marines not looking at their target when using a melee weapon.
- Fixed marines not accounting for sharpness on melee weapons.
- Fixed marines not switching to the best melee weapon they have.
- Fixed marines not picking up better melee weapons when one is nearby.
- Fixed marines trying to shoot at monsters through walls.
  - This led to them getting "stuck" in their combat AI.

## 🛠 Data Pack
- Added `#avp_human:hated_by_marines` entity type tag.
- Added `#avp_human:wy_commando_armor` item tag.
- Added `#avp_human:wy_elite_armor` item tag.
