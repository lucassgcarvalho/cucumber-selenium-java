package com.stefanini.automation.page.user.model;
public class CorrelationPojo
{
    private String businessGroup;

    private String docNumber;

    private String __typename;

    private String name;

    private String id;

    private Accounts[] accounts;

    private PersonType personType;

    public String getBusinessGroup ()
    {
        return businessGroup;
    }

    public void setBusinessGroup (String businessGroup)
    {
        this.businessGroup = businessGroup;
    }

    public String getDocNumber ()
    {
        return docNumber;
    }

    public void setDocNumber (String docNumber)
    {
        this.docNumber = docNumber;
    }

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

    public Accounts[] getAccounts ()
    {
        return accounts;
    }

    public void setAccounts (Accounts[] accounts)
    {
        this.accounts = accounts;
    }

    public PersonType getPersonType ()
    {
        return personType;
    }

    public void setPersonType (PersonType personType)
    {
        this.personType = personType;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [businessGroup = "+businessGroup+", docNumber = "+docNumber+", __typename = "+__typename+", name = "+name+", id = "+id+", accounts = "+accounts+", personType = "+personType+"]";
    }
}