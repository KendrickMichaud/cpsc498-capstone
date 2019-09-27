package core;

public class Equipment {
    private String title;
    private String description;

    public Equipment(String parse){
        if(parse == null)throw new NullPointerException("String is null");
        parseString(parse);
    }

    public Equipment(String title, String description){
        if(title == null)throw new NullPointerException("Title is null");
        if(description == null)throw new NullPointerException("Description is null");
        this.title=title;
        this.description=description;
    }

    public String getTitle(){
        return title;
    }

    public String getDesc(){
        return description;
    }

    public void setTitle(String iTitle){
        if(iTitle == null)throw new NullPointerException("String is null");
        title = iTitle;

    }

    public void setDesc(String iDesc){
        if(iDesc == null)throw new NullPointerException("String is null");
        description = iDesc;
    }

    public void setTitleAndDescription(String parse){
        if(parse == null)throw new NullPointerException("String is null");
    }

    private void parseString(String parse){
        int slicePos = parse.indexOf(';');
        if(slicePos > 0){
            title = parse.substring(0, slicePos);
            description = parse.substring(slicePos+1);
        }
        else if(slicePos != 0){
            title = parse;
        }
    }

}
