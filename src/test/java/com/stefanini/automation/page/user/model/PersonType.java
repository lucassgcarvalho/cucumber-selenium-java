package com.stefanini.automation.page.user.model;
public class PersonType
{
    private String code;

    private String __typename;

    private String description;

    public String getCode ()
    {
        return code;
    }

    public void setCode (String code)
    {
        this.code = code;
    }

    public String get__typename ()
    {
        return __typename;
    }

    public void set__typename (String __typename)
    {
        this.__typename = __typename;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [code = "+code+", __typename = "+__typename+", description = "+description+"]";
    }
}