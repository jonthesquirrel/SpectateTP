# SpectateTP

This is a simple plugin to solve a simple problem.

Players can normally use spectator mode to teleport to anyone without permission (using the number keys). However, spectator mode can be useful, so disabling it shouldn't be the only option.

This plugin prevents players from teleporting using spectator mode, unless they have the permission: `spectate.tp`

The `deny-message` is configurable in the config. Set it to an empty string `''` to not send any message.

Known issues:
- Some spigot versions cause `PlayerTeleportEvent.TeleportCause` to return `UNKNOWN`, causing the plugin to not block teleportation. If this happens, update to the latest spigot jar.

**[Downloads (1.8)](https://github.com/lasercar/SpectateTP/releases) | [Spigot forum thread](https://www.spigotmc.org/resources/spectatetp.12003)**
