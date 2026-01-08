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