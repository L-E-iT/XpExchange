package com.branwidth.xpexchange;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.ChatColor.*;


public class TestCommand implements CommandExecutor{


    private ConfigurationSection sec = Main.getPlugin().getConfig().getConfigurationSection("effect-exchanges");
    // Setting the configuration section 'sec' to the effect-exchange section

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player p = (Player) sender; // Setting the sender to the player value
        int playerLevel = p.getLevel(); // Checking the player level and saving the value

        if(args.length == 1){ // Checking for arguments on the command
            String effectName = args[0]; // Setting the argument to a lowercase
            // Check player level for cost, needs to be moved for each individual effect.
                switch (effectName) {
                    case "list":
                        sender.sendMessage(AQUA + "== Effect Menu ==");
                        int count = 0;
                        for (String key : sec.getKeys(false)) { // For each key value in the 'sec' section of the config file, each key is an effect
                            String enabled = Main.getPlugin().getConfig().getString("effect-exchanges." + key + ".enabled");
                            String cost = Main.getPlugin().getConfig().getString("effect-exchanges." + key + ".cost");
                            int duration = (Main.getPlugin().getConfig().getInt("effect-exchanges." + key + ".duration"))/20;

                            // Obtaining the enabled value from the 'key' specified in the for each.  each key is an effect in the list
                            count++;
                            if (enabled.equals("true")) { // Checking for the enabled field to be either true or false
                                TextComponent messageKey = new TextComponent(count +": " + key);
                                messageKey.setColor(ChatColor.WHITE);
                                TextComponent messageCost = new TextComponent(" | Cost: " + cost + " Levels ");
                                messageCost.setColor(ChatColor.DARK_AQUA);
                                TextComponent messageDuration = new TextComponent("| Duration: " + duration + " seconds");
                                messageDuration.setColor(ChatColor.DARK_GREEN);
//                                TextComponent message = new TextComponent(count + ": "+ key + " | Cost: " + cost + " Levels | Duration: " + duration + " seconds");
                                messageKey.addExtra(messageCost);
                                messageKey.addExtra(messageDuration);
                                messageKey.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/xpexchange " + key));
                                messageKey.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click Here to Exchange for " + key + " !").create() ));
                                p.spigot().sendMessage(messageKey);
                                //sender.sendMessage(ChatColor.RED + key); // Sending a message to the user with the enabled effects
                                // Add an array here and add the enabled effects to the array.
                                // Use this array to handle what effects can be used by the user.
                                // Use a switch and case to handle inputs by the user.
                            }
                        }
                        break;
                    case "ABSORPTION":
                        int absorptionCost = Main.getPlugin().getConfig().getInt("effect-exchanges.ABSORPTION.cost");
                        int absorptionDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.ABSORPTION.duration");
                        boolean absorptionEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.ABSORPTION.enabled");
                        if (playerLevel >= absorptionCost && absorptionEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, absorptionDuration, absorptionCost));
                            p.setLevel(p.getLevel() - absorptionCost);
                            sender.sendMessage(RED + "You feel Invincible!");
                        } else {
                            break;
                        }
                        break;
                    case "BLINDNESS":
                        int blindnessCost = Main.getPlugin().getConfig().getInt("effect-exchanges.BLINDNESS.cost");
                        int blindnessDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.BLINDNESS.duration");
                        boolean blindnessEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.BLINDNESS.enabled");
                        if (playerLevel >= blindnessCost && blindnessEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, blindnessDuration, blindnessCost));
                            p.setLevel(p.getLevel() - blindnessCost);
                            sender.sendMessage(RED + "You feel Blind!");
                        } else {
                            break;
                        }
                        break;
                    case "CONFUSION":
                        int confusionCost = Main.getPlugin().getConfig().getInt("effect-exchanges.CONFUSION.cost");
                        int confusionDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.CONFUSION.duration");
                        boolean confusionEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.CONFUSION.enabled");
                        if (playerLevel >= confusionCost && confusionEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, confusionDuration, confusionCost));
                            p.setLevel(p.getLevel() - confusionCost);
                            sender.sendMessage(RED + "You feel Confused!");
                        } else {
                            break;
                        }
                        break;
                    case "DAMAGE_RESISTANCE":
                        int damageResistanceCost = Main.getPlugin().getConfig().getInt("effect-exchanges.DAMAGE_RESISTANCE.cost");
                        int damageResistanceDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.DAMAGE_RESISTANCE.duration");
                        boolean damageResistanceEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.DAMAGE_RESISTANCE.enabled");
                        if (playerLevel >= damageResistanceCost && damageResistanceEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, damageResistanceDuration, damageResistanceCost));
                            p.setLevel(p.getLevel() - damageResistanceCost);
                            sender.sendMessage(RED + "You feel Resistant!");
                        } else {
                            break;
                        }
                        break;
                    case "FAST_DIGGING":
                        int fastDiggingCost = Main.getPlugin().getConfig().getInt("effect-exchanges.FAST_DIGGING.cost");
                        int fastDiggingDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.FAST_DIGGING.duration");
                        boolean fastDiggingEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.FAST_DIGGING.enabled");
                        if (playerLevel >= fastDiggingCost && fastDiggingEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, fastDiggingDuration, fastDiggingCost));
                            p.setLevel(p.getLevel() - fastDiggingCost);
                            sender.sendMessage(RED + "You feel more Dextrious!");
                        } else {
                            break;
                        }
                        break;
                    case "FIRE_RESISTANCE":
                        int fireResistanceCost = Main.getPlugin().getConfig().getInt("effect-exchanges.FIRE_RESISTANCE.cost");
                        int fireResistanceDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.FIRE_RESISTANCE.duration");
                        boolean fireResistanceEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.FIRE_RESISTANCE.enabled");
                        if (playerLevel >= fireResistanceCost && fireResistanceEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, fireResistanceDuration, fireResistanceCost));
                            p.setLevel(p.getLevel() - fireResistanceCost);
                            sender.sendMessage(RED + "You feel Immune to Fire!");
                        } else {
                            break;
                        }
                        break;
                    case "GLOWING":
                        int glowingCost = Main.getPlugin().getConfig().getInt("effect-exchanges.GLOWING.cost");
                        int glowingDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.GLOWING.duration");
                        boolean glowingEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.GLOWING.enabled");
                        if (playerLevel >= glowingCost && glowingEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, glowingDuration, glowingCost));
                            p.setLevel(p.getLevel() - glowingCost);
                            sender.sendMessage(RED + "You feel Bright!");
                        } else {
                            break;
                        }
                        break;
                    case "HARM":
                        int harmCost = Main.getPlugin().getConfig().getInt("effect-exchanges.HARM.cost");
                        int harmDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.HARM.duration");
                        boolean harmEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.HARM.enabled");
                        if (playerLevel >= harmCost && harmEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.HARM, harmDuration, harmCost));
                            p.setLevel(p.getLevel() - harmCost);
                            sender.sendMessage(RED + "You feel Hurt!");
                        } else {
                            break;
                        }
                        break;
                    case "HEAL":
                        int healCost = Main.getPlugin().getConfig().getInt("effect-exchanges.HEAL.cost");
                        int healDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.HEAL.duration");
                        boolean healEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.HEAL.enabled");
                        if (playerLevel >= healCost && healEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, healDuration, healCost));
                            p.setLevel(p.getLevel() - healCost);
                            sender.sendMessage(RED + "You feel Healthy!");
                        } else {
                            break;
                        }
                        break;
                    case "HEALTH_BOOST":
                        int healthBoostCost = Main.getPlugin().getConfig().getInt("effect-exchanges.HEALTH_BOOST.cost");
                        int healthBoostDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.HEALTH_BOOST.duration");
                        boolean healthBoostEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.HEALTH_BOOST.enabled");
                        if (playerLevel >= healthBoostCost && healthBoostEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, healthBoostDuration, healthBoostCost));
                            p.setLevel(p.getLevel() - healthBoostCost);
                            sender.sendMessage(RED + "You feel Healthier than ever!");
                        } else {
                            break;
                        }
                        break;
                    case "HUNGER":
                        int hungryCost = Main.getPlugin().getConfig().getInt("effect-exchanges.HUNGER.cost");
                        int hungryDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.HUNGER.duration");
                        boolean hungryEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.HUNGER.enabled");
                        if (playerLevel >= hungryCost && hungryEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, hungryDuration, hungryCost));
                            p.setLevel(p.getLevel() - hungryCost);
                            sender.sendMessage(RED + "You feel Hungry!");
                        } else {
                            break;
                        }
                        break;
                    case "INCREASE_DAMAGE":
                        int increaseDamageCost = Main.getPlugin().getConfig().getInt("effect-exchanges.INCREASE_DAMAGE.cost");
                        int increaseDamageDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.INCREASE_DAMAGE.duration");
                        boolean increaseDamageEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.INCREASE_DAMAGE.enabled");
                        if (playerLevel >= increaseDamageCost && increaseDamageEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, increaseDamageDuration, increaseDamageCost));
                            p.setLevel(p.getLevel() - increaseDamageCost);
                            sender.sendMessage(RED + "You feel Stronger!");
                        } else {
                            break;
                        }
                        break;
                    case "INVISIBILITY":
                        int invisibilityCost = Main.getPlugin().getConfig().getInt("effect-exchanges.INVISIBILITY.cost");
                        int invisibilityDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.INVISIBILITY.duration");
                        boolean invisibilityEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.INVISIBILITY.enabled");
                        if (playerLevel >= invisibilityCost && invisibilityEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, invisibilityDuration, invisibilityCost));
                            p.setLevel(p.getLevel() - invisibilityCost);
                            sender.sendMessage(RED + "You feel Invisible!");
                        } else {
                            break;
                        }
                        break;
                    case "JUMP":
                        int jumpCost = Main.getPlugin().getConfig().getInt("effect-exchanges.JUMP.cost");
                        int jumpDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.JUMP.duration");
                        boolean jumpEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.JUMP.enabled");
                        if (playerLevel >= jumpCost && jumpEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, jumpDuration, jumpCost));
                            p.setLevel(p.getLevel() - jumpCost);
                            sender.sendMessage(RED + "You feel Agile!");
                        } else {
                            break;
                        }
                        break;
                    case "LEVITATION":
                        int levitationCost = Main.getPlugin().getConfig().getInt("effect-exchanges.LEVITATION.cost");
                        int levitationDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.LEVITATION.duration");
                        boolean levitationEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.LEVITATION.enabled");
                        if (playerLevel >= levitationCost && levitationEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, levitationDuration, levitationCost));
                            p.setLevel(p.getLevel() - levitationCost);
                            sender.sendMessage(RED + "You feel Light!");
                        } else {
                            break;
                        }
                        break;
                    case "LUCK":
                        int luckCost = Main.getPlugin().getConfig().getInt("effect-exchanges.LUCK.cost");
                        int luckDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.LUCK.duration");
                        boolean luckEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.LUCK.enabled");
                        if (playerLevel >= luckCost && luckEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, luckDuration, luckCost));
                            p.setLevel(p.getLevel() - luckCost);
                            sender.sendMessage(RED + "You feel Lucky!");
                        } else {
                            break;
                        }
                        break;
                    case "NIGHT_VISION":
                        int nightVisionCost = Main.getPlugin().getConfig().getInt("effect-exchanges.NIGHT_VISION.cost");
                        int nightVisionDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.NIGHT_VISION.duration");
                        boolean nightVisionEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.NIGHT_VISION.enabled");
                        if (playerLevel >= nightVisionCost && nightVisionEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, nightVisionDuration, nightVisionCost));
                            p.setLevel(p.getLevel() - nightVisionCost);
                            sender.sendMessage(RED + "You feel as if you can see in the Night!");
                        } else {
                            break;
                        }
                        break;
                    case "POISON":
                        int poisonCost = Main.getPlugin().getConfig().getInt("effect-exchanges.POISON.cost");
                        int poisonDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.POISON.duration");
                        boolean poisonEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.POISON.enabled");
                        if (playerLevel >= poisonCost && poisonEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, poisonDuration, poisonCost));
                            p.setLevel(p.getLevel() - poisonCost);
                            sender.sendMessage(RED + "You feel Poisoned!");
                        } else {
                            break;
                        }
                        break;
                    case "REGENERATION":
                        int regenerationCost = Main.getPlugin().getConfig().getInt("effect-exchanges.REGENERATION.cost");
                        int regenerationDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.REGENERATION.duration");
                        boolean regenerationEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.REGENERATION.enabled");
                        if (playerLevel >= regenerationCost && regenerationEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, regenerationDuration, regenerationCost));
                            p.setLevel(p.getLevel() - regenerationCost);
                            sender.sendMessage(RED + "You feel Refreshed!");
                        } else {
                            break;
                        }
                        break;
                    case "SATURATION":
                        int saturationCost = Main.getPlugin().getConfig().getInt("effect-exchanges.SATURATION.cost");
                        int saturationDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.SATURATION.duration");
                        boolean saturationEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.SATURATION.enabled");
                        if (playerLevel >= saturationCost && saturationEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, saturationDuration, saturationCost));
                            p.setLevel(p.getLevel() - saturationCost);
                            sender.sendMessage(RED + "You feel Saturated!");
                        } else {
                            break;
                        }
                        break;
                    case "SLOW":
                        int slowCost = Main.getPlugin().getConfig().getInt("effect-exchanges.SLOW.cost");
                        int slowDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.SLOW.duration");
                        boolean slowEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.SLOW.enabled");
                        if (playerLevel >= slowCost && slowEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, slowDuration, slowCost));
                            p.setLevel(p.getLevel() - slowCost);
                            sender.sendMessage(RED + "You feel Slow!");
                        } else {
                            break;
                        }
                        break;
                    case "SLOW_DIGGING":
                        int slowDiggingCost = Main.getPlugin().getConfig().getInt("effect-exchanges.SLOW_DIGGING.cost");
                        int slowDiggingDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.SLOW_DIGGING.duration");
                        boolean slowDiggingEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.SLOW_DIGGING.enabled");
                        if (playerLevel >= slowDiggingCost && slowDiggingEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, slowDiggingDuration, slowDiggingCost));
                            p.setLevel(p.getLevel() - slowDiggingCost);
                            sender.sendMessage(RED + "You feel Sluggish!");
                        } else {
                            break;
                        }
                        break;
                    case "SPEED":
                        int speedCost = Main.getPlugin().getConfig().getInt("effect-exchanges.SPEED.cost");
                        int speedDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.SPEED.duration");
                        boolean speedEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.SPEED.enabled");
                        if (playerLevel >= speedCost && speedEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, speedDuration, speedCost));
                            p.setLevel(p.getLevel() - speedCost);
                            sender.sendMessage(RED + "You feel Fast!");
                        } else {
                            break;
                        }
                        break;
                    case "UNLUCK":
                        int unluckCost = Main.getPlugin().getConfig().getInt("effect-exchanges.UNLUCK.cost");
                        int unluckDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.UNLUCK.duration");
                        boolean unluckEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.UNLUCK.enabled");
                        if (playerLevel >= unluckCost && unluckEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.UNLUCK, unluckDuration, unluckCost));
                            p.setLevel(p.getLevel() - unluckCost);
                            sender.sendMessage(RED + "You feel Unlucky!");
                        } else {
                            break;
                        }
                        break;
                    case "WATER_BREATHING":
                        int waterBreathingCost = Main.getPlugin().getConfig().getInt("effect-exchanges.WATER_BREATHING.cost");
                        int waterBreathingDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.WATER_BREATHING.duration");
                        boolean waterBreathingEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.WATER_BREATHING.enabled");
                        if (playerLevel >= waterBreathingCost && waterBreathingEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, waterBreathingDuration, waterBreathingCost));
                            p.setLevel(p.getLevel() - waterBreathingCost);
                            sender.sendMessage(RED + "You feel like a Fish!");
                        } else {
                            break;
                        }
                        break;
                    case "WEAKNESS":
                        int weaknessCost = Main.getPlugin().getConfig().getInt("effect-exchanges.WEAKNESS.cost");
                        int weaknessDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.WEAKNESS.duration");
                        boolean weaknessEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.WEAKNESS.enabled");
                        if (playerLevel >= weaknessCost && weaknessEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, weaknessDuration, weaknessCost));
                            p.setLevel(p.getLevel() - weaknessCost);
                            sender.sendMessage(RED + "You feel Weakened!");
                        } else {
                            break;
                        }
                        break;
                    case "WITHER":
                        int witherCost = Main.getPlugin().getConfig().getInt("effect-exchanges.WITHER.cost");
                        int witherDuration = Main.getPlugin().getConfig().getInt("effect-exchanges.WITHER.duration");
                        boolean witherEnabled = Main.getPlugin().getConfig().getBoolean("effect-exchanges.WITHER.enabled");
                        if (playerLevel >= witherCost && witherEnabled) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, witherDuration, witherCost));
                            p.setLevel(p.getLevel() - witherCost);
                            sender.sendMessage(BLACK + "You feel as if your soul is Withering away!");
                        } else {
                            break;
                        }
                        break;
                    default: // If a non-applicable argument is specified
                        p.sendMessage(RED + "That is not a known effect!");
                }
            } else {
            p.sendMessage(RED + "Try '/xpexchange list'");
        }
        return true;
        }

    }


