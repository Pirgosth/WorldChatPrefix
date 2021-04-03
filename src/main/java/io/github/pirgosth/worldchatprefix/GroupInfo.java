package io.github.pirgosth.worldchatprefix;

import java.util.ArrayList;
import java.util.List;

public class GroupInfo {

    public List<String> worlds = new ArrayList<>();
    public String prefix;

    public GroupInfo(){

    }

    public GroupInfo(List<String> worlds, String prefix) {
        this.worlds = worlds;
        this.prefix = prefix;
    }

}
