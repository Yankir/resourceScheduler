package Models;

import java.io.Serializable;
import java.util.Date;

public class Schedule implements Serializable
{
    private int userId;
    private int resourceId;

    private Date initialDate;
    private Date finalDate;

    public Schedule() {}
    public Schedule(int userId , int resourceId , Date initialDate, Date finalDate)
    {
        setUserId(userId);
        setResourceId(resourceId);

        setInitialDate(initialDate);
        setFinalDate(finalDate);
    }

    private void setUserId(int userId) { this.userId = userId; }
    private void setResourceId(int resourceId) { this.resourceId = resourceId; }

    private void setInitialDate(Date initialDate) { this.initialDate = initialDate; }
    private void setFinalDate(Date finalDate) { this.finalDate = finalDate; }


    public int getUserId() { return userId; }
    public int getResourceId() { return resourceId; }

    public Date getInitialDate() { return initialDate; }
    public Date getFinalDate() { return finalDate; }
}
