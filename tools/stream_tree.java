    @Test
    public void streamTree(){
        List<Sys_menu> menus = sysMenuService.query(Cnd.where("disabled", "=", false).and("delFlag", "=", false));
        List<Sys_menu> col=menus.stream().filter(m->Strings.isBlank(m.getParentId())).map((m)->{
            m.setChildren(buildTree(m,menus));
            return m;
        }).collect(Collectors.toList());
        System.out.println(Json.toJson(col));
    }

    private List<Sys_menu> buildTree(Sys_menu root,List<Sys_menu> all){
        List<Sys_menu> children=all.stream().filter(m-> Objects.equals(m.getParentId(),root.getId())).map((m)->{
            m.setChildren(buildTree(m,all));
            return m;
        }).collect(Collectors.toList());
        return children;
    }