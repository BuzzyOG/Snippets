package com.buzzyog.snippets;
 
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
 
import java.util.HashMap;
import java.util.Map;
 
/**
 * @author Zeno
 * @author Sam
 */
public class LetterV2 {
    
    /**
     * @author Zeno
     */
    public static enum TextAlign {
        LEFT, CENTER, RIGHT
    }
    
    /**
     * Each character has a specific pattern of blocks.
     * 0 is for air - 1 is for block
     */
    private static final Map<Character, byte[][]> chars = new HashMap<>();
    
    /**
     * All chars get initialized.
     * New chars (possibly UTF-8 symbols) may be added by you.
     * All default char patterns are created by Sam (twitter.com/Sam_SMBHS)
     */
    static {
        // all capital letters
        chars.put(
                'A',
                new byte[][] {
                        { 0, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 }
                }
        );
        chars.put(
                'B',
                new byte[][] {
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 0 }
                }
        );
        chars.put(
                'C',
                new byte[][] {
                        { 0, 1, 1, 1 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 0, 1, 1, 1 }
                }
        );
        chars.put(
                'D',
                new byte[][] {
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 0 }
                }
        );
        chars.put(
                'E',
                new byte[][] {
                        { 1, 1, 1, 1 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 1, 1, 1 }
                }
        );
        chars.put(
                'F',
                new byte[][] {
                        { 1, 1, 1, 1 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 }
                }
        );
        chars.put(
                'G',
                new byte[][] {
                        { 0, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 0 },
                        { 1, 0, 0, 0, 0 },
                        { 1, 0, 0, 1, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 1, 1, 1 }
                }
        );
        chars.put(
                'H',
                new byte[][] {
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 }
                }
        );
        chars.put(
                'I',
                new byte[][] {
                        { 1, 1, 1 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 1, 1, 1 }
                }
        );
        chars.put(
                'J',
                new byte[][] {
                        { 0, 1, 1, 1 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 1, 0 },
                        { 1, 0, 1, 0 },
                        { 1, 1, 1, 0 }
                }
        );
        chars.put(
                'K',
                new byte[][] {
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 1, 0 },
                        { 1, 0, 1, 0, 0 },
                        { 1, 1, 0, 0, 0 },
                        { 1, 0, 1, 0, 0 },
                        { 1, 0, 0, 1, 0 },
                        { 1, 0, 0, 0, 1 }
                }
        );
        chars.put(
                'L',
                new byte[][] {
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 1, 1, 1 }
                }
        );
        chars.put(
                'M',
                new byte[][] {
                        { 1, 0, 0, 0, 1 },
                        { 1, 1, 0, 1, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 }
                }
        );
        chars.put(
                'N',
                new byte[][] {
                        { 1, 1, 0, 0, 1 },
                        { 1, 1, 0, 0, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 0, 1, 1 },
                        { 1, 0, 0, 1, 1 }
                }
        );
        chars.put(
                'O',
                new byte[][] {
                        { 0, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 0, 1, 1, 0 }
                }
        );
        chars.put(
                'P',
                new byte[][] {
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 }
                }
        );
        chars.put(
                'Q',
                new byte[][] {
                        { 0, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 1, 0 },
                        { 0, 1, 0, 1 }
                }
        );
        chars.put(
                'R',
                new byte[][] {
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 }
                }
        );
        chars.put(
                'S',
                new byte[][] {
                        { 0, 1, 1, 1 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 0, 1, 1, 0 },
                        { 0, 0, 0, 1 },
                        { 0, 0, 0, 1 },
                        { 1, 1, 1, 0 }
                }
        );
        chars.put(
                'T',
                new byte[][] {
                        { 1, 1, 1, 1, 1 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }
        );
        chars.put(
                'U',
                new byte[][] {
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 1 }
                }
        );
        chars.put(
                'V',
                new byte[][] {
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 0, 1, 0 },
                        { 0, 0, 1, 0, 0 }
                }
        );
        chars.put(
                'W',
                new byte[][] {
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 0, 1, 0, 1, 0 }
                }
        );
        chars.put(
                'X',
                new byte[][] {
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 0, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 1, 0, 1, 0 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 }
                }
        );
        chars.put(
                'Y',
                new byte[][] {
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 0, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }
        );
        chars.put(
                'Z',
                new byte[][] {
                        { 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 1, 0, 0, 0, 0 },
                        { 1, 1, 1, 1, 1 }
                }
        );
        // all non-capital letters
        chars.put(
                'a',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 1, 1, 1, 0 },
                        { 0, 0, 0, 1 },
                        { 0, 1, 1, 1 },
                        { 1, 0, 0, 1 },
                        { 0, 1, 1, 1 }
                }
        );
        chars.put(
                'b',
                new byte[][] {
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 0 }
                }
        );
        chars.put(
                'c',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 0, 1, 1, 1 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 1 },
                        { 0, 1, 1, 0 }
                }
        );
        chars.put(
                'd',
                new byte[][] {
                        { 0, 0, 0, 1 },
                        { 0, 0, 0, 1 },
                        { 0, 1, 1, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 0, 1, 1, 1 }
                }
        );
        chars.put(
                'e',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 0, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 1 },
                        { 1, 0, 0, 0 },
                        { 0, 1, 1, 1 }
                }
        );
        chars.put(
                'f',
                new byte[][] {
                        { 0, 0, 1, 1 },
                        { 0, 1, 0, 0 },
                        { 1, 1, 1, 1 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 }
                }
        );
        chars.put(
                'g',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 0, 1, 1, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 0, 1, 1, 1 },
                        { 0, 0, 0, 1 },
                        { 1, 1, 1, 0 }
                }
        );
        chars.put(
                'h',
                new byte[][] {
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 }
                }
        );
        chars.put(
                'i',
                new byte[][] {
                        { 1 },
                        { 0 },
                        { 1 },
                        { 1 },
                        { 1 },
                        { 1 },
                        { 1 }
                }
        );
        chars.put(
                'j',
                new byte[][] {
                        { 0, 1 },
                        { 0, 0 },
                        { 0, 1 },
                        { 0, 1 },
                        { 0, 1 },
                        { 0, 1 },
                        { 0, 1 },
                        { 0, 1 },
                        { 1, 0 }
                }
        );
        chars.put(
                'k',
                new byte[][] {
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 1, 0 },
                        { 1, 1, 0, 0 },
                        { 1, 0, 1, 0 },
                        { 1, 0, 0, 1 }
                }
        );
        chars.put(
                'l',
                new byte[][] {
                        { 1 },
                        { 1 },
                        { 1 },
                        { 1 },
                        { 1 },
                        { 1 },
                        { 1 }
                }
        );
        chars.put(
                'm',
                new byte[][] {
                        { 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0 },
                        { 1, 1, 1, 0, 1, 1, 0 },
                        { 1, 0, 0, 1, 0, 0, 1 },
                        { 1, 0, 0, 1, 0, 0, 1 },
                        { 1, 0, 0, 1, 0, 0, 1 },
                        { 1, 0, 0, 1, 0, 0, 1 }
                }
        );
        chars.put(
                'n',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 }
                }
        );
        chars.put(
                'o',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 0, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 0, 1, 1, 0 }
                }
        );
        chars.put(
                'p',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 1, 1, 0 },
                        { 1, 0, 0, 0 },
                        { 1, 0, 0, 0 }
                }
        );
        chars.put(
                'q',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 0, 1, 1, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 0, 1, 1, 1 },
                        { 0, 0, 0, 1 },
                        { 0, 0, 0, 1 }
                }
        );
        chars.put(
                'r',
                new byte[][] {
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 1, 0, 1 },
                        { 1, 1, 0 },
                        { 1, 0, 0 },
                        { 1, 0, 0 },
                        { 1, 0, 0 }
                }
        );
        chars.put(
                's',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 0, 1, 1, 1 },
                        { 1, 0, 0, 0 },
                        { 0, 1, 1, 0 },
                        { 0, 0, 0, 1 },
                        { 1, 1, 1, 0 }
                }
        );
        chars.put(
                't',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 1, 1, 1, 1 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 0, 1, 1 }
                }
        );
        chars.put(
                'u',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 0, 1, 1, 1 }
                }
        );
        chars.put(
                'v',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 0, 1, 1, 0 },
                        { 0, 1, 0, 0 }
                }
        );
        chars.put(
                'w',
                new byte[][] {
                        { 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0 },
                        { 1, 0, 0, 1, 0, 0, 1 },
                        { 1, 0, 0, 1, 0, 0, 1 },
                        { 1, 0, 0, 1, 0, 0, 1 },
                        { 0, 1, 1, 0, 1, 1, 0 },
                        { 0, 1, 0, 0, 1, 0, 0 }
                }
        );
        chars.put(
                'x',
                new byte[][] {
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 0, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 1, 0, 1, 0 },
                        { 1, 0, 0, 0, 1 }
                }
        );
        chars.put(
                'y',
                new byte[][] {
                        { 0, 0, 0, 0 },
                        { 0, 0, 0, 0 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 1, 0, 0, 1 },
                        { 0, 1, 1, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 1, 0, 0 },
                        { 1, 0, 0, 0 }
                }
        );
        chars.put(
                'z',
                new byte[][] {
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0 },
                        { 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 1, 1, 1, 1, 1 }
                }
        );
        // so here is where all number chars happen to be
        chars.put(
                '0',
                new byte[][] {
                        { 0, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 1, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 1, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 1, 1, 0 }
                }
        );
        chars.put(
                '1',
                new byte[][] {
                        { 1, 1, 0 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 1, 1, 1 }
                }
        );
        chars.put(
                '2',
                new byte[][] {
                        { 0, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 1, 1, 1, 1, 1 }
                }
        );
        chars.put(
                '3',
                new byte[][] {
                        { 0, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 1, 1, 0 }
                }
        );
        chars.put(
                '4',
                new byte[][] {
                        { 0, 0, 0, 1, 0 },
                        { 0, 0, 1, 1, 0 },
                        { 0, 1, 0, 1, 0 },
                        { 1, 0, 0, 1, 0 },
                        { 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 1, 0 },
                        { 0, 0, 0, 1, 0 }
                }
        );
        chars.put(
                '5',
                new byte[][] {
                        { 1, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 0 },
                        { 1, 1, 1, 1, 0 },
                        { 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 0 }
                }
        );
        chars.put(
                '6',
                new byte[][] {
                        { 0, 0, 1, 1, 0 },
                        { 0, 1, 0, 0, 0 },
                        { 1, 0, 0, 0, 0 },
                        { 1, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 1, 1, 0 }
                }
        );
        chars.put(
                '7',
                new byte[][] {
                        { 1, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 0, 0, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }
        );
        chars.put(
                '8',
                new byte[][] {
                        { 0, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 1, 1, 0 }
                }
        );
        chars.put(
                '9',
                new byte[][] {
                        { 0, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 1, 0 },
                        { 0, 1, 1, 0, 0 }
                }
        );
        // special stuff
        chars.put(
                ' ',
                new byte[][] {
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 }
                }
        );
        chars.put(
                '.',
                new byte[][] {
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 1 }
                }
        );
        chars.put(
                ':',
                new byte[][] {
                        { 0 },
                        { 1 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 1 },
                        { 0 }
                }
        );
        chars.put(
                ',',
                new byte[][] {
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 1 },
                        { 1 }
                }
        );
        chars.put(
                ';',
                new byte[][] {
                        { 0 },
                        { 0 },
                        { 0 },
                        { 0 },
                        { 1 },
                        { 0 },
                        { 1 },
                        { 1 }
                }
        );
        chars.put(
                '-',
                new byte[][] {
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 1, 1, 1 },
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 }
                }
        );
        chars.put(
                '_',
                new byte[][] {
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 1, 1, 1 }
                }
        );
        chars.put(
                '+',
                new byte[][] {
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 1, 0 },
                        { 1, 1, 1 },
                        { 0, 1, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 }
                }
        );
        chars.put(
                '=',
                new byte[][] {
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 1, 1, 1 },
                        { 0, 0, 0 },
                        { 1, 1, 1 },
                        { 0, 0, 0 },
                        { 0, 0, 0 },
                        { 0, 0, 0 }
                }
        );
        chars.put(
                '!',
                new byte[][] {
                        { 1 },
                        { 1 },
                        { 1 },
                        { 1 },
                        { 1 },
                        { 0 },
                        { 1 }
                }
        );
        chars.put(
                '?',
                new byte[][] {
                        { 0, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 1, 0 },
                        { 0, 0, 1, 0, 0 },
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 1, 0, 0 }
                }
        );
        chars.put(
                '(',
                new byte[][] {
                        { 0, 0, 1 },
                        { 0, 1, 0 },
                        { 1, 0, 0 },
                        { 1, 0, 0 },
                        { 1, 0, 0 },
                        { 0, 1, 0 },
                        { 0, 0, 1 }
                }
        );
        chars.put(
                ')',
                new byte[][] {
                        { 1, 0, 0 },
                        { 0, 1, 0 },
                        { 0, 0, 1 },
                        { 0, 0, 1 },
                        { 0, 0, 1 },
                        { 0, 1, 0 },
                        { 1, 0, 0 }
                }
        );
        chars.put(
                '<',
                new byte[][] {
                        { 0, 0, 0, 1 },
                        { 0, 0, 1, 0 },
                        { 0, 1, 0, 0 },
                        { 1, 0, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 0, 1 }
                }
        );
        chars.put(
                '>',
                new byte[][] {
                        { 1, 0, 0, 0 },
                        { 0, 1, 0, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 0, 1 },
                        { 0, 0, 1, 0 },
                        { 0, 1, 0, 0 },
                        { 1, 0, 0, 0 }
                }
        );
        chars.put(
                '/',
                new byte[][] {
                        { 0, 0, 1 },
                        { 0, 0, 1 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 1, 0, 0 },
                        { 1, 0, 0 }
                }
        );
        chars.put(
                '\\',
                new byte[][] {
                        { 1, 0, 0 },
                        { 1, 0, 0 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 0, 1, 0 },
                        { 0, 0, 1 },
                        { 0, 0, 1 }
                }
        );
    }
    
    /**
     * Text to be written.
     */
    private String text;
    /**
     * Location, from which the text will be written.
     */
    private Location start;
    /**
     * Direction, in which the text will be written.
     */
    private BlockFace direction;
    
    /**
     * Constructor
     * 
     * @param text Text to be written.
     * @param start Location, from which the text will be written.
     * @param direction Direction, in which the text will be written.
     */
    public LetterV2( String text, Location start, BlockFace direction ) {
        this.text = text;
        this.start = start;
        this.direction = direction;
    }
    
    /**
     * Creates a char at a specific location.
     *
     * @param ch Char to be written.
     * @param loc Location, from which the char will be written.
     * @param material Material, the char is made from.
     * @param data Minecraft Sub-Ids, the blocks can have.
     * @return The location, where the next char can be created.
     */
    private Location writeChar( char ch, Location loc, Material material, byte data ) {
        byte[][] pattern = chars.get( ch );
        if( pattern == null )
            return loc;
        int lnr = 0;
        Location lastloc = null;
        for ( byte[] line : pattern ) {
            lastloc = loc.clone().subtract( 0, lnr, 0 );
            for ( byte air : line ) {
                Block block = lastloc.getBlock().getRelative( this.direction );
                if( air == 0 ) {
                    block.setType( Material.AIR );
                    block.setData( (byte) 0 );
                } else {
                    block.setType( material );
                    block.setData( data );
                }
                lastloc = block.getLocation();
            }
            lnr++;
        }
        lastloc.setY( loc.getY() );
        return lastloc.getBlock().getRelative( this.direction ).getLocation();
    }
 
    /**
     * Creates a text.
     *
     * @param material Material, the text is made from.
     * @param data Minecraft Sub-Ids, the blocks can have.
     * @return Builder class.
     */
    public LetterV2 write( Material material, byte data ) {
        Location nextloc = this.start;
        for ( char ch : this.text.toCharArray() )
            nextloc = this.writeChar( ch, nextloc, material, data );
        return this;
    }
 
    /**
     * Re-aligns the text.
     * 
     * @param align Text alignment.
     * @return Builder class.
     */
    public LetterV2 align( TextAlign align ) {
        int length = 0;
        for ( char ch : this.text.toCharArray() ) {
            int letterlength = 1;
            byte[][] pattern = chars.get( ch );
            if( pattern != null )
                letterlength += pattern[0].length;
            length += letterlength;
        }
        switch ( align ) {
            case LEFT:
                length = 0;
                break;
            case CENTER:
                length /= 2;
                break;
            case RIGHT:
                break;
        }
        Location aligned = this.start;
        BlockFace face = this.direction.getOppositeFace();
        for ( int i = 0; i < length; i++ )
            aligned = aligned.getBlock().getRelative( face ).getLocation();
        this.start = aligned;
        return this;
    }
    
}