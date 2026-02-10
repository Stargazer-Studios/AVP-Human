# v0.1.6

## ✍️ Developer Notes
- For help or other questions, concerns, etc. check out our Discord server: https://discord.gg/wp7mvmbkVb

## 🐞 Fixes
- Fixed industrial concrete, industrial glass and plastic not being included in the `#avp_alien:xenomorph_immune` block tag.

# v0.1.5

## ✍️ Developer Notes
- For help or other questions, concerns, etc. check out our Discord server: https://discord.gg/wp7mvmbkVb

## ☢️ Breaking Changes
- N/A

## ✨ What's New
- Added hazard and safety plastic blocks with stairs, slab, and wall variants:
    - Aisle Hazard Plastic
    - Alien Hazard Plastic
    - Fire Hazard Plastic
    - Hazard Plastic
    - Machine Hazard Plastic
    - Radiation Hazard Plastic
    - Safety Plastic
    - Traffic Hazard Plastic

## ♻️ Changes
- WY ape armor is now equal to titanium in terms of defense and toughness.
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

# v0.1.4

## ✍️ Developer Notes
- For help or other questions, concerns, etc. check out our Discord server: https://discord.gg/wp7mvmbkVb

## ✨ What's New
- Added crafting recipes for WY Ape armor (helmet, chestplate, leggings, boots).
- Added full WY Ape armor set bonus: grants Fire Resistance while wearing the complete set.

## ♻️ Changes
- Renamed "Ape" armor to "WY Ape" armor (e.g., "Ape Boots" is now "WY Ape Boots").
- Simplified WY Commando Boots recipe to a single recipe instead of 16 dye-color variants.
- Moved armor set bonus effects (MK50, Pressure, WY Ape) from mixin to event-based system.

## 🐞 Fixes
- Fixed WY Commando Boots and WY Elite Boots having the same recipes.

## 🛠 Data Pack
- Added `avp_human:padding_blocks` item tag containing all colored padding blocks.
- Added `avp_human:plastic_blocks` item tag containing all colored plastic blocks.
- Added `avp_human:wy_ape_armor` item tag containing all WY Ape armor pieces.

# v0.1.3

## ✍️ Developer Notes
- For help or other questions, concerns, etc. check out our Discord server: https://discord.gg/wp7mvmbkVb

## 🐞 Fixes
- Fixed ape suit helmet not being facehugger-resistant.
- Fixed industrial glass not being immune to `AVP: Alien` acid.
- Fixed plastic not being immune to `AVP: Alien` acid.

# v0.1.2

## ✍️ Developer Notes
- For help or other questions, concerns, etc. check out our Discord server: https://discord.gg/wp7mvmbkVb

## ✨ What's New
- AzureLib is no longer required.
- BLib 0.2.0+ is now required.
- WY commando armor can now be dyed.
- WY elite armor can now be dyed.
- Added cornbread item.
- Added dog tag item.
- Overhauled marine patrol spawning system:
    - There are now 7 different types of marine patrols:
        - **Marines**: The backbone of the USCM. Equipped with standard gear and occasionally wolves, these marines are well-trained for any standard colonial op. Gear includes:
            - Battle Rifles
            - Shotguns
            - Combat Pistols
            - Tactical Knives
            - Grenades
            - Cornbread
            - Dog Tags (exclusive)
            - Bones (exclusive)
            - Wolves (exclusive)
                - 0 to 3 wolves can spawn with regular marine squads.
                - The wolves will always have wolf armor equipped.
                - Wolves owned by marines will always have their collars dyed green.
        - **Tactical Marines**: The USCM's finest. Equipped with camo armor and extra firepower, these marines are rigorously trained for colonial ops that require a little extra "care". Gear includes:
            - 128x Torches
            - Sniper Rifles
            - Water Buckets
            - Dog Tags (exclusive)
            - And all other gear that regular marines can have.
        - **WY Ape Suits**: Weyland-Yutani's best for torch-and-burn ops. Gear includes:
            - Pulse Rifles
            - 2x Potions of Fire Resistance
            - 2x Splash Potions of Fire Resistance
            - Flamethrowers (exclusive)
            - And all other gear that regular marines and tactical marines can have.
        - **WY Commandos**: Weyland-Yutani's personal problem solvers. If a person or organization poses a threat Weyland-Yutani's bottom line, these boys will deal with them... permanently. Gear includes:
            - 1x Totem of Undying
            - 4x Golden Apples
            - Splash Potion of Instant Healing
            - Splash Potion of Regeneration
            - And all other gear that regular marines, tactical marines and WY ape suits can have.
        - **WY Elite**: The core of Weyland-Yutani's facility defenses. The elites handle defense ops better than most others, second only to their spec-ops counterparts. Gear includes:
            - 8x Golden Apples
            - And all other gear that regular marines, tactical marines, WY ape suits and WY commandos can have.
        - **WY Spec-Ops Commandos**: Elite even amongst regular commandos. It's unclear if they even exist, as Weyland-Yutani hardly ever calls upon them. Gear includes:
            - 2x Totem of Undying
            - 4x Enchanted Golden Apples
            - Splash Potion of Invisibility
            - And all other gear that regular marines, tactical marines, WY ape suits, WY commandos and WY elites can have.
        - **WY Spec-Ops Elite**: The best of the best that Weyland-Yutani has to offer. Gear includes:
            - 8x Enchanted Golden Apples
            - Smartguns (exclusive)
            - Rocket Launchers (exclusive)
            - Old Painless (exclusive)
            - And all other gear that regular marines, tactical marines, WY ape suits, WY commandos, WY elites and WY spec-ops commandos can have.
- Marines can now equip any armor given to them so long as it is better than their currently equipped armor.
- Marines can now use healing items to heal themselves:
    - Marines can now be given most healing items by players.
    - Marines can now pick up most healing items off the ground.
    - Marines will prefer to heal themselves once they are at 50% health or lower.
    - The following healing items can be used by marines:
        - Potion of Instant Health
        - Splash Potion of Instant Health
        - Lingering Potion of Instant Health
        - Potion of Regeneration
        - Splash Potion of Regeneration
        - Lingering Potion of Regeneration
        - Honey Bottles
        - Any other food items (including but not limited to rotten flesh, poisonous potatoes, golden apples and enchanted golden apples)
- Marines can now use water buckets to clutch landings:
    - When marines have a water bucket and are falling, they will equip the water bucket and break their fall with water.
    - Because marines can break their fall with water, they will take faster routes and riskier falls to get to places quicker.
    - If the marine is moving too fast, they will not be able to save themselves with a water bucket in time.
        - This means that at a certain fall distance, they will surely die from fall damage.
        - Please be nice to the marines and definitely don't push them off of cliffs for science.
- Marines can now use totems of undying:
    - Marines can now be given totems of undying by players.
    - Marines can now pick up totems of undying off the ground.
    - By default, marines prefer to have at most 2 totems of undying.
    - When marines are near death (< 10% health), they will equip a totem of undying and keep it equipped.
    - When the marine is about to die, the totem of undying will function as if it were a player holding the totem, and the marine will survive.
- Marines can now use torches:
    - Marines can now be given torches by players.
    - Marines can now pick up torches off the ground.
    - By default, marines prefer to have at most 2 stacks of torches.
    - Marines will only place torches in dark places not exposed to the sky.
    - Marines prefer placing torches on walls. If they cannot do so, then they will place torches at their feet.
- Marines can now tame wolves with bones:
    - Marines can now be given bones by players.
    - Marines can now pick up bones off the ground.
    - By default, marines prefer to have at most a stack of bones.
    - If an untamed wolf is nearby, marines will try to tame it if they have bones on-hand.
    - If marines have no leader or their leader is a marine, the wolf they tamed will belong to them and not their leader.
    - If marines are following a player and tame a wolf, the wolf they tame will belong to the player.
        - The player MUST be present in the game for the tamed wolf to belong to the player. Otherwise, the wolf will belong to the marine that tamed them.
- Added wy commando armor item textures.
    - Thanks to Davianortis for contributing these!
- Added wy elite armor item textures.
    - Thanks to Davianortis for contributing these!

## ♻️ Changes
- Updated wy commando armor model/textures.
- Updated wy elite armor model/textures.
- Reduced accuracy required for marines to pathfind to fire resistance items.
- Reduced accuracy required for marines to pathfind to weapon items.
- Marine aggression towards mobs is now controlled by the `#avp_human:hated_by_marines` entity type tag.
- Reduced marine nearby biome detection radius (16 -> 4).
- The radiation effect has been reworked:
    - Radiation no longer ramps up to higher amplifiers over time.
    - Radiation instead now has an "incubation period" of 20% of the duration.
        - If you get radiation for 5 minutes, then for 1 minute nothing bad will happen to you.
        - If you get radiation for 10 minutes, then the incubation period is 2 minutes.
    - After the incubation period has elapsed, you will start to slowly take damage.
    - The damage ramps up until 80% of the way through the effect's duration, where the damage is at its peak.
    - After 80% of the duration has elapsed, the damage will slowly ramp back down until the effect goes away.
    - The duration of the radiation depends on the source:
        - If you touch radioactive items or have radioactive items in your inventory, you get a radioactive dose of 1 minute.
        - If you touch radioactive blocks in the world, you get a larger radioactive dose of 2.5 minutes.
        - If you walk around in a radioactive biome, you get a larger radioactive dose of 5 minutes.
    - The amplifier of the effect controls how much damage is dealt each damage tick. It also controls what side effects are given.
        - An amplifier of 0 will give weakness and hunger.
        - An amplifier of 1 will also give slowness in addition to the side effects given with an amplifier of 0.
        - An amplifier of 2 will also give blindness in addition to the side effects given with an amplifier of 1.
        - Currently amplifier is not used anywhere in the mod at the moment, but may in the near-future.
- Marines will now target mobs under any of the following conditions:
    - The mob is part of the `#avp_human:hated_by_marines` entity type tag.
    - The mob is targeting them.
    - The mob is targeting their leader (if they have a leader).
    - The mob is targeting an allied marine (a marine with no leader or the same leader).
    - The mob was attacked by their leader (if they have a leader).

## 🐞 Fixes
- [NeoForge] Fixed weapon blueprints not generating in vanilla structures.
- Fixed radiation effect sometimes causing a crash when the player pauses the game.
- Fixed radiation effect having an untranslated name.
- Fixed marine pathfinding sometimes getting stuck.
- Fixed marines trying to attack invulnerable targets.
- Fixed marines not playing a pickup animation when picking up items.
- Fixed marine item consume cooldown not resetting after first consume.
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
- Fixed numerous bugs with gun animations:
    - Fixed gun animations locking up after holding fire and then releasing.
    - Fixed muzzle flashes on guns sometimes getting stuck for players and marines.
    - Fixed muzzle flashes not showing when guns are shot.

## 🛠 Data Pack
- Added `#avp_human:has_marine_patrols` biome tag.
- Added `#avp_human:has_tactical_marine_patrols` biome tag.
- Added `#avp_human:has_wy_ape_patrols` biome tag.
- Added `#avp_human:has_wy_commando_patrols` biome tag.
- Added `#avp_human:has_wy_elite_patrols` biome tag.
- Added `#avp_human:has_wy_spec_ops_commando_patrols` biome tag.
- Added `#avp_human:has_wy_spec_ops_elite_patrols` biome tag.
- Added `#avp_human:hated_by_marines` entity type tag.
- Added `#avp_human:wy_commando_armor` item tag.
- Added `#avp_human:wy_elite_armor` item tag.

# v0.1.1

## ✍️ Developer Notes
- For help or other questions, concerns, etc. check out our Discord server: https://discord.gg/wp7mvmbkVb

## ✨ What's New
- AzureLib 3.1.3 is now required.
- [Fabric] Fabric Loader 0.18.4 is now required.
- [NeoForge] NeoForge 21.1.217 is now required.
- Pressure suits are now dyeable.


# v0.1.0

## ✍️ Developer Notes
- For help or other questions, concerns, etc. check out our Discord server: https://discord.gg/wp7mvmbkVb

## ☢️ Breaking Changes
- N/A

## ✨ What's New
- Marines can now be hired using diamonds.
    - Marines can be given items once they are hired. These items include:
        - Fire resistance items
        - Guns/Weapons
        - Water buckets
    - See more details below about how the marines use these items!
- Added an advancement for hiring marines called 'Fresh Meat'.
- Marines can now spawn with the following weapons:
    - F903WE Sniper Rifle
    - Flamethrower (Sevastopol)
    - M41A Pulse Rifle
    - M56 Smartgun
    - M6B Rocket Launcher
    - ZX-76 Shotgun
- Marines can now be given guns.
- Marines can now be given and use armor items:
    - Marines will now automatically figure out what armor is best to wear depending on their situation.
    - If on fire, marines will try to equip armors that automatically give fire resistance (alien nether chitin armor sets).
        - Marines will only equip these armors if they have a full set of either armor type.
    - If near a radioactive biome, marines will try to equip armors that grant radiation immunity (MK50).
        - Marines will only equip the MK50 if they have the full set.
    - If under water, marines will equip a pressure suit or MK50 to breathe infinitely.
        - Marines will only equip these armors if they have a full set of either armor type.
- Marines can now be given and use fire resistance items. The following are valid strategies for the marine to use:
    - Drinkable potion of fire resistance
    - Lingering potion of fire resistance
    - Splash potion of fire resistance
    - Golden apples (which grant fire resistance)
- Marines can now be given a water bucket to extinguish themselves if they are on fire.
- Added a new texture for the marine spawn egg item.
    - Thanks to Danlogo for contributing the texture!

## ♻️ Changes
- Marines now use guns as if they were players.
    - This means marines will run out of ammunition.
- Marines now spawn with ammunition in their guns.
- Marines now spawn with multiple weapons instead of just 1.
    - Marines will always spawn with a primary gun which is any gun other than the combat pistol.
    - Marines now always spawn with a combat pistol as their secondary gun.
    - Marines now also spawn with a melee weapon (iron sword or iron axe) if their guns run out of ammunition.
- Guns enchanted with infinity now still need to be reloaded, but no longer consume bullets.
- Guns enchanted with piercing now deal reduced damage with each pierce (-20% damage each pierce).
- Increased pulse rifle cooldown (4 -> 10 ticks).
- Increased pistol cooldown (4 -> 5 ticks).
- Decreased pistol damage (5 -> 3 half-hearts).
- Resin blocks can no longer be smelted in the industrial furnace.
    - This was an unintended 'feature' that was added. We'll have faster ways to smelt resin in the near future!

## 🐞 Fixes
- Fixed marine camps sometimes generating in water.

## 🧪 Experimental
- N/A

## 🛠 Data Pack
- Added `#avp_human:plastic` item tag.

## 🔬 Technical Changes
- N/A