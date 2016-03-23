# SpectateTP

[![Join the chat at https://gitter.im/lasercar/SpectateTP](https://badges.gitter.im/lasercar/SpectateTP.svg)](https://gitter.im/lasercar/SpectateTP?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[!Build Status](https://travis-ci.org/lasercar/SpectateTP.svg)
[![Stories in Ready](https://badge.waffle.io/lasercar/SpectateTP.png?label=ready&title=Ready)](https://waffle.io/lasercar/SpectateTP)

This is a simple plugin to solve a simple problem.

Players can normally use spectator mode to teleport to anyone without permission (using the number keys). However, spectator mode can be useful, so disabling it shouldn't be the only option.

This plugin prevents players from teleporting using spectator mode, unless they have permission.

Config:
- `deny-message` - The message users get if they teleport using spectator mode without having the permission. Set to an empty string `''` to not send a message.

Permissions:
- `spectatetp.tp` - can teleport using spectator mode
- `spectatetp.reload` - can reload the config file

Commands:
- `/spectatetp-reload` - reloads the config file

Known issues:
- Some spigot versions cause `PlayerTeleportEvent.TeleportCause` to return `UNKNOWN` when it should return `SPECTATE`, causing the teleport blocking to not work. If this happens, update to the latest spigot jar.

Changelog:

`1.1`
- built jar properly to reduce size dramatically

`1.1.1`
- small speed optimization

`1.2.0`
- added command to reload config
- if deny-message is empty string, sends no message instead of blank message

**[Downloads (1.8)](https://github.com/lasercar/SpectateTP/releases) | [Spigot forum thread](https://www.spigotmc.org/resources/spectatetp.12003)**
