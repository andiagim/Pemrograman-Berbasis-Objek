import greenfoot.*;

public class OverClass  extends Actor
{   
    
    public boolean noObjectInWay(int x, int y, Class object)
    {     
        if(getWorld().getObjectsAt(x, y, object).size() == 0)
        {
            return true;
        }
        return false;
    }
    
    public boolean objectAtSameLocation(Class object)
    {
        Actor over = getOneObjectAtOffset(0, 0, object);
        return over != null; 
    }
    
}
