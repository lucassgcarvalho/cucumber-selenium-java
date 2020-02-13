package com.stefanini.automation.page.user.model;
public class Accounts
{
    private String __typename;

    private String name;

    private String id;

    private String type;

    public String get__typename ()
    {
        return __typename;
    }

    public void set__typename (String __typename)
    {
        this.__typename = __typename;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [__typename = "+__typename+", name = "+name+", id = "+id+", type = "+type+"]";
    }
}