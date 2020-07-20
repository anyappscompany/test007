package ua.com.anyapps.test007.pojo.sources;

public class SourcesNews
{
    private Sources[] sources;

    private String status;

    public Sources[] getSources ()
    {
        return sources;
    }

    public void setSources (Sources[] sources)
    {
        this.sources = sources;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sources = "+sources+", status = "+status+"]";
    }
}
