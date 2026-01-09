# v0.1.2

## ✍️ Developer Notes
- For help or other questions, concerns, etc. check out our Discord server: https://discord.gg/wp7mvmbkVb

## ☢️ Breaking Changes
- N/A

## ✨ What's New
- Added wy commando armor item textures.
  - Thanks to Davianortis for contributing these!

## ♻️ Changes
- Reduced accuracy required for marines to pathfind to fire resistance items.
- Reduced accuracy required for marines to pathfind to weapon items.
- Marine aggression towards mobs is now controlled by the `#avp_human:hated_by_marines` entity type tag.
- Marines will now target mobs under any of the following conditions:
  - The mob is part of the `#avp_human:hated_by_marines` entity type tag.
  - The mob is targeting them.
  - The mob is targeting their leader (if they have a leader).
  - The mob was attacked by their leader (if they have a leader).

## 🐞 Fixes
- Fixed marines not using a full nether chitin armor set to prevent fire damage.
- Fixed marines not attacking the closest monsters to them first.
- Fixed marines trying to shoot at monsters through walls.
  - This led to them getting "stuck" in their combat AI.

## 🧪 Experimental
- N/A

## 🛠 Data Pack
- Added `#avp_human:hated_by_marines` entity type tag.

## 🔬 Technical Changes
- N/A