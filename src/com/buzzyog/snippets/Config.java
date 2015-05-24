package com.buzzyog.snippets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.util.com.google.common.base.Joiner;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public enum Config {

    BOOLEAN("Your.Boolean", true, "Boolean"),
    STRING("Your.String", "&aString", "String"),
    INT("Your.Integer", 1, "Integer"),
    STRINGLIST("Your.StringList", Arrays.asList("String1", "String2"), "StringList");

    private final Object value;
    private final String path;
    private final String desc;

    private static YamlConfiguration cfg;
    private static File f;
    private static JavaPlugin main;

    /**
     * Creates a new configuration entry with the given values.
     *
     * @param path: The path of this object.
     * @param val: The default value for this object.
     * @param desc: The description for this object.
     */
    private Config(String path, Object val, String desc) {
        this.path = path;
        this.value = val;
        this.desc = desc;
    }

    /**
     * Returns the path of this configuration entry
     *
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * Returns the default object of this configuration entry
     *
     * @return value
     */
    public Object getDefaultValue() {
        return value;
    }

    /**
     * Returns the description of this configuration entry
     *
     * @return desc
     */
    public String getDescription() {
        return desc;
    }

    /**
     * Returns an int which is in the configuration.
     *
     * @return cfg.getInt(getPath())
     */
    public int getInt() {
        return cfg.getInt(path);
    }

    /**
     * Returns a boolean which is in the configuration.
     *
     * @return cfg.getBoolean(getPath())
     */
    public boolean getBoolean() {
        return cfg.getBoolean(path);
    }

    /**
     * Returns a String which is in the configuration.
     * Color codes starting with '&' get replaced.
     *
     * @return replaceColors(cfg.getString(getPath()))
     */
    public String getString() {
        return replaceColors(cfg.getString(path));
    }

    /**
     * Returns an Object which is in the configuration.
     * Color codes starting with '&' get replaced.
     *
     * @return cfg.get(getPath())
     */
    public Object getObject() {
        Object ret = cfg.get(path);
        if (ret instanceof String) {
            return getString();
        }
        return ret;
    }

    /**
     * Sends the message which is stored in the config to the receiver.
     * Color codes starting with '&' get replaced.
     *
     * @param receiver The receiver
     */
    public void sendMessage(CommandSender receiver) {
        receiver.sendMessage(getString());
    }

    /**
     * Returns a List&lt;String&gt; which is in the configuration.
     * Color codes starting with '&' get replaced.
     *
     * @return cfg.getStringList(getPath())
     */
    public List<String> getStringList() {
        List<String> ret = new ArrayList<String>();
        for (String s : cfg.getStringList(path)) {
            ret.add(replaceColors(s));
        }
        return ret;
    }

    /**
     * Returns a double which is in the configuration.
     *
     * @return cfg.getDouble(getPath())
     */
    public double getDouble() {
        return cfg.getDouble(path);
    }

    /**
     * Sets the value into the configuration file.
     * Saves the configuration to the file if save=true
     *
     * @param value
     * @param save
     * @throws IOException
     */
    public void set(Object value, boolean save) throws IOException {
        if (value instanceof String) {
            String s = (String) value;
            s = replaceColors(s);
            cfg.set(path, value);
        } else {
            cfg.set(path, value);
        }
        if (save) {
            save();
            reload();
        }
    }

    /**
     * Loads the configuration.
     *
     * @param pl
     * @param cfgFile
     * @throws IOException
     */
    public static void load(JavaPlugin pl, File cfgFile) throws IOException {
        pl.getLogger().info("Loading the configuration file...");
        main = pl;
        main.getDataFolder().mkdirs();
        f = cfgFile;
        reload();
        String header = main.getDescription().getName() + " plugin by " + Joiner.on(", ").join(main.getDescription().getAuthors()) + System.lineSeparator();
        for (Config c : values()) {
            header += c.getPath() + ": " + c.getDescription() + System.lineSeparator();
            if (!cfg.contains(c.getPath())) {
                pl.getLogger().info("Writing " + c.getPath() + " into the configuration...");
                c.set(c.getDefaultValue(), false);
            }
        }
        cfg.options().header(header);
        pl.getLogger().info("Saving configuration file to disk...");
        save();
        pl.getLogger().info("Config was loaded successfully!");
    }

    /**
     * Saves the configuration to disc.
     *
     * @throws IOException
     */
    public static void save() throws IOException {
        cfg.save(f);
    }

    /**
     * Loads the configuration from disc.
     */
    public static void reload() {
        cfg = YamlConfiguration.loadConfiguration(f);
    }

    /**
     * Replaces all color codes starting with '&' in the string
     *
     * @param string
     * @return string with repalced colors.
     */
    private static String replaceColors(String string) {
        return string.replaceAll("&((?i)[0-9a-fk-or])", "§$1");
    }
}