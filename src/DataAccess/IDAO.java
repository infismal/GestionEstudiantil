package DataAccess;

import java.util.List;

public interface IDAO<T> {
    List<T> readAll()            throws Exception;
    boolean create (T entity)    throws Exception;
    boolean update (T entity)    throws Exception;
    boolean delete (Integer id)  throws Exception;
    
}
