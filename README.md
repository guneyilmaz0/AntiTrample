# AntiTrample

**AntiTrample** is a lightweight Nukkit plugin designed to prevent players and mobs from trampling crops. It provides configurable options to customize the behavior and messages.

## Features

- Prevents players and mobs from trampling crops.
- Configurable bypass permission for players.
- Customizable warning message for players without permission.
- Optional sound effect when trampling is prevented.

## Installation

1. Download the plugin `.jar` file.
2. Place the `.jar` file in the `plugins` folder of your Nukkit server.
3. Restart or reload your server.

## Configuration

The plugin provides a `config.yml` file for customization. Below is the default configuration:

```yaml
# Permission node that allows players to bypass crop trampling prevention
bypass_permission: "antitrample.bypass"

# Whether to prevent mobs from trampling crops
prevent_mobs: true

# Message displayed to players without permission when they attempt to trample crops
# If you want to disable the message, set it to an empty string
message: "§cYou dont have permission to trample crops!"

# Whether to play a sound when crop trampling is prevented
# Sound: note.bass
sound: true