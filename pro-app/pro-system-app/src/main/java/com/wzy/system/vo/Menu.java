package com.wzy.system.vo;
import lombok.Data;
import java.util.List;

@Data
public class Menu {
    String path;
    String name;
    MenuMeta meta;
    String type;
    List<Menu> children;
}
